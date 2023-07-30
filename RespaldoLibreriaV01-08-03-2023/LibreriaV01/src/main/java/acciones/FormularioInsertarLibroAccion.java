package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAOJPAImpl;
import servicios.ServicioCategoria;

public class FormularioInsertarLibroAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		
		ServicioCategoria servicioCategoria = (ServicioCategoria) getBean("servicioCategoria", request);
		//CategoriaDAO categoriaDAO = servicioCategoria.getCategoriaDAO();
		List<Integer> listaDeCategorias = servicioCategoria.buscarLasCategorias();
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		return "FormularioAltaLibro.jsp";
	}

}
