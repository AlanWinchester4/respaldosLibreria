package servicios;

import java.util.List;

import beans.Libro;
import dao.CategoriaDAO;
import dao.LibroDAO;

public interface ServicioLibros 
{
	public abstract void insertar(Libro libro);
	public abstract List<Libro> buscarTodos();
	public abstract void borrar(Libro libro);
	public abstract void guardarCambios(Libro libro);
	public abstract Libro buscarporClave(Integer id);
	public abstract List<Libro> buscarPorCategoria(int Cat);
	public abstract List<Integer> buscarLasCategorias();
	
	public LibroDAO getLibroDAO();
	public void setLibroDAO(LibroDAO libroDAO);
}
