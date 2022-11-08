package practica4;

import java.sql.Timestamp;

public class Transferencia {

	protected int id;
	protected int id_ordenante;
	protected int id_beneficiario;
	protected double importe;
	protected String concepto;
	protected Timestamp fecha;
	




	public Transferencia() {
	}

	
	public Transferencia (int  id_ordenante, int id_beneficiario, double importe, String concepto , Timestamp fecha) {
		this.id_ordenante = id_ordenante;
		this.id_beneficiario = id_beneficiario;
		this.importe = importe;
		this.concepto = concepto;
		this.fecha = fecha;
		

	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_ordenante() {
		return id_ordenante;
	}


	public void setId_ordenante(int id_ordenante) {
		this.id_ordenante = id_ordenante;
	}


	public int getId_beneficiario() {
		return id_beneficiario;
	}


	public void setId_beneficiario(int id_beneficiario) {
		this.id_beneficiario = id_beneficiario;
	}


	public double getImporte() {
		return importe;
	}


	public void setImporte(double importe) {
		this.importe = importe;
	}


	public String getConcepto() {
		return concepto;
	}


	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}


	public Timestamp getFecha() {
		return fecha;
	}


	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

}