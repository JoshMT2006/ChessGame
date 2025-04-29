package example.com.chessgame;

public class Bishop extends pieces {
    public Bishop(boolean isWhite) {
        super(isWhite);
    }
    @Override
    public boolean validMove(int initalX, int initalY, int finalX, int finalY) {
        return Math.abs(initalX-finalX) == Math.abs(initalY-finalY);
    }
    @Override
    public String toString() {
        return isWhite ? "B" : "b";
    }
}
