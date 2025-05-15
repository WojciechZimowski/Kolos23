import java.util.ArrayList;
import java.util.List;

public class Land extends Polygon{

    private  List<City> cities = new ArrayList<>();
    public Land(List<Point> points) {
        super(points);
    }
    public void addCity(City city){
        if(!this.inside(city.center)){
            throw new RuntimeException(city.getCityName());
        }
        cities.add(city);
    }
}
