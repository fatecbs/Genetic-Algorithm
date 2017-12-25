package genetic_algorithm;

import java.util.Random;

public class Algorithm {
    
    public static int qtdCities;
    public static int tamPop;
    public static int tournmentSize;
    public static double mutationRate;
    
    public static Population newGeneration(Population population) {
        Population newPopulation = new Population(tamPop, false);
        newPopulation.setTour(population.getFittest());
        for(int i=1; i<tamPop; i++)
        {
            Tour parent1 = tournmentSelection(population);
            Tour parent2 = tournmentSelection(population);
            Tour child = crossover(parent1, parent2);
            child = mutate(child);
            newPopulation.setTour(child);
        }
        return newPopulation;
    }
    
    public static Tour tournmentSelection(Population pop) {
        Random r = new Random();
        Population popTournment = new Population(tournmentSize, false);
        for(int i=0; i<tournmentSize; i++)
        {
            popTournment.setTour(pop.getTour(r.nextInt(tamPop)));
        }
        Tour parent = popTournment.getFittest();
        return parent;
    }
    
    public static Tour crossover(Tour parent1, Tour parent2) {
        Tour child = new Tour();
        int startPos = (int) (Math.random() * parent1.getTamTour());
        int endPos = (int) (Math.random() * parent1.getTamTour());
        // Loop and add the sub tour from parent1 to our child
        for(int i = 0; i < child.getTamTour(); i++)
        {
            if(startPos < endPos && i > startPos && i < endPos)
            {
                child.setCity(i, parent1.getCity(i));
            }
            else if(startPos > endPos)
            {
                if(!(i < startPos && i > endPos))
                {
                    child.setCity(i, parent1.getCity(i));
                }
            }
        }
        // Loop through parent2's city tour
        for(int i = 0; i < parent2.getTamTour(); i++)
        {
            if(!child.containsCity(parent2.getCity(i)))
            {
                for(int ii = 0; ii < child.getTamTour(); ii++)
                {
                    if(child.getCity(ii) == null)
                    {
                        child.setCity(ii, parent2.getCity(i));
                        break;
                    }
                }
            }
        }
        return child;
    }
    
    public static Tour mutate(Tour tour) {
        Random r = new Random();
        for(int i=0; i<tour.getTamTour(); i++)
        {
            if(r.nextDouble() <= mutationRate)
            {
                int pos1 = i;
                int pos2 = r.nextInt(tour.getTamTour());
                City city1 = tour.getCity(pos1);
                City city2 = tour.getCity(pos2);
                tour.setCity(pos1, city2);
                tour.setCity(pos2, city1);
            }
        }
        return tour;
    }
}