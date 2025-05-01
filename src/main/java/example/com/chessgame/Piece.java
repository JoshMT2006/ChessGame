package example.com.chessgame;

import javafx.scene.image.Image;

public abstract class Piece {
    protected boolean isWhite;
    protected int row;
    protected int col;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    public abstract Image getImage();

    public abstract boolean validMove(int initialRow, int initialCol, int finalRow, int finalCol);
}
