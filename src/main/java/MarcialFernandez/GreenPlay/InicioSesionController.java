package MarcialFernandez.GreenPlay;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import MarcialFernandez.GreenPlay.Model.Usuario;
import MarcialFernandez.GreenPlay.ModelDao.UsuarioDao;
import MarcialFernandez.GreenPlay.Utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class InicioSesionController implements Initializable {

	@FXML
	private Button Entrar;
	@FXML
	private PasswordField txtpassword;
	@FXML
	private TextField txtdni, txtpassword2;
	@FXML
	private CheckBox check;

	@FXML
	private void cambioLobby() throws IOException {
		App.setRoot("Lobby");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		maskpassword(txtpassword, txtpassword2, check);
	}

	/**
	 * Metodo para mostrar en texto los asteriscos del panel contraseña
	 * 
	 * @param pass
	 * @param txt
	 * @param check
	 */
	public void maskpassword(PasswordField pass, TextField txt, CheckBox check) {

		txt.setVisible(false);
		txt.setManaged(false);

		txt.managedProperty().bind(check.selectedProperty());
		txt.visibleProperty().bind(check.selectedProperty());

		txt.textProperty().bindBidirectional(pass.textProperty());
	}

	/**
	 * al pulsar el boton , compara las credenciales introducidas con la base de
	 * datos y entra si son iguales
	 * 
	 * @param e
	 */
	public void actionEvent(ActionEvent e) {

		if (!txtdni.getText().isEmpty() && !txtpassword.getText().isEmpty()) {

			Usuario usuario = UsuarioDao.selectUsuario(txtdni.getText(), txtpassword.getText());

			if (usuario != null) {

				if (usuario.getContrasenia().equals(txtpassword2.getText())) {
					JOptionPane.showMessageDialog(null, "Bienvenido", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
					try {
						cambioLobby();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "La Contraseña que ha ingresado no es la correcta",
							"ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null, "El Usuario no existe en la Base de Datos", "SIN RESULTADOS",
						JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Debe llenar los campos obligatorios", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}