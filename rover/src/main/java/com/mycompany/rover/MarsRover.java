/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rover;
public class MarsRover {
    private int x;
    private int y;
    private Direction direction;
    private Grid grid;

    public MarsRover(int x, int y, Direction direction, Grid grid) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.grid = grid;
    }

    public boolean move() {
        int newX = x + direction.getDeltaX();
        int newY = y + direction.getDeltaY();

        if (grid.isWithinBounds(newX, newY) && !grid.isObstacle(newX, newY)) {
            x = newX;
            y = newY;
            return true;
        } else {
            return false;
        }
    }

    public void turnLeft() {
        direction = direction.left();
    }

    public void turnRight() {
        direction = direction.right();
    }

    public void executeCommand(Command command) {
        command.execute(this);
    }

    public void reportStatus() {
        System.out.printf("Rover is at (%d, %d) facing %s%n", x, y, direction);
        printGrid();
    }
    private void printGrid() {
        for (int i = grid.getHeight() - 1; i >= 0; i--) {
            for (int j = 0; j < grid.getWidth(); j++) {
                if (i == y && j == x) {
                    System.out.print("R ");
                } else if (grid.isObstacle(j, i)) {
                    System.out.print("O ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
