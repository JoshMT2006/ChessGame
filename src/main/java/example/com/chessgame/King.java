package example.com.chessgame;

import javafx.scene.image.Image;

public class King extends Piece {
    private int row;
    private int col;
    public King(boolean isWhite) {
        super(isWhite);
    }
    @Override
    public Image getImage(){
        if (isWhite) {
            return new Image(getClass().getResourceAsStream("/images/WhiteKing.png"));
        } else {
            return new Image(getClass().getResourceAsStream("/images/BlackKing.png"));
        }
    }
    @Override
    public boolean validMove(int initalX, int initalY, int finalX, int finalY) {
        return Math.abs(initalX-finalX) <= 1 && Math.abs(initalY-finalY) <= 1;
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
