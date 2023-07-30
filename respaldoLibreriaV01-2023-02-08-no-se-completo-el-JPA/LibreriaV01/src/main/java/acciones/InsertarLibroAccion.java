package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import dbhHelpers.DataBaseException;

public class InsertarLibroAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		String StrISBN = request.getParameter("ISBNLibro");
		String StrTitulo = request.getParameter("TitLibro");
		String Cat =request.getParameter("CatLibro");
		String Pre = request.getParameter("PreLibro");
		new Libro(StrISBN,StrTitulo,Integer.parseInt(Cat),Float.parseFloat(Pre)).insertar();	
		return "MostrarLibros.do";
	}

}
