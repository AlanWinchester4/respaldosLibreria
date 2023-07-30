package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.DataBaseException;
import javaEEJDBC.Libro;

public class MostrarLibroAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		List <Libro> listaDeLibros;
		List <Integer> listaDeCategorias;
		try 
		{
			listaDeLibros = Libro.buscarTodos();
			listaDeCategorias = Libro.buscarLasCategorias();
			
			request.setAttribute("listaDeLibros", listaDeLibros);
			request.setAttribute("listaDeCategorias", listaDeCategorias);		
		} catch (DataBaseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "MostrarLibros.jsp";
	}

}
