package example.com.chessgame;

import javafx.scene.image.Image;

public class Queen extends Piece {
    private int row;
    private int col;
    public Queen (boolean isWhite) {
        super(isWhite);
    }
    @Override
    public Image getImage(){
        if (isWhite) {
            return new Image(getClass().getResourceAsStream("/images/WhiteQueen.png"));
        } else {
            return new Image(getClass().getResourceAsStream("/images/BlackQueen.png"));
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

        int rowStep = Integer.compare(finalRow, initialRow);
        int colStep = Integer.compare(finalCol, initialCol);

        if (rowDiff == colDiff || initialRow == finalRow || initialCol == finalCol) {
            int row = initialRow + rowStep;
            int col = initialCol + colStep;

            // Check path (excluding destination)
            while (row != finalRow || col != finalCol) {
                if (board[row][col] != null) {
                    return false; // Blocked path
                }
                row += rowStep;
                col += colStep;
            }

            // Final square: either empty or enemy
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
