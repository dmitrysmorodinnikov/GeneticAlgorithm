package operations.crossover;

import common.Config;
import common.Randomizer;
import common.Tuple;
import domain.Chromosome;
import domain.Population;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Single point crossover - one crossover point is selected,
 * binary string from beginning of chromosome to the crossover point is copied from one parent,
 * the rest is copied from the second parent
 */
public class OnePointCrossoverOperation extends CrossoverOperation {
    /** split point */
    private int point;

    /**
     * Overriden method performs one-point crossover operation for each pair of parents
     * The newly born offsprings are added to population
     * @param parents the list of parents comes from Selection operation
     */
    @Override
    public void execute(List<Chromosome> parents) {
        point = Randomizer.randInt(0,Config.chromosomeSize-1);
        for(int i=0;i+1<parents.size();i+=2){
            Tuple<Chromosome,Chromosome>offsprings = crossover(parents.get(i),parents.get(i+1));
            Config.population.getChromosomes().add(offsprings.first);
            Config.population.getChromosomes().add(offsprings.second);
        }
        if(parents.size()%2 !=0){
            Config.population.getChromosomes().add(parents.get(parents.size() - 1));
        }
    }

    /**
     * One-point crossover implementation
     * @param parentA first parent
     * @param parentB second parent
     * @return two newly born chromosomes
     */
    private Tuple<Chromosome, Chromosome> crossover(Chromosome parentA, Chromosome parentB){
        Chromosome offspringA = new Chromosome();
        Chromosome offspringB = new Chromosome();
        for(int i = 0;i<Config.chromosomeSize;++i){
            if(i<=point){
                offspringA.getBinaryCode().set(i,parentA.getBinaryCode().get(i));
                offspringB.getBinaryCode().set(i,parentB.getBinaryCode().get(i));
            }
            else {
                offspringA.getBinaryCode().set(i,parentB.getBinaryCode().get(i));
                offspringB.getBinaryCode().set(i,parentA.getBinaryCode().get(i));
            }
        }
        return new Tuple<>(offspringA,offspringB);
    }
}
