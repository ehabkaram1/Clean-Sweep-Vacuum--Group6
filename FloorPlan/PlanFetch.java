import java.io.File;
import java.io.IOException;

public class PlanFetch {
    public static FloorPlan fetchFloorPlan(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        FloorPlan floorPlan = null;

        floorPlan = objectMapper.readValue(new File(filePath), FloorPlan.class);
        System.out.println("Floor plan successfully fetched from file: " + filePath);

        return floorPlan;
    }

    public static void main(String[] args) {
       
        String filePath = "floorplan.json";
        
       
        FloorPlan floorPlan = PlanFetch.fetchFloorPlan(filePath);

       
        if (floorPlan != null) {
            System.out.println("Floor plan loaded successfully.");
        } else {
            System.out.println("Failed to load the floor plan.");
        }
    }
}

