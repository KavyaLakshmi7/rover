package com.mycompany.rover1;

public class TurnLeftCommand implements Command {
    @Override
    public void execute(MarsRover rover) {
        Direction newDirection;
        switch (rover.getDirection()) {
            case N: newDirection = Direction.W; break;
            case E: newDirection = Direction.N; break;
            case S: newDirection = Direction.E; break;
            case W: newDirection = Direction.S; break;
            default: throw new IllegalStateException("Unexpected value: " + rover.getDirection());
        }
        rover.setDirection(newDirection);
    }
}
