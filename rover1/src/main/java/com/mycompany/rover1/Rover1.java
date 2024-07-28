package com.mycompany.rover1;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Rover1 {
    private static final Logger LOGGER = Logger.getLogger(Rover1.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter grid size (width height): ");
        int width = getNextInt(scanner);
        int height = getNextInt(scanner);

        Grid grid = new Grid(width, height);

        System.out.print("Enter number of obstacles: ");
        int numberOfObstacles = getNextInt(scanner);

        for (int i = 0; i < numberOfObstacles; i++) {
            System.out.printf("Enter obstacle %d position (x y): ", i + 1);
            int obstacleX = getNextInt(scanner);
            int obstacleY = getNextInt(scanner);
            grid.addObstacle(obstacleX, obstacleY);
        }

        System.out.print("Enter starting position (x y direction[N/E/S/W]): ");
        int startX = getNextInt(scanner);
        int startY = getNextInt(scanner);
        Direction startDirection = null;

        while (startDirection == null) {
            try {
                char startDirectionChar = scanner.next().toUpperCase().charAt(0); // Convert to uppercase
                startDirection = Direction.fromChar(startDirectionChar);
            } catch (IllegalArgumentException e) {
                LOGGER.log(Level.WARNING, "Invalid direction entered. Please enter one of N, E, S, W: ", e);
                System.out.print("Enter starting direction again (N/E/S/W): ");
            }
        }

        MarsRover rover = new MarsRover(startX, startY, startDirection, grid);

        // Print initial position
         // Print the initial grid with the rover's position

        System.out.print("Enter commands: ");
        String commands = scanner.next().toUpperCase();
        System.out.println("Initial Position:");
        rover.reportStatus();
        grid.addRover(startX, startY);
        grid.printGrid();
        try {
            for (char command : commands.toCharArray()) {
                rover.executeCommand(CommandFactory.getCommand(command));
            }
        } catch (IllegalArgumentException e) {
            LOGGER.log(Level.WARNING, "Invalid command encountered: ", e);
        }

        // Report final position
        System.out.println("Final Position:");
        rover.reportStatus();

        scanner.close();
    }

    private static int getNextInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
