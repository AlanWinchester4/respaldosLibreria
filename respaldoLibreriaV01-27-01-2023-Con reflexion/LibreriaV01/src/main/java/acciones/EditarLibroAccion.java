package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.DataBaseException;
import javaEEJDBC.Libro;

public class EditarLibroAccion extends Accion
{
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		int id = Integer.parseInt(request.getParameter("IdLibro"));
		//String id = request.getParameter("IdLibro");
		String StrISBN = request.getParameter("ISBNLibro");
		String StrTitulo = request.getParameter("TitLibro");
		String Cat =request.getParameter("CatLibro");
		String Pre = request.getParameter("PreLibro");
		try 
		{
			new Libro(StrISBN,StrTitulo,Integer.parseInt(Cat),Float.parseFloat(Pre)).modificarLibro(id);	
		} 
		catch (NumberFormatException | DataBaseException e) 
		{
			e.printStackTrace();
		}
		return "MostrarLibros.do";
	}
	

}
