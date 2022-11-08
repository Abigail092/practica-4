package practica4;

public class Gestor {

	protected int id;
	protected String usuario;
	protected String password;
	protected String correo;

	// constructor por defecto
	public Gestor() {
	}

	// constructor parametrizado
	public Gestor(int id, String usuario, String password, String correo) {
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}