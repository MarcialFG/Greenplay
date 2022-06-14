package MarcialFernandez.GreenPlay;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import MarcialFernandez.GreenPlay.Model.Multimedia;
import MarcialFernandez.GreenPlay.Model.Usuario;
import MarcialFernandez.GreenPlay.ModelDao.MultimediaDao;
import MarcialFernandez.GreenPlay.ModelDao.UsuarioDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaUsuariosController implements Initializable {
	
	@FXML
	private TableView<Usuario> tablausuarios;
	@FXML
	private TableColumn<Usuario, String> dni;
	@FXML
	private TableColumn<Usuario, String> nombre;
	@FXML
	private TableColumn<Usuario, String> correo;
	@FXML
	private Button volver;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.dni.setCellValueFactory(new PropertyValueFactory<>("dni"));
		this.nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.correo.setCellValueFactory(new PropertyValueFactory<>("correo"));
		UsuarioDao usu = new UsuarioDao();
		ObservableList<Usuario> lista = FXCollections.observableList(usu.listaUsuario());
		this.tablausuarios.setItems(lista);
	}
	
	public void volver(ActionEvent e) throws IOException {
		App.setRoot("LobbyAdmin");
	}

}
