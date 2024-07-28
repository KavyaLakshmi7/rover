package com.mycompany.rover1;

public class Grid {
    private int width;
    private int height;
    private char[][] grid; // 2D array to represent the grid
    private Point[] obstacles; // Array to store obstacle points

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new char[height][width]; // Initialize grid
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = '.'; // Default empty space
            }
        }

    }
    public void addRover(int x, int y) {
        if (isWithinBounds(x, y)) {
            grid[y][x] = 'R'; // Add rover to the grid
        }
    }
    public void addObstacle(int x, int y) {
        if (isWithinBounds(x, y)) {
            grid[y][x] = 'o';
        }
    }
    public boolean isObstacle(int x, int y) {
        if (isWithinBounds(x, y)) {
            return grid[y][x] == 'o';
        }
        return false;
    } 
    
    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public void printGrid() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
