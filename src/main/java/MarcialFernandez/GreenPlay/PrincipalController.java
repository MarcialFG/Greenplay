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

public class PrincipalController implements Initializable {

	@FXML
	private Button iniciosesion, registro;
	@FXML
	private StackPane container;
	@FXML
	private VBox iniciosesionpanel, panelRegistro;

	/**
	 * asigna a cada boton un panel para mostrar en la vista principal, al mostrar
	 * uno se oculta el otro
	 * 
	 * @param e
	 */
	@FXML
	private void actionEvent(ActionEvent e) {
		Object evt = e.getSource();
		if (evt.equals(iniciosesion)) {
			iniciosesionpanel.setVisible(true);
			panelRegistro.setVisible(false);
		} else if (evt.equals(registro)) {
			iniciosesionpanel.setVisible(false);
			panelRegistro.setVisible(true);
		}
	}

	/**
	 * carga las vistas de inicio de sesion y registro y las guarda en el container
	 * para ser utilizadas por el actionEvent
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
			iniciosesionpanel = loadForm("/MarcialFernandez/GreenPlay/InicioSesion.fxml");
			panelRegistro = loadForm("/MarcialFernandez/GreenPlay/Registro.fxml");
			container.getChildren().addAll(iniciosesionpanel, panelRegistro);
			iniciosesionpanel.setVisible(true);
			panelRegistro.setVisible(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * carga la vista introduciendo su direccion
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	private VBox loadForm(String url) throws IOException {

		return (VBox) FXMLLoader.load(getClass().getResource(url));

	}

}
