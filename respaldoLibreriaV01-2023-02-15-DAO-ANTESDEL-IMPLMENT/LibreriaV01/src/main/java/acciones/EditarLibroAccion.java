package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Libro;
import dao.LibroDAO;
import dbhHelpers.DataBaseException;
import dbhHelpers.HibernateHelper;

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
		
		LibroDAO LibDAO = new LibroDAO();
		Libro libro = LibDAO.seleccionarLibro(id);
		libro.setisbn_lib(StrISBN);
		libro.settit_lib(StrTitulo);
		libro.setcat_lib(Integer.parseInt(Cat));
		libro.setpre_lib(Float.parseFloat(Pre));
		LibDAO.guardarCambios(libro);
		return "MostrarLibros.do";
	}
	

}
