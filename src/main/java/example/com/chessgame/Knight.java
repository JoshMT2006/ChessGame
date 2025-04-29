package example.com.chessgame;

import javafx.scene.image.Image;

public class Knight extends pieces {
    public Knight (boolean isWhite) {
        super(isWhite);
    }
    @Override
    public Image getImage(){
        return null;
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
