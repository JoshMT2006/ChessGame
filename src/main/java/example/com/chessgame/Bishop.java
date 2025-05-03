package example.com.chessgame;

import javafx.scene.image.Image;

public class Bishop extends Piece {
    private int row;
    private int col;
    public Bishop(boolean isWhite) {
        super(isWhite);
    }
    @Override
    public Image getImage(){
        if (isWhite) {
            return new Image(getClass().getResourceAsStream("/images/WhiteBishop.png"));
        } else {
            return new Image(getClass().getResourceAsStream("/images/BlackBishop.png"));
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
        if (rowDiff != colDiff) {
            return false;
        }

        int rowStep = (finalRow - initialRow) > 0 ? 1 : -1;
        int colStep = (finalCol - initialCol) > 0 ? 1 : -1;

        int row = initialRow + rowStep;
        int col = initialCol + colStep;
        while (row != finalRow && col != finalCol) {
            if (board[row][col] != null) {
                return false; // Path blocked
            }
            row += rowStep;
            col += colStep;
        }
        Object destination = board[finalRow][finalCol];
        if (destination == null) {
            return true;
        }
        if (destination instanceof ChessPieces) {
            ChessPieces target = (ChessPieces) destination;
            if (target.getPiece() instanceof King) {
                return false;
            }
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
