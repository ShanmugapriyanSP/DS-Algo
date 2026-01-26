package com.data.structures.algorithms.java.lld.tictactoe.state;

import com.data.structures.algorithms.java.lld.tictactoe.models.Player;
import com.data.structures.algorithms.java.lld.tictactoe.enums.Symbol;
import com.data.structures.algorithms.java.lld.tictactoe.context.GameContext;

public class OTurnState implements GameState {

    private static GameState instance = null;

    private OTurnState() {}

    public static synchronized GameState getInstance() {
        if (instance == null)
            instance = new OTurnState();
        return instance;
    }

    @Override
    public void next(GameContext context, Player player, boolean hasWon) {
        if (hasWon) {
            context.setState(player.symbol() == Symbol.X ? XWinState.getInstance() : OWinState.getInstance());
        } else {
            context.setState(XTurnState.getInstance());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
