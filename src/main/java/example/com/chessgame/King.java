package example.com.chessgame;

import javafx.scene.image.Image;

public class King extends pieces {
    public King(boolean isWhite) {
        super(isWhite);
    }
    @Override
    public Image getImage(){
        return null;
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
