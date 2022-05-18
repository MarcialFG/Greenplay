package MarcialFernandez.GreenPlay;

import java.time.LocalDateTime;
import java.util.List;

import MarcialFernandez.GreenPlay.Model.Descarga;
import MarcialFernandez.GreenPlay.Model.Musica;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DescargasController {

	@FXML
	private ObservableList<Descarga> obserDescargas;
	@FXML
	private TableView<Descarga> tablaDescargas;
	@FXML
	private TableColumn<Descarga, String> Titulo;
	@FXML
	private TableColumn<Descarga, String> Descripcion;
	@FXML
	private TableColumn<Descarga, String> Autor;
	@FXML
	private TableColumn<Descarga, LocalDateTime> Fecha;

	List<Descarga> Descargas;
}
