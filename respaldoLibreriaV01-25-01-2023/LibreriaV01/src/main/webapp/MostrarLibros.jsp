<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page import= "java.util.List"%>
<%@ page import= "javaEEJDBC.Libro"%>
<%@ page import= "javaEEJDBC.DataBaseException"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
<title>Insert title here</title>
<LINK rel="stylesheet" type="text/css" href="css/vista.css"/>
</head>
<body>
<form action="ControladorLibros.do" method = "GET">
	<select name= "categoria">
	<option value= "seleccionar">Seleccionar</option>
			<!--List<Integer> ListaCategorias = null;
			ListaCategorias = (List<Integer>)request.getAttribute("listaDeCategorias");-->
			<c:forEach var = "cat" items="${listaDeCategorias}">
				<option value="${cat}">${cat}</option>
			</c:forEach>
	</select>
	<INPUT type="submit" value="Filtrar"/>
</form>
<br/>
	<DIV class="div-tabla">
		<h1>Tabla de Libros</h1>
		<table class = "content-table">
			<thead>
				<tr>
					<th >Numero de Libro</th>
					<th class="col">ISBN</th>
					<th>Titulo de Libro</th>
					<th>Categoria</th>
					<th class="col">Precio</th>
					<th class="col">Opciones</th>
				</tr>
			</thead>	
				<TBODY>
					<c:forEach var="L" items="${listaDeLibros}">
								<TR>
									<td class = "col-num">${L.getNum_lib()}</td>
									<td class ="active-row">${L.getisbn_lib()}</td>
									<td>${L.gettit_lib()}</td>
									<td class = "col-cat">
										<c:forEach var="cat" items="${listaDeCategorias}">
											<c:if test="${L.getcat_lib() == cat}">${cat}</c:if>
										</c:forEach>
									</td>
									<td class = "col-pre">${L.getpre_lib()}</td>
									<td>
										<a href="BorrarLibro.do?id=${L.getNum_lib()}">Borrar</a>
										<a href="FormularioEditarLibro.jsp?id=${L.getNum_lib()}">Editar</a>
									</td>
								</TR>
					</c:forEach>			
				</TBODY>
				<!-- <TBODY>
							
						List<Libro> ListaLibros = null;
						if(request.getParameter("categoria")==null || 
							request.getParameter("categoria").equals("seleccionar"))
						{	
								ListaLibros = (List<Libro>)request.getAttribute("listaDeLibros");
							
						}
						else
						{
							//int C = Integer.parseInt(request.getParameter("categoria"));
						//	ListaLibros = new Libro().buscarPorCategoria(C);
							ListaLibros = (List<Libro>)request.getAttribute("listaDeLibros");
						}
						try
						{
							for(Libro L: ListaLibros) 
							
							<TR>
								<td class = "col-num">L.getNum_lib()</td>
								<td class ="active-row">L.getisbn_lib()</td>
								<td>L.gettit_lib()</td>
								<td class = "col-cat">L.getcat_lib()</td>
								<td class = "col-pre">L.getpre_lib(></td>
								<td><a href="BorrarLibro.do?id=L.getNum_lib()">Borrar</a>
								<a href="FormularioEditarLibro.jsp?id=L.getNum_lib()">Editar</a></td>
							</TR>
							}	
						}catch(NullPointerException e)
						{
						 out.println("<br>Lista de Libros esta Vacia!</br>");
						}	
					
				</TBODY> -->
		</table>
	</DIV>
<a id=link href="FormularioAltaLibro.jsp">Insertar Nuevo Libro</a>
</body>
</html>