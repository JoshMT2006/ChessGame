package example.com.chessgame;

import javafx.scene.image.Image;

public class Rook extends pieces {
    private int row;
    private int col;
    public Rook(boolean isWhite) {
        super(isWhite);
    }
    @Override
    public Image getImage(){
        if (isWhite) {
            return new Image(getClass().getResourceAsStream("/images/WhiteRook.png"));
        } else {
            return new Image(getClass().getResourceAsStream("/images/BlackRook.png"));
        }
    }
    @Override
    public boolean validMove(int initalX, int initalY, int finalX, int finalY) {
        return Math.abs(initalX-finalX) == Math.abs(initalY-finalY);
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
