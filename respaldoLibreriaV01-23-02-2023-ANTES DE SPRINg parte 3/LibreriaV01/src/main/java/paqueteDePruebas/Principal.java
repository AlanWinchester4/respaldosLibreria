package paqueteDePruebas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Principal 
{
	public static void main(String[] args)
	{
		ApplicationContext factoria = new FileSystemXmlApplicationContext("classpath*:/contextoAplicacion.xml");
		Mensaje mimensaje = (Mensaje)factoria.getBean("MensajeHTML");
		//MensajeFactory.getMensaje().hola();
		mimensaje.hola();
		Mensaje mimensaje2 = (Mensaje)factoria.getBean("MensajePlano");
		//MensajeFactory.getMensaje().hola();
		mimensaje2.hola();

	}
}
