package MarcialFernandez.GreenPlay;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import MarcialFernandez.GreenPlay.Model.Descarga;
import MarcialFernandez.GreenPlay.Model.Multimedia;
import MarcialFernandez.GreenPlay.Model.Usuario;
import MarcialFernandez.GreenPlay.ModelDao.DescargaDao;
import MarcialFernandez.GreenPlay.ModelDao.MultimediaDao;
import MarcialFernandez.GreenPlay.ModelDao.UsuarioDao;
import MarcialFernandez.GreenPlay.Utils.PorDefecto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaDescargasController implements Initializable{
	@FXML
	private TableView<Descarga> tablaDescargas;
	@FXML
	private TableColumn<Descarga, LocalDate> fecha;
	@FXML
	private TableColumn<Descarga, String> multimedia;
	@FXML
	private Button volver,borrar;
	
	public void volver(ActionEvent e) throws IOException {
		App.setRoot("LobbyUsuario");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		this.multimedia.setCellValueFactory(new PropertyValueFactory<>("multimedia"));
		DescargaDao d = new DescargaDao();
		ObservableList<Descarga> lista = FXCollections.observableList(d.listaDescargas(PorDefecto.usuario.getDni()));
		this.tablaDescargas.setItems(lista);
	}
}
