/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rover;


import java.util.Scanner;

public class Rover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter grid size (width height): ");
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        Grid grid = new Grid(width, height);

        System.out.print("Enter number of obstacles: ");
        int numberOfObstacles = scanner.nextInt();

        for (int i = 0; i < numberOfObstacles; i++) {
            System.out.printf("Enter obstacle %d position (x y): ", i + 1);
            int obstacleX = scanner.nextInt();
            int obstacleY = scanner.nextInt();
            grid.addObstacle(obstacleX, obstacleY);
        }

        System.out.print("Enter starting position (x y direction[N/E/S/W]): ");
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        char startDirectionChar = scanner.next().charAt(0);
        Direction startDirection = Direction.fromChar(startDirectionChar);
        

        MarsRover rover = new MarsRover(startX, startY, startDirection, grid);
       
        
        System.out.print("Enter commands: ");
        String commands = scanner.next().toUpperCase();
        System.out.println("Initial Position:");
        rover.reportStatus();
        for (char command : commands.toCharArray()) {
            rover.executeCommand(CommandFactory.getCommand(command));
        }
        
        // Report final position
        System.out.println("Final Position:");
        rover.reportStatus();

        scanner.close();
    }
}
