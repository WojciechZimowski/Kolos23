import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    Polygon polygon = new Polygon(Arrays.asList(
            new Point(0,0),
            new Point(10,0),
            new Point(10,10),
            new Point(0,10)


    ));
      Point insidePoint = new Point(5,5);
      Point outsidePoint = new Point(15,5);
      System.out.println("Ins"+ polygon.inside(insidePoint));
        System.out.println("Out"+ polygon.inside(outsidePoint));
    }
}