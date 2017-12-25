package genetic_algorithm;

public class City {
    
    private int x;
    private int y;
    
    // Constructs a randomly placed city
    public City() {
        this.x = (int)(Math.random()*200);
        this.y = (int)(Math.random()*200);
    }
    // Constructs a city at chosen x, y location
    public City(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public double distanceCities(City city) {
        int xDistance = Math.abs(getX() - city.getX());
        int yDistance = Math.abs(getY() - city.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        return distance;
    }
    
    @Override
    public String toString() {
        return getX()+", "+getY();
    }
}