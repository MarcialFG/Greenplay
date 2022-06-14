package MarcialFernandez.GreenPlay;

import java.io.IOException;

import javax.swing.JOptionPane;

import MarcialFernandez.GreenPlay.Model.Musica;
import MarcialFernandez.GreenPlay.Model.Pelicula;
import MarcialFernandez.GreenPlay.ModelDao.MultimediaDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddMusicaController {
	@FXML
	private TextField txttitulo, txtdescripcion, txtautor, txtproductor;
	@FXML
	private Button volver, add;

	@FXML
	public void add(ActionEvent e) throws IOException {
		if (!txttitulo.getText().isEmpty() && !txtdescripcion.getText().isEmpty() && !txtautor.getText().isEmpty() && !txtproductor.getText().isEmpty()) {

			if (txttitulo.getText().length() >= 3) {

				Musica m = new Musica(txttitulo.getText(), txtdescripcion.getText(), txtautor.getText(),
						txtproductor.getText());
				if (MultimediaDao.insertMusica(m)) {
					JOptionPane.showMessageDialog(null, "La musica ha sido registrada de manera éxitosa",
							"OPERACIÓN ÉXITOSA", JOptionPane.INFORMATION_MESSAGE);
					App.setRoot("LobbyAdmin");
				} else {
					JOptionPane.showMessageDialog(null, "La musica no se ha podido registrar", "ERROR",
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

	public void volver(ActionEvent e) throws IOException {
		App.setRoot("LobbyAdmin");
	}
}
