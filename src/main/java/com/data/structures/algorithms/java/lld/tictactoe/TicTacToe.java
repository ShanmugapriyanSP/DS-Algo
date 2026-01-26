package com.data.structures.algorithms.java.lld.tictactoe;

import com.data.structures.algorithms.java.lld.tictactoe.context.GameContext;
import com.data.structures.algorithms.java.lld.tictactoe.models.Action;
import com.data.structures.algorithms.java.lld.tictactoe.models.Player;
import com.data.structures.algorithms.java.lld.tictactoe.rules.IRuleEngine;
import com.data.structures.algorithms.java.lld.tictactoe.rules.RuleEngine;

import java.util.*;
import static java.util.AbstractMap.SimpleEntry;

public class TicTacToe {

    Action[][] board;
    Player playerX;
    Player playerO;
    IRuleEngine ruleEngine;
    Scanner scanner;
    Player currentPlayer;
    GameContext context;

    public TicTacToe(Player player1, Player playerO) {
        this.board = new Action[3][3];
        this.context = new GameContext();
        this.ruleEngine = new RuleEngine(this.board, context);
        this.playerX = player1;
        this.playerO = playerO;
        this.currentPlayer = player1;
        this.scanner = new Scanner(System.in);
    }

    public synchronized void start() {
        while(true) {
            Action action = getPosition();
            if (this.ruleEngine.evaluate(action)) {
                this.ruleEngine.execute(action);
                printBoard();
                if (context.isGameOver()) {
                    println(currentPlayer.name() + " is the winner!!");
                    break;
                }
            } else {
               printInvalidOption();
               continue;
            }
            swapCurrentPlayer();
        }
    }

    private Action getPosition() {
        println("Player to Move: " + currentPlayer.name());
        println("Enter the position to play Symbol " + currentPlayer.symbol());
        Map<Integer, SimpleEntry<Integer, Integer>> positions = new HashMap<>();
        StringBuilder openPositions = new StringBuilder();
        int serialNumber = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != null)
                    continue;

                positions.put(++serialNumber, new SimpleEntry<>(i, j));
                openPositions.append(serialNumber).append(") ").append(i + 1).append(", ").append(j + 1).append("\n");
            }
        }
        Action action = null;
        do {
            println(openPositions.toString());
            int option = scanner.nextInt();
            if (positions.containsKey(option)) {
                SimpleEntry<Integer, Integer> position = positions.get(option);
                action = new Action(currentPlayer, currentPlayer.symbol(), position.getKey(), position.getValue());
            } else {
                printInvalidOption();
            }

        } while (action == null);

        return action;
    }

    private void swapCurrentPlayer() {
        currentPlayer = currentPlayer == playerX ? playerO : playerX;
    }

    private void println(String s) {
        System.out.println(s);
    }

    private static void print(String s) {
        System.out.print(s);
    }

    private static void printInvalidOption() {
        System.out.println("Invalid Option Try Again!");
    }

    private void printBoard() {
        println("------------------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                print(board[i][j] != null ? board[i][j].symbol().name() + "\t\t" : " \t\t");
            }
            println("");
        }
        println("------------------------");
    }
}
