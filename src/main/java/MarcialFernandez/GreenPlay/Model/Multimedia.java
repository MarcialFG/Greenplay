package MarcialFernandez.GreenPlay.Model;

import java.util.Objects;

public class Multimedia {
	protected int id_Multi;
	protected String Titulo;
	protected String Descripcion;
	protected String Autor;

	public Multimedia() {
		super();
	}

	public Multimedia(int id_Multi, String titulo, String descripcion, String autor) {
		super();
		this.id_Multi = id_Multi;
		this.Titulo = titulo;
		this.Descripcion = descripcion;
		this.Autor = autor;
	}

	public Multimedia(String titulo, String descripcion, String autor) {
		super();
		Titulo = titulo;
		Descripcion = descripcion;
		Autor = autor;
	}

	public int getId_Multi() {
		return id_Multi;
	}

	public void setId_Multi(int id_Multi) {
		this.id_Multi = id_Multi;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		this.Titulo = titulo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.Descripcion = descripcion;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		this.Autor = autor;
	}
	
	
	@Override
	public String toString() {
		return "Multimedia [id_Multi=" + id_Multi + ", titulo=" + Titulo + ", descripcion=" + Descripcion + ", autor="
				+ Autor + "]";
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
