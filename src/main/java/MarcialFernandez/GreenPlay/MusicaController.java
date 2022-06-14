package MarcialFernandez.GreenPlay;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import MarcialFernandez.GreenPlay.Model.Multimedia;
import MarcialFernandez.GreenPlay.ModelDao.MultimediaDao;
import MarcialFernandez.GreenPlay.ModelDao.MusicaDao;
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

public class MusicaController implements Initializable{
	@FXML
	private TableView<Multimedia> tablemultimedia;
	@FXML
	private TableColumn<Multimedia,Integer> id;
	@FXML
	private TableColumn<Multimedia, String> titulo;
	@FXML
	private TableColumn<Multimedia, String> descripcion;
	@FXML
	private TableColumn<Multimedia, String> autor;
	@FXML
	private TableColumn<Multimedia, String> productor;
	@FXML
	private Button peliculas;
	@FXML
	private Button BorrarBotton;
	@FXML
	private Button AñadirBotton;
	@FXML
	private Button EditarBotton;
	@FXML
	private Button Volver;
	/**
	 * vulve a la pagina principal
	 * @param e
	 * @throws IOException
	 */
	public void volver(ActionEvent e) throws IOException {
		App.setRoot("LobbyAdmin");
	}
	/**
	 * cambia a la pagina que muestra las peliculas
	 * @param e
	 * @throws IOException
	 */
	public void cambioPeli(ActionEvent e) throws IOException {
		App.setRoot("Pelis");
	}
	/**
	 * cambia a la pagina que recoge los valores para añadir una cancion
	 * @param e
	 * @throws IOException
	 */
	public void añadir(ActionEvent e) throws IOException {
		App.setRoot("AddMusica");
	}
	/**
	 * recoge los datos de la multimedia seleccionada y los guarda para usarlos en la vista siguiente
	 * @param e
	 * @throws IOException
	 */
	public void Editar(ActionEvent e) throws IOException {
		Multimedia m = this.tablemultimedia.getSelectionModel().getSelectedItem();
		if (m!=null) {
			PorDefecto.multimedia.setId_Multi(m.getId_Multi());
			PorDefecto.multimedia.setTitulo(m.getTitulo());
			PorDefecto.multimedia.setDescripcion(m.getDescripcion());
			PorDefecto.multimedia.setAutor(m.getAutor());
			App.setRoot("EditarMusica");
		}

	}
	/**
	 * recoge los datos de la multimedia seleccionada y le pasa a la funcion delete la id_multi seleccionada
	 * @param e
	 * @throws IOException
	 */
	public void delete(ActionEvent e) throws IOException {
		MultimediaDao mu = new MultimediaDao();
		Multimedia m = this.tablemultimedia.getSelectionModel().getSelectedItem();
		if (m!=null) {
			mu.delete(m.getId_Multi());
		}
		App.setRoot("LobbyAdmin");
	
}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.id.setCellValueFactory(new PropertyValueFactory<>("id_Multi"));
		this.titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		this.descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
		this.autor.setCellValueFactory(new PropertyValueFactory<>("autor"));
		this.productor.setCellValueFactory(new PropertyValueFactory<>("productor"));
		MusicaDao musica = new MusicaDao();
		ObservableList<Multimedia> lista = FXCollections.observableList(musica.listaMusica());
		this.tablemultimedia.setItems(lista);
	}
}
