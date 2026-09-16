/* Esta clase contendrá todo lo necesario para conectar
 * la aplicacion WEB que estamos desarrollando con la base
 * de datos, utilizando el protocolo JDBC (Java Database 
 * Connectivity) 
 * 
 * ¿Donde esta la teoria que respalda esta protocolo? 
 * 
 * https://docs.oracle.com/javase/tutorial/jdbc/index.html
 * 
 * */
package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConexion {
	
	/* Utilizando el metodo println() que esta en el paquete System.out nos 
	 * permite escribir en la consola, o terminal, informacion o mensajes
	 * respecto a muchas cosas, como por ejemplo si ha habido algun error en el 
	 * momento de conectarnos a la base de datos, o si la conexion ha sido 
	 * exitosa, pero el problema es que todos estos mensajes si el Eclipse se cierra o
	 * se bloquea ya no vamos a poder acceder a ellos, es decir, utilizando la 
	 * terminologia de la ciber seguridad, no podriamos hacer un analis forence o 
	 * post morten para saber porqué fallo todo. */
	
	/* ¿Como se soluciona lo anterior, entonces? Creando un  Logger para la clase, es
	 * decir un objeto, que muestre tambien los mensajes de error pero los deje 
	 * registrados en un archivo .log que se puede analizar 
	 * posteriormente aunque todo haya fallado */

	private static final Logger LOG = Logger.getLogger("DBConexion");
	
	private String user;
	private String password;
	
	/* La siguiente propiedad va a almacenar el objeto de conexion a la base
	 * de datos, para realizar consultas utilizando el lenguaje SQL, posteriormente */
	private Connection conn;

	// Constructor
	public DBConexion(String user, String password) {
		super();
		this.user = user;
		this.password = password;
		
	}
	
	/* Metodo que permite conectar a la base de datos y 
	 * devuelve el objeto de coneccion. */
	public Connection getConexion() throws ClassNotFoundException {
		
		String urlConnection = "jdbc:mysql://localhost:3306/empresa_crud_empleados";
		
		Properties connectionInfo;
		
		connectionInfo = new Properties();
		
		connectionInfo.put("user", this.user);
		connectionInfo.put("password", this.password);
		
		try {
			// La instruccion siguiente es necesaria para registrar el driver 
			// de coneccion a la base de datos
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			this.conn = DriverManager.getConnection(urlConnection, connectionInfo);
			LOG.info("Conexion establecida con la base de datos");
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.log(Level.SEVERE, "Error de coneccion a la base de datos");
		}
		
		return this.conn;
	}

	/* Metodo que recupera todos los registro de la tabla de empleados.
	 * 
	 * Tener presente que todos los metodos que lancen consultas de SQL contra
	 * la base de datos tienen que hacerlo a traves de una conexion existente,
	 * por eso es que se pasa siempre como parametro al metodo la conexion que 
	 * devuelve el metodo getConexion().
	 * 
	 * Una conexion es un recurso valioso, que tiene que ser cerrada una vez
	 * que hayamos terminado de utilizarla */
	public ResultSet getEmpleados(Connection connection) {
		
		ResultSet rs = null;
		
		/* La variable local siguiente, query, almacena la consulta que se va a 
		 * ejecutar, que por simple que nos parezca, no debemos de escribir 
		 * directamente sin antes haberla probado en un cliente de conexion a 
		 * la base de datos, como pueden ser el MySQL Workbench o el DBeaver */
		String query = "select * from empleados";
		
		/* La consulta anterior hay que adecuarla, convertirla a binario, 
		 * para que el motor de base de datos la entienda, porque ahora 
		 * mismo esta en lenguaje humano pero las maquinas dicho lenguaje no 
		 * lo entienden. */
		
		/* Para una consulta sin parametros variables se untiliza la interfaz 
		 * siguiente. */
		Statement stmt;
		
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return rs;
	}
}







