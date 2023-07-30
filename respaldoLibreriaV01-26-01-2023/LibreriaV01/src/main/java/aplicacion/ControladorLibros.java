package aplicacion;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acciones.Accion;
import acciones.BorrarLibroAccion;
import acciones.ControladorLibrosAccion;
import acciones.EditarLibroAccion;
import acciones.InsertarLibroAccion;
import acciones.MostrarLibroAccion;
import acciones.VistaInsertarLibroAccion;
import javaEEJDBC.DataBaseException;
import javaEEJDBC.Libro;

/**
 * Servlet implementation class ControladorLibros
 */
//@WebServlet("/ControladorLibros")
public class ControladorLibros extends HttpServlet 
 {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorLibros() 
    {
        super();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher despachador = null;
		Accion accion = null;
		if(request.getServletPath().equals("/MostrarLibros.do"))
			{
				accion = new MostrarLibroAccion();
			}
		else if(request.getServletPath().equals("/ControladorLibros.do"))
			{
				accion = new ControladorLibrosAccion();
			}
		else if(request.getServletPath().equals("/FormularioInsertarLibro.do"))
			{
				accion = new VistaInsertarLibroAccion();
			}
		else if(request.getServletPath().equals("/BorrarLibro.do"))
			{
				accion = new BorrarLibroAccion();
			}
		else if(request.getServletPath().equals("/EditarLibro.do"))
			{
				accion = new EditarLibroAccion();
			}
		else if(request.getServletPath().equals("/InsertarLibro.do"))
			{
				accion = new InsertarLibroAccion();
			}
		if(accion != null)
			{
				despachador = request.getRequestDispatcher(accion.ejecutar(request, response));
				despachador.forward(request, response);
			}
	}
}
