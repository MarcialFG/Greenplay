package MarcialFernandez.GreenPlay.Model;

import java.util.List;
import java.util.Objects;

public class Usuario {
	protected String dni;
	protected String nombre;
	protected String correo;
	protected String contraseña;
	protected List<Descarga>misDescargas;

	public Usuario() {
		super();
	}
	
	public Usuario(String dni, String nombre, String correo, String contraseña, List<Descarga> misDescargas) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.correo = correo;
		this.contraseña = contraseña;
		this.misDescargas = misDescargas;
	}

	public Usuario(String dni, String nombre, String correo, List<Descarga> misDescargas) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.correo = correo;
		this.misDescargas = misDescargas;
	}


	public Usuario(String dni, String nombre, String correo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.correo = correo;
	}


	public Usuario(String dni, String nombre, String correo, String contraseña) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.correo = correo;
		this.contraseña = contraseña;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public List<Descarga> getMisDescargas() {
		return misDescargas;
	}

	public void setMisDescargas(List<Descarga> misDescargas) {
		this.misDescargas = misDescargas;
	}

	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", nombre=" + nombre + ", correo=" + correo + ", contraseña=" + contraseña
				+ ", misDescargas=" + misDescargas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(dni, other.dni);
	}

	
	
}
