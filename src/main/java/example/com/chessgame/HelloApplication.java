package example.com.chessgame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Timer;

public class HelloApplication extends Application {
    public static TilePane whiteCaptured = new TilePane();
    public static TilePane blackCaptured = new TilePane();

    public void start(Stage stage) throws IOException {
        Pane boardPane = new Pane();
        Pane playerCaptures = new Pane();
        Pane computerCaptures = new Pane();
        BorderPane root = new BorderPane();
        Label turnLabel = new Label();
        Game game = new Game(boardPane, turnLabel, computerCaptures, playerCaptures);

        // Initialize static piece positions
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                PiecePositions.piecesPositions[row][col] = null;
            }
        }

        turnLabel.setStyle("-fx-font-size: 18px; -fx-padding: 10px;");
        turnLabel.setBackground(new Background(new BackgroundFill(
                javafx.scene.paint.Color.DARKGRAY, CornerRadii.EMPTY,
                Insets.EMPTY)));


        // Create player and computer side labels
        Label playerSide = new Label("Player Side");
        playerSide.setStyle("-fx-background-color: rgba(51,90,119,0.38); -fx-padding: 20px;");
        Label computerSide = new Label("Computer Side");
        computerSide.setStyle("-fx-background-color: #807676; -fx-padding: 20px;");

        //creat Pieces
        placePieces(game, boardPane);
        //Place where Captured pieces go
        capturedPieces(root, boardPane);



        // HBox for layout
        HBox BoardGUI = new HBox();
        BoardGUI.getChildren().addAll( playerCaptures, root,computerCaptures);
        BoardGUI.setAlignment(Pos.CENTER);

        VBox Layout = new VBox();
        Layout.getChildren().addAll(turnLabel, BoardGUI);
        Layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(Layout, 1000, 1000);
        stage.setTitle("Chess Game");
        stage.setScene(scene);
        stage.show();
    }
    //sets up board
    private void placePieces(Game game, Pane root) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                PiecePositions.piecesPositions[row][col] = null;
            }
        }
        // Initialize black pawns (row 1)
        for (int col = 0; col < 8; col++) {
            Pawn blackPawn = new Pawn(false);
            ChessPieces BPawn = new ChessPieces(blackPawn, 1, col, game);
            root.getChildren().add(BPawn);
            PiecePositions.setPiece(1, col, BPawn);

        // Initialize white pawns (row 6)
            Pawn whitePawn = new Pawn(true);
            ChessPieces Wpawn = new ChessPieces(whitePawn, 6, col, game);
            root.getChildren().add(Wpawn);
            PiecePositions.setPiece(1, col, Wpawn);

        }
        //Initializes non-Pawns
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                //Rooks
                if (col == 0 && row == 0 || col == 7 && row == 0) {
                    Rook blackRook = new Rook(false);
                    ChessPieces bRook = new ChessPieces(blackRook, row, col, game);
                    root.getChildren().add(bRook);
                    PiecePositions.setPiece(row, col, bRook);
                }
                if (col == 0 && row == 7 || col == 7 && row == 7) {
                    Rook whiteRook = new Rook(true);
                    ChessPieces wRook = new ChessPieces(whiteRook, row, col, game);
                    root.getChildren().add(wRook);
                    PiecePositions.setPiece(row, col, wRook);
                }
                //Knights
                if (col == 1 && row == 0 || col == 6 && row == 0) {
                    Knight blackKnight = new Knight(false);
                    ChessPieces bknight = new ChessPieces(blackKnight, row, col, game);
                    root.getChildren().add(bknight);
                    PiecePositions.setPiece(row, col, bknight);
                }
                if (col == 6 && row == 7 || col == 1 && row == 7) {
                    Knight blackKnight = new Knight(true);
                    ChessPieces Wknight = new ChessPieces(blackKnight, row, col, game);
                    root.getChildren().add(Wknight);
                    PiecePositions.setPiece(row, col, Wknight);
                }
                //Bishops
                if (col == 2 && row == 0 || col == 5 && row == 0) {
                    Bishop blackBishop = new Bishop(false);
                    ChessPieces bBishops = new ChessPieces(blackBishop, row, col, game);
                    root.getChildren().add(bBishops);
                    PiecePositions.setPiece(row, col, bBishops);
                }
                if (col == 5 && row == 7 || col == 2 && row == 7) {
                    Bishop whiteBishop = new Bishop(true);
                    ChessPieces wBishop = new ChessPieces(whiteBishop, row, col, game);
                    root.getChildren().add(wBishop);
                    PiecePositions.setPiece(row, col, wBishop);
                }
                //Queens
                if (col == 3 && row == 0) {
                    Queen blackQueen = new Queen(false);
                    ChessPieces bQueen = new ChessPieces(blackQueen, row, col, game);
                    root.getChildren().add(bQueen);
                    PiecePositions.setPiece(row, col, bQueen);
                }
                if (col == 3 && row == 7) {
                    Queen whiteQueen = new Queen(true);
                    ChessPieces wBishop = new ChessPieces(whiteQueen, row, col, game);
                    root.getChildren().add(wBishop);
                    PiecePositions.setPiece(row, col, wBishop);
                }
                //Kings
                if (col == 4 && row == 0) {
                    King blackKing = new King(false);
                    ChessPieces bKing = new ChessPieces(blackKing, row, col, game);
                    root.getChildren().add(bKing);
                    PiecePositions.setPiece(row, col, bKing);
                }
                if (col == 4 && row == 7) {
                    King whiteKing = new King(true);
                    ChessPieces wKing = new ChessPieces(whiteKing, row, col, game);
                    root.getChildren().add(wKing);
                    PiecePositions.setPiece(row, col, wKing);
                }
            }
        }
    }

    private void capturedPieces(BorderPane root, Pane boarderPane){
        whiteCaptured.setPrefColumns(2); // Wrap after 2 columns
        whiteCaptured.setHgap(5);
        whiteCaptured.setVgap(5);
        whiteCaptured.setPrefTileWidth(30);
        whiteCaptured.setPrefTileHeight(30);
        whiteCaptured.setPadding(new Insets(5));

        blackCaptured.setPrefColumns(2);
        blackCaptured.setHgap(5);
        blackCaptured.setVgap(5);
        blackCaptured.setPrefTileWidth(30);
        blackCaptured.setPrefTileHeight(30);
        blackCaptured.setPadding(new Insets(5));
        root.setLeft(whiteCaptured);
        root.setCenter(boarderPane);
        root.setRight(blackCaptured);
    }



    public static void main(String[] args) {
        launch();
    }
}
