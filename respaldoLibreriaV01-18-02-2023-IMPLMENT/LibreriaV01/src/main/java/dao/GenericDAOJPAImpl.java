package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import dbhHelpers.JPAHelper;

@SuppressWarnings("hiding")
public abstract class GenericDAOJPAImpl <T,Id extends Serializable> implements GenericDAO<T,Id>
{
	private Class<T> claseDePersistencia;
	
	@SuppressWarnings("unchecked")
	public GenericDAOJPAImpl()
	{
		this.claseDePersistencia = (Class <T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	public T buscarporClave(Id id)
	{
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		T objeto = null;
		try
		{
			objeto = (T) manager.find(claseDePersistencia, id);
			return objeto;
		}catch(PersistenceException e)
		{
			e.printStackTrace();
		}
		finally
		{
			manager.close();
		}
		return objeto;
	}
	public List<T> buscarTodos()
	{
		//EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		//EntityManager manager = factoriaSession.createEntityManager();
		//List<T> listaDeObjetos = null;
		TypedQuery<T> consulta = null;
		try
		{
			consulta = JPAHelper.getJPAFactory().createEntityManager().createQuery("SELECT o FROM "+ claseDePersistencia.getSimpleName()+ " o",claseDePersistencia);
			//listaDeObjetos = consulta.getResultList();	
		}
		catch(PersistenceException e)
		{
			e.printStackTrace();
		}
		return consulta.getResultList();
		/*finally
		{
			manager.close();
		}*/
		//return listaDeObjetos;
	}
	public void borrar(T objeto)
	{
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		try
		{	
			tx = manager.getTransaction();
			tx.begin();
			manager.remove(manager.merge(objeto));
			tx.commit();
			
		}
		catch(PersistenceException e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			manager.close();
		}
	}
	public void insertar(T objeto)
	{
		EntityManagerFactory factoriaSession= JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		try 
		{
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(objeto);
			tx.commit();
		}
		catch(PersistenceException e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			manager.close();
		}
	}
	public void guardarCambios(T objeto)
	{
		EntityManagerFactory factoriaSession= JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		try 
		{
			tx = manager.getTransaction();
			tx.begin();
			manager.merge(objeto);
			tx.commit();
		}
		catch(PersistenceException e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			manager.close();
		}
	}
}
