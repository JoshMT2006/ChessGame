package example.com.chessgame;

import javafx.scene.image.Image;

public class King extends Piece {
    private int row;
    private int col;
    public King(boolean isWhite) {
        super(isWhite);
    }
    @Override
    public Image getImage(){
        if (isWhite) {
            return new Image(getClass().getResourceAsStream("/images/WhiteKing.png"));
        } else {
            return new Image(getClass().getResourceAsStream("/images/BlackKing.png"));
        }
    }
    @Override
    public boolean validMove(int initialRow, int initialCol, int finalRow, int finalCol) {
        // Bounds check
        if (finalRow < 0 || finalRow >= 8 || finalCol < 0 || finalCol >= 8) {
            return false;
        }

        // Same square check
        if (initialRow == finalRow && initialCol == finalCol) {
            return false;
        }

        int rowDiff = Math.abs(finalRow - initialRow);
        int colDiff = Math.abs(finalCol - initialCol);

        // King moves 1 square in any direction
        if (rowDiff <= 1 && colDiff <= 1) {
            Object[][] board = PiecePositions.piecesPositions;
            Object destination = board[finalRow][finalCol];

            // If destination is empty
            if (destination == null) {
                return true;
            }

            // If destination has a piece of the opposite color
            if (destination instanceof ChessPieces) {
                ChessPieces target = (ChessPieces) destination;
                return target.isWhite() != this.isWhite;
            }
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
