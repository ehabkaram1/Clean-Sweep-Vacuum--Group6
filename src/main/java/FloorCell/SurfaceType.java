package FloorCell;

public enum SurfaceType {
    BARE(1),
    LOWPILE(2),
    HIGHPILE(3);
  
    // abbr indicates how many units of charge this surface will consume.
    private int abbr;
  
    SurfaceType(int abb) {
      abbr = abb;
    }
  
    public int getAbbr() {
      return abbr;
    }
  }
