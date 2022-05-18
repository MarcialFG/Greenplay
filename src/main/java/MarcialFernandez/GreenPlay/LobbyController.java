package MarcialFernandez.GreenPlay;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class LobbyController implements Initializable{
	@FXML
	private Button Peliculas, Musica,Descargas;
	/**
	 * asigna a cada boton una funcion para cambiar de vista
	 * @param e
	 */
	@FXML
	private void actionEvent(ActionEvent e) {
		Object evt = e.getSource();
		if (evt.equals(Peliculas)) {
			try {
				cambioPelis();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}if (evt.equals(Musica)) {
				try {
					cambioMusica();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		} else if (evt.equals(Descargas)) {
			try {
				cambioDescargas();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	
	private void cambioPelis() throws IOException {
        App.setRoot("Peliculas");
    }
	private void cambioMusica() throws IOException {
        App.setRoot("Musica");
    }
	private void cambioDescargas() throws IOException {
        App.setRoot("Descargas");
    }
}
