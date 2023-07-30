package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.DataBaseException;
import javaEEJDBC.Libro;

public class MostrarLibrosAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		List <Libro> listaDeLibros;
		List <Integer> listaDeCategorias;
		listaDeLibros = Libro.buscarTodos();
		listaDeCategorias = Libro.buscarLasCategorias();
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);		
		return "MostrarLibros.jsp";
	}

}
