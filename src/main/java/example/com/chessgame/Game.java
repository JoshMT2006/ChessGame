package example.com.chessgame;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Game {
    public static final int SQUARE_SIZE = 64;
    public static final int BOARD_OFFSET_X = 0;
    public static final int BOARD_OFFSET_Y = 0;

    private final Pane root;

    public Game(Pane root) {
        this.root = root;
        drawBoard();
    }

    private void drawBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Rectangle square = new Rectangle(SQUARE_SIZE, SQUARE_SIZE);
                square.setX(col * SQUARE_SIZE);
                square.setY(row * SQUARE_SIZE);
                square.setFill((row + col) % 2 == 0 ? Color.BEIGE : Color.BROWN);
                root.getChildren().add(square);
            }
        }
    }

    // Coordinate conversion methods
    public int getColFromX(double x) {
        return (int) ((x - BOARD_OFFSET_X) / SQUARE_SIZE);
    }

    public int getRowFromY(double y) {
        return (int) ((y - BOARD_OFFSET_Y) / SQUARE_SIZE);
    }

    public static double getXFromCol(int col) {
        return BOARD_OFFSET_X + col * SQUARE_SIZE;
    }

    public static double getYFromRow(int row) {
        return BOARD_OFFSET_Y + row * SQUARE_SIZE;
    }

    public boolean isValidMove(ChessPieces piece, int newRow, int newCol) {
        // Replace with real move validation later
        return newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8;
    }
}
