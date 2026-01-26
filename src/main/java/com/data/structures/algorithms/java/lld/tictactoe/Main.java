package com.data.structures.algorithms.java.lld.tictactoe;

import com.data.structures.algorithms.java.lld.tictactoe.enums.Symbol;
import com.data.structures.algorithms.java.lld.tictactoe.models.Player;

public class Main {

    public static void main(String[] args) {
        new TicTacToe(new Player("Shan", Symbol.X), new Player("Mani", Symbol.O)).start();
    }
}
