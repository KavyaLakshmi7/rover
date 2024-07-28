/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pattern;

// Grid.java
public class Grid {
    private static Grid instance;
    private int width;
    private int height;

    private Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static Grid getInstance(int width, int height) {
        if (instance == null) {
            instance = new Grid(width, height);
        }
        return instance;
    }

    public void display() {
        System.out.println("Grid size: " + width + "x" + height);
    }
}

// Test.java
public class Test {
    public static void main(String[] args) {
        Grid grid = Grid.getInstance(10, 10);
        grid.display();
        
        Grid anotherGrid = Grid.getInstance(20, 20);
        anotherGrid.display(); // Should display the same instance's size
    }
}
