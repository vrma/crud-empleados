package com.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.example.dao.DBConexion;

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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
