package example.com.chessgame;

import javafx.scene.image.Image;

public class Knight extends pieces {

    private int row;
    private int col;
    public Knight (boolean isWhite) {
        super(isWhite);
    }
    @Override
    public Image getImage(){
        if (isWhite) {
            return new Image(getClass().getResourceAsStream("/images/WhiteKnight.png"));
        } else {
            return new Image(getClass().getResourceAsStream("/images/BlackKnight.png"));
        }
    }
    @Override
    public boolean validMove(int initalX, int initalY, int finalX, int finalY) {
        return Math.abs(initalX-finalX) == 2 && Math.abs(initalY-finalY) == 1 ||
                Math.abs(initalX-finalX) == 1 && Math.abs(initalY-finalY) == 2;
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
