package ObstacleDetection;

public class ObstacleDetection {

    // Method to detect obstacles in the four cardinal directions (up, down, left, right)
    public String[] detectObstacles(String[][] floorPlan, int x, int y) {
        // Get the dimensions of the floor plan
        int rows = floorPlan.length;
        int cols = floorPlan[0].length;

        // Array to store obstacle detection results for each direction
        String[] obstacles = new String[4]; // up, down, left, right

        // Check for obstacles in the "up" direction (x - 1, y)
        if (x > 0) {
            if (floorPlan[x - 1][y].equals("X") || floorPlan[x - 1][y].equals("S")) {
                obstacles[0] = "Obstacle detected";
            } else {
                obstacles[0] = "Path clear";
            }
        } else {
            obstacles[0] = "Out of bounds";
        }

        // Check for obstacles in the "down" direction (x + 1, y)
        if (x < rows - 1) {
            if (floorPlan[x + 1][y].equals("X") || floorPlan[x + 1][y].equals("S")) {
                obstacles[1] = "Obstacle detected";
            } else {
                obstacles[1] = "Path clear";
            }
        } else {
            obstacles[1] = "Out of bounds";
        }

        // Check for obstacles in the "left" direction (x, y - 1)
        if (y > 0) {
            if (floorPlan[x][y - 1].equals("X") || floorPlan[x][y - 1].equals("S")) {
                obstacles[2] = "Obstacle detected";
            } else {
                obstacles[2] = "Path clear";
            }
        } else {
            obstacles[2] = "Out of bounds";
        }

        // Check for obstacles in the "right" direction (x, y + 1)
        if (y < cols - 1) {
            if (floorPlan[x][y + 1].equals("X") || floorPlan[x][y + 1].equals("S")) {
                obstacles[3] = "Obstacle detected";
            } else {
                obstacles[3] = "Path clear";
            }
        } else {
            obstacles[3] = "Out of bounds";
        }

        return obstacles;
    }

    
}
