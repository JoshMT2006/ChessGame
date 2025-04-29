package example.com.chessgame;

public class King extends pieces {
    public King(boolean isWhite) {
        super(isWhite);
    }
    @Override
    public boolean validMove(int initalX, int initalY, int finalX, int finalY) {
        return Math.abs(initalX-finalX) <= 1 && Math.abs(initalY-finalY) <= 1;
    }
    @Override
    public String toString() {
        return isWhite ? "K" : "k";
    }
}
