import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class City extends Polygon{
    public final Point center;
    private String cityName;
    Set<Resource.Type> resources = new HashSet<>();

    public City(List<Point> points, Point center, String cityName,double wallSize) {
        super(squarePoints(center,wallSize));
        this.center = center;
        this.cityName = cityName;


    }
    private static List<Point> squarePoints(Point center, double wallSize){
        double halfSize= wallSize/2;
        List<Point> square = new ArrayList<>();
        square.add(new Point(center.x-halfSize, center.y-halfSize ));
        square.add(new Point(center.x+halfSize, center.y-halfSize ));
        square.add(new Point(center.x+halfSize, center.y+halfSize ));
        square.add(new Point(center.x-halfSize, center.y+halfSize ));
        return square;

    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String toString(){
        return cityName;
    }
    private boolean port = false;

    public  void updatePortStatus(Land land){
        for(Point corner : getPoints()){
            this.port = true;
            return;
        }
        this.port = false;

    }
    public  boolean isPort(){
        return  port;
    }
    public void AddResourcesInRange(List<Resource> allResources,double range){
        for(Resource resource : allResources){
            double dx = resource.point.x-this.center.x;
            double dy = resource.point.y-this.center.y;
            double distance=Math.sqrt(dx*dx+dy*dy);
            if(distance<=range){
                if(resource.type == Resource.Type.Fish && ! port){
                    continue;
                }
                resources.add(resource.type);

            }
        }
    }
    public  Set<Resource.Type> getResources(){
        return  resources;
    }
}
