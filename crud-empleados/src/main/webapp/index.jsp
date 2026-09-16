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
	
	<!-- El siguiente enlace es un elemento HTML llamado enlace hipertexto o anchoar, o 
	llamado en los entornos de desarrollo ancla. 
	Cuando se haga click en dicho enlace
	se va a generar una peticion (request), a traves del protocolo HTTP (Hipertext 
	Transfer Protocol) (Protocolo de Transferencia de Hipertexto), que es un protocolo
	especialmente diseñado para que viaje a traves del mismo documentos HTML, audio, 
	video, imagenes, PDF, JavaScripts, hojas de estilo en cascada (CSS), etc.
	Dicha peticion tiene que ser recibida por el Controlador que es un Servlet. 
	¿Que es un Servlet? Pues es una clase de Java, que implementa unas interfaces para 
	manejar peticiones recibidas mediante el protocolo HTTP y que puede generar la 
	respuesta mediante codigo HTML o utilizar una vista para mostrar la respuesta a la 
	peticion recibida. Normalmente el Servlet se comunica con el modelo para, a traves 
	del procotolo JDBC (Java Data Base Connectivity) acceder a la base de datos -->
	
<!-- 	El patron MVC no se implementa de forma aislada sino que se implementa conjuntamente
	con el patron Facade, que es patron de diseño que divide el proyecto en distintas
	capas que el objetivo es ocultar la complejidad de una capa a otra, en tal sentido 
	se acostumbra a tener, por lo menos, las siguientes capas, que son paquetes:
	
	1- Capa DAO (Data Access Object), tambien se le llama Repository
	2- Capa de Model (Modelo)
	3- La capa de Servicios, que son interfaces con clases concretas que las 
	implementan.
	4- La de controladores -->
	
	<!-- Cuando en el atributo href del elemento <a></a> aparece el simbolo de numero
	o almohadilla, la peticion no viaja a ninguna parte, y se utiliza temporalmente
	con propositos de prueba, porque realmente el valor del atributo href debe ser
	el Servlet que recibe la peticion -->
	<a href="MainController">Recuperar un listado de todos los empleados</a>
</body>
</html>


