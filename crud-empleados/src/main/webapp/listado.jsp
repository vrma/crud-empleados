<%@page import="com.example.model.Empleado"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Listado de empleados</h1>
	
	<!-- A continuacion se renderiza una tabla con el listado de empleados recibido 
	como atributo de la respuesta la peticion de mostrar el listado de estudiantes -->
	
	<table>
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Primer Apellido</th>
				<th>Segundo Apellido</th>
				<th>Fecha de Alta</th>
				<th>Fecha de Baja</th>
				<th>Salario</th>
				<th>Genero</th>
			</tr>
		</thead>
		<tbody>
			<%
				// Aqui se recibe como atributo el listado de empleados
				List<Empleado> listadoDeEmpleados = (List<Empleado>) request.getAttribute("empleados");
			
				for (Empleado empleado : listadoDeEmpleados) {
					%>
					<tr>
						<td><%=empleado.nombre() %></td>
						<td><%=empleado.apellido1() %></td>
						<td><%=empleado.apellido2() %></td>
						<td><%=empleado.fechaAlta() %></td>
						<td><%=empleado.fechaBaja() != null ? empleado.fechaBaja() : " " %></td>
						<td><%=empleado.salario() %></td>
						<td><%=empleado.genero() %></td>
					</tr>
					
					
					<% 
				}
			%>
		</tbody>
	</table>
	
	
</body>
</html>