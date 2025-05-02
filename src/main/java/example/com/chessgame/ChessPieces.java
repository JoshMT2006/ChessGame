package example.com.chessgame;


import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ChessPieces extends ImageView {
    private int row;
    private int col;
    private int originalRow;
    private int originalCol;
    private double mouseX, mouseY;
    private double startX, startY;
    private Piece piece;
    private Game game;
    //Added Turn Counter for use in the futu
    private final GameHistory gameHistory = new GameHistory();

    public ChessPieces(Piece piece, int row, int col, Game game) {
        super(piece.getImage());
        this.piece = piece;
        this.row = row;
        this.col = col;
        this.game = game;

        piece.setRow(row);
        piece.setCol(col);

        setFitWidth(Game.SQUARE_SIZE - 10);
        setFitHeight(Game.SQUARE_SIZE - 10);
        relocateToBoard();

        PiecePositions.setPiece(row, col, this);

        setOnMousePressed(this::onMousePressed);
        setOnMouseDragged(this::onMouseDragged);
        setOnMouseReleased(this::onMouseReleased);
    }

    private void onMousePressed(MouseEvent event) {
        mouseX = event.getSceneX();
        mouseY = event.getSceneY();
        startX = getLayoutX();
        startY = getLayoutY();
        originalRow = row;
        originalCol = col;
        toFront();
    }

    private void onMouseDragged(MouseEvent event) {
        double offsetX = event.getSceneX() - mouseX;
        double offsetY = event.getSceneY() - mouseY;
        setLayoutX(startX + offsetX - 5);
        setLayoutY(startY + offsetY - 5);
    }

    private void onMouseReleased(MouseEvent event) {
        Point2D localPoint = getParent().sceneToLocal(event.getSceneX(), event.getSceneY());
        int newCol = game.getColFromX(localPoint.getX());
        int newRow = game.getRowFromY(localPoint.getY());

        if (PiecePositions.piecesPositions[row][col] != this) {
            boolean found = false;
            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {
                    if (PiecePositions.piecesPositions[r][c] == this) {
                        row = r;
                        col = c;
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
            if (!found) {
                PiecePositions.setPiece(row, col, this);
            }
        }

        newCol = Math.max(0, Math.min(7, newCol));
        newRow = Math.max(0, Math.min(7, newRow));
        if(gameHistory.getMoveCount() == 0) {
            if(piece.isWhite() == game.isWhiteTurn()) {
                if (piece.validMove(row, col, newRow, newCol)) {
                    int oldRow = row;
                    int oldCol = col;

                    this.row = newRow;
                    this.col = newCol;
                    piece.setRow(newRow);
                    piece.setCol(newCol);

                    PiecePositions.movePiece(oldRow, oldCol, newRow, newCol);
                    game.switchTurn();
                    gameHistory.incrementMoveCount();
                }
            }
        }
        else if(piece.isWhite() != game.isWhiteTurn()) {
            if (piece.validMove(row, col, newRow, newCol)) {

                int oldRow = row;
                int oldCol = col;

                this.row = newRow;
                this.col = newCol;
                piece.setRow(newRow);
                piece.setCol(newCol);

                PiecePositions.movePiece(oldRow, oldCol, newRow, newCol);
                game.switchTurn();
                gameHistory.incrementMoveCount();
            }
        }
        else {
            this.row = originalRow;
            this.col = originalCol;
        }

        relocateToBoard();
    }

    public void relocateToBoard() {
        setLayoutX(Game.getXFromCol(col));
        setLayoutY(Game.getYFromRow(row));
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
    public boolean isWhite() { return piece.isWhite(); }
}