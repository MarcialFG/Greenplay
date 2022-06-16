package MarcialFernandez.GreenPlay.ModelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.xpath.XPathException;

import com.mysql.cj.xdevapi.Statement;

import MarcialFernandez.GreenPlay.Interface.IusuarioDao;
import MarcialFernandez.GreenPlay.Model.Descarga;
import MarcialFernandez.GreenPlay.Model.Multimedia;
import MarcialFernandez.GreenPlay.Model.Musica;
import MarcialFernandez.GreenPlay.Model.Pelicula;
import MarcialFernandez.GreenPlay.Model.Usuario;
import MarcialFernandez.GreenPlay.Utils.Connect;
import MarcialFernandez.GreenPlay.Utils.PorDefecto;
import MarcialFernandez.GreenPlay.Utils.Utils;

public class UsuarioDao extends Usuario implements IusuarioDao {
	/**
	 * inserta un usuario en la base de datos
	 * 
	 * @param usuario introducido por teclado
	 * @return
	 */
	public static boolean insertUsuario(Usuario usuario) {

		Connection connection = Connect.getConnect();
		boolean state = false;

		String sql = "INSERT INTO usuario (dni, Nombre, correo ,contraseña)" + "VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement pst;
			pst = connection.prepareStatement(sql);
			pst.setString(1, usuario.getDni());
			pst.setString(2, usuario.getNombre());
			pst.setString(3, usuario.getCorreo());
			pst.setString(4, usuario.getContrasenia());
			pst.executeUpdate();
			state = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return state;
	}

	/**
	 * Busca un usuario de la base de datos con el mismo dni y contraseña
	 * introducidos y lo guarda en un usuario
	 * 
	 * @param dni
	 * @param pass
	 * @return
	 */
	public static Usuario selectUsuario(String dni, String pass) {

		Connection connection = Connect.getConnect();
		String sql = "SELECT dni, Nombre, correo, contraseña from usuario WHERE dni='" + dni + "' AND contraseña='"
				+ pass + "'";
		Usuario usuario = null;

		try {
			java.sql.Statement st;
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				usuario = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return usuario;
	}
/**
 * Crea una lista de los usuarios recogidos de la base de datos y los añade uno a uno
 * sql es la sentencia para recoger todos los parametros del usuario menos la contraseña
 * @return
 */
	public List<Usuario> listaUsuario() {
		String sql = "SELECT dni,Nombre, Correo FROM usuario";
		Connection connection = Connect.getConnect();
		List<Usuario> lista = new ArrayList<Usuario>();
		try {
			java.sql.Statement st;
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String dni = rs.getString("dni");
				String nombre = rs.getString("Nombre");
				String correo = rs.getString("Correo");
				Usuario usuari = new Usuario(dni, nombre, correo);
				lista.add(usuari);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	/**
	 * Crea una lista de las descargas recogidos de la base de datos y los añade uno a uno segun el dni introducido
	 * sql es la sentencia para recoger la fecha , el titulo de la multimedia y su id
	 * @param dni
	 * @return
	 */
	public List<Descarga> listaMisDescargas(Usuario u) {
		String sql = "SELECT descarga.Fecha, multimedia.Titulo, multimedia.Id_multimedia from descarga,multimedia,usuario WHERE descarga.Id_multimedia=multimedia.Id_multimedia AND usuario.dni=descarga.Dni AND descarga.Dni='"
				+ u.getDni() + "'";
		Connection connection = Connect.getConnect();
		try {
			java.sql.Statement st;
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				LocalDate fecha = rs.getDate("Fecha").toLocalDate();
				String titulo = rs.getString("Titulo");
				int id=rs.getInt("Id_multimedia");
				Multimedia m = new Multimedia(id, titulo, "", "");
				Descarga d = new Descarga(fecha, u, m);
				misDescargas.add(d);
				System.out.println(misDescargas);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return misDescargas;
	}
}
