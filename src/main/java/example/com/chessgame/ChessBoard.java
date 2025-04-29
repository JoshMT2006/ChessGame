package example.com.chessgame;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessBoard {
    private static final int TILE_SIZE = 80;
    private static final int BOARD_SIZE = 8;

    public GridPane CreateBoard() {
        GridPane grid = new GridPane();

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                StackPane tile = new StackPane();

                Rectangle square = new Rectangle(TILE_SIZE, TILE_SIZE);
                square.setFill((row + col) % 2 == 0 ? Color.BEIGE : Color.TAN);

                tile.getChildren().add(square);
                //places Black Pawns
                if (row == 1) {
                    Pawn blackPawn = new Pawn(false);
                    ImageView pieceImage = new ImageView(blackPawn.getImage());
                    pieceImage.setFitWidth(60);
                    pieceImage.setFitHeight(60);
                    pieceImage.setPreserveRatio(true); // Optional for quality
                    tile.getChildren().add(pieceImage);
                }
                grid.add(tile, col, row);
                //Places White Pawns
                if (row == 6) {
                    Pawn whitePawn = new Pawn(true);
                    ImageView pieceImage = new ImageView(whitePawn.getImage());
                    pieceImage.setFitWidth(60);
                    pieceImage.setFitHeight(60);
                    pieceImage.setPreserveRatio(true);
                    tile.getChildren().add(pieceImage);
                }

                //place Rooks
                if (row == 0 && col == 0 || row == 0 && col == 7) {
                    Rook rook = new Rook(false);
                    ImageView pieceImage = new ImageView(rook.getImage());
                    pieceImage.setFitWidth(60);
                    pieceImage.setFitHeight(60);
                    pieceImage.setPreserveRatio(true);
                    tile.getChildren().add(pieceImage);
                }

                if(row == 7 && col == 0 || row == 7 && col == 7){
                    Rook rook = new Rook(true);
                    ImageView pieceImage = new ImageView(rook.getImage());
                    pieceImage.setFitWidth(60);
                    pieceImage.setFitHeight(60);
                    pieceImage.setPreserveRatio(true);
                    tile.getChildren().add(pieceImage);
                }

                //place Knights
                if (row == 0 && col == 1 || row == 0 && col == 6 || row == 7 && col == 1 || row == 7 && col == 6) {
                    Knight knight = new Knight(false);
                    ImageView pieceImage = new ImageView(knight.getImage());
                    pieceImage.setFitWidth(60);
                    pieceImage.setFitHeight(60);
                    pieceImage.setPreserveRatio(true);
                    tile.getChildren().add(pieceImage);
                }
                if(row == 7 && col == 1 || row == 7 && col == 6){
                    Knight knight = new Knight(true);
                    ImageView pieceImage = new ImageView(knight.getImage());
                    pieceImage.setFitWidth(60);
                    pieceImage.setFitHeight(60);
                    pieceImage.setPreserveRatio(true);
                    tile.getChildren().add(pieceImage);
                }



            }
        }
        return grid;
    }



}
