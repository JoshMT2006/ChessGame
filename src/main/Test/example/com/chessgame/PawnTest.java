package example.com.chessgame;


import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    void getImage() {
        class HelloApplication extends Application {
            @Override
            public void start(Stage stage) throws IOException {
                Pawn pawn = new Pawn(true);
                Image image = pawn.getImage();
                assertEquals(new Image(getClass().getResourceAsStream("/images/WhitePawn.png")), image);
            }
        }
    }

    @Test
    void validMove() {
        class HelloApplication extends Application {
            @Override
            public void start(Stage stage) throws IOException {
                Pawn pawn = new Pawn(true);
                assertTrue(pawn.validMove(0, 0, 0, 1));

            }
        }
    }

    @Test
    void setRow() {
        class HelloApplication extends Application {
            @Override
            public void start(Stage stage) throws IOException {
                Pawn pawn = new Pawn(true);
                pawn.setRow(0);
                assertEquals(0, pawn.getRow());
            }
        }
    }

    @Test
    void setCol() {
        class HelloApplication extends Application {
            @Override
            public void start(Stage stage) throws IOException {
                Pawn pawn = new Pawn(true);
                pawn.setCol(0);
                assertEquals(0, pawn.getCol());
            }
        }
    }

    @Test
    void getRow() {
        class HelloApplication extends Application {
            @Override
            public void start(Stage stage) throws IOException {
                Pawn pawn = new Pawn(true);
                assertEquals(0, pawn.getRow());
            }
        }
    }

    @Test
    void getCol() {
        class HelloApplication extends Application {
            @Override
            public void start(Stage stage) throws IOException {
                Pawn pawn = new Pawn(true);
                assertEquals(0, pawn.getCol());
            }
        }
    }
}