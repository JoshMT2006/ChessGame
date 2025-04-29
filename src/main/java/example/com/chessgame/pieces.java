package example.com.chessgame;

public abstract class pieces {
    protected boolean isWhite;

    public pieces(boolean isWhite) {
        this.isWhite = isWhite;
    }
    public boolean isWhite() {
        return isWhite;
    }

    public abstract boolean validMove(int initalX , int initalY, int finalX , int finalY);

    public abstract String toString();

}
