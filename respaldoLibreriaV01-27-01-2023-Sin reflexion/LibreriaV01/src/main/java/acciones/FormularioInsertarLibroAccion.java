package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaEEJDBC.DataBaseException;
import javaEEJDBC.Libro;

public class FormularioInsertarLibroAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		List<Integer> listaDeCategorias = null;
		try 
		{
			listaDeCategorias = Libro.buscarLasCategorias();
			request.setAttribute("listaDeCategorias", listaDeCategorias);
		} catch (DataBaseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "FormularioAltaLibro.jsp";
	}

}
