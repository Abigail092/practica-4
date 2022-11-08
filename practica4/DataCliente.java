package practica4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataCliente {

	private Connection conexion;

	public DataCliente() {
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean insertarCliente(Cliente cliente) {
		PreparedStatement ps = null;
		try {

			ps = conexion.prepareStatement("INSERT INTO cliente(usuario, id_gestor,password, correo, saldo) VALUES (?,?,?,?,?) ");
			ps.setString(1, cliente.getUsuario());
			
			ps.setInt(2, cliente.getId_gestor());

			ps.setString(3, cliente.getPassword());

			ps.setString(4, cliente.getCorreo());

			ps.setDouble(5, cliente.getSaldo());

			ps.executeUpdate();

			ps.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return false;
	}

	public ArrayList<Cliente> getCliente() {
		Statement instruccion = null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {

			// obtiene un objeto de tipo Statement

			instruccion = conexion.createStatement();

			// ejecuta sentencia SQL

			ResultSet resultados = instruccion.executeQuery("SELECT * from gestor");

			while (resultados.next()) {

				int id = resultados.getInt("id");
				int id_gestor = resultados.getInt("id_gestor");
				String usuario = resultados.getString("usuario");
				String password = resultados.getString("password");
				String correo = resultados.getString("correo");
				Double saldo = resultados.getDouble("saldo");

				Cliente cliente = new Cliente(id_gestor, usuario, password, correo, saldo);
				cliente.setId(id);
				clientes.add(cliente);
			}

			instruccion.close();
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (instruccion != null) {
				try {
					instruccion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public Cliente getCliente(int id) {
		PreparedStatement instruccion = null;
		Cliente cliente = null;
		try {
			String query = "SELECT * FROM gestor WHERE ID = ?";
			instruccion = conexion.prepareStatement((query));
			instruccion.setInt(1, id);

			ResultSet resultados = instruccion.executeQuery();
			// next() devuelve true si hay fila para leer
			if (resultados.next()) {
				cliente = new Cliente();
				cliente.setUsuario(resultados.getString("usuario"));
				cliente.setPassword(resultados.getString("password"));
				cliente.setCorreo(resultados.getString("correo"));
				cliente.setSaldo(resultados.getDouble("saldo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (instruccion != null) {
				try {
					instruccion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// si no había gestor en BD, gestor es null

		return cliente;
	}

	public boolean borrarGestor(int id) {
		PreparedStatement instruccion = null;
		try {
			String query = "DELETE * FROM gestor WHERE ID = ?";
			instruccion = conexion.prepareStatement((query));
			instruccion.setInt(1, id);
			int filasBorradas = instruccion.executeUpdate();
			return filasBorradas != 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (instruccion != null) {
				try {
					instruccion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return false;

	}

	public boolean actualizarCliente(Cliente cliente) {
		PreparedStatement instruccion = null;
		try {
			String query = "UPDATE gestor SET usuario = ?, password =?, correo=? WHERE  ID = ?";
			instruccion = conexion.prepareStatement((query));
			instruccion.setString(1, cliente.getUsuario());
			instruccion.setString(2, cliente.getPassword());
			instruccion.setString(3, cliente.getCorreo());
			instruccion.setInt(4, cliente.getId());

			int filasActualizadas = instruccion.executeUpdate();
			return filasActualizadas != 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (instruccion != null) {
				try {
					instruccion.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return false;

	}
}
