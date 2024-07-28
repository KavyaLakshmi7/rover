package com.mycompany.rover1;

public class TurnRightCommand implements Command {
    @Override
    public void execute(MarsRover rover) {
        Direction newDirection;
        switch (rover.getDirection()) {
            case N: newDirection = Direction.E; break;
            case E: newDirection = Direction.S; break;
            case S: newDirection = Direction.W; break;
            case W: newDirection = Direction.N; break;
            default: throw new IllegalStateException("Unexpected value: " + rover.getDirection());
        }
        rover.setDirection(newDirection);
    }
}
