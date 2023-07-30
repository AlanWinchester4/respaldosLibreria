package paqueteDePruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import dbhHelpers.DataBaseException;
import dbhHelpers.DataBaseHelper;

public class PruebadeConexion 
{
	//private static final Logger log = Logger.getLogger(DataBaseHelper.class.getPackage().getName());
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL ="jdbc:mysql://localhost:3306/pasteler_software";
	private static final String USUARIO = "pasteler_prueba";
	private static final String CLAVE = "Winchester040601";
	Connection con = null;
	Statement stm = null;
	int filasAfectadas=0;
	
	public Connection conectar() throws DataBaseException
	{
		try 
		{
			Class.forName(DRIVER);
			con= DriverManager.getConnection(URL,USUARIO,CLAVE);
			System.out.println("Concexion ok");		} 
		catch (SQLException e) 
		{
			System.out.println("Error de SQL "+e.getMessage());
			throw new DataBaseException("Error de SQL");
			//e.printStackTrace();
		} catch (ClassNotFoundException e) 
		{
			System.out.println("Error en la conexion"+e.getMessage());
			throw new DataBaseException("Clase No Encontrada");
		}
		return con;
	}
	public static void main(String[] args)
	{
		PruebadeConexion p = new PruebadeConexion();
		try {
			p.conectar();
		} catch (DataBaseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
