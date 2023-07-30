package dao;

public class DAOJPAFactory implements DAOFactory
{
	public CategoriaDAO getCategoriaDAO()
	{
		return new CategoriaDAOJPAImpl();
	}
	public LibroDAO getLibroDAO()
	{
		return new LibroDAOJPAImpl();
	}
}
