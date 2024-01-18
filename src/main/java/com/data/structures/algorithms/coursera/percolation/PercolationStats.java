//package com.data.structures.algorithms.coursera.percolation;
//import edu.princeton.cs.algs4.StdRandom;
//import edu.princeton.cs.algs4.StdStats;
//
//public class PercolationStats {
//
//    int n;
//    int trials;
//
//    // perform independent trials on an n-by-n grid
//    public PercolationStats(int n, int trials) {
//
//        if (n <=0 || trials <= 0)
//            throw new IllegalArgumentException("Provide correct n and trials value");
//
//        this.n = n;
//        this.trials = trials;
//    }
//
//    // sample mean of percolation threshold
//    public double mean() {
//        return 0.0;
//    }
//
//    // sample standard deviation of percolation threshold
//    public double stddev() {
//        return 0.0;
//    }
//
//    // low endpoint of 95% confidence interval
//    public double confidenceLo() {
//        return 0.0;
//    }
//
//    // high endpoint of 95% confidence interval
//    public double confidenceHi() {
//        return 0.0;
//    }
//
//    // test client (see below)
//    public static void main(String[] args) {
//        int n = Integer.parseInt(args[0]);
//        int trials = Integer.parseInt(args[1]);
//        Percolation percolation = new Percolation(n);
//        for (int i = 0; i < n*n; i++) {
//            int row = StdRandom.uniformInt(n);
//            int column = StdRandom.uniformInt(n);
//            percolation.open(row, column);
//            if (percolation.percolates()) {
//
//            }
//        }
//    }
//
//}