package servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import beans.Categoria;
import dao.CategoriaDAO;
import dao.GenericDAOJPAImpl;
import dbhHelpers.JPAHelper;

public class ServicioCategoriaImpl extends GenericDAOJPAImpl<Categoria, Integer> implements ServicioCategoria
{
	CategoriaDAO categoriaDAO = null;
	public List <Integer> buscarLasCategorias()
	{
		EntityManagerFactory factoriaSession = JPAHelper.buildEntityManagerFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Integer> consulta = manager.createQuery("SELECT DISTINCT libro.cat_lib FROM Libro libro",Integer.class);
		List<Integer> listaDecat_libs = consulta.getResultList();
		manager.close();
		return listaDecat_libs;
	}

	@Override
	public void insertar(Categoria categoria) 
	{
		
	}

	@Override
	public void borrar(Categoria categoria) 
	{

	}

	@Override
	public void guardarCambios(Categoria categoria) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public CategoriaDAO getCategoriaDAO() 
	{
		return categoriaDAO;
	}

	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) 
	{
		this.categoriaDAO = categoriaDAO;
	}
}