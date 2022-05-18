package MarcialFernandez.GreenPlay.Utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlTransient;

public class Connect {

	@XmlTransient
	private static Connection con;
	@XmlTransient
	private String file = "conexion.xml";
	@XmlTransient
	private static Connect _instance;

	private Connect() {
		// cargamos los datos de la conexion del xml
		DataConnect dc = load();
		// Establecemos la conexion
		try {

			con = DriverManager.getConnection(dc.getServer() + "/" + dc.getDatabase(), dc.getUsername(),
					dc.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			con = null;
			System.out.println("connect");
		}
	}

	public static Connection getConnect() {
		if (_instance == null) {
			_instance = new Connect();
		}
		return con;
	}

	public void loadFile() {
		JAXBContext c;
		try {
			c = JAXBContext.newInstance(Connect.class);
			Unmarshaller m = c.createUnmarshaller();
			Connect newR = (Connect) m.unmarshal(new File(file));
			_instance = newR;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public DataConnect load() {
		DataConnect DatosCon = new DataConnect();
		JAXBContext c;
		try {
			c = JAXBContext.newInstance(DataConnect.class);
			Unmarshaller m = c.createUnmarshaller();
			DataConnect newR = (DataConnect) m.unmarshal(new File(file));
			DatosCon = newR;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return DatosCon;
	}
}
