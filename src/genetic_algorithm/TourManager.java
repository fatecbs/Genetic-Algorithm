package genetic_algorithm;

import java.util.ArrayList;

public class TourManager {
    
    public static ArrayList cities = new ArrayList<City>();
    
    public static void addCity(City city) {
        cities.add(city);
    }
    public static City getCity(int index) {
        return (City)cities.get(index);
    }
    public static int numberOfCities() {
        return cities.size();
    }
}