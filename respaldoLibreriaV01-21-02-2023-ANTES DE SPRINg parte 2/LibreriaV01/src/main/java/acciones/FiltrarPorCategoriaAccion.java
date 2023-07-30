package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import dao.CategoriaDAO;
import dao.CategoriaDAOJPAImpl;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;
import dao.LibroDAOJPAImpl;

public class FiltrarPorCategoriaAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
			int C = Integer.parseInt(request.getParameter("categoria"));
			List <Libro> listaDeLibros;
			List <Integer> listaDeCategorias;
			DAOFactory factoria = DAOAbstractFactory.getInstance();
			CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
			LibroDAO libroDAO = factoria.getLibroDAO();
			listaDeLibros = libroDAO.buscarPorCategoria(C);
			listaDeCategorias = categoriaDAO.buscarLasCategorias();		
			request.setAttribute("listaDeLibros", listaDeLibros);
			request.setAttribute("listaDeCategorias", listaDeCategorias);		
			return "MostrarLibros.jsp";	
	}
}
