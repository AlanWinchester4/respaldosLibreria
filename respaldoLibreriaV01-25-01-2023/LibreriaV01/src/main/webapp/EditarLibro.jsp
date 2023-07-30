<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javaEEJDBC.Libro"%>
<%
	int id = Integer.parseInt(request.getParameter("IdLibro"));
	String StrISBN = request.getParameter("ISBNLibro");
	String StrTitulo = request.getParameter("TitLibro");
	int Cat =Integer.parseInt(request.getParameter("CatLibro"));
	float Pre = Float.parseFloat(request.getParameter("PreLibro"));
	//int filas = new Libro(StrISBN,StrTitulo,Integer.parseInt(Cat),Float.parseFloat(Pre)).insertar();;
	Libro L= new Libro(StrISBN,StrTitulo,Cat,Pre);
	L.modificarLibro(id);
	response.sendRedirect("MostrarLibros.jsp");
%>