package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import dao.LibroDAO;
import dbhHelpers.DataBaseException;

public class FiltrarPorCategoriaAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
			int C = Integer.parseInt(request.getParameter("categoria"));
			List <Libro> listaDeLibros;
			List <Integer> listaDeCategorias;
			listaDeLibros = new LibroDAO().buscarPorCategoria(C);
			listaDeCategorias = new LibroDAO().buscarLasCategorias();
				
			request.setAttribute("listaDeLibros", listaDeLibros);
			request.setAttribute("listaDeCategorias", listaDeCategorias);		
			return "MostrarLibros.jsp";	
	}
}
