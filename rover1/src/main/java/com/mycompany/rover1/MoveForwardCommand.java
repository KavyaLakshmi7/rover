package com.mycompany.rover1;

public class MoveForwardCommand implements Command {
    @Override
    public void execute(MarsRover rover) {
        int newX = rover.getX();
        int newY = rover.getY();
        switch (rover.getDirection()) {
            case N: newY += 1; break;
            case E: newX += 1; break;
            case S: newY -= 1; break;
            case W: newX -= 1; break;
        }

        if (rover.getGrid().isWithinBounds(newX, newY) && !rover.getGrid().isObstacle(newX, newY)) {
            rover.setX(newX);
            rover.setY(newY);
        } else {
            System.out.println("Move blocked by obstacle or grid boundary.");
        }
    }
}
