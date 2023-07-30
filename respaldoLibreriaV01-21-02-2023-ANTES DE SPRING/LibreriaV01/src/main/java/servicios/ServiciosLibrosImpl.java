package servicios;

import java.util.List;

import beans.Libro;
import dao.CategoriaDAO;
import dao.DAOAbstractFactory;
import dao.DAOFactory;
import dao.LibroDAO;

public class ServiciosLibrosImpl implements ServiciosLibros
{

	private LibroDAO libroDAO =null;
	private CategoriaDAO categoriaDAO = null;
	
	public ServiciosLibrosImpl()
	{
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		libroDAO = factoria.getLibroDAO();
		categoriaDAO = factoria.getCategoriaDAO();
	}
	
	@Override
	public void insertar(Libro libro) 
	{
		libroDAO.insertar(libro);;
	}

	@Override
	public List<Libro> buscarTodos() 
	{
		return libroDAO.buscarTodos();
	}

	@Override
	public void borrar(Libro libro) 
	{
		libroDAO.borrar(libro);
	}

	@Override
	public void guardarCambios(Libro libro) 
	{
		libroDAO.guardarCambios(libro);
	}

	@Override
	public Libro buscarporClave(Integer id) 
	{
		return libroDAO.buscarporClave(id);
	}

	@Override
	public List<Libro> buscarPorCategoria(int Cat) 
	{
		return libroDAO.buscarPorCategoria(Cat);
	}
	@Override
	public List<Integer> buscarLasCategorias()
	{
		return categoriaDAO.buscarLasCategorias();
	}
}
