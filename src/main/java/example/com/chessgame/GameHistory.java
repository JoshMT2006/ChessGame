package example.com.chessgame;

import java.util.ArrayList;

public class GameHistory {

    ArrayList<Integer> moves;
    private int moveCount;

    public GameHistory() {
        moveCount = 0;
    }
    public void incrementMoveCount() {
        moveCount++;
    }
    public int getMoveCount() {
        return moveCount;
    }




}
