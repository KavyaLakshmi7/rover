package com.mycompany.rover1;

public class CommandFactory {
    public static Command getCommand(char commandChar) {
        switch (commandChar) {
            case 'L': return new TurnLeftCommand();
            case 'R': return new TurnRightCommand();
            case 'M': return new MoveForwardCommand();
            default: throw new IllegalArgumentException("Invalid command: " + commandChar);
        }
    }
}
