package example.com.chessgame;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessBoard {
    private static final int TILE_SIZE = 80;
    private static final int BOARD_SIZE = 8;

    public GridPane CreateBoard() {
        GridPane grid = new GridPane();
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Rectangle square = new Rectangle(TILE_SIZE, TILE_SIZE);
                if ((row + col) % 2 == 0) {
                    square.setFill(Color.TAN);
                } else {
                    square.setFill(Color.BLACK);
                }
                grid.add(square, col, row);
            }
        }
        return grid;
    }

}
