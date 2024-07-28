package com.mycompany.rover1;

public class MarsRover {
    private int x;
    private int y;
    private Direction direction;
    private Grid grid;

    public MarsRover(int x, int y, Direction direction, Grid grid) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.grid = grid;
    }

    public void executeCommand(Command command) {
        command.execute(this);
        logMove(command);
    }

    public void reportStatus() {
        System.out.printf("Position: (%d, %d) Direction: %s%n", x, y, direction);
    }

    private void logMove(Command command) {
        String commandName = command.getClass().getSimpleName().replace("Command", "");
        boolean obstacleDetected = grid.isObstacle(x, y);
        String obstacleMessage = obstacleDetected ? "Obstacle detected!" : "No obstacle detected.";
        System.out.printf("Executed Command: %s -> New Position: (%d, %d) Direction: %s - %s%n", commandName, x, y, direction, obstacleMessage);
        grid.addRover(x,y);
        grid.printGrid(); // Print the grid with the rover's position
    }

    // getters and setters for x, y, direction

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Grid getGrid() {
        return grid;
    }
}
