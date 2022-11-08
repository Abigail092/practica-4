package practica4;

import java.sql.Timestamp;
import java.util.Date;

public class TestMensaje {

	public static void main(String[] args) {
		
		DataMensaje data = new DataMensaje  ();
		Mensaje mensaje = new Mensaje ();
		mensaje.setId_origen(2);
		mensaje.setId_destino( 1);
		mensaje.setTexto("Y");
		mensaje.setFecha (new Timestamp( new Date().getTime()));
		
		
		boolean insertado = data.insertarMensaje (mensaje);
		
		if (insertado) {
			System.out.println("insertado");
		}else {
			System.out.println("no insertado");
		}


	}

}
