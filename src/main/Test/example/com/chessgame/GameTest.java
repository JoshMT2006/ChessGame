package example.com.chessgame;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void getColFromX() {
        Pane root = new Pane();
        Game game = new Game(root);
        assertEquals(0, game.getColFromX(0));

    }

    @Test
    void getRowFromY() {
        Pane root = new Pane();
        Game game = new Game(root);
        assertEquals(0, game.getRowFromY(0));
    }

    @Test
    void getXFromCol() {
        Pane root = new Pane();
        Game game = new Game(root);
        //15 unit off set
        assertEquals(15, game.getXFromCol(0));
    }

    @Test
    void getYFromRow() {
        Pane root = new Pane();
        Game game = new Game(root);
        assertEquals(15, game.getYFromRow(0));

    }

    @Test
    //problems with internal Graphics
    void isValidMove() {
        class HelloApplication extends Application {
            @Override
            public void start(Stage stage) throws IOException {
                Pane root = new Pane();
                Game game = new Game(root);


            }
        }
    }
}