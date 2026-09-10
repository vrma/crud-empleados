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
	<h1 style="color: yellow; background: blue">
		Mi primera aplicación WEB con la tecnologia JSP (Java Server Page)</h1>
	
	<!-- A continuacion se agrega codigo de Java al documento mediante un lenguaje de marcas
	llamado scriptlet -->
	
	<%
		// Comentario de una sola linea
		/* Comentario que puede abarcar varias lineas */
		
		/* A continuacion declaramos una lista de nombres, inmutable y la recorremos
		para mostrarla en un elemento HTML de lista no ordenada */
		
		/* ELEMENTO HTML, es todo lo que esta desde la etiqueta (tap) de apertura hasta la 
		etiqueta de cierre. Dentro de un elemento HTML pueden haber otros de forma anidada */
		
		List<String> nombres = List.of("Elida", "Yakelin", "Miguel", 
				"Gina", "Yodalis", "Youssef");
	%>
	
	<!-- lista no ordenada (unordered list) -->
	<ul>
		<!-- list items (elementos de la lista no ordenada) -->
		<li>Elida</li>
		<li>Yakelin</li>
	</ul>
	
	<!-- Queremos que la lista de elementos se genere de forma 
	automatica en correspondencia con el numero de elementos 
	que tenga la lista de nombres -->
	
	<ul>
		<!-- Recorremos la lista de nombres, utilizando alguna de las sentencias de 
		bucle que ya conocemos (for clasico, for mejorado, iterador u
		Operaciones de agregado) -->
		<% 
			for(String nombre : nombres) {
				%>
				
				<li><%=nombre %></li>
				
				<% 
			}
		%>
	</ul>
</body>
</html>


