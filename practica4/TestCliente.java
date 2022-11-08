package practica4;

public class TestCliente {

	public static void main(String[] args) {
		
		DataCliente data = new DataCliente ();
		Cliente cliente = new Cliente ();
		cliente.setId_gestor(1);
		cliente.setUsuario ("X");
		cliente.setPassword ("Y");
		cliente.setCorreo ("Z");
		cliente.setSaldo ( 0); 
		
		boolean insertado = data.insertarCliente(cliente);
		
		if (insertado) {
			System.out.println("insertado");
		}else {
			System.out.println("no insertado");
		}

	}

}
