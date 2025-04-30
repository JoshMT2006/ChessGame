package example.com.chessgame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        Game game = new Game(root);
        ChessBoard chessBoard = new ChessBoard();

        // Create player and computer side labels
        Label playerSide = new Label("Player Side");
        playerSide.setStyle("-fx-background-color: rgba(51,90,119,0.38); -fx-padding: 20px;");
        Label computerSide = new Label("Computer Side");
        computerSide.setStyle("-fx-background-color: #807676; -fx-padding: 20px;");

        // Set container for chess board
        VBox chessBoardContainer = new VBox();
        chessBoardContainer.setAlignment(Pos.CENTER);
        chessBoardContainer.getChildren().add(chessBoard.CreateBoard());

        //WhitePawns
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    ChessPieces blackPawn = new ChessPieces("/images/BlackPawn.png", i, j, new Game(chessBoardContainer));
                    root.getChildren().add(blackPawn);
                }
                if (i == 6) {
                    ChessPieces whitePawn = new ChessPieces("/images/WhitePawn.png", i, j, new Game(chessBoardContainer));
                    root.getChildren().add(whitePawn);
                }
            }

        }




        // HBox for layout
        HBox BoardGUI = new HBox();
        BoardGUI.setAlignment(Pos.CENTER);
        BoardGUI.getChildren().addAll(computerSide, root, playerSide);

        Scene scene = new Scene(BoardGUI, 1000, 1000);

        // Set the scene and show the stage
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}