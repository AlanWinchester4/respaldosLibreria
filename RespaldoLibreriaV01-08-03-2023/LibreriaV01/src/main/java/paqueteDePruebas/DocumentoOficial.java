package paqueteDePruebas;

public class DocumentoOficial extends Documento
{

	@Override
	protected void imprimirEncabezado() 
	{
		System.out.println("<oficial>encabezado del documento oficial</oficial>");
	}

	@Override
	protected void imprimirMensaje(String mensaje) 
	{
		System.out.println("<oficial>"+mensaje+"</oficial>");
	}

	@Override
	protected void imprimirPie() 
	{
		System.out.println("<oficial> pie del documento oficial</oficial>");
	}

}
