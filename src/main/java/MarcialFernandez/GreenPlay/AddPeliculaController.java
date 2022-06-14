package MarcialFernandez.GreenPlay;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import MarcialFernandez.GreenPlay.Model.Multimedia;
import MarcialFernandez.GreenPlay.Model.Musica;
import MarcialFernandez.GreenPlay.Model.Pelicula;
import MarcialFernandez.GreenPlay.Model.Usuario;
import MarcialFernandez.GreenPlay.ModelDao.MultimediaDao;
import MarcialFernandez.GreenPlay.ModelDao.UsuarioDao;
import MarcialFernandez.GreenPlay.Utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddPeliculaController {

	@FXML
	private TextField txttitulo, txtdescripcion, txtautor, txtdirector;
	@FXML
	private Button volver, add;
	/**	
	 * Añade una pelicula a la base de datos con los paramtros introducidos por teclado
	 * @param e
	 * @throws IOException
	 */
	@FXML
	public void add(ActionEvent e) throws IOException {
		if (!txttitulo.getText().isEmpty() && !txtdescripcion.getText().isEmpty() && !txtautor.getText().isEmpty() && !txtdirector.getText().isEmpty()) {

			if (txttitulo.getText().length() >= 3) {

				Pelicula p = new Pelicula(txttitulo.getText(), txtdescripcion.getText(), txtautor.getText(),
						txtdirector.getText());
				if (MultimediaDao.insertPelicula(p)) {
					JOptionPane.showMessageDialog(null, "La Pelicula ha sido registrada de manera éxitosa",
							"OPERACIÓN ÉXITOSA", JOptionPane.INFORMATION_MESSAGE);
					App.setRoot("LobbyAdmin");
				} else {
					JOptionPane.showMessageDialog(null, "La Pelicula no se ha podido registrar", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "El titulo debe de tener mas de 3 letras", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		} else

		{
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos obligatorios", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * vulve a la pagina principal
	 * @param e
	 * @throws IOException
	 */
	public void volver(ActionEvent e) throws IOException {
		App.setRoot("LobbyAdmin");
	}
}
