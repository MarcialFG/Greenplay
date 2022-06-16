package MarcialFernandez.GreenPlay.Model;

public class Musica extends Multimedia {

	private String Productor;

	public Musica(int id_Multi, String titulo, String descripcion, String autor, String productor) {
		super(id_Multi, titulo, descripcion, autor);
		Productor = productor;
	}
	
	public Musica(String titulo, String descripcion, String autor, String productor) {
		super(titulo, descripcion, autor);
		Productor = productor;
	}
	

	public Musica() {
		
	}

	public String getProductor() {
		return Productor;
	}

	public void setProductor(String productor) {
		Productor = productor;
	}

	@Override
	public String toString() {
		return super.toString()+ "Productor=" + Productor + "]";
	}

}
