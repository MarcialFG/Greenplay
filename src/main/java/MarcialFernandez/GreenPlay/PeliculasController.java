package MarcialFernandez.GreenPlay;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.sql.ConnectionPoolDataSource;

import com.mysql.cj.xdevapi.Table;

import MarcialFernandez.GreenPlay.Model.Pelicula;
import MarcialFernandez.GreenPlay.ModelDao.PeliculaDao;
import MarcialFernandez.GreenPlay.Utils.Connect;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class PeliculasController implements Initializable {

	@FXML
	private Button Descargar;
	@FXML
	private ObservableList<Pelicula> obserPeliculas;
	@FXML
	private TableView<Pelicula> tablaPeliculas;
	@FXML
	private TableColumn<Pelicula, String> Titulo;
	@FXML
	private TableColumn<Pelicula, String> Descripcion;
	@FXML
	private TableColumn<Pelicula, String> Autor;
	@FXML
	private TableColumn<Pelicula, String> Tipo;
	@FXML
	private TableColumn<Pelicula, String> id;

	List<Pelicula> Peliculas;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		PeliculaDao pe = new PeliculaDao();
		obserPeliculas = FXCollections.observableArrayList(pe.getall());
		configuraTabla();
		tablaPeliculas.setItems(obserPeliculas);
	}

	public PeliculasController() {
		Peliculas = new ArrayList<Pelicula>();
		obserPeliculas = FXCollections.observableList(Peliculas);
	}

	private void configuraTabla() {
		Titulo.setCellValueFactory(Pelicula -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(Pelicula.getValue().getTitulo());
			return ssp;
		});
		Descripcion.setCellValueFactory(Pelicula -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(Pelicula.getValue().getDescripcion());
			return ssp;
		});
		Autor.setCellValueFactory(Pelicula -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(Pelicula.getValue().getAutor());
			return ssp;
		});
		Tipo.setCellValueFactory(Pelicula -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(Pelicula.getValue().getTipo());
			return ssp;
		});
	}

}
