package MarcialFernandez.GreenPlay.Model;

public class Pelicula extends Multimedia {

	protected String Tipo;

	public Pelicula(int id_Multi, String titulo, String descripcion, String autor, String tipo) {
		super(id_Multi, titulo, descripcion, autor);
		Tipo = tipo;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	@Override
	public String toString() {
		return "Pelicula [Tipo=" + Tipo + ", id_Multi=" + id_Multi + ", titulo=" + titulo + ", descripcion="
				+ descripcion + ", autor=" + autor + "]";
	}

	
	
}
