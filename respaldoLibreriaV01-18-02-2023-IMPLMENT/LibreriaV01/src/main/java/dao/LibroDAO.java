package dao;

import java.util.List;

import beans.Libro;

public interface LibroDAO 
{
	public abstract void insertar(Libro libro);
	public abstract List<Libro> buscarTodos();
	public abstract void borrar(Libro libro);
	public abstract void guardarCambios(Libro libro);
	public abstract Libro buscarporClave(Integer id);
	public abstract List<Libro> buscarPorCategoria(int Cat);
}
