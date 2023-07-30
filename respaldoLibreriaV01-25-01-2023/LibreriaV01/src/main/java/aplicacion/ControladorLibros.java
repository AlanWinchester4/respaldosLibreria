package aplicacion;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher despachador = null;
		if(request.getServletPath().equals("/MostrarLibros.do"))
		{
			List <Libro> listaDeLibros;
			List <Integer> listaDeCategorias;
			try 
			{
				listaDeLibros = Libro.buscarTodos();
				listaDeCategorias = Libro.buscarLasCategorias();
				
				request.setAttribute("listaDeLibros", listaDeLibros);
				request.setAttribute("listaDeCategorias", listaDeCategorias);		
			} catch (DataBaseException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			despachador = request.getRequestDispatcher("MostrarLibros.jsp");
			despachador.forward(request, response);
		}
		else if(request.getServletPath().equals("/ControladorLibros.do"))
		{
			if(request.getParameter("categoria").equals("seleccionar"))
			{
				despachador = request.getRequestDispatcher("MostrarLibros.do");
				despachador.forward(request, response);
			}
			else
			{
				int C = Integer.parseInt(request.getParameter("categoria"));
				List <Libro> listaDeLibros;
				List <Integer> listaDeCategorias;
				try 
				{
					listaDeLibros = new Libro().buscarPorCategoria(C);
					listaDeCategorias = Libro.buscarLasCategorias();
					
					request.setAttribute("listaDeLibros", listaDeLibros);
					request.setAttribute("listaDeCategorias", listaDeCategorias);		
				} catch (DataBaseException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				despachador = request.getRequestDispatcher("MostrarLibros.jsp");
				despachador.forward(request, response);
			}
		}
		else if(request.getServletPath().equals("/FormularioInsertarLibro.do"))
		{
			List<Integer> listaDeCategorias = null;
			try 
			{
				listaDeCategorias = Libro.buscarLasCategorias();
				request.setAttribute("listaDeCategorias", listaDeCategorias);
				despachador = request.getRequestDispatcher("FormularioAltaLibro.jsp");
				despachador.forward(request, response);
			} catch (DataBaseException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(request.getServletPath().equals("/BorrarLibro.do"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			try 
			{
				new Libro().BorrarLibro(id);
			} catch (DataBaseException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			despachador = request.getRequestDispatcher("MostrarLibros.do");
			despachador.forward(request, response);
		}
		else if(request.getServletPath().equals("/EditarLibro.do"))
		{
			int id = Integer.parseInt(request.getParameter("IdLibro"));
			//String id = request.getParameter("IdLibro");
			String StrISBN = request.getParameter("ISBNLibro");
			String StrTitulo = request.getParameter("TitLibro");
			String Cat =request.getParameter("CatLibro");
			String Pre = request.getParameter("PreLibro");
			try 
			{
				new Libro(StrISBN,StrTitulo,Integer.parseInt(Cat),Float.parseFloat(Pre)).modificarLibro(id);	
			} 
			catch (NumberFormatException | DataBaseException e) 
			{
				e.printStackTrace();
			}
			despachador = request.getRequestDispatcher("MostrarLibros.do");
			despachador.forward(request, response);
		}
		else
		{
			String StrISBN = request.getParameter("ISBNLibro");
			String StrTitulo = request.getParameter("TitLibro");
			String Cat =request.getParameter("CatLibro");
			String Pre = request.getParameter("PreLibro");
			try 
			{
				new Libro(StrISBN,StrTitulo,Integer.parseInt(Cat),Float.parseFloat(Pre)).insertar();	
			} 
			catch (NumberFormatException | DataBaseException e) 
			{
				e.printStackTrace();
			}
			despachador = request.getRequestDispatcher("MostrarLibros.do");
			despachador.forward(request, response);
		}
	}
}
