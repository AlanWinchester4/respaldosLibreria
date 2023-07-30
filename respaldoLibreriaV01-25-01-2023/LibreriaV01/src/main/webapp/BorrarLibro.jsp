<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javaEEJDBC.Libro"%>
<%@ page import="javaEEJDBC.DataBaseException"%>
<%
	String libID = request.getParameter("id");
	int id = Integer.parseInt(libID);
	boolean error = false;
	Libro lib = new Libro();
	try
	{
		lib.BorrarLibro(id);
	}catch(DataBaseException e)
	{%>
		<%out.println("Se disparo la exception!");
			error=true;%>
		<%out.println(e.getMessage()); %>
	<%}	
	if(!error)
	{
		response.sendRedirect("MostrarLibros.jsp");
	}
%>