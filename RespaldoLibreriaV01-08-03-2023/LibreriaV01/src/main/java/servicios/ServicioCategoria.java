package servicios;

import java.util.List;

import beans.Categoria;
import beans.Libro;
import dao.CategoriaDAO;

public interface ServicioCategoria 
{	
	public abstract void insertar(Categoria categoria);
	public abstract List<Categoria> buscarTodos();
	public abstract void borrar(Categoria categoria);
	public abstract void guardarCambios(Categoria categoria);
	public abstract List<Integer> buscarLasCategorias();
	
	public CategoriaDAO getCategoriaDAO();
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);
}
