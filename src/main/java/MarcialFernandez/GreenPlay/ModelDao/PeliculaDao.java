package MarcialFernandez.GreenPlay.ModelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MarcialFernandez.GreenPlay.Interface.IpeliculaDao;
import MarcialFernandez.GreenPlay.Model.Pelicula;
import MarcialFernandez.GreenPlay.Utils.Connect;
import javafx.util.Callback;

public class PeliculaDao implements IpeliculaDao{
	
	public List<Pelicula> getall() {
        List<Pelicula> listaPelis = new ArrayList<>();
        Connection connection = Connect.getConnect();
        String sql = "SELECT * FROM multimedia";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                
                Pelicula p = new Pelicula(rs.getInt("id_Multi"),(rs.getString("titulo")),(rs.getString("descripcion")),(rs.getString("autor")),(rs.getString("tipo")));
                listaPelis.add(p);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaPelis;

    }
}
