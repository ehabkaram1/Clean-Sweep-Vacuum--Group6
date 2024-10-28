public class Cell {
    private boolean obstacle;
    private int dirtLevel;

    public Cell(boolean obstacle, int dirtLevel) {
        this.obstacle = obstacle;
        this.dirtLevel = dirtLevel;
    }

    public boolean isObstacle() {
        return obstacle;
    }

    public int getDirtLevel() {
        return dirtLevel;
    }

    public void clean() {
        if (dirtLevel > 0) {
            dirtLevel--;
        }
    }

    public String getX() {
        throw new UnsupportedOperationException("Unimplemented method 'getX'");
    }
}
