package paqueteDePruebas;

public class MensajeHTML implements Mensaje
{
	@Override
	public void hola() 
	{
		System.out.println("<html>Hola<html>");
	}

}
