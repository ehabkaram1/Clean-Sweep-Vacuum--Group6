package src.main.java.FloorPlan;

import java.io.File;
import java.io.IOException;

public class PlanFetch {
    // Function to fetch and parse the floor plan from a JSON file
    public static FloorPlan fetchFloorPlan(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper(); 
        FloorPlan floorPlan = null;

        try {
            // Read and parse the JSON file into a FloorPlan object
            floorPlan = objectMapper.readValue(new File(filePath), FloorPlan.class);
            System.out.println("Floor plan successfully fetched from file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to fetch or parse the floor plan file.");
        }

        return floorPlan;
    }

    public static void main(String[] args) {
        // Specify the path to your JSON file
        String filePath = "floorplan.json";
        
        // Fetch the floor plan
        FloorPlan floorPlan = PlanFetch.fetchFloorPlan(filePath);

        // Ensure the floor plan is successfully fetched
        if (floorPlan != null) {
            System.out.println("Floor plan loaded successfully.");
        } else {
            System.out.println("Failed to load the floor plan.");
        }
    }
}

