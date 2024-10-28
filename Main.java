public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(10, 10);
        CleanSweep robot = new CleanSweep(grid);
        robot.navigate();
    }
}

