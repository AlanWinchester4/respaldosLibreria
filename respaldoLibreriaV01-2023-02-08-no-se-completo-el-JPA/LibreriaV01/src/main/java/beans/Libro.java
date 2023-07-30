package beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import dbhHelpers.DataBaseException;
import dbhHelpers.HibernateHelper;
import dbhHelpers.JPAHelper;
@Entity
@Table(name = "libros")
public class Libro 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_lib;
	private String isbn_lib;
	private String tit_lib;
	@ManyToOne
	@JoinColumn(name = "cat_Lib", referencedColumnName ="num_cat",insertable = false, updatable= false, nullable = false)
	private Categoria categoria;
	
	public Categoria getCategoria() 
	{
		return categoria;
	}
	public void setCategoria(Categoria categoria) 
	{
		this.categoria = categoria;
	}
	private int cat_lib;
	private float pre_lib;
	
	public Libro(String isbn_lib, String tit_lib, int cat_lib, float pre_lib) 
	{
		this.isbn_lib= isbn_lib;
		this.tit_lib = tit_lib;
		this.cat_lib = cat_lib;
		this.pre_lib = pre_lib;
	}
	public Libro()
	{
		
	}

	protected void setnum_lib(int num_lib) 
	{
		this.num_lib = num_lib;
	}
	public int getNum_lib() 
	{
		return num_lib;
	}
	
	public String getisbn_lib() 
	{
		return isbn_lib;
	}
	public void setisbn_lib(String isbn_lib) 
	{
		this.isbn_lib = isbn_lib;
	}
	public String gettit_lib() 
	{
		return tit_lib;
	}
	public void settit_lib(String tit_lib) 
	{
		this.tit_lib = tit_lib;
	}
	public int getcat_lib() 
	{
		return cat_lib;
	}
	public void setcat_lib(int cat_lib) 
	{
		this.cat_lib = cat_lib;
	}
	public float getpre_lib() 
	{
		return pre_lib;
	}
	public void setpre_lib(float pre_lib) 
	{
		this.pre_lib = pre_lib;
	}
	
	@SuppressWarnings("unchecked")
	public static List <Integer> buscarLasCategorias()
	{
		EntityManagerFactory factoriaSession = JPAHelper.buildEntityManagerFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Integer> consulta = manager.createQuery("SELECT DISTINCT libro.cat_lib FROM Libro libro",Integer.class);
		List<Integer> listaDecat_libs = consulta.getResultList();
		manager.close();
		return listaDecat_libs;
	}
	
	public void insertar()
	{
		EntityManagerFactory factoriaSession= JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		tx = manager.getTransaction();
		tx.begin();
		manager.persist(this);
		tx.commit();
		manager.close();
	}
	@SuppressWarnings("unchecked")
	public static List<Libro> buscarTodos()
	{
		EntityManagerFactory factoriaSession = JPAHelper.buildEntityManagerFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Libro> consulta = manager.createQuery("SELECT l From Libro l JOIN FETCH l.categoria",Libro.class);
		List<Libro> listaDeLibros = consulta.getResultList();
		manager.close();
		return listaDeLibros;
	}
	public void BorrarLibro()
	{
		EntityManagerFactory factoriaSession= JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		tx = manager.getTransaction();
		tx.begin();
		manager.remove(manager.merge(this));
		tx.commit();
		manager.close();
	}
	
	public void guardarCambios()
	{
		EntityManagerFactory factoriaSession= JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		EntityTransaction tx = null;
		tx = manager.getTransaction();
		tx.begin();
		manager.merge(this);
		tx.commit();
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	public Libro seleccionarLibro(int id) throws DataBaseException
	{
		EntityManagerFactory factoriaSession = JPAHelper.buildEntityManagerFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Libro> consulta = manager.createQuery("SELECT l From Libro 1 JOIN FETCH l.categoria WHERE l.num_lib=?1",Libro.class);
		consulta.setParameter(1,id);
		Libro libro = consulta.getSingleResult();
		manager.close();	
		return libro;
	}
	
	public List<Libro> buscarPorCategoria(int Cat) throws DataBaseException
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
