package MarcialFernandez.GreenPlay;

import java.io.IOException;

import javax.swing.JOptionPane;

import MarcialFernandez.GreenPlay.Model.Usuario;
import MarcialFernandez.GreenPlay.ModelDao.UsuarioDao;
import MarcialFernandez.GreenPlay.Utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistroController {

	@FXML
	private Button Registar;
	@FXML
	private TextField txtusuario, txtdni, txtcorreo, txtcontraseña;

	/**
	 * Recoge los credenciales introducidos por teclado,los verifica e introduce en
	 * la base de datos si es correcto
	 * 
	 * @param e
	 */
	@FXML
	public void actionEvent(ActionEvent e) {
		if (!txtcorreo.getText().isEmpty() && !txtusuario.getText().isEmpty() && !txtdni.getText().isEmpty()
				&& !txtcontraseña.getText().isEmpty()) {
			if (Utils.validateEmail(txtcorreo.getText())) {
				if (Utils.getDNI(txtdni.getText())) {
					if (txtusuario.getText().length() >= 3) {

						Usuario usuario = new Usuario(txtdni.getText(), txtusuario.getText(), txtcorreo.getText(),
								txtcontraseña.getText());

						if (UsuarioDao.insertUsuario(usuario)) {
							JOptionPane.showMessageDialog(null, "El Usuario ha sido registrado de manera éxitosa",
									"OPERACIÓN ÉXITOSA", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "El usuario no se ha podido registrar", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "El nombre debe de tener mas de 3 letras", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "El DNI es invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Correo invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos obligatorios", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
