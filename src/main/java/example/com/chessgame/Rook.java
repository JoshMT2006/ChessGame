package example.com.chessgame;

import javafx.scene.image.Image;

public class Rook extends Piece {
    private int row;
    private int col;
    public Rook(boolean isWhite) {
        super(isWhite);
    }
    @Override
    public Image getImage(){
        if (isWhite) {
            return new Image(getClass().getResourceAsStream("/images/WhiteRook.png"));
        } else {
            return new Image(getClass().getResourceAsStream("/images/BlackRook.png"));
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
        if (initialRow != finalRow && initialCol != finalCol) {
            return false;
        }

        int rowStep = Integer.compare(finalRow, initialRow);
        int colStep = Integer.compare(finalCol, initialCol);
        int currentRow = initialRow + rowStep;
        int currentCol = initialCol + colStep;

        while (currentRow != finalRow || currentCol != finalCol) {
            if (board[currentRow][currentCol] != null) {
                return false;
            }
            currentRow += rowStep;
            currentCol += colStep;
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

