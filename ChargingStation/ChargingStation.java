package FloorPlan;

import java.util.LinkedList;
import java.util.Queue;

public class FloorPlan {
    private Cell[][] grid; // 2D array representing the floor plan (cells include charging stations and obstacles)
    
    // Directions to move in the grid (right, left, down, up)
    private static final int[][] DIRECTIONS = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public FloorPlan(int rows, int cols) {
        grid = new Cell[rows][cols];
        initializeGrid(rows, cols); // Initialize the grid with default values (you can customize this)
    }

    // Initialize grid with default values (bare floor, no obstacles, no charging station)
    private void initializeGrid(int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell(i, j, "bare_floor", false, false); // Default: no charging station, no obstacle
            }
        }
        // Example: Manually set a charging station at a specific location
        grid[2][3].setChargingStation(true);
    }

    // Function to find the nearest charging station using BFS
    public Cell findNearestChargingStation(int startX, int startY) {
        Queue<Cell> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // Add the starting cell to the queue
        Cell startCell = grid[startX][startY];
        queue.add(startCell);
        visited[startX][startY] = true;

        // Perform BFS to find the nearest charging station
        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            // Check if the current cell has a charging station
            if (current.isChargingStation()) {
                return current; // Return the nearest charging station
            }

            // Explore neighbors (up, down, left, right)
            for (int[] direction : DIRECTIONS) {
                int newX = current.getX() + direction[0];
                int newY = current.getY() + direction[1];

                // Check if the new position is within bounds and not visited, and no obstacle
                if (isValidMove(newX, newY, visited)) {
                    queue.add(grid[newX][newY]);
                    visited[newX][newY] = true;
                }
            }
        }

        return null; // No charging station found
    }

    // Helper function to check if the move is valid
    private boolean isValidMove(int x, int y, boolean[][] visited) {
        // Check if it's within bounds
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }

        // Check if it's an obstacle or already visited
        Cell cell = grid[x][y];
        return !cell.isObstacle() && !visited[x][y];
    }
}
