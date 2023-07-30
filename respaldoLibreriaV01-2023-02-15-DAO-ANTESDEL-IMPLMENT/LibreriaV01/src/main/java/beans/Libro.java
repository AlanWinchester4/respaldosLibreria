package beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
	
}
