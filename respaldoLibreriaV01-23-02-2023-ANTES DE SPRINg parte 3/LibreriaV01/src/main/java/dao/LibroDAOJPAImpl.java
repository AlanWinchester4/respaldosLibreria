package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import beans.Libro;
import dbhHelpers.JPAHelper;

public class LibroDAOJPAImpl extends GenericDAOJPAImpl<Libro, Integer> implements LibroDAO
{
	public List <Integer> buscarLasCategorias()
	{
		EntityManagerFactory factoriaSession = JPAHelper.buildEntityManagerFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Integer> consulta = manager.createQuery("SELECT DISTINCT libro.cat_lib FROM Libro libro",Integer.class);
		List<Integer> listaDecat_libs = consulta.getResultList();
		manager.close();
		return listaDecat_libs;
	}
	

	public List<Libro> buscarPorCategoria(int Cat)
	{
		EntityManagerFactory factoriaSession = JPAHelper.buildEntityManagerFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Libro> consulta = manager.createQuery("SELECT l From Libro l WHERE l.cat_lib=?1",Libro.class);
		consulta.setParameter(1,Cat);
		List<Libro> listaDeLibros = consulta.getResultList();
		manager.close();
		return listaDeLibros;
	}
}
