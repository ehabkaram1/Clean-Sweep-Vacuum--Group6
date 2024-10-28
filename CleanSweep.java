public class CleanSweep {
    private int x;
    private int y;
    private Grid grid;

    public CleanSweep(Grid grid) {
        this.grid = grid;
        this.x = 0;
        this.y = 0;
    }

    public void move(String direction) {
        int newX = x, newY = y;
        
        switch (direction) {
            case "UP": newY -= 1; break;
            case "DOWN": newY += 1; break;
            case "LEFT": newX -= 1; break;
            case "RIGHT": newX += 1; break;
        }
        
        if (isValidMove(newX, newY)) {
            x = newX;
            y = newY;
            System.out.println("Moved to (" + x + ", " + y + ")");
            if (grid.hasDirt(x, y)) {
                clean();
            }
        } else {
            System.out.println("Obstacle encountered or out of bounds!");
        }
    }

    private boolean isValidMove(int newX, int newY) {
        return newX >= 0 && newX < grid.getRows() && newY >= 0 && newY < grid.getColumns() && !grid.isObstacle(newX, newY);
    }

    private void clean() {
        grid.cleanCell(x, y);
        System.out.println("Cleaned cell at (" + x + ", " + y + ")");
    }

    public void navigate() {
        String[] directions = {"UP", "DOWN", "LEFT", "RIGHT"};
        boolean hasMoved = false;

        for (String direction : directions) {
            int newX = x;
            int newY = y;

            switch (direction) {
                case "UP" -> newY -= 1;
                case "DOWN" -> newY += 1;
                case "LEFT" -> newX -= 1;
                case "RIGHT" -> newX += 1;
            }

            if (isValidMove(newX, newY)) {
                move(direction);
                hasMoved = true;
                break;
            }
        }

        if (!hasMoved) {
            System.out.println("All paths are blocked. Shutting down.");
        }
    }
}
