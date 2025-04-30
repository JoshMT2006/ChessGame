package example.com.chessgame;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

                // Place Black Pawns
                if (row == 1) {
                    Pawn blackPawn = new Pawn(false);
                    ImageView pieceImage = createPieceImage(blackPawn);
                    int finalRow = row;
                    int finalCol = col;
                    pieceImage.setOnMousePressed(e -> onPiecePressed(e, pieceImage, finalRow, finalCol));
                    pieceImage.setOnMouseDragged(e -> onPieceDragged(e, pieceImage));
                    pieceImage.setOnMouseReleased(e -> onPieceReleased(e, pieceImage));
                    tile.getChildren().add(pieceImage);
                }

                // Place White Pawns
                if (row == 6) {
                    Pawn whitePawn = new Pawn(true);
                    ImageView pieceImage = createPieceImage(whitePawn);
                    int finalRow = row;
                    int finalCol = col;
                    pieceImage.setOnMousePressed(e -> onPiecePressed(e, pieceImage, finalRow, finalCol));
                    pieceImage.setOnMouseDragged(e -> onPieceDragged(e, pieceImage));
                    pieceImage.setOnMouseReleased(e -> onPieceReleased(e, pieceImage));
                    tile.getChildren().add(pieceImage);
                }

                // Place Rooks
                if ((row == 0 && col == 0) || (row == 0 && col == 7)) {
                    Rook rook = new Rook(false);
                    ImageView pieceImage = createPieceImage(rook);
                    int finalRow = row;
                    int finalCol = col;
                    pieceImage.setOnMousePressed(e -> onPiecePressed(e, pieceImage, finalRow, finalCol));
                    pieceImage.setOnMouseDragged(e -> onPieceDragged(e, pieceImage));
                    pieceImage.setOnMouseReleased(e -> onPieceReleased(e, pieceImage));
                    tile.getChildren().add(pieceImage);
                }

                if ((row == 7 && col == 0) || (row == 7 && col == 7)) {
                    Rook rook = new Rook(true);
                    ImageView pieceImage = createPieceImage(rook);
                    int finalRow = row;
                    int finalCol = col;
                    pieceImage.setOnMousePressed(e -> onPiecePressed(e, pieceImage, finalRow, finalCol));
                    pieceImage.setOnMouseDragged(e -> onPieceDragged(e, pieceImage));
                    pieceImage.setOnMouseReleased(e -> onPieceReleased(e, pieceImage));
                    tile.getChildren().add(pieceImage);
                }


                grid.add(tile, col, row);
            }
        }
        return grid;
    }

    // Helper method to create ImageView for pieces
    private ImageView createPieceImage(pieces piece) {
        ImageView pieceImage = new ImageView(piece.getImage());
        pieceImage.setFitWidth(60);
        pieceImage.setFitHeight(60);
        pieceImage.setPreserveRatio(true);
        return pieceImage;
    }

    // Handle the mouse pressed event for dragging a piece
    private void onPiecePressed(MouseEvent event, ImageView pieceImage, int row, int col) {
        // Store initial coordinates of the piece
        pieceImage.setUserData(new int[]{row, col}); // Store original row and col
    }

    // Handle the mouse dragged event to move the piece
    private void onPieceDragged(MouseEvent event, ImageView pieceImage) {
        pieceImage.setLayoutX(event.getSceneX() - (double) TILE_SIZE / 2);
        pieceImage.setLayoutY(event.getSceneY() - (double) TILE_SIZE / 2);
    }

    // Handle the mouse released event to snap the piece back to the board
    private void onPieceReleased(MouseEvent event, ImageView pieceImage) {
        int newCol = (int) (event.getSceneX() / TILE_SIZE);
        int newRow = (int) (event.getSceneY() / TILE_SIZE);
        // Adjust piece position back to the closest tile
        pieceImage.setLayoutX(newCol * TILE_SIZE);
        pieceImage.setLayoutY(newRow * TILE_SIZE);
        // Here you can add your own validation for valid moves and game rules
        // Update the piece's stored position (if necessary)
    }

}