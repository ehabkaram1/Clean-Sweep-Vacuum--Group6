package MainControlSytstem;


import BatteryPower.PowerConsumptionLog;
import FloorPLan.CustomLinkedList;
import FloorPLan.FloorTile;
import FloorPLan.TileType;
import java.io.IOException;
import java.util.*;
import org.javatuples.Pair;

public class Cleaner {
  // variables related to battery consumption

  private static final double MAX_BATTERY_POWER = 250;
  private static final int MAX_DIRT_CAPACITY = 50;
  private double currBattery;
  private double lowBatteryThreshold = 35;
  private static PowerConsumptionLog pcl;
  // variables related to dirt capacity

  private int currDirtCapacity;
  private boolean atCapacity;
  private boolean almostAtCapacity; // about dirt size
  private List<Pair<Integer, TileType>> vacuumBag = new LinkedList<Pair<Integer, TileType>>();
  // variables related to movement

  public char headingTowards = 'N';
  private String currStatus = new String("No status yet");
  private FloorTile currNode;
  private FloorTile prevNode = null;
  private ArrayList<FloorTile> chargingStations = new ArrayList<FloorTile>();
  private ArrayList<FloorTile> cleanerHistory = new ArrayList<FloorTile>();
  private Stack<FloorTile> validTilesStack = new Stack<FloorTile>();
  private FloorTile[][] currentMap = new FloorTile[1000][1000];
  private CustomLinkedList sensorMap =
      null; // the cleaner stores it's own sensor map for checking completion
  private boolean cleaningComplete; // the cleaner can check if the map is complete

  private boolean isOnTheWay2Charging = false;

  // constructor
  public Cleaner() throws IOException {
    sensorMap = new CustomLinkedList();
    cleaningComplete = false;
    pcl = PowerConsumptionLog.getInstance();
    currBattery = MAX_BATTERY_POWER;
    currDirtCapacity = MAX_DIRT_CAPACITY;
  }

  // getters/setters
  public boolean getCleaningComplete() {
    return cleaningComplete;
  }

  public double getCurrBattery() {
    return currBattery;
  }

  public void setCurrBattery(double cb) {
    currBattery = cb;
  }

  public void setCurrDirtCapacity(int cdc) {
    currDirtCapacity = cdc;
  }

  public FloorTile getCurrNode() {
    return currNode != null ? currNode : new FloorTile(0, 0);
  }

  public void setCurrNode(FloorTile n) {
    currNode = n;
    this.currentMap[n.get_x()][n.get_y()] = copyFloorTile(n);
    cleanerHistory.add(n);
  }

  public CustomLinkedList getSensorMap() {
    // method used to retrieve private sensor map
    return this.sensorMap;
  }

  public void setSensorMap(CustomLinkedList testMap) {
    // method used to set a sensor map to the cleaner, useful for setting custom maps in tests
    this.sensorMap = testMap;
    setCurrNode(this.sensorMap.getHead());
  }

  public boolean isAtCapacity() {
    return atCapacity;
  }

  public boolean isAlmostAtCapacity() {
    return almostAtCapacity;
  }

  public String getCleanerStatus() {
    return currStatus;
  }

  public void setCleanerStatus(String newStatus) {
    currStatus = newStatus;
  }

  // check if map is completely cleaned and visited
  private boolean checkMapCleaningComplete() {
    // this method checks if the sensor map is the same as the current map and that all nodes are
    // cleaned and visited if possible
    FloorTile currSensorNode = this.sensorMap.getHead(); // get sensor map head
    boolean loopCheck = true; // loop checker to determine if all information is correct

    // check for nulls?

    while (currSensorNode != null) { // loop through the sensorNodes (Y-Axis)
      if (currSensorNode.get_y() % 2
          == 0) { // depending of row number move east if even, move west if odd
        while (currSensorNode.east
            != null) { // loop through the sensorNodes (X-Axis) east if row is even
          loopCheck = checkNodeCleanAndVisited(currSensorNode);
          if (!loopCheck) {
            break;
          }
          currSensorNode = currSensorNode.east; // move checker east
        }
        loopCheck = checkNodeCleanAndVisited(currSensorNode);
      } else {
        while (currSensorNode.west
            != null) { // loop through the sensorNodes (X-Axis) west if row is odd
          loopCheck = checkNodeCleanAndVisited(currSensorNode);
          if (!loopCheck) {
            break;
          }
          currSensorNode = currSensorNode.west; // move checker west
        }
        loopCheck = checkNodeCleanAndVisited(currSensorNode);
      }

      if (!loopCheck) {
        break;
      }

      if (currSensorNode.south
          != null) { // after looping all the way east/west then move south 1 row if not empty
        currSensorNode = currSensorNode.south;
      } else {
        break;
      }
    }

    return loopCheck;
  }