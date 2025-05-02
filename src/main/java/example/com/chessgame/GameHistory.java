package example.com.chessgame;

import java.util.ArrayList;

public class GameHistory {

    ArrayList<Integer> moves;
    private int moveCount;

    public void incrementMoveCount() {
        moveCount+=1;
    }
    public int getMoveCount() {
        return moveCount;
    }




}
