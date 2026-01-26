package com.data.structures.algorithms.java.lld.tictactoe.context;

import com.data.structures.algorithms.java.lld.tictactoe.models.Player;
import com.data.structures.algorithms.java.lld.tictactoe.state.GameState;
import com.data.structures.algorithms.java.lld.tictactoe.state.XTurnState;

public class GameContext {

    GameState currentState;

    public GameContext() {
        this.currentState = XTurnState.getInstance();
    }

    public void setState(GameState gameState) {
        this.currentState = gameState;
    }

    public void next(Player player,boolean hasWon) {
        currentState.next(this, player, hasWon);
    }

    public boolean isGameOver() {
        return currentState.isGameOver();
    }

    public GameState getCurrentState() {
        return currentState;
    }
}
