package MarcialFernandez.GreenPlay.ModelDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import MarcialFernandez.GreenPlay.Interface.IdescargaDao;
import MarcialFernandez.GreenPlay.Model.Descarga;
import MarcialFernandez.GreenPlay.Model.Multimedia;
import MarcialFernandez.GreenPlay.Model.Musica;
import MarcialFernandez.GreenPlay.Model.Pelicula;
import MarcialFernandez.GreenPlay.Model.Usuario;
import MarcialFernandez.GreenPlay.Utils.Connect;

public class DescargaDao extends Descarga implements IdescargaDao {

	public DescargaDao(LocalDate fecha, Usuario usuario, Multimedia multimedia) {
		super(fecha, usuario, multimedia);
		// TODO Auto-generated constructor stub
	}

	public DescargaDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean Download(Descarga d) {
		Connection connection = Connect.getConnect();
		boolean state = false;

		String sql = "INSERT INTO descarga (Dni, Fecha ,Id_multimedia)" + "VALUES ( ?, ?, ?)";

		try {
			PreparedStatement pst;
			pst = connection.prepareStatement(sql);
			pst.setString(1, d.getUsuario().getDni());
			pst.setObject(2, d.getFecha());
			pst.setInt(3, d.getMultimediatotal().getId_Multi());
			pst.executeUpdate();
			state = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return state;
	}

	public List<Descarga> listaDescargas(String dni) {
		String sql = "SELECT descarga.Fecha, multimedia.Titulo from descarga,multimedia,usuario WHERE descarga.Id_multimedia=multimedia.Id_multimedia AND usuario.dni=descarga.Dni AND descarga.Dni='"+dni+"'" ;
		
		Connection connection = Connect.getConnect();
		List<Descarga> lista = new ArrayList<>();
		try {
			java.sql.Statement st;
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				LocalDate fecha = rs.getDate("Fecha").toLocalDate();
				String titulo=rs.getString("Titulo");
				Usuario u = new Usuario();
				Multimedia m = new Multimedia(titulo, "", "");
				Descarga d = new Descarga(fecha, u, m);
				lista.add(d);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}

}
