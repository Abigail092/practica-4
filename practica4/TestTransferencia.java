package practica4;

import java.sql.Timestamp;
import java.util.Date;

public class TestTransferencia {
		
	
	public static void main(String[] args) {
		
		DataTransferencia data = new DataTransferencia ();
		
		Transferencia transferencia = new Transferencia ();
		transferencia.setId_ordenante( 1);
		transferencia.setId_beneficiario(2);
		transferencia.setImporte( 0 );
		transferencia.setConcepto ("&");
		transferencia.setFecha (new Timestamp( new Date().getTime()));
		
		boolean insertado = data.insertarTranferencia(transferencia);
		
		if (insertado) {
			System.out.println("insertado");
		}else {
			System.out.println("no insertado");
		}

	}

}

