package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.DataBaseException;
import javaEEJDBC.Libro;

public class BorrarLibroAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		try 
		{
			new Libro().BorrarLibro(id);
		} catch (DataBaseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "MostrarLibros.do";
	}

}
