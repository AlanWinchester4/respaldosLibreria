package dao;

import java.util.List;

import beans.Categoria;
import beans.Libro;

public interface CategoriaDAO 
{	
	public abstract void insertar(Categoria categoria);
	public abstract List<Categoria> buscarTodos();
	public abstract void borrar(Categoria categoria);
	public abstract void guardarCambios(Categoria categoria);
	public abstract List<Integer> buscarLasCategorias();
}
