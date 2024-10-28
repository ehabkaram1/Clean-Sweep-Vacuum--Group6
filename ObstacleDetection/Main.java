package ObstacleDetection;

public class Main {

    // Main method to test the ObstacleDetection class
    public static void main(String[] args) {
        // Create an instance of the ObstacleDetection class
        ObstacleDetection detector = new ObstacleDetection();

        // Example floor plan (5x5 grid)
        String[][] floorPlan = {
            {"O", "O", "X", "O", "O"},
            {"O", "X", "O", "O", "S"},
            {"C", "O", "O", "X", "O"},
            {"O", "O", "O", "O", "O"},
            {"X", "O", "S", "O", "O"}
        };

        // Current position of the Clean Sweep (x = 2, y = 2)
        int x = 2;
        int y = 2;

        // Detect obstacles around the current position
        String[] result = detector.detectObstacles(floorPlan, x, y);

        // Print results for each direction
        System.out.println("Up: " + result[0]);
        System.out.println("Down: " + result[1]);
        System.out.println("Left: " + result[2]);
        System.out.println("Right: " + result[3]);
    }
    
}
