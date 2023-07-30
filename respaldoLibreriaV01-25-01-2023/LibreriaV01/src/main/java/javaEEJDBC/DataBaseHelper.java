package javaEEJDBC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class DataBaseHelper<T> extends Libro
{
	private static final Logger log = Logger.getLogger(DataBaseHelper.class.getPackage().getName());
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL ="jdbc:mysql://localhost/libreria";
	private static final String USUARIO = "root";
	private static final String CLAVE = "";
	Connection con = null;
	Statement stm = null;
	int filasAfectadas=0;
	
	public DataBaseHelper() throws DataBaseException
	{
		log.setLevel(Level.DEBUG);
		try 
		{
			Class.forName(DRIVER);
			con= DriverManager.getConnection(URL,USUARIO,CLAVE);	
		} 
		catch (SQLException e) 
		{
			System.out.println("Error de SQL "+e.getMessage());
			throw new DataBaseException("Error de SQL");
			//e.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			System.out.println("Clase No Encontrada "+e.getMessage());
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new DataBaseException("Clase No Encontrada");
		}
	}
	public int modificarRegistro(String querySQL) throws DataBaseException
	{	
		try 
		{
			stm = con.createStatement();
			filasAfectadas = stm.executeUpdate(querySQL);
		} catch (SQLException e) 
		{	
			System.out.println("Error de SQL "+e.getMessage());
			throw new DataBaseException("Error de SQL ");
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		cerrarObjetos();
		return filasAfectadas;
	}
	public void cerrarObjetos() 
	{
		try 
		{	
			if(stm!=null) stm.close();
			if(con!=null) con.close();
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
	@SuppressWarnings({ "unchecked", "removal" })
	public List<T> seleccionarRegistros(String query,Class clase) throws DataBaseException
	{
		ResultSet filas= null;
		List<T> listadeObjetos = new ArrayList<T>();
		try
		{
			stm = con.createStatement();
			filas = stm.executeQuery(query);
			while (filas.next())
			{
				Integer x = 1;
				String linea = ""+Class.forName(clase.getName());
				if(!linea.equals("class java.lang.Integer"))
					{
					//System.out.println("entro al librio");
						T objeto = (T) Class.forName(
								clase.getName()).getDeclaredConstructor().newInstance();
						Method[] metodos = objeto.getClass().getDeclaredMethods();
						for(int i = 0; i<metodos.length; i++)
						{
							if(metodos[i].getName().startsWith("set"))
							{
								//System.out.println(metodos[i].getName().startsWith("set")+"este es el primero");
								if((metodos[i].getName().substring(3).equals("num_lib") || (metodos[i].getName().substring(3)).equals("cat_lib")))
								{
									metodos[i].invoke(objeto, filas.getInt(metodos[i].getName().substring(3))); 
									//System.out.println(metodos[i].getName().substring(3));
								}
								else if((metodos[i].getName().substring(3)).equals("pre_lib"))
								{
									metodos[i].invoke(objeto, filas.getFloat(metodos[i].getName().substring(3))); 
									//System.out.println(metodos[i].getName().substring(3));
								}
								else
								{
									metodos[i].invoke(objeto, filas.getString(metodos[i].getName().substring(3)));
									//System.out.println(metodos[i].getName().substring(3));
								}
							}	
						}
						listadeObjetos.add(objeto);
				}
				if(linea.equals("class java.lang.Integer"))
					{
					//System.out.println("entro a las categorias");

					//System.out.println(filas.getInt("cat_lib"));
					x =(filas.getInt("cat_lib"));
						listadeObjetos.add((T) x);
					}	
			}
		}catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException | InvocationTargetException | IllegalArgumentException | NoSuchMethodException | SecurityException e)
		{
			log.error("Error en el DataBaseHelper" + e.getMessage());
			System.out.println("Error al seleccionar Registros "+e.getMessage());
			throw new DataBaseException("Error al leer Registros ");
		}
		return listadeObjetos;
	}
	public int actualizarRegistro(int id,Libro lib)
	{
		String SQL = "UPDATE Libros SET isbn_lib = ?,tit_lib = ?, cat_lib = ?, pre_lib = ?"
				+ " WHERE num_lib = ?";
		int filas=-1;
		try 
		{
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, lib.getisbn_lib());
			ps.setString(2, lib.gettit_lib());
			ps.setInt(3, lib.getcat_lib());
			ps.setFloat(4, lib.getpre_lib());
			ps.setInt(5, id);
			filas = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cerrarObjetos();
		return filas;
	}
	
	
	
	
	
	
}
