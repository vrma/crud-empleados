package com.example.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.DBConexion;

public class CorreoServiceImpl implements CorreoService {

	@Override
	public List<String> dameCorreos(int empleado_id) {
		
		List<String> direccionesDeCorreos = new ArrayList<String>();
		
		try (DBConexion dbConexion = new DBConexion("root", "Temp2026");
				Connection connection = dbConexion.getConexion()) {
			
			ResultSet rs = dbConexion.dameCorreos(connection, empleado_id);
			
			while (rs.next()) {
				
				direccionesDeCorreos.add(rs.getString("email"));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return direccionesDeCorreos;
	}

}
