package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Libro;
import servicios.ServicioLibros;

public class EditarLibroAccion extends Accion
{
	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		int id = Integer.parseInt(request.getParameter("IdLibro"));
		String StrISBN = request.getParameter("ISBNLibro");
		String StrTitulo = request.getParameter("TitLibro");
		String Cat =request.getParameter("CatLibro");
		String Pre = request.getParameter("PreLibro");
		
		ServicioLibros serviciosLibros = (ServicioLibros) getBean("servicioLibros", request);
		//LibroDAO libroDAO = serviciosLibros.getLibroDAO();
		
		//Libro libro = libroDAO.buscarporClave(id);
		Libro libro = serviciosLibros.buscarporClave(id);
		libro.setisbn_lib(StrISBN);
		libro.settit_lib(StrTitulo);
		libro.setcat_lib(Integer.parseInt(Cat));
		libro.setpre_lib(Float.parseFloat(Pre));
		serviciosLibros.guardarCambios(libro);
		//serviciosLibros.guardarCambios(libro);
		return "MostrarLibros.do";
	}
	

}
