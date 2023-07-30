package paqueteDePruebas;

public class GestionDocumentos 
{

	public static void main(String[] args) 
	{
		Documento d = new DocumentoOficial();
		d.imprimir("saludo cordiales");
		d = new DocumentoPlano();
		d.imprimir("que ondo");
		d = new DocumentoEstatal();
		d.imprimir("Saludos Estatales");
	}

}
