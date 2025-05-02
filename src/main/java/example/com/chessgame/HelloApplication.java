package example.com.chessgame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {
    public void start(Stage stage) throws IOException {
        Pane boardPane = new Pane();
        Label turnLabel = new Label();
        Game game = new Game(boardPane, turnLabel);
        // Initialize static piece positions
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                PiecePositions.piecesPositions[row][col] = null;
            }
        }

        turnLabel.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");

        // Create player and computer side labels
        Label playerSide = new Label("Player Side");
        playerSide.setStyle("-fx-background-color: rgba(51,90,119,0.38); -fx-padding: 20px;");
        Label computerSide = new Label("Computer Side");
        computerSide.setStyle("-fx-background-color: #807676; -fx-padding: 20px;");

        placePieces(game, boardPane);

        // HBox for layout
        HBox BoardGUI = new HBox();
        BoardGUI.getChildren().addAll(computerSide, boardPane, playerSide);

        VBox Layout = new VBox();
        Layout.getChildren().addAll(turnLabel, BoardGUI);

        Scene scene = new Scene(Layout, 1000, 1000);
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
        //Initialize Rooks
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                if (col == 0 && row == 0 || col == 7 && row == 0) {
                    Rook blackRook = new Rook(false);
                    ChessPieces piece = new ChessPieces(blackRook, row, col, game);
                    root.getChildren().add(piece);
                    PiecePositions.setPiece(row, col, piece);
                }
                if (col == 0 && row == 7 || col == 7 && row == 7) {
                    Rook whiteRook = new Rook(true);
                    ChessPieces piece = new ChessPieces(whiteRook, row, col, game);
                    root.getChildren().add(piece);
                    PiecePositions.setPiece(row, col, piece);
                }
            }
        }

        //Initialize Knights
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                if (col == 1 && row == 0 || col == 6 && row == 0) {
                    Knight blackKnight = new Knight(false);
                    ChessPieces piece = new ChessPieces(blackKnight, row, col, game);
                    root.getChildren().add(piece);
                    PiecePositions.setPiece(row, col, piece);
                }
                if (col == 6 && row == 7 || col == 1 && row == 7) {
                    Knight blackKnight = new Knight(true);
                    ChessPieces piece = new ChessPieces(blackKnight, row, col, game);
                    root.getChildren().add(piece);
                    PiecePositions.setPiece(row, col, piece);
                }
            }
        }

        //Initialize Bishops
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                if (col == 2 && row == 0 || col == 5 && row == 0) {
                    Bishop blackBishop = new Bishop(false);
                    ChessPieces piece = new ChessPieces(blackBishop, row, col, game);
                    root.getChildren().add(piece);
                    PiecePositions.setPiece(row, col, piece);
                }
                if (col == 5 && row == 7 || col == 2 && row == 7) {
                    Bishop whiteBishop = new Bishop(true);
                    ChessPieces piece = new ChessPieces(whiteBishop, row, col, game);
                    root.getChildren().add(piece);
                    PiecePositions.setPiece(row, col, piece);
                }
            }
        }

        //Initialize Queens
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                if (col == 3 && row == 0 || col == 4 && row == 0) {
                    Queen blackQueen = new Queen(false);
                    ChessPieces piece = new ChessPieces(blackQueen, row, col, game);
                    root.getChildren().add(piece);
                    PiecePositions.setPiece(row, col, piece);
                }
                if (col == 4 && row == 7 || col == 3 && row == 7) {
                    Queen whiteQueen = new Queen(true);
                    ChessPieces piece = new ChessPieces(whiteQueen, row, col, game);
                    root.getChildren().add(piece);
                    PiecePositions.setPiece(row, col, piece);
                }
            }
        }
        //Initialize Kings
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                if (col == 4 && row == 0) {
                    King blackKing = new King(false);
                    ChessPieces piece = new ChessPieces(blackKing, row, col, game);
                    root.getChildren().add(piece);
                    PiecePositions.setPiece(row, col, piece);
                }
                if (col == 4 && row == 7) {
                    King whiteKing = new King(true);
                    ChessPieces piece = new ChessPieces(whiteKing, row, col, game);
                    root.getChildren().add(piece);
                    PiecePositions.setPiece(row, col, piece);
                }
            }
        }


    }

    public static void main(String[] args) {
        launch();
    }
}
