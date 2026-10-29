package com.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.example.service.EmpleadoService;
import com.example.service.EmpleadoServiceImpl;

/**
 * Servlet implementation class EliminarController
 */
@WebServlet("/EliminarController")
public class EliminarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recibir el id del empleado a eliminar
		
		int empleado_id = Integer
				.parseInt(request.getParameter("empleado_id"));
		
		// Con el id del empleado me conectare a la capa de servicio y llamare 
		// a un metodo deleteEmpleado para eliminar el empleado con todos sus 
		// telefonos y correos, y su foto tambien cuando la tenga
		
		EmpleadoService empleadoService = new EmpleadoServiceImpl();
		
		empleadoService.deleteEmpleado(empleado_id);
		
		// Vuelvo a mostrar el listado de empleados a ver si se ha eliminado el empleado en cuestion
		
		try {
			request.setAttribute("empleados", empleadoService.dameEmpleados());
			request.getRequestDispatcher("listado.jsp").forward(request, response);
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
