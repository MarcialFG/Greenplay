module MarcialFernandez.GreenPlay {
    requires javafx.controls;
    requires javafx.fxml;

    opens MarcialFernandez.GreenPlay to javafx.fxml;
    exports MarcialFernandez.GreenPlay;
}
