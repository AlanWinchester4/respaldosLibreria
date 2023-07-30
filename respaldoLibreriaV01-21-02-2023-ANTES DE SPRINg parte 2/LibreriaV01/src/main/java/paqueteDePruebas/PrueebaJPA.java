package paqueteDePruebas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import beans.Libro;

public class PrueebaJPA 
{

	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cursodia");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Libro> consulta = em.createQuery("SELECT L from Libro L",Libro.class);
		List<Libro> lista = consulta.getResultList();
		for(Libro l :lista)
		{
			System.out.println(l.gettit_lib());
		}
	}

}
