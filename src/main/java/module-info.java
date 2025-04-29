module example.com.chessgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens example.com.chessgame to javafx.fxml;
    exports example.com.chessgame;
}