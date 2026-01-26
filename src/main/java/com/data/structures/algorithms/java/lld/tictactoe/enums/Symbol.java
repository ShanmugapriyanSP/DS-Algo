package com.data.structures.algorithms.java.lld.tictactoe.enums;

import java.util.Optional;

public enum Symbol {
    X("X", 1),
    O("O", 2);

    private final String move;
    private final int option;

    Symbol(String move, int option) {
        this.move = move;
        this.option = option;
    }

    public static Optional<Symbol> get(int option) {
        for (Symbol symbol : Symbol.values()) {
            if (symbol.option == option)
                return Optional.of(symbol);
        }
        return Optional.empty();
    }
}
