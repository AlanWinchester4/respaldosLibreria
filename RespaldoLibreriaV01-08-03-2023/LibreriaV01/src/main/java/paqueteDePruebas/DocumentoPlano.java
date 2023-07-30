package paqueteDePruebas;

public class DocumentoPlano extends Documento
{

	@Override
	protected void imprimirEncabezado() 
	{
		System.out.println("encabezado del documento odicial");
	}

	@Override
	protected void imprimirMensaje(String mensaje) 
	{
		System.out.println(mensaje);
	}

	@Override
	protected void imprimirPie() 
	{
		System.out.println("pie del documento oficial");
	}

}
