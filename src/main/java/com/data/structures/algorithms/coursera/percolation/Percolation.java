package com.data.structures.algorithms.coursera.percolation;

public class Percolation {

    int[][] sites;
    int n;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Number of grids cannot be less than or equal to zero.");
        this.n = n;
        this.sites = new int[n][n];
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        sites[row][col] = 1;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return sites[row][col] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return true;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        int openSites = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (this.isOpen(i, j))
                    openSites += 1;
            }
        }
        return openSites;
    }

    // does the system percolate?
    public boolean percolates(){
        boolean result = true;
        for (int i = 0; i < n; i++) {
            if (!result)
                break;
            for (int j = i; j < n; j++) {
                if (this.isOpen(i, j)) {
                    result = true;
                    break;
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}
