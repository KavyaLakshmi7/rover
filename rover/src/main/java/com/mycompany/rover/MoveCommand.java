/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rover;



public class MoveCommand implements Command {
    @Override
    public void execute(MarsRover rover) {
        System.out.println("Command: Move");
        if (rover.move()) {
            System.out.println("Obstacle not detected. Moving to new position.");
        } else {
            System.out.println("Obstacle detected or out of bounds. Move aborted.");
        }
        rover.reportStatus();
    }
}
