package practica4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataTransferencia {
	private Connection conexion;

	public DataTransferencia() {
		try {

			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean insertarTranferencia(Transferencia transferencia) {

		PreparedStatement ps = null;
		try {

			ps = conexion.prepareStatement("INSERT INTO transferencia( id_ordenante, id_beneficiario, importe, concepto, fecha) VALUES (?,?,?,?,?) ");
			ps.setInt(1, transferencia.getId_ordenante());

			ps.setInt(2, transferencia.getId_beneficiario());

			ps.setDouble(3, transferencia.getImporte());

			ps.setString(4, transferencia.getConcepto());

			ps.setTimestamp(5, transferencia.getFecha());

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

	public boolean actualizarTransferencia(Transferencia transferencia) {
		PreparedStatement instruccion = null;
		try {
			String query = "UPDATE gestor SET usuario = ?, password =?, correo=? WHERE  ID = ?";
			instruccion = conexion.prepareStatement((query));
			instruccion.setInt(1, transferencia.getId_ordenante());
			instruccion.setInt(2, transferencia.getId_beneficiario());
			instruccion.setDouble(3, transferencia.getImporte());
			instruccion.setString(4, transferencia.getConcepto());
			instruccion.setTimestamp(5, transferencia.getFecha());
			instruccion.setInt(5, transferencia.getId());

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