package com.data.structures.algorithms.java.lld.tictactoe.state;

import com.data.structures.algorithms.java.lld.tictactoe.models.Player;
import com.data.structures.algorithms.java.lld.tictactoe.context.GameContext;

public interface GameState {

    void next(GameContext context, Player player, boolean hasWon);

    boolean isGameOver();
}
