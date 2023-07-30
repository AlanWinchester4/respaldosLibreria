package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.DataBaseException;
import javaEEJDBC.Libro;

public class ControladorLibrosAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		if(request.getParameter("categoria").equals("seleccionar"))
		{
			return "MostrarLibros.do";
		}
		else
		{
			int C = Integer.parseInt(request.getParameter("categoria"));
			List <Libro> listaDeLibros;
			List <Integer> listaDeCategorias;
			try 
			{
				listaDeLibros = new Libro().buscarPorCategoria(C);
				listaDeCategorias = Libro.buscarLasCategorias();
				
				request.setAttribute("listaDeLibros", listaDeLibros);
				request.setAttribute("listaDeCategorias", listaDeCategorias);		
			} catch (DataBaseException e) 
			{
				e.printStackTrace();
			}
			return "MostrarLibros.jsp";
		}
		
	}

}
