package example.com.chessgame;

public class Knight extends pieces {
    public Knight (boolean isWhite) {
        super(isWhite);
    }
    @Override
    public boolean validMove(int initalX, int initalY, int finalX, int finalY) {
        return Math.abs(initalX-finalX) == 2 && Math.abs(initalY-finalY) == 1 ||
                Math.abs(initalX-finalX) == 1 && Math.abs(initalY-finalY) == 2;
    }
    @Override
    public String toString() {
        return isWhite ? "N" : "n";
    }
}
