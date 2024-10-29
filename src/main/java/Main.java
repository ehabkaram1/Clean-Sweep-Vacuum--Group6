import MainControlSytstem.*;
import floorPlan.*;
import java.io.*;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.*;
import org.xml.sax.SAXException;

public class Main {

  //	private static CustomLinkedList xmlFloorPlan = new CustomLinkedList();
  //	private static CustomLinkedList myFloor = new CustomLinkedList();

  public static void main(String[] args)
      throws ParserConfigurationException, SAXException, IOException {

    CustomLinkedList floorPlan = new CustomLinkedList();
    floorPlan.createFloorFromXML(new File("files/SamplePlanWithAttributes.xml"));

    Cleaner cleaner = new Cleaner();
    cleaner.setSensorMap(floorPlan);
    System.out.println("Hello! My start point is " + cleaner.printCoordinate());
    try {
      TimeUnit.SECONDS.sleep(8);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    cleaner.fillChargingStations(floorPlan);
    cleaner.setCurrBattery(20);
    cleaner.setCurrDirtCapacity(40);

    floorPlan.printSuccintMap();

    while (!cleaner.moreCleaningToDo()) {
      for (int i = 0; i <= 5; i++) {
        for (int j = 0; j <= 8; j++) {
          if (!floorPlan.returnNode(j, i).getAccessable()) continue;
          cleaner.moveToLocation_UsingStack(j, i);
        }
      }
    }
    System.out.println("***************");
    System.out.println("CLEANING IS COMPLETE.");
    System.out.println("***************");
  }
}
