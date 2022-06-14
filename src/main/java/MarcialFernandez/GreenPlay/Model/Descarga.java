package MarcialFernandez.GreenPlay.Model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Descarga {
	private LocalDate fecha;
	private Usuario usuario;
	private Multimedia multimedia;

	public Descarga(LocalDate fecha, Usuario usuario, Multimedia multimedia) {
		super();
		this.fecha = fecha;
		this.usuario = usuario;
		this.multimedia = multimedia;
	}

	public Descarga() {
		super();
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Multimedia getMultimediatotal() {
		return multimedia;
	}
	public String getMultimedia() {
		return multimedia.Titulo;
	}

	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;
	}

	@Override
	public String toString() {
		return "Descarga [fecha=" + fecha + ", usuario=" + usuario + ", multimedia=" + multimedia + "]";
	}

}
