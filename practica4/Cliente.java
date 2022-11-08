package practica4;

public class Cliente {

	protected int id;
	protected int id_gestor;
	protected String usuario;
	protected String password;
	protected String correo;
	protected double saldo;

	// constructor por defecto
	public Cliente() {
	}

	// constructor parametrizado
	public Cliente(int id_gestor, String usuario, String password, String correo, double saldo) {
		this.id_gestor = id_gestor;
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
		this.saldo = saldo;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_gestor() {
		return id_gestor;
	}

	public void setId_gestor(int id_gestor) {
		this.id_gestor = id_gestor;
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

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	

}
