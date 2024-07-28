package com.mycompany.rover1;

public enum Direction {
    N, E, S, W;

    public static Direction fromChar(char directionChar) {
        switch (directionChar) {
            case 'N': return N;
            case 'E': return E;
            case 'S': return S;
            case 'W': return W;
            default: throw new IllegalArgumentException("Invalid direction: " + directionChar);
        }
    }
}
