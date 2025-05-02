package example.com.chessgame;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Game {
    public static final int SQUARE_SIZE = 90;
    public static final int BOARD_OFFSET_X = 100;
    public static final int BOARD_OFFSET_Y = 100;
    private boolean isWhiteTurn = false;
    private Label turnLabel;
    private final GameHistory gameHistory = new GameHistory();

    private final Pane root;

    public Game(Pane root, Label turnLabel) {
        this.root = root;
        this.turnLabel = turnLabel;
        drawBoard();
    }


    private void drawBoard() {
        // Draw board background
        Rectangle boardBackground = new Rectangle(
                BOARD_OFFSET_X - 5,
                BOARD_OFFSET_Y - 5,
                SQUARE_SIZE * 8 + 10,
                SQUARE_SIZE * 8 + 10
        );
        boardBackground.setFill(Color.DARKGRAY);
        root.getChildren().add(boardBackground);

        // Draw board squares
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Rectangle square = new Rectangle(SQUARE_SIZE, SQUARE_SIZE);
                square.setX(BOARD_OFFSET_X + col * SQUARE_SIZE);
                square.setY(BOARD_OFFSET_Y + row * SQUARE_SIZE);
                square.setFill((row + col) % 2 == 0 ? Color.BEIGE : Color.TAN);
                root.getChildren().addAll(square);
            }
        }
    }

    // Coordinate conversion methods
    public int getColFromX(double x) {
        return Math.max(0, Math.min(7, (int) Math.floor((x - BOARD_OFFSET_X) / SQUARE_SIZE)));
    }

    public int getRowFromY(double y) {
        return Math.max(0, Math.min(7, (int) Math.floor((y - BOARD_OFFSET_Y) / SQUARE_SIZE)));
    }

    public static double getXFromCol(int col) {
        return BOARD_OFFSET_X + col * SQUARE_SIZE;
    }

    public static double getYFromRow(int row) {
        return BOARD_OFFSET_Y + row * SQUARE_SIZE;
    }

    public void switchTurn() {
        isWhiteTurn = !isWhiteTurn;
        turnLabel.setText(isWhiteTurn ? "White's Turn" : "Black's Turn");
    }

    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }

    public GameHistory getGameHistory() {
        return gameHistory;
    }

}
