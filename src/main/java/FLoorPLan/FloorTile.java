package FLoorPLan;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "node")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class FloorTile implements Serializable {
  private static final long serialVersionUID = 1L;

  public FloorTile north;
  public FloorTile south;
  public FloorTile east;
  public FloorTile west;
  public int _x;
  public int _y;

  public int G;
  public int H;
  public int F;
  public FloorTile parent;

  TileType surfaceType;
  boolean isClean;
  boolean accessable;
  boolean chargingStation;
  int unitsOfDirt;

  public FloorTile() {
    super();
  }

  // Constructor
  // will make floorplan a java object from xml, which will allow for these nodes to be inserted
  public FloorTile(int y, int x) {
    north = null;
    south = null;
    east = null;
    west = null;
    _x = x;
    _y = y;

    // Default values, will be an easy tile.
    surfaceType = TileType.BARE;
    isClean = true;
    accessable = true;
    chargingStation = false;
    unitsOfDirt = 0;
  }

  public FloorTile(int y, int x, boolean isAccessable) {
    north = null;
    south = null;
    east = null;
    west = null;
    _x = x;
    _y = y;
    accessable = isAccessable;
  }

  public FloorTile(int y, int x, int dirtAmount, TileType type) {
    north = null;
    south = null;
    east = null;
    west = null;
    _x = x;
    _y = y;
    surfaceType = type;
    unitsOfDirt = dirtAmount;
    isClean = true;
    if (unitsOfDirt > 0) {
      isClean = false;
    }

    // Default values, will be an easy tile.
    accessable = true;
    chargingStation = false;
  }

  public FloorTile(
      int y,
      int x,
      int dirtAmount,
      boolean isAccessible,
      boolean isChargingStation,
      TileType type) {
    north = null;
    south = null;
    east = null;
    west = null;
    _x = x;
    _y = y;
    surfaceType = type;
    unitsOfDirt = dirtAmount;
    isClean = true;
    if (unitsOfDirt > 0) {
      isClean = false;
    }
    accessable = isAccessible;
    chargingStation = isChargingStation;
  }

  public void setAccessable(boolean f) {
    accessable = f;
  }

  public boolean getAccessable() {
    return accessable;
  }

  public void setSurfaceType(TileType type) {
    surfaceType = type;
  }

  public TileType getSurfaceType() {
    return surfaceType;
  }

  public double getBatteryConsumption() {
    TileType temp = getSurfaceType();
    return Double.valueOf(temp.getValue());
  }

  public void setClean(boolean clean) {
    isClean = clean;
  }

  public boolean getClean() {
    return isClean;
  }

  public void setUnitsOfDirt(int units) {
    if (unitsOfDirt > 0) {
      isClean = false;
    }
    unitsOfDirt = units;
  }

  public int getUnitsOfDirt() {
    return unitsOfDirt;
  }

  public void setChargeStation(boolean chargeStation) {
    chargingStation = chargeStation;
  }

  public boolean getChargeStation() {
    return chargingStation;
  }
