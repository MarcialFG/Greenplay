module MarcialFernandez.GreenPlay {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.xml.bind;
	requires java.sql;
	requires mysql.connector.java;
	requires javafx.base;
	requires java.base;
	requires java.desktop;
	requires spring.security.crypto;
	requires javafx.graphics;

	opens MarcialFernandez.GreenPlay.Utils to java.xml.bind;
	opens MarcialFernandez.GreenPlay to java.xml.bind, javafx.fxml;

	exports MarcialFernandez.GreenPlay;
}
