package MarcialFernandez.GreenPlay;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import MarcialFernandez.GreenPlay.Model.Descarga;
import MarcialFernandez.GreenPlay.Model.Multimedia;
import MarcialFernandez.GreenPlay.ModelDao.DescargaDao;
import MarcialFernandez.GreenPlay.ModelDao.MultimediaDao;
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

public class LobbyUsuarioController implements Initializable {
	
	@FXML
	private TableView<Multimedia> table;
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
	private Button listaDescargas;
	@FXML
	private Button Descargar;

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
		this.table.setItems(lista);
	}
	/**
	 * cambia a la pagina que muestra la lista de descargas
	 * @param e
	 * @throws IOException
	 */
	public void cambiolistas(ActionEvent e) throws IOException {
		App.setRoot("ListaDescargas");
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
	 * cambia a la pagina que muestra las peliculas
	 * @param e
	 * @throws IOException
	 */
	public void cambiopelis(ActionEvent e) throws IOException {
		App.setRoot("PelisUsu");
	}
	/**
	 * cambia a la pagina que muestra la musica
	 * @param e
	 * @throws IOException
	 */
	public void cambiomusica(ActionEvent e) throws IOException {
		App.setRoot("MusicaUsu");
	}
	/**
	 * recoge los datos de la multimedia seleccionada y los guarda para llamar a la funcion descarga y añadir 
	 * una descarga a la base de datos
	 * @param e
	 * @throws IOException
	 */
	public void download(ActionEvent e) throws IOException {
		Multimedia m = this.table.getSelectionModel().getSelectedItem();
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
