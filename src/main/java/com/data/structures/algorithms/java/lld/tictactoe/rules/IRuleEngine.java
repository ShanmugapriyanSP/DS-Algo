package com.data.structures.algorithms.java.lld.tictactoe.rules;

import com.data.structures.algorithms.java.lld.tictactoe.enums.Symbol;
import com.data.structures.algorithms.java.lld.tictactoe.models.Action;

public interface IRuleEngine {

    boolean evaluate(Action action);

    void execute(Action action);

    boolean isGameEnded(Symbol symbol);
}
