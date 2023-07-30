package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import dao.LibroDAOJPAImpl;
import dbhHelpers.DataBaseException;

public class MostrarLibrosAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		//llevaria un try
		List <Libro> listaDeLibros;
		List <Integer> listaDeCategorias;
		LibroDAOJPAImpl DAOlib = new LibroDAOJPAImpl();
		listaDeLibros = DAOlib.buscarTodos();
		listaDeCategorias = DAOlib.buscarLasCategorias();
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);	
		return "MostrarLibros.jsp";
	}

}
