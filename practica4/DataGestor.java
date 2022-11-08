package practica4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DataGestor {

	private Connection conexion;

	public DataGestor() {
		try {

			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean insertarGestor(Gestor gestor) {

		PreparedStatement ps = null;
		try {

		    ps = conexion
					.prepareStatement("INSERT INTO gestor(id, usuario,password, correo) VALUES (?,?,?) ");
			ps.setString(1, gestor.getUsuario());

			ps.setString(2, gestor.getPassword());

			ps.setString(3, gestor.getCorreo());

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

	public ArrayList<Gestor> getGestores() {
		Statement instruccion = null;
		ArrayList<Gestor> gestores = new ArrayList<Gestor>();
		try {

			// obtiene un objeto de tipo Statement

			instruccion = conexion.createStatement();

			// ejecuta sentencia SQL

			ResultSet resultados = instruccion.executeQuery("SELECT * from gestor");

			while (resultados.next()) {

				int id = resultados.getInt("id");

				String usuario = resultados.getString("usuario");
				String password = resultados.getString("password");
				String correo = resultados.getString("correo");

				Gestor gestor = new Gestor(id, usuario, password, correo);
				gestores.add(gestor);
			}

			instruccion.close();
			return gestores;
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

	public Gestor getGestor(int id) {
		PreparedStatement instruccion = null;
		Gestor gestor = null;
		try {
			String query = "SELECT * FROM gestor WHERE ID = ?";
			instruccion = conexion.prepareStatement((query));
			instruccion.setInt(1, id);

			ResultSet resultados = instruccion.executeQuery();
			// next() devuelve true si hay fila para leer
			if (resultados.next()) {
				gestor = new Gestor();
				gestor.setUsuario(resultados.getString("usuario"));
				gestor.setPassword(resultados.getString("password"));
				gestor.setCorreo(resultados.getString("correo"));
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

		return gestor;
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

	public boolean actualizarGestor(Gestor gestor) {
		PreparedStatement instruccion = null;
		try {
			String query = "UPDATE gestor SET usuario = ?, password =?, correo=? WHERE  ID = ?";
			instruccion = conexion.prepareStatement((query));
			instruccion.setString(1, gestor.getUsuario());
			instruccion.setString(2, gestor.getPassword());
			instruccion.setString(3, gestor.getCorreo());
			instruccion.setInt(4, gestor.getId());

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