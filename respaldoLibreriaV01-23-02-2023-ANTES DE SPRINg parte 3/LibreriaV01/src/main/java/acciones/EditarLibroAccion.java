package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import dao.CategoriaDAO;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;
import dao.LibroDAOJPAImpl;

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
		
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		LibroDAO libroDAO = factoria.getLibroDAO();
		
		Libro libro = libroDAO.buscarporClave(id);
		libro.setisbn_lib(StrISBN);
		libro.settit_lib(StrTitulo);
		libro.setcat_lib(Integer.parseInt(Cat));
		libro.setpre_lib(Float.parseFloat(Pre));
		libroDAO.guardarCambios(libro);
		return "MostrarLibros.do";
	}
	

}
