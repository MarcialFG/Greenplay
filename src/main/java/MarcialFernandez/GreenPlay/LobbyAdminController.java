package MarcialFernandez.GreenPlay;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import MarcialFernandez.GreenPlay.Model.Multimedia;
import MarcialFernandez.GreenPlay.ModelDao.MultimediaDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LobbyAdminController implements Initializable {
	@FXML
	private TableView<Multimedia> tablemultimedia;
	@FXML
	private TableColumn<Multimedia, Integer> id;
	@FXML
	private TableColumn<Multimedia, String> titulo;
	@FXML
	private TableColumn<Multimedia, String> descripcion;
	@FXML
	private TableColumn<Multimedia, String> autor;
	@FXML
	private TableColumn<Multimedia, String> director;
	@FXML
	private TableColumn<Multimedia, String> productor;
	@FXML
	private Button pelis;
	@FXML
	private Button musica;
	@FXML
	private Button listaUsuarios;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.id.setCellValueFactory(new PropertyValueFactory<>("id_Multi"));
		this.titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		this.descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
		this.autor.setCellValueFactory(new PropertyValueFactory<>("autor"));
		this.director.setCellValueFactory(new PropertyValueFactory<>("director"));
		this.productor.setCellValueFactory(new PropertyValueFactory<>("productor"));
		MultimediaDao multi = new MultimediaDao();
		ObservableList<Multimedia> lista = FXCollections.observableList(multi.listamultimedia());
		this.tablemultimedia.setItems(lista);
	}
	/**
	 * cambia a la pagina que muestra la lista de usuarios
	 * @param e
	 * @throws IOException
	 */
	public void cambiolistas(ActionEvent e) throws IOException {
		App.setRoot("ListaUsuarios");
	}
	/**
	 * cambia a la pagina que muestra las peliculas
	 * @param e
	 * @throws IOException
	 */
	public void cambiopelis(ActionEvent e) throws IOException {
		App.setRoot("Pelis");
	}
	/**
	 * cambia a la pagina principal de inicio de sesion
	 * @param e
	 * @throws IOException
	 */
	public void cambiosesion(ActionEvent e) throws IOException {
		App.setRoot("Principal");
	}
	/**
	 * cambia a la pagina que muestra la musica
	 * @param e
	 * @throws IOException
	 */
	public void cambiomusica(ActionEvent e) throws IOException {
		App.setRoot("Musica");
	}
}
