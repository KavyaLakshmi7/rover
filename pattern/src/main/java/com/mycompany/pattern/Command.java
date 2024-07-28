/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pattern;

// Command.java
public interface Command {
    void execute();
}

// MoveForwardCommand.java
public class MoveForwardCommand implements Command {
    private Rover rover;

    public MoveForwardCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.moveForward();
    }
}

// TurnLeftCommand.java
public class TurnLeftCommand implements Command {
    private Rover rover;

    public TurnLeftCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.turnLeft();
    }
}

// TurnRightCommand.java
public class TurnRightCommand implements Command {
    private Rover rover;

    public TurnRightCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.turnRight();
    }
}

// Rover.java
public class Rover {
    private int x, y;
    private String direction;

    public Rover(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void moveForward() {
        // Logic for moving forward
    }

    public void turnLeft() {
        // Logic for turning left
    }

    public void turnRight() {
        // Logic for turning right
    }

    public void executeCommand(Command command) {
        command.execute();
    }
}

// Test.java
public class Test {
    public static void main(String[] args) {
        Rover rover = new Rover(0, 0, "N");

        Command moveForward = new MoveForwardCommand(rover);
        Command turnLeft = new TurnLeftCommand(rover);
        Command turnRight = new TurnRightCommand(rover);

        rover.executeCommand(moveForward);
        rover.executeCommand(turnRight);
        rover.executeCommand(moveForward);
    }
}
