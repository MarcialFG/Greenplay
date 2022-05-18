package MarcialFernandez.GreenPlay.Model;

import java.time.LocalDateTime;

public class Descarga {
	protected String dni;
	protected int id_Multi;
	protected LocalDateTime fecha;

	public Descarga() {
		super();
	}

	public Descarga(String dni, int id_Multi, LocalDateTime fecha) {
		super();
		this.dni = dni;
		this.id_Multi = id_Multi;
		this.fecha = fecha;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getId_Multi() {
		return id_Multi;
	}

	public void setId_Multi(int id_Multi) {
		this.id_Multi = id_Multi;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Descarga [dni=" + dni + ", id_Multi=" + id_Multi + ", fecha=" + fecha + "]";
	}

	

}
