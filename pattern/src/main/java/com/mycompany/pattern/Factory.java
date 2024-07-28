/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pattern;

// CommandFactory.java
public abstract class CommandFactory {
    public abstract Command createCommand();
}

// MoveForwardCommandFactory.java
public class MoveForwardCommandFactory extends CommandFactory {
    private Rover rover;

    public MoveForwardCommandFactory(Rover rover) {
        this.rover = rover;
    }

    @Override
    public Command createCommand() {
        return new MoveForwardCommand(rover);
    }
}

// Test.java
public class Test {
    public static void main(String[] args) {
        Rover rover = new Rover(0, 0, "N");

        CommandFactory factory = new MoveForwardCommandFactory(rover);
        Command moveForward = factory.createCommand();
        rover.executeCommand(moveForward);
    }
}
