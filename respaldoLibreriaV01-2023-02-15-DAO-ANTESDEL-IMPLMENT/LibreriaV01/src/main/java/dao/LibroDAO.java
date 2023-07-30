package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import beans.Libro;
import dbhHelpers.DataBaseException;
import dbhHelpers.JPAHelper;

public class LibroDAO 
{
	@SuppressWarnings("unchecked")
	public List <Integer> buscarLasCategorias()
	{
		EntityManagerFactory factoriaSession = JPAHelper.buildEntityManagerFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Integer> consulta = manager.createQuery("SELECT DISTINCT libro.cat_lib FROM Libro libro",Integer.class);
		List<Integer> listaDecat_libs = consulta.getResultList();
		manager.close();
		return listaDecat_libs;
	}
	
	public void insertar(Libro lib)
	{
		EntityManagerFactory factoriaSession= JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		tx = manager.getTransaction();
		tx.begin();
		manager.persist(lib);
		tx.commit();
		manager.close();
	}
	@SuppressWarnings("unchecked")
	public List<Libro> buscarTodos()
	{
		EntityManagerFactory factoriaSession = JPAHelper.buildEntityManagerFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Libro> consulta = manager.createQuery("SELECT l From Libro l JOIN FETCH l.categoria",Libro.class);
		List<Libro> listaDeLibros = consulta.getResultList();
		manager.close();
		return listaDeLibros;
	}
	public void BorrarLibro(Libro lib)
	{
		EntityManagerFactory factoriaSession= JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		tx = manager.getTransaction();
		tx.begin();
		manager.remove(manager.merge(lib));
		tx.commit();
		manager.close();
	}
	
	public void guardarCambios(Libro lib)
	{
		EntityManagerFactory factoriaSession= JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		tx = manager.getTransaction();
		tx.begin();
		manager.merge(lib);
		tx.commit();
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	public Libro seleccionarLibro(int id)
	{
		EntityManagerFactory factoriaSession = JPAHelper.buildEntityManagerFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Libro> consulta = manager.createQuery("SELECT l From Libro l JOIN FETCH l.categoria WHERE l.num_lib=?1",Libro.class);
		consulta.setParameter(1,id);
		Libro libro = consulta.getSingleResult();
		manager.close();	
		return libro;
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
