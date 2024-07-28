/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pattern;

// Component.java
public interface Component {
    void print();
}

// Grid.java
public class Grid implements Component {
    private List<Component> components = new ArrayList<>();

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public void print() {
        System.out.println("Grid:");
        for (Component component : components) {
            component.print();
        }
    }
}

// Obstacle.java
public class Obstacle implements Component {
    private int x, y;

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void print() {
        System.out.println("Obstacle at (" + x + ", " + y + ")");
    }
}

// Test.java
public class Test {
    public static void main(String[] args) {
        Grid grid = new Grid();
        Component obstacle1 = new Obstacle(2, 2);
        Component obstacle2 = new Obstacle(3, 5);

        grid.add(obstacle1);
        grid.add(obstacle2);
        grid.print();
    }
}
