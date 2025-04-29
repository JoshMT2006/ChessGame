package example.com.chessgame;
import javafx.scene.image.Image;

public class Pawn extends pieces {

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public Image getImage() {
        if (isWhite) {
            return new Image(getClass().getResourceAsStream("/images/WhitePawn.png"));
        } else {
            return new Image(getClass().getResourceAsStream("/images/BlackPawn.png"));
        }
    }

    @Override
    public boolean validMove(int initialX, int initialY, int finalX, int finalY) {
        int direction = isWhite ? 1 : -1;

        return (finalX == initialX) && (finalY == initialY + direction);
    }
}
