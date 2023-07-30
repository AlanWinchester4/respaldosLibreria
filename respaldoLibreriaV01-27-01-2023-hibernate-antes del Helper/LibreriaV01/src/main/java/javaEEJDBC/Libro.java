package javaEEJDBC;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "libros")
public class Libro 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_lib;
	private String isbn_lib;
	private String tit_lib;
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
	
	public static List <Integer> buscarLasCategorias() throws DataBaseException
	{
		String consultaSQL = " SELECT DISTINCT(cat_lib) FROM libros";
		DataBaseHelper dbh = new DataBaseHelper();

		@SuppressWarnings("unchecked")
		List <Integer> ListaDecat_libs= dbh.seleccionarRegistros(consultaSQL,Integer.class);
		//List <Integer> ListaDecat_libs = new ArrayList<Integer>();
		dbh.cerrarObjetos();
		return ListaDecat_libs;
	}
	
	public int insertar() throws DataBaseException
	{
		String consultaSQL ="INSERT INTO Libros(isbn_lib,tit_lib,cat_lib,pre_lib) VALUES ";
		consultaSQL += "('"+isbn_lib+"','"+tit_lib+"',"+cat_lib+","+pre_lib+")";
		DataBaseHelper dbh = new DataBaseHelper();
		int filasM = dbh.modificarRegistro(consultaSQL);
		dbh.cerrarObjetos();
		return filasM;
	}
	@SuppressWarnings("unchecked")
	public static List<Libro> buscarTodos() throws DataBaseException
	{
		String SQL = "SELECT * FROM libros";
		DataBaseHelper dbh = new DataBaseHelper();
		List <Libro> ListaDeLibros= dbh.seleccionarRegistros(SQL,Libro.class);
		dbh.cerrarObjetos();
		return ListaDeLibros;
	}
	public void BorrarLibro(int id) throws DataBaseException
	{
		String SQL = "DELETE FROM libros WHERE num_lib = "+id;
		DataBaseHelper dbh = new DataBaseHelper();
		int f = dbh.modificarRegistro(SQL);
		System.out.println(f);
	}
	@SuppressWarnings("unchecked")
	public Libro seleccionarLibro(int id) throws DataBaseException
	{
		String SQL = "SELECT * FROM libros WHERE num_lib = "+id;
		DataBaseHelper dbh = new DataBaseHelper();
		List <Libro> ListaDeLibros = dbh.seleccionarRegistros(SQL,Libro.class);
			dbh.cerrarObjetos();
			System.out.println(ListaDeLibros.get(0));
			return ListaDeLibros.get(0);
	}
	public void modificarLibro(int id) throws DataBaseException
	{		
		DataBaseHelper dbh = new DataBaseHelper();
		int filasM = dbh.actualizarRegistro(id, this);
		System.out.println("Filas modificadas: "+filasM);
	} 
	
	public List<Libro> buscarPorCategoria(int Cat) throws DataBaseException
	{
		String SQL = "SELECT * FROM Libros WHERE cat_lib ="+Cat;
		DataBaseHelper dbh = new DataBaseHelper();
		@SuppressWarnings("unchecked")
		List <Libro> ListaDeLibros = dbh.seleccionarRegistros(SQL,Libro.class);
		dbh.cerrarObjetos();
		return ListaDeLibros;
	}
	
	
	
	
	
	
}
