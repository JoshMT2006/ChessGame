package example.com.chessgame;


public class PiecePositions {
    public static Object[][] piecesPositions = new Object[8][8];

    public Object getPiece(int row, int col) {
        return piecesPositions[row][col];
    }

    public Object[][] getPiecesPositions() {
        return piecesPositions;
    }

    public static void setPiece(int row, int col, Object piece) {
        // Check bounds
        if (row < 0 || row >= 8 || col < 0 || col >= 8) {
            return;
        }
        piecesPositions[row][col] = piece;
    }

    public static void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        if (piecesPositions[fromRow][fromCol] == null) {
            return;
        }

        piecesPositions[toRow][toCol] = piecesPositions[fromRow][fromCol];
        piecesPositions[fromRow][fromCol] = null;
    }
}
