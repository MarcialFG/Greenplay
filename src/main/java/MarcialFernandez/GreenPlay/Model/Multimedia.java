package MarcialFernandez.GreenPlay.Model;

import java.util.Objects;

public class Multimedia {
	protected int id_Multi;
	protected String titulo;
	protected String descripcion;
	protected String autor;

	public Multimedia() {
		super();
	}

	public Multimedia(int id_Multi, String titulo, String descripcion, String autor) {
		super();
		this.id_Multi = id_Multi;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.autor = autor;
	}

	public int getId_Multi() {
		return id_Multi;
	}

	public void setId_Multi(int id_Multi) {
		this.id_Multi = id_Multi;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
	@Override
	public String toString() {
		return "Multimedia [id_Multi=" + id_Multi + ", titulo=" + titulo + ", descripcion=" + descripcion + ", autor="
				+ autor + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_Multi);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Multimedia other = (Multimedia) obj;
		return id_Multi == other.id_Multi;
	}

}
