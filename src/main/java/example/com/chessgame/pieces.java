package example.com.chessgame;

import javafx.scene.image.Image;

public abstract class pieces {
    protected boolean isWhite;

    public pieces(boolean isWhite) {
        this.isWhite = isWhite;
    }
    public boolean isWhite() {
        return isWhite;
    }

    public abstract Image getImage();

    public abstract boolean validMove(int initalX , int initalY, int finalX , int finalY);

}
