package example.com.chessgame;

public class Pawn extends pieces {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }
    @Override
    public boolean validMove(int initalX, int initalY, int finalX, int finalY) {
        int direction = isWhite ? 1 : -1;
        if (initalX == finalX+1){
            return initalY+ direction == finalY;
        }
        return false;
    }
    @Override
    public String toString() {
        return isWhite ? "P" : "p";
    }

}
