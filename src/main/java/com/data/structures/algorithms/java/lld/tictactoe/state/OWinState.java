package com.data.structures.algorithms.java.lld.tictactoe.state;

import com.data.structures.algorithms.java.lld.tictactoe.models.Player;
import com.data.structures.algorithms.java.lld.tictactoe.context.GameContext;

public class OWinState implements GameState {

    private static GameState instance = null;

    private OWinState() {}

    public static synchronized GameState getInstance() {
        if (instance == null)
            instance = new OWinState();
        return instance;
    }

    @Override
    public void next(GameContext context, Player player, boolean hasWon) {
        throw new RuntimeException("Illegal state... Game is already over");
    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
