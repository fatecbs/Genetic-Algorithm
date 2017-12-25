package genetic_algorithm;

public class Population {
    
    private Tour tours[];
    
    /**
     * @param tamPop
     * @param initialise if it's false then create an empty population, else create a random population
     */
    public Population(int tamPop, boolean initialise) {
        tours = new Tour[tamPop];
        if(initialise == true)
        {
            for(int i=0; i<tamPop; i++)
            {
                Tour newTour = new Tour();
                newTour.generateIndividual();
                tours[i] = newTour;
            }
        }
    }
    
    public void setTour(Tour tour) {
        for(int i=0; i<tours.length; i++)
        {
            if(tours[i] == null)
            {
                tours[i] = tour;
                return;
            }
        }
    }
    
    public Tour getTour(int index) {
        return tours[index];
    }
    
    public Tour getFittest() {
        Tour fittest = tours[0];
        for(int i=0; i<tours.length; i++)
        {
            if(tours[i].getFitness() > fittest.getFitness())
            {
                fittest = tours[i];
            }
        }
        return fittest;
    }
}