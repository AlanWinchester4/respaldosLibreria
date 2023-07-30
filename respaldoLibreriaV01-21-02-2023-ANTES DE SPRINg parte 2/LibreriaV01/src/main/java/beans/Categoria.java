package beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "categorias")
public class Categoria 
{
	@Id
	@PrimaryKeyJoinColumn(name = "num_cat")
	private int num_cat;
	@Fetch(value = FetchMode.SELECT)
	@OneToMany
	@JoinColumn(name = "num_cat")
	private List<Libro> listaDeLibros;
	public List<Libro> getListaDeLibros() 
	{
		return listaDeLibros;
	}
	public void setListaDeLibros(List<Libro> listaDeLibros) 
	{
		this.listaDeLibros = listaDeLibros;
	}	
	private String nom_cat;
	
	////////////////////////////////////////////////////////////
	
	public Categoria()
	{
	}
	public int getNum_cat() 
	{
		return num_cat;
	}
	public void setNum_cat(int num_cat) 
	{
		this.num_cat = num_cat;
	}
	public String getNom_cat() 
	{
		return nom_cat;
	}
	public void setNom_cat(String nom_cat) 
	{
		this.nom_cat = nom_cat;
	}
	
}
