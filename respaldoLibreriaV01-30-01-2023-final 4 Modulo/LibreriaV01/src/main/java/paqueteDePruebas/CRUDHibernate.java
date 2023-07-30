package paqueteDePruebas;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javaEEJDBC.Libro;


public class CRUDHibernate 
{	
	public static void main(String[] args)
	{
	
		CRUDHibernate hib = new CRUDHibernate();
		hib.leerLibros();
		//hib.altaLibro();
	}
	
	public void leerLibros()
	{
		Session session = null;
		try
		{
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			Query consulta = session.createQuery("from Libro libros");
			List<Libro> listaDeLibros = consulta.list();
			for(Libro L:listaDeLibros)
			{
			//System.out.println(L.getNum_lib()+"\t\t"+L.getisbn_lib()+"\t\t"+L.gettit_lib()+"\t\t"+L.getcat_lib()+"\t\t"+L.getpre_lib());
		System.out.println(L.getNum_lib()+"\t\t"+L.getisbn_lib()+"\t\t"+L.gettit_lib()+"\t\t"+L.getCategoria().getNom_cat());

			}
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if(session!=null) session.close();
		}
		
	}
	
	public void altaLibro()
	{
		Session session = null;
		Transaction transaccion = null;
		try
		{
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			transaccion = session.beginTransaction();
			Libro lib  = new Libro("474747","Programacion Funcional",3,455.23f);
			session.save(lib);
			transaccion.commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			try
			{
				transaccion.rollback();
			}
			catch(IllegalStateException e1)
			{
				System.out.println("No se pudo realizar el rollback");
				e1.printStackTrace();
			}
		}
		catch(SecurityException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(session!=null) session.close();
				
		}
	}
	
	public void borrarLibros(int id)
	{
		Session session = null;
		try
		{
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			Libro libro = (Libro) session.find(Libro.class, id);
			session.beginTransaction();
			session.remove(libro);
			session.flush();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if(session!=null) session.close();
		}
	}
	public void filtrarLibros()
	{
		Session session = null;
		try
		{
			SessionFactory factoria = new Configuration().configure().buildSessionFactory();
			session = factoria.openSession();
			Query consulta = session.createQuery("from Libro libros where libro.cat_lib()");
			List<Libro> listaDeLibros = consulta.list();
			for(Libro L:listaDeLibros)
			{
				System.out.println(L.getNum_lib()+"\t\t"+L.getisbn_lib()+"\t\t"+L.gettit_lib()+"\t\t"+L.getcat_lib()+"\t\t"+L.getpre_lib());
			}
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if(session!=null) session.close();
		}
	}
	
	
	
}
