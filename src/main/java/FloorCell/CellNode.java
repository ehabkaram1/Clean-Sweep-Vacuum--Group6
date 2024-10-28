package FloorCell;

import FloorCell.*;;

public class CellNode {
  private SideType sideN;
  private SideType sideS;
  private SideType sideW;
  private SideType sideE;

  private CellNode nodeN;
  private CellNode nodeS;
  private CellNode nodeW;
  private CellNode nodeE;

  private SurfaceType surface;
  private int dirtAmount;
  private int[] coordinate = new int[2];

  public CellNode(
      int x, int y, SurfaceType sur, int dirt, SideType n, SideType s, SideType w, SideType e) {
    coordinate[0] = x;
    coordinate[1] = y;
    surface = sur;
    dirtAmount = dirt;
    sideN = n;
    sideS = s;
    sideW = w;
    sideE = e;
  }

  /*get (x, y)*/
public int getCoordinateX() {
    return coordinate[0];}
  
    public int getCoordinateY() {
      return coordinate[1];
    }
  

}
