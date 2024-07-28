/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rover;

public class TurnLeftCommand implements Command {
    @Override
    public void execute(MarsRover rover) {
        System.out.println("Command: Turn Left");
        rover.turnLeft();
        rover.reportStatus();
    }
}
