/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rover;
public class CommandFactory {
    public static Command getCommand(char command) {
        switch (command) {
            case 'M':
                return new MoveCommand();
            case 'L':
                return new TurnLeftCommand();
            case 'R':
                return new TurnRightCommand();
            default:
                throw new IllegalArgumentException("Invalid command");
        }
    }
}
