package com.example.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.DBConexion;
import com.example.model.Departamento;

public class DepartamentoServiceImpl implements DepartamentoService {

	@Override
	public List<Departamento> getDepartamentos() {
		
		// Conectar con la capa DAO
		DBConexion dbConexion = new DBConexion("root", "Temp2026");
		List<Departamento> departamentos = new ArrayList<>();
		ResultSet rs = null;
		Connection connection = null;
		
		try {
			connection = dbConexion.getConexion();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		
		
		return departamentos;
	}

}
