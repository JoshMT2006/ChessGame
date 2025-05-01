package example.com.chessgame;

import javafx.scene.image.Image;

public class Queen extends Piece {
    private int row;
    private int col;
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
    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getCol() {
        return col;
    }

}
