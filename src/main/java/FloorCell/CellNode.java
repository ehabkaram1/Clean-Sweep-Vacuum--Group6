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

}
