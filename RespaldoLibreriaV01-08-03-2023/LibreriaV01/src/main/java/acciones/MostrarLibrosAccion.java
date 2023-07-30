package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import beans.Libro;
import dao.CategoriaDAO;
import dao.CategoriaDAOJPAImpl;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;
import dao.LibroDAOJPAImpl;
import dbhHelpers.DataBaseException;
import servicios.ServicioCategoria;
import servicios.ServicioLibros;
import servicios.ServicioLibrosImpl;

public class MostrarLibrosAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		ServicioLibros serviciosLibros = (ServicioLibros) getBean("servicioLibros", request);
		ServicioCategoria servicioCategoria = (ServicioCategoria) getBean("servicioCategoria", request);
		
		List <Libro> listaDeLibros = serviciosLibros.buscarTodos();
		List <Integer> listaDeCategorias = servicioCategoria.buscarLasCategorias();
		
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);	
		return "MostrarLibros.jsp";
	}

}
