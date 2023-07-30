package servicios;

import java.util.List;

import beans.Libro;
import dao.CategoriaDAO;
import dao.LibroDAO;

public class ServicioLibrosImpl implements ServicioLibros
{

	private LibroDAO libroDAO =null;
	private CategoriaDAO categoriaDAO = null;
	
	public ServicioLibrosImpl()
	{
		
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
		//return categoriaDAO.buscarLasCategorias();
		return null;
	}

	@Override
	public LibroDAO getLibroDAO() 
	{
		return libroDAO;
	}

	@Override
	public void setLibroDAO(LibroDAO libroDAO) 
	{
		this.libroDAO = libroDAO;
	}
}
