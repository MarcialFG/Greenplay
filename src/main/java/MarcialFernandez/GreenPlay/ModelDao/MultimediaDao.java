package MarcialFernandez.GreenPlay.ModelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MarcialFernandez.GreenPlay.Interface.ImultimediaDao;
import MarcialFernandez.GreenPlay.Model.Multimedia;
import MarcialFernandez.GreenPlay.Model.Musica;
import MarcialFernandez.GreenPlay.Model.Pelicula;
import MarcialFernandez.GreenPlay.Model.Usuario;
import MarcialFernandez.GreenPlay.Utils.Connect;

public class MultimediaDao implements ImultimediaDao{
	
	public List<Multimedia>listamultimedia() {
		String sql = "Select * from multimedia";
		Connection connection = Connect.getConnect();
		List<Multimedia>lista=new ArrayList<>();
		try {
			java.sql.Statement st;
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id=rs.getInt("Id_multimedia");
				String titulo=rs.getString("Titulo");
				String descrip=rs.getString("Descripcion");
				String autor=rs.getString("Autor");
				String director=rs.getString("Director");
				String productor=rs.getString("Productor");
				if(productor==null) {
					Pelicula p=new Pelicula(id,titulo,descrip,autor,director);
					lista.add(p);
				}else {
					Musica m=new Musica(id,titulo,descrip,autor,productor);
					lista.add(m);
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	
	public static boolean insertPelicula(Pelicula p) {

		Connection connection = Connect.getConnect();
		boolean state = false;

		String sql = "INSERT INTO multimedia (Titulo, Descripcion ,Autor,Director)" + "VALUES ( ?, ?, ?,?)";

		try {
			PreparedStatement pst;
			pst = connection.prepareStatement(sql);
			pst.setString(1, p.getTitulo());
			pst.setString(2, p.getDescripcion());
			pst.setString(3, p.getAutor());
			pst.setString(4, p.getDirector());
			pst.executeUpdate();
			state = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return state;
	}
	public static boolean insertMusica(Musica m) {

		Connection connection = Connect.getConnect();
		boolean state = false;

		String sql = "INSERT INTO multimedia (Titulo, Descripcion ,Autor,Productor)" + "VALUES ( ?, ?, ?,?)";

		try {
			PreparedStatement pst;
			pst = connection.prepareStatement(sql);
			pst.setString(1, m.getTitulo());
			pst.setString(2, m.getDescripcion());
			pst.setString(3, m.getAutor());
			pst.setString(4, m.getProductor());
			pst.executeUpdate();
			state = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return state;
	}

	public boolean delete(int id_Multi) {
		boolean result=false;
		Connection connection = Connect.getConnect();
		String sql = "DELETE from multimedia WHERE Id_multimedia= ?";
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, id_Multi);
			pst.executeUpdate();
			result=true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return result;
		
		
	}
}
