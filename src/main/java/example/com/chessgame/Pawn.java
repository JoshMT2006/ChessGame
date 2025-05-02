package example.com.chessgame;
import javafx.scene.image.Image;

public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public Image getImage() {
        if (isWhite) {
            return new Image(getClass().getResourceAsStream("/images/WhitePawn.png"));
        } else {
            return new Image(getClass().getResourceAsStream("/images/BlackPawn.png"));
        }
    }

    @Override
    public boolean validMove(int initialRow, int initialCol, int finalRow, int finalCol) {
        int direction = isWhite ? -1 : 1;

        //bounds check
        if (finalRow < 0 || finalRow >= 8 || finalCol < 0 || finalCol >= 8) {
            return false;
        }
        if (initialRow == finalRow && initialCol == finalCol) {
            return false;
        }

        Object[][] board = PiecePositions.piecesPositions;
        Object destination = board[finalRow][finalCol];

        ChessPieces targetPiece = (ChessPieces) PiecePositions.piecesPositions[finalRow][finalCol];

        // Move forward one square
        if (finalCol == initialCol && finalRow == initialRow + direction && destination == null) {
            return true;
        }

        if (Math.abs(finalCol - initialCol) == 1 && finalRow == initialRow + direction && destination instanceof ChessPieces) {
            ChessPieces target = (ChessPieces) destination;
            boolean result = target.isWhite() != this.isWhite;
            return result;
        }

        // First move - two squares forward
        if ((isWhite && initialRow == 6) || (!isWhite && initialRow == 1)) {
            if (finalCol == initialCol && finalRow == initialRow + (2 * direction) && destination == null) {
                int middleRow = initialRow + direction;
                return board[middleRow][initialCol] == null;
            }
        }
        return false;
    }
}

