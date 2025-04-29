package example.com.chessgame;

import javafx.scene.image.Image;

public class Queen extends pieces {
    public Queen (boolean isWhite) {
        super(isWhite);
    }
    @Override
    public Image getImage(){
        return null;
    }
    @Override
    public boolean validMove(int initalX, int initalY, int finalX, int finalY) {
        return Math.abs(initalX-finalX) == Math.abs(initalY-finalY) ||
                initalX == finalX || initalY == finalY;
    }

}
