package MarcialFernandez.GreenPlay;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import MarcialFernandez.GreenPlay.Model.Multimedia;
import MarcialFernandez.GreenPlay.Model.Musica;
import MarcialFernandez.GreenPlay.ModelDao.MultimediaDao;
import MarcialFernandez.GreenPlay.ModelDao.MusicaDao;
import MarcialFernandez.GreenPlay.ModelDao.PeliculaDao;
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

public class PelisController implements Initializable{
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
	private Button musica;
	@FXML
	private Button BorrarBotton;
	@FXML
	private Button AñadirBotton;
	@FXML
	private Button EditarBotton;
	@FXML
	private Button Volver;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.id.setCellValueFactory(new PropertyValueFactory<>("id_Multi"));
		this.titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		this.descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
		this.autor.setCellValueFactory(new PropertyValueFactory<>("autor"));
		this.director.setCellValueFactory(new PropertyValueFactory<>("director"));
		PeliculaDao peli = new PeliculaDao();
		ObservableList<Multimedia> lista = FXCollections.observableList(peli.listaPeliculas());
		this.tablemultimedia.setItems(lista);
	}

	public void volver(ActionEvent e) throws IOException {
		App.setRoot("LobbyAdmin");
	}

	public void cambiomusica(ActionEvent e) throws IOException {
		App.setRoot("Musica");
	}
	public void añadir(ActionEvent e) throws IOException {
		App.setRoot("AddPelicula");
	}
	public void editar(ActionEvent e) throws IOException {
		Multimedia m = this.tablemultimedia.getSelectionModel().getSelectedItem();
		if (m!=null) {
			PorDefecto.multimedia.setId_Multi(m.getId_Multi());
			PorDefecto.multimedia.setTitulo(m.getTitulo());
			PorDefecto.multimedia.setDescripcion(m.getDescripcion());
			PorDefecto.multimedia.setAutor(m.getAutor());
			App.setRoot("EditarPelis");
		}
	}
	public void delete(ActionEvent e) throws IOException {
		MultimediaDao mu = new MultimediaDao();
		Multimedia m = this.tablemultimedia.getSelectionModel().getSelectedItem();
		if (m!=null) {
			mu.delete(m.getId_Multi());
		}
		App.setRoot("LobbyAdmin");
	}
}
