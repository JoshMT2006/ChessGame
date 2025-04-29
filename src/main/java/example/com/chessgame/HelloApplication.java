package example.com.chessgame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {
    private static final int TILE_SIZE = 80;
    private static final int BOARD_SIZE = 8;

    @Override
    public void start(Stage stage) throws IOException {
        //creates chess board
        ChessBoard chessBoard = new ChessBoard();

        //user and computer side labels
        Label playerSide = new Label("Player Side");
        playerSide.setStyle("-fx-background-color: rgba(51,90,119,0.38); -fx-padding: 20px;");
        Label computerSide = new Label("Computer Side");
        computerSide.setStyle("-fx-background-color: #602626; -fx-padding: 20px;");


        //setting container for chess board
        VBox chessBoardContainer = new VBox();
        chessBoardContainer.setAlignment(Pos.CENTER);
        chessBoardContainer.getChildren().add(chessBoard.CreateBoard());

        HBox BoardGUI = new HBox();
        BoardGUI.getChildren().addAll(computerSide,chessBoardContainer,playerSide);

        stage.setScene(new Scene(BoardGUI));
        stage.show();




        //Drag and drop for piece movements

    }

    public static void main(String[] args) {
        launch();
    }
}