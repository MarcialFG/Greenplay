package MarcialFernandez.GreenPlay.Model;

public class Pelicula extends Multimedia {

	private String Director;

	public Pelicula(int id_Multi, String titulo, String descripcion, String autor, String director) {
		super(id_Multi, titulo, descripcion, autor);
		Director = director;
	}

	public Pelicula(String titulo, String descripcion, String autor, String director) {
		super(titulo, descripcion, autor);
		Director = director;
	}

	public Pelicula() {
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	@Override
	public String toString() {
		return "Pelicula [Director=" + Director + ", id_Multi=" + id_Multi + ", Titulo=" + Titulo + ", Descripcion="
				+ Descripcion + ", Autor=" + Autor + "]";
	}

}
