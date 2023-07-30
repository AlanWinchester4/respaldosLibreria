package paqueteDePruebas;

public class DocumentoEstatal extends DocumentoOficial
{
	@Override
	protected void imprimirEncabezado() 
	{
		System.out.println("<oficial>encabezado del documento Estatal</oficial>");
	}
}
