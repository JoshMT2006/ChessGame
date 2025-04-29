package example.com.chessgame;

import javafx.scene.image.Image;

public class Rook extends pieces {
    public Rook(boolean isWhite) {
        super(isWhite);
    }
    @Override
    public Image getImage(){
        return null;
    }
    @Override
    public boolean validMove(int initalX, int initalY, int finalX, int finalY) {
        return Math.abs(initalX-finalX) == Math.abs(initalY-finalY);
    }
    @Override
    public String toString() {
        return isWhite ? "R" : "r";
    }
}
