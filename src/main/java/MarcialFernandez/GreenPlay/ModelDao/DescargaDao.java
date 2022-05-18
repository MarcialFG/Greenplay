package MarcialFernandez.GreenPlay.ModelDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import MarcialFernandez.GreenPlay.Interface.IdescargaDao;
import MarcialFernandez.GreenPlay.Model.Descarga;
import MarcialFernandez.GreenPlay.Utils.Connect;

public class DescargaDao extends Descarga implements IdescargaDao {

	String sql = "INSERT INTO descarga (dni,id_multimedia) VALUES (?,?)";

	/**
	 * Metodo para insertar en la BD una descarga
	 * 
	 * @return
	 */
	@Override
	public boolean getDownload() {
		boolean status=false;
		Connection con = Connect.getConnect();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(sql);
				q.setString(1, dni);
				q.setInt(2, id_Multi);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}

}
