package genetic_algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Tour {
    
    private ArrayList tour = new ArrayList<City>();
    private int distance = 0;
    private double fitness = 0;
    
    public Tour() {
        for(int i=0; i<TourManager.numberOfCities(); i++)
        {
            tour.add(null);
        }
    }
    
    public void setCity(int cityPosition, City city) {
        tour.set(cityPosition, city);
        fitness = 0;
        distance = 0;
    }
    
    public City getCity(int cityPosition) {
        return (City)tour.get(cityPosition);
    }
    
    public int getTamTour() {
        return tour.size();
    }
    
    public void generateIndividual() {
        for(int i=0; i<TourManager.numberOfCities(); i++)
        {
            setCity(i, TourManager.getCity(i));
        }
        Collections.shuffle(tour);
    }
    
    public int getTotalDistance() {
        if(distance == 0)
        {
            int tourDistance = 0;
            for(int i=0; i < tour.size(); i++)
            {
                City fromCity = getCity(i);
                City destinationCity;
                if(i+1 < tour.size())
                {
                    destinationCity = getCity(i+1);
                }
                else
                {
                    destinationCity = getCity(0);
                }
                tourDistance += fromCity.distanceCities(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }
    
    public double getFitness() {
        if(fitness == 0)
        {
            fitness = 1/(double)getTotalDistance();
        }
        return fitness;
    }
    
    public boolean containsCity(City city){
        return tour.contains(city);
    }
    
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tour.size(); i++) {
            geneString += getCity(i)+"|";
        }
        return geneString;
    }
}