/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rover;
public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public static Direction fromChar(char direction) {
        switch (Character.toUpperCase(direction)) {
            case 'N':
                return NORTH;
            case 'E':
                return EAST;
            case 'S':
                return SOUTH;
            case 'W':
                return WEST;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }

    public Direction left() {
        return values()[(ordinal() + 3) % 4];
    }

    public Direction right() {
        return values()[(ordinal() + 1) % 4];
    }

    public int getDeltaX() {
        switch (this) {
            case EAST: return 1;
            case WEST: return -1;
            default: return 0;
        }
    }

    public int getDeltaY() {
        switch (this) {
            case NORTH: return 1;
            case SOUTH: return -1;
            default: return 0;
        }
    }
}
