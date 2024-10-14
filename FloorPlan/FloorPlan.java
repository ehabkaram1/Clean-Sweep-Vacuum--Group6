package FloorPlan;

public class FloorPlan {
    private int[][] dirtMap; // 2D array representing dirt levels at each cell

    public FloorPlan(int rows, int cols) {
        dirtMap = new int[rows][cols];
        // Initialize dirtMap with random values or pre-defined layout
    }

    // Method to check if a location has dirt
    public boolean isDirty(int x, int y) {
        return dirtMap[x][y] > 0;
    }

    // Method to clean a location (reduce dirt level by 1)
    public void clean(int x, int y) {
        if (dirtMap[x][y] > 0) {
            dirtMap[x][y]--;
        }
    }
}
