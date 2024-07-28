/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rover;

public class TurnRightCommand implements Command {
    @Override
    public void execute(MarsRover rover) {
        System.out.println("Command: Turn Right");
        rover.turnRight();
        rover.reportStatus();
    }
}
