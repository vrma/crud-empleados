package com.example.service;

import java.sql.SQLException;
import java.util.List;

import com.example.model.Empleado;

public interface EmpleadoService {
	
	/* Los metodos abstractos de una interface, es decir, los metodos que no
	 * tienen cuerpo, tienen que ser implementados por una clase concreta, en
	 * este caso la clase se le acostumbra a llamar EmpleadoServiceImpl */
	List<Empleado> dameEmpleados() throws SQLException;
	
	// Metodo para persistir un empleado
	
	public abstract void persistirEmpleado(Empleado empleado, 
			List<String> numerosTelefono, List<String> direccionesCorreo )
					throws SQLException;
}
