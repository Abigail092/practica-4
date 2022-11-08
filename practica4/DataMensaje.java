package practica4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataMensaje {
	
	private Connection conexion;

	public DataMensaje() {
		try {

			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


public boolean insertarMensaje(Mensaje mensaje) {

	PreparedStatement ps = null;
	try {

	    ps = conexion
				.prepareStatement("INSERT INTO mensaje ( id_origen, id_destino, texto, fecha) VALUES (?,?,?,?) ");
		ps.setInt(1, mensaje.getId_origen());

		ps.setInt(2, mensaje.getId_destino());

		ps.setString(3, mensaje.getTexto());
		
		ps.setTimestamp(4, mensaje.getFecha());

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


	public boolean actualizarMensaje(Mensaje mensaje) {
	PreparedStatement instruccion = null;
	try {
		String query = "UPDATE gestor SET usuario = ?, password =?, correo=? WHERE  ID = ?";
		instruccion = conexion.prepareStatement((query));
		instruccion.setInt(1, mensaje.getId_origen());
		instruccion.setInt(2, mensaje.getId_destino());
		instruccion.setString(3, mensaje.getTexto());
		instruccion.setTimestamp(4, mensaje.getFecha());
		instruccion.setInt(5, mensaje.getId());

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
