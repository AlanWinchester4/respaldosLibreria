package paqueteDePruebas;

public abstract class Documento 
{
	public void imprimir(String mensaje)
	{
		imprimirEncabezado();
		imprimirMensaje(mensaje);
		imprimirPie();
	}
	
	protected abstract void imprimirEncabezado();
	
	protected abstract void imprimirMensaje(String mensaje);
	
	protected abstract void imprimirPie();

}
