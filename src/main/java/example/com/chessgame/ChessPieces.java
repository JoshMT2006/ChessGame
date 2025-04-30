package example.com.chessgame;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ChessPieces extends ImageView {
    private int row;
    private int col;
    private double mouseX, mouseY;
    private double startX, startY;
    private ChessBoard board;
    private Game game;

    public ChessPieces(String imagePath, int row, int col, Game game) {
        super(new Image(imagePath));
        this.row = row;
        this.col = col;
        this.game = game;

        setFitWidth(64);
        setFitHeight(64);
        relocateToBoard();

        setOnMousePressed(this::onMousePressed);
        setOnMouseDragged(this::onMouseDragged);
        setOnMouseReleased(this::onMouseReleased);
    }

    private void onMousePressed(MouseEvent event) {
        mouseX = event.getSceneX();
        mouseY = event.getSceneY();
        startX = getLayoutX();
        startY = getLayoutY();
        toFront();
    }

    private void onMouseDragged(MouseEvent event) {
        double offsetX = event.getSceneX() - mouseX;
        double offsetY = event.getSceneY() - mouseY;
        setLayoutX(startX + offsetX);
        setLayoutY(startY + offsetY);
    }

    private void onMouseReleased(MouseEvent event) {
        int newCol = game.getColFromX(getLayoutX());
        int newRow = game.getRowFromY(getLayoutY());

        if (game.isValidMove(this, newRow, newCol)) {
            this.row = newRow;
            this.col = newCol;
        }
        relocateToBoard();
    }

    public void relocateToBoard() {
        setLayoutX(Game.getXFromCol(col));
        setLayoutY(Game.getYFromRow(row));
    }

}