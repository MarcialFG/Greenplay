package MarcialFernandez.GreenPlay;

import java.util.List;

import MarcialFernandez.GreenPlay.Model.Musica;
import MarcialFernandez.GreenPlay.Model.Pelicula;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MusicaController {

	@FXML
	private Button Descargar;
	@FXML
	private ObservableList<Musica> obserMusica;
	@FXML
	private TableView<Musica> tablaMusica;
	@FXML
	private TableColumn<Musica, String> Titulo;
	@FXML
	private TableColumn<Musica, String> Descripcion;
	@FXML
	private TableColumn<Musica, String> Autor;
	@FXML
	private TableColumn<Musica, String> Tipo;

	List<Musica> Musica;
}
