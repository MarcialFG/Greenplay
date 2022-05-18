package MarcialFernandez.GreenPlay.Model;

import java.util.Objects;

public class Usuario {
	protected static String dni;
	protected static String nombre;
	protected static String correo;
	protected static String contraseña;

	public Usuario() {
		super();
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
		dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public  void setNombre(String nombre) {
		nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		correo = correo;
	}

	public String getContrasenia() {
		return contraseña;
	}

	public void setContrasenia(String contraseña) {
		contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", nombre=" + nombre + ", correo=" + correo + ", contrasenia=" + contraseña
				+ "]";
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
