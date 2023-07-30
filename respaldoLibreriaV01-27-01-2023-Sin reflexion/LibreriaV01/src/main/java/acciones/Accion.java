package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Accion 
{
	public abstract String ejecutar(HttpServletRequest request,HttpServletResponse response);
	
	public static Accion getAccion(String tipo)
	{
		Accion accion = null;
		if(tipo.equals("MostrarLibros"))
		{
			accion = new MostrarLibrosAccion();
		}
		else if(tipo.equals("FormularioInsertarLibro"))
		{
			accion = new FormularioInsertarLibroAccion();
		}
		else if(tipo.equals("InsertarLibro"))
		{
			accion = new InsertarLibroAccion();
		}
		else if(tipo.equals("BorrarLibro"))
		{
			accion = new BorrarLibroAccion();
		}
		else if(tipo.equals("EditarLibro"))
		{
			accion = new EditarLibroAccion();
		}
		return accion;
		
	}

}
