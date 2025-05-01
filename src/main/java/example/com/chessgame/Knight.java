package example.com.chessgame;

import javafx.scene.image.Image;

public class Knight extends Piece {

    private int row;
    private int col;
    public Knight (boolean isWhite) {
        super(isWhite);
    }
    @Override
    public Image getImage(){
        if (isWhite) {
            return new Image(getClass().getResourceAsStream("/images/WhiteKnight.png"));
        } else {
            return new Image(getClass().getResourceAsStream("/images/BlackKnight.png"));
        }
    }
    @Override
    public boolean validMove(int initialRow, int initialCol, int finalRow, int finalCol) {
        if (finalRow < 0 || finalRow >= 8 || finalCol < 0 || finalCol >= 8) {
            return false;
        }
        if (initialRow == finalRow && initialCol == finalCol) {
            return false;
        }

        Object[][] board = PiecePositions.piecesPositions;
        int rowDiff = Math.abs(finalRow - initialRow);
        int colDiff = Math.abs(finalCol - initialCol);

        boolean isLShape = (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
        if (!isLShape) {
            return false;
        }
        Object destination = board[finalRow][finalCol];
        if (destination == null) {
            return true;
        }
        if (destination instanceof ChessPieces) {
            ChessPieces target = (ChessPieces) destination;
            return target.isWhite() != this.isWhite;
        }
        return false;
    }

    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getCol() {
        return col;
    }
}
