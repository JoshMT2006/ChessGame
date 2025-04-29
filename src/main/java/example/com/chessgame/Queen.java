package example.com.chessgame;

public class Queen extends pieces {
    public Queen (boolean isWhite) {
        super(isWhite);
    }
    @Override
    public boolean validMove(int initalX, int initalY, int finalX, int finalY) {
        return Math.abs(initalX-finalX) == Math.abs(initalY-finalY) ||
                initalX == finalX || initalY == finalY;
    }
    @Override
    public String toString() {
        return isWhite ? "Q" : "q";
    }
}
