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
