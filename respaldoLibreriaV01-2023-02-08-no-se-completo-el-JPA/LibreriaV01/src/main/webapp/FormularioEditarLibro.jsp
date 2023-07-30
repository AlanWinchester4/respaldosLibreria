<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="es">
<%@ page import="beans.Libro"%>
<% int id= Integer.parseInt(request.getParameter("id"));%>
<% Libro lib = new Libro().seleccionarLibro(id);%>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
		<title>Formulario Editar Libro</title>
		<LINK rel="stylesheet" type="text/css" href="css/vista.css"/>
	</head>
	<body>
		<h1>Formulario Editar Libro</h1>
		<form action="EditarLibro.do" method = "GET">
			
			<input type="hidden" name="IdLibro" id="ID" value="<%=lib.getNum_lib()%>"/></p>
			
			<P><labeL for="ISBN">ISBN:</label>
			<input type="text" name="ISBNLibro" id="ISBN" value="<%=lib.getisbn_lib()%>"/></p>
			
			<P><label for="Titulo">Titulo:</label>
			<input type="text" name="TitLibro" id="Titulo"value="<%=lib.gettit_lib()%>"/></p>
			
			<P><label for="Categoria">Categoria:</label>
			<input type="text" name="CatLibro" id="Categoria"value="<%=lib.getcat_lib()%>"/></p>
			
			<P><label for="Precio">Precio:</label>
			<input type="text" name="PreLibro" id="Precio"value="<%=lib.getpre_lib()%>"/></p>
			
			<input type="submit" value="submit"/>
		</form>
	</body>
</html>