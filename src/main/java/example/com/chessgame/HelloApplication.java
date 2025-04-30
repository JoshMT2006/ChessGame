package example.com.chessgame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {
    public void start(Stage stage) throws IOException {
        Pane boardPane = new Pane();
        Game game = new Game(boardPane);

        // Initialize static piece positions
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                PiecePositions.piecesPositions[row][col] = null;
            }
        }

        // Create player and computer side labels
        Label playerSide = new Label("Player Side");
        playerSide.setStyle("-fx-background-color: rgba(51,90,119,0.38); -fx-padding: 20px;");
        Label computerSide = new Label("Computer Side");
        computerSide.setStyle("-fx-background-color: #807676; -fx-padding: 20px;");

        placePieces(game, boardPane);

        // HBox for layout
        HBox BoardGUI = new HBox();
        BoardGUI.getChildren().addAll(computerSide, boardPane, playerSide);

        Scene scene = new Scene(BoardGUI, 1000, 1000);
        stage.setTitle("Chess Game");
        stage.setScene(scene);
        stage.show();
    }

    private void placePieces(Game game, Pane root) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                PiecePositions.piecesPositions[row][col] = null;
            }
        }
        // Initialize black pawns (row 1)
        for (int col = 0; col < 8; col++) {
            Pawn blackPawn = new Pawn(false);
            ChessPieces piece = new ChessPieces(blackPawn, 1, col, game);
            root.getChildren().add(piece);
            PiecePositions.setPiece(1, col, piece);
        }

        // Initialize white pawns (row 6)
        for (int col = 0; col < 8; col++) {
            Pawn whitePawn = new Pawn(true);
            ChessPieces piece = new ChessPieces(whitePawn, 6, col, game);
            root.getChildren().add(piece);
            PiecePositions.setPiece(1, col, piece);
        }

    }

    public static void main(String[] args) {
        launch();
    }
}
