package acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriaDAO;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAOJPAImpl;

public class FormularioInsertarLibroAccion extends Accion
{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) 
	{
		List<Integer> listaDeCategorias = null;
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
		listaDeCategorias = categoriaDAO.buscarLasCategorias();
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		return "FormularioAltaLibro.jsp";
	}

}
