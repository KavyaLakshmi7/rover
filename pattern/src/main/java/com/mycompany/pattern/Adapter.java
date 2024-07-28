/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pattern;
// OldObstacleDetectionSystem.java
public class OldObstacleDetectionSystem {
    public boolean detectObstacle(int x, int y) {
        // Old detection logic
        return false; // Placeholder
    }
}

// ObstacleDetectionAdapter.java
public class ObstacleDetectionAdapter implements ObstacleDetection {
    private OldObstacleDetectionSystem oldSystem;

    public ObstacleDetectionAdapter(OldObstacleDetectionSystem oldSystem) {
        this.oldSystem = oldSystem;
    }

    @Override
    public boolean isObstacle(int x, int y) {
        return oldSystem.detectObstacle(x, y);
    }
}

// ObstacleDetection.java
public interface ObstacleDetection {
    boolean isObstacle(int x, int y);
}

// Rover.java (updated)
public class Rover {
    private ObstacleDetection obstacleDetection;

    public Rover(ObstacleDetection obstacleDetection) {
        this.obstacleDetection = obstacleDetection;
    }

    public void moveForward(int x, int y) {
        if (!obstacleDetection.isObstacle(x, y)) {
            // Move forward logic
        }
    }
}

// Test.java
public class Test {
    public static void main(String[] args) {
        OldObstacleDetectionSystem oldSystem = new OldObstacleDetectionSystem();
        ObstacleDetection adapter = new ObstacleDetectionAdapter(oldSystem);

        Rover rover = new Rover(adapter);
        rover.moveForward(2, 2);
    }
}
