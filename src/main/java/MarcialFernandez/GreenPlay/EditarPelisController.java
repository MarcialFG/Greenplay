package MarcialFernandez.GreenPlay;

import java.io.IOException;

import javax.swing.JOptionPane;

import MarcialFernandez.GreenPlay.ModelDao.MusicaDao;
import MarcialFernandez.GreenPlay.ModelDao.PeliculaDao;
import MarcialFernandez.GreenPlay.Utils.PorDefecto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditarPelisController {
	@FXML
	private TextField txttitulo, txtdescripcion, txtautor, txtdirector;
	@FXML
	private Button volver, editar;

	public void editar(ActionEvent e) throws IOException {
		PeliculaDao p = new PeliculaDao();
		if (!txttitulo.getText().isEmpty() && !txtdescripcion.getText().isEmpty() && !txtautor.getText().isEmpty()
				&& !txtdirector.getText().isEmpty()) {
			if (txttitulo.getText().length() >= 3) {
				if (p.update(PorDefecto.multimedia.getId_Multi(), txttitulo.getText(), txtdescripcion.getText(),
						txtautor.getText(), txtdirector.getText())) {
					JOptionPane.showMessageDialog(null, "La pelicula ha sido editada correctamente", "OPERACIÓN ÉXITOSA",
							JOptionPane.INFORMATION_MESSAGE);
					App.setRoot("LobbyAdmin");
				} else {
					JOptionPane.showMessageDialog(null, "La pelicula no se ha registrado", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					App.setRoot("LobbyAdmin");
				}
			} else {
				JOptionPane.showMessageDialog(null, "El titulo debe de tener mas de 3 letras", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos obligatorios", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void volver(ActionEvent e) throws IOException {
		App.setRoot("LobbyAdmin");
	}
}
