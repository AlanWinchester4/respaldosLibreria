package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.CloseableThreadContext.Instance;

public abstract class Accion 
{
	public abstract String ejecutar(HttpServletRequest request,HttpServletResponse response);
	
	public static Accion getAccion(String tipo)
	{
		Accion accion = null;
				try 
					{
					String text = Accion.class.getPackage()+"."+tipo+"Accion";
					Class c= Class.forName(text.substring(8,text.length()));
					System.out.println("Clase "+c);
					accion = (Accion) c.newInstance();
					} 
				catch (InstantiationException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				catch (IllegalAccessException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				catch (ClassNotFoundException e)
					{
						e.printStackTrace();
					}
		return accion;
		
	}

}
