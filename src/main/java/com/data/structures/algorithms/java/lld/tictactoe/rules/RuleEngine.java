package com.data.structures.algorithms.java.lld.tictactoe.rules;

import com.data.structures.algorithms.java.lld.tictactoe.context.GameContext;
import com.data.structures.algorithms.java.lld.tictactoe.enums.Symbol;
import com.data.structures.algorithms.java.lld.tictactoe.models.Action;
import com.data.structures.algorithms.java.lld.tictactoe.models.Player;

public class RuleEngine implements IRuleEngine {

    Action[][] board;
    GameContext context;

    public RuleEngine(Action[][] board, GameContext context) {
        this.board = board;
        this.context = context;
    }

    @Override
    public boolean evaluate(Action action) {
        return evaluateBoundary(action.x()) && evaluateBoundary(action.y()) &&
                board[action.x()][action.y()] == null;
    }

    @Override
    public void execute(Action action) {
        this.board[action.x()][action.y()] = action;
        context.next(action.player(), isGameEnded(action.symbol()));
    }

    private boolean evaluateBoundary(int position) {
        return position >= 0 && position < 3;
    }

    @Override
    public boolean isGameEnded(Symbol symbol) {
        if (checkDiagonalRow(symbol))
            return true;
        for (int i = 0; i < 3; i++) {
            if (checkHorizontalRow(symbol, i) || checkVerticalRow(symbol, i))
                return true;
        }
        return false;
    }

    private boolean checkHorizontalRow(Symbol symbol, int x) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[x][j] == null || board[x][j].symbol() != symbol)
                return false;
        }
        return true;
    }

    private boolean checkVerticalRow(Symbol symbol, int y) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == null || board[i][y].symbol() != symbol)
                return false;
        }
        return true;
    }

    private boolean checkDiagonalRow(Symbol symbol) {
        return forwardDiagonalRow(symbol) || reverseDiagonalRow(symbol);
    }

    private boolean forwardDiagonalRow(Symbol symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][i] == null || board[i][i].symbol() != symbol)
                return false;
        }
        return true;
    }

    private boolean reverseDiagonalRow(Symbol symbol) {
        for (int i = 0, j = 2; i < 3 && j >= 0; i++, j--) {
            if (board[i][j] == null || board[i][j].symbol() != symbol)
                return false;
        }
        return true;
    }
}
