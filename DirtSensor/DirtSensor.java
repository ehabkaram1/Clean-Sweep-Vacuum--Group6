package DirtSensor;

import FloorPlan.FloorPlan;

public class DirtSensor {
    private int dirtCapacity = 50; // Total dirt the vacuum can collect
    private int currentDirt = 0; // Dirt collected so far
    private FloorPlan floorPlan; // Assume FloorPlan is a class that holds the map layout and dirt status
    private int currentX, currentY; // Vacuum's current position

    public DirtSensor(FloorPlan floorPlan, int x, int y) {
        this.floorPlan = floorPlan;
        updatePosition(x, y);
    }

    // Method to detect and clean dirt at the current location
    public void detectAndClean() {
        // Check if vacuum has reached max capacity
        if (currentDirt >= dirtCapacity) {
            System.out.println("Dirt capacity full! Returning to charging station...");
            return;
        }

        // Check if the current location has dirt
        if (floorPlan.isDirty(currentX, currentY)) {
            System.out.println("Dirt detected at location (" + currentX + ", " + currentY + "). Cleaning...");
            floorPlan.clean(currentX, currentY); // Clean the current location
            currentDirt++; // Increase the dirt collected by the vacuum
        } else {
            System.out.println("Location (" + currentX + ", " + currentY + ") is already clean.");
        }
    }

    // Method to update the vacuum's position
    public void updatePosition(int x, int y) {
        this.currentX = x;
        this.currentY = y;
    }
}
