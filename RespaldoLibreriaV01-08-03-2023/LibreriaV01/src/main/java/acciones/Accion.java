 package acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
	public Object getBean(String nombre, HttpServletRequest request)
	{
		WebApplicationContext factoria = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
		return factoria.getBean(nombre);
	}
	
	
	

}
