package MarcialFernandez.GreenPlay.ModelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import MarcialFernandez.GreenPlay.Interface.ImusicaDao;
import MarcialFernandez.GreenPlay.Model.Multimedia;
import MarcialFernandez.GreenPlay.Model.Musica;
import MarcialFernandez.GreenPlay.Model.Pelicula;
import MarcialFernandez.GreenPlay.Utils.Connect;

public class MusicaDao implements ImusicaDao{
	public List<Multimedia> listaMusica() {
		String sql = "Select * from multimedia";
		Connection connection = Connect.getConnect();
		List<Multimedia> lista = new ArrayList<>();
		try {
			java.sql.Statement st;
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("Id_multimedia");
				String titulo = rs.getString("Titulo");
				String descrip = rs.getString("Descripcion");
				String autor = rs.getString("Autor");
				String director = rs.getString("Director");
				String productor = rs.getString("Productor");
				if (director == null) {
					Musica m = new Musica(id, titulo, descrip, autor, productor);
					lista.add(m);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	
	public boolean update(int id,String titulo,String descripcion,String autor,String productor) {
		boolean result=false;
		String sql = "UPDATE multimedia set Titulo=?, Descripcion=?, Autor=?, Productor=? WHERE Id_multimedia="+ id;
		Connection connection = Connect.getConnect();
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, titulo);
			pst.setString(2, descripcion);
			pst.setString(3, autor);
			pst.setString(4, productor);
			pst.executeUpdate();
			result=true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
