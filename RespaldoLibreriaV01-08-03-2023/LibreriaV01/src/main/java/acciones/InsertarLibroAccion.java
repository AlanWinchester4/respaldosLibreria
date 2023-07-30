package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import dao.LibroDAOJPAImpl;
import servicios.ServicioLibros;
import servicios.ServicioLibrosImpl;

public class InsertarLibroAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		ServicioLibros serviciosLibros = (ServicioLibros) getBean("servicioLibros", request);
		String StrISBN = request.getParameter("ISBNLibro");
		String StrTitulo = request.getParameter("TitLibro");
		String Cat =request.getParameter("CatLibro");
		String Pre = request.getParameter("PreLibro");
		serviciosLibros.insertar(new Libro(StrISBN,StrTitulo,Integer.parseInt(Cat),Float.parseFloat(Pre)));
		return "MostrarLibros.do";
	}

}
