package domain;

import common.Randomizer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Domain class. Represents a population of chromosomes.
 * I need only one instance of Population class so it's made a Singleton.
 * Singleton implementation is thread-safe.
 */
public class Population {
    private static Population instance = new Population();
    private List<Chromosome>chromosomes;

    private Population(){
        chromosomes = new ArrayList<>();
    }

    /**
     *  @return the instance of {@link Population} class
     */
    public static Population getInstance(){ return instance; }

    public List<Chromosome> getChromosomes(){
        return this.chromosomes;
    }

    /**
     *
     * @return the chromosome with the highest {@link Chromosome#rate}
     */
    public Chromosome getBestChromosome(){
        return chromosomes.stream().max(Comparator.comparingInt(x->x.getRate())).get();
    }

    /**
     * Removes all chromosomes except the one with highest {@link Chromosome#rate}
     * @param population
     * @return the list of parent chromosomes to produce new offsprings
     */
    public List<Chromosome> removeAllExceptBest(Population population){
        Chromosome bestChromosome = getBestChromosome();
        population.chromosomes.remove(bestChromosome);
        List<Chromosome>parents = new ArrayList<>(population.chromosomes);
        population.chromosomes.clear();
        population.chromosomes.add(bestChromosome);
        return parents;
    }

    /**
     * Removes all chromosomes except the one randomly chosen
     * @param population
     * @return the list of parent chromosomes to produce new offsprings
     */
    public List<Chromosome> removeAllExceptRandom(Population population){
        int rand = Randomizer.randInt(0, population.chromosomes.size()-1);
        Chromosome randomChromosome = population.chromosomes.get(rand);
        population.chromosomes.remove(randomChromosome);
        List<Chromosome>parents = new ArrayList<>(population.chromosomes);
        population.chromosomes.clear();
        population.chromosomes.add(randomChromosome);
        return parents;
    }
}
