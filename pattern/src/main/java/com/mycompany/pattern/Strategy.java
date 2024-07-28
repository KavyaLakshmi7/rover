/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pattern;

// MovementStrategy.java
public interface MovementStrategy {
    void move(Rover rover);
}

// StraightMovementStrategy.java
public class StraightMovementStrategy implements MovementStrategy {
    @Override
    public void move(Rover rover) {
        // Implement straight movement
    }
}

// AvoidObstacleMovementStrategy.java
public class AvoidObstacleMovementStrategy implements MovementStrategy {
    @Override
    public void move(Rover rover) {
        // Implement obstacle avoidance
    }
}

// Rover.java
public class Rover {
    private MovementStrategy strategy;

    public Rover(MovementStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(MovementStrategy strategy) {
        this.strategy = strategy;
    }

    public void move() {
        strategy.move(this);
    }
}

// Test.java
public class Test {
    public static void main(String[] args) {
        Rover rover = new Rover(new StraightMovementStrategy());
        rover.move();

        rover.setStrategy(new AvoidObstacleMovementStrategy());
        rover.move();
    }
}
