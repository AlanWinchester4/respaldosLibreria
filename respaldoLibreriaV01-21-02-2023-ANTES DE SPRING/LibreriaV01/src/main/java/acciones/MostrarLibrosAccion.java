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
import servicios.ServiciosLibros;
import servicios.ServiciosLibrosImpl;

public class MostrarLibrosAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		//llevaria un try
		//List <Libro> listaDeLibros;
		//List <Integer> listaDeCategorias;
		//DAOFactory factoria = DAOAbstractFactory.getInstance();
		//CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
		//LibroDAO libroDAO = factoria.getLibroDAO();
		ServiciosLibros serviciosLibros = new ServiciosLibrosImpl();
		//listaDeLibros = libroDAO.buscarTodos();
		//listaDeCategorias = categoriaDAO.buscarLasCategorias();
		List <Libro> listaDeLibros = serviciosLibros.buscarTodos();
		List <Integer> listaDeCategorias = serviciosLibros.buscarLasCategorias();
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);	
		return "MostrarLibros.jsp";
	}

}
