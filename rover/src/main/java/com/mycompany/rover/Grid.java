/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rover;

import java.util.HashSet;
import java.util.Set;

public class Grid {
    private int width;
    private int height;
    private boolean[][] obstacles;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.obstacles = new boolean[width][height];
    }

    public void addObstacle(int x, int y) {
        if (isWithinBounds(x, y)) {
            obstacles[x][y] = true;
        }
    }

    public boolean isObstacle(int x, int y) {
        if (isWithinBounds(x, y)) {
            return obstacles[x][y];
        }
        return false;
    }

    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
