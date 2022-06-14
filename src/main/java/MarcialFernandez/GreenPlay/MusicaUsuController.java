package MarcialFernandez.GreenPlay;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import MarcialFernandez.GreenPlay.Model.Descarga;
import MarcialFernandez.GreenPlay.Model.Multimedia;
import MarcialFernandez.GreenPlay.ModelDao.DescargaDao;
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

public class MusicaUsuController implements Initializable {
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
	private TableColumn<Multimedia, String> productor;
	@FXML
	private Button Descargar;
	@FXML
	private Button ListaDescargas;
	

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

	public void cambioPeli(ActionEvent e) throws IOException {
		App.setRoot("PelisUsu");
	}
	public void Lista(ActionEvent e) throws IOException {
		App.setRoot("ListaDescargas");
	}
	public void download(ActionEvent e) throws IOException {
		Multimedia m = this.tablemultimedia.getSelectionModel().getSelectedItem();
		if (m!=null) {
			PorDefecto.multimedia.setId_Multi(m.getId_Multi());
			PorDefecto.multimedia.setTitulo(m.getTitulo());
			PorDefecto.multimedia.setDescripcion(m.getDescripcion());
			PorDefecto.multimedia.setAutor(m.getAutor());
		}
		DescargaDao d = new DescargaDao();
		Descarga des = new Descarga(LocalDate.now(), PorDefecto.usuario, PorDefecto.multimedia);
		if (d.Download(des)) {
			JOptionPane.showMessageDialog(null, "La descarga comenzara en breves",
					"OPERACIÓN ÉXITOSA", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "La descarga no se ha podido realizar o ya se ha descargado",
					"OPERACIÓN ERRONEA", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
}
