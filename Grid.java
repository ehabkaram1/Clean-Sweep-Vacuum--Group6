import java.util.Random;

public class Grid {
    private final int rows;
    private final int columns;
    private Cell[][] grid;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new Cell[rows][columns];
        initializeGrid();
    }

    private void initializeGrid() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boolean isObstacle = random.nextBoolean();
                int dirtLevel = random.nextInt(3);
                grid[i][j] = new Cell(isObstacle, dirtLevel);
            }
        }
    }

    public boolean isObstacle(int x, int y) {
        return grid[x][y].isObstacle();
    }

    public boolean hasDirt(int x, int y) {
        return grid[x][y].getDirtLevel() > 0;
    }

    public void cleanCell(int x, int y) {
        grid[x][y].clean();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
