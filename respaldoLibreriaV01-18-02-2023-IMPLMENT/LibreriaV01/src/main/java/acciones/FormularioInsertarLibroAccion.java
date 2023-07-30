package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.LibroDAOJPAImpl;

public class FormularioInsertarLibroAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		List<Integer> listaDeCategorias = null;
		listaDeCategorias = new LibroDAOJPAImpl().buscarLasCategorias();
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		return "FormularioAltaLibro.jsp";
	}

}
