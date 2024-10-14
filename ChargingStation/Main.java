package ChargingStation;

public class Main {
    public static void main(String[] args) {
        // Create a 5x5 floor plan
        ChargingStation floorPlan = new ChargingStation(5, 5);

        // Starting position of the robot
        int startX = 0, startY = 0;

        // Find the nearest charging station
        Cell nearestChargingStation = floorPlan.findNearestChargingStation(startX, startY);

        if (nearestChargingStation != null) {
            System.out.println("Nearest charging station found at: (" + nearestChargingStation.getX() + ", " + nearestChargingStation.getY() + ")");
        } else {
            System.out.println("No charging station found.");
        }
    }
}

