package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.LibroDAOJPAImpl;

public class BorrarLibroAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		LibroDAOJPAImpl libDAO = new LibroDAOJPAImpl();
		libDAO.borrar(libDAO.buscarporClave(id));
		return "MostrarLibros.do";
	}

}
