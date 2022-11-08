package practica4;

public class TestGestor {

	public static void main(String[] args) {
		
		DataGestor data = new DataGestor ();
		Gestor gestor = new Gestor ();
		gestor.setUsuario( "X");
		gestor.setPassword("Y");
		gestor.setCorreo("C");
		
		boolean insertado = data.insertarGestor(gestor);
		
		if (insertado) {
			System.out.println("insertado");
		}else {
			System.out.println("no insertado");
		}

	}

}
