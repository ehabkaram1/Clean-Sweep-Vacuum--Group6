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
