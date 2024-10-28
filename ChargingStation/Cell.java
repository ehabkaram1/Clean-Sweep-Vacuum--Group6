package ChargingStation;

public class Cell {
    private int x;
    private int y;
    private String type; // e.g., "bare_floor", "carpet", etc.
    private boolean isChargingStation;
    private boolean isObstacle;

    public Cell(int x, int y, String type, boolean isChargingStation, boolean isObstacle) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.isChargingStation = isChargingStation;
        this.isObstacle = isObstacle;
    }

    public Cell() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getType() {
        return type;
    }

    public boolean isChargingStation() {
        return isChargingStation;
    }

    public void setChargingStation(boolean chargingStation) {
        this.isChargingStation = chargingStation;
    }

    public boolean isObstacle() {
        return isObstacle;
    }

    public void setObstacle(boolean obstacle) {
        this.isObstacle = obstacle;
    }

    public void setType(String type) {
        this.type = type;
    }
}