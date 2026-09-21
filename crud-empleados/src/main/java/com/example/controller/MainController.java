package com.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.example.dao.DBConexion;
import com.example.model.Empleado;
import com.example.service.EmpleadoService;
import com.example.service.EmpleadoServiceImpl;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Conectar con el Modelo para recuperar los registros de la tabla de empleados
		// que se encuentra en la base de datos
		
		// Conexion de prueba a la base de datos
		
		/* MUY IMP0RTANTE !!!! 
		 * 
		 * En el patron MVC (Model Vista Controlador), el Controlador nunca, pero nunca,
		 * se debe conectar con la capa de datos directamente, sino a traves de una 
		 * capa de Servicio que no hemos creado todavia, asi que la instrucciones siguientes
		 * que crean una instancia de la clase DBConexion e invocan la metodo getConexion()
		 * en el bloque try ... catch, NO tiene nada que hacer aqui, y ¿Por que lo hemos 
		 * hecho entonces? Para hacer una prueba rapida que y comprobar que nos estamos 
		 * conectando a la base de datos, porque dicha conexion es impresindible para las
		 * futuras consultas de SQL que vamos a lanzar, y una vez comprobado que nos conectamos
		 * a la base de datos, se pueden comentar todas la lineas siguientes */
		
		/*
		 * DBConexion dbConexion = new DBConexion("root", "Temp2026");
		 * 
		 * try { dbConexion.getConexion(); } catch (ClassNotFoundException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
		/* Conectar a la capa de servicio, es decir, al servicio de Empleado. 
		 * ¿Como me conecto al servicio de empleado? Pues declarando una variable
		 * del tipo EmpleadoService, que es la interface y no la clase que implementa
		 * la interface */
		
		EmpleadoService empleadoService = new EmpleadoServiceImpl();
		
		try {
			List<Empleado> empleados = empleadoService.dameEmpleados();
			
			/* Un Servlet puede devolver la respuesta generando codigo HTML o
			 * utilizando una vista y mandar lo que hay que mostrar en dicha 
			 * vista como atributos de dicha vista */
			request.getRequestDispatcher("listado.jsp")
					.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
