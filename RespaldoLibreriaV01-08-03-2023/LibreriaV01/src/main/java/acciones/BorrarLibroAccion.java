package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;
import dao.LibroDAOJPAImpl;
import servicios.ServicioLibros;

public class BorrarLibroAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		ServicioLibros serviciosLibros = (ServicioLibros) getBean("servicioLibros", request);
		serviciosLibros.borrar(serviciosLibros.buscarporClave(id));
		return "MostrarLibros.do";
	}

}
