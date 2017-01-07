package operations.crossover;

import common.Config;
import common.Randomizer;
import common.Tuple;
import domain.Chromosome;
import domain.Population;
import javafx.util.Pair;

import java.util.List;

/** 
 * Two point crossover - two crossover point are selected,
 * binary string from beginning of chromosome to the first crossover point is copied from one parent,
 * the part from the first to the second crossover point is copied from the second parent
 * and the rest is copied from the first parent
 */
public class TwoPointCrossoverOperation extends CrossoverOperation {
    /** split point A */
    private int pointA;
    /** split point B */
    private int pointB;

    /**
     * set split points
     */
    private void setPoints(){
        int oneThirdPart = (Config.chromosomeSize/3)-1;
        pointA = Randomizer.randInt(0, oneThirdPart);
        pointB = Randomizer.randInt(oneThirdPart+1,Config.chromosomeSize-1);
    }

    /**
     * Overriden method performs two-point crossover operation for each pair of parents
     * The newly born offsprings are added to population
     * @param parents the list of parents comes from Selection operation
     */
    @Override
    public void execute(List<Chromosome> parents) {
        setPoints();
        for(int i=0;i+1<parents.size();i+=2){
            Tuple<Chromosome,Chromosome> offsprings = crossover(parents.get(i),parents.get(i+1));
            Config.population.getChromosomes().add(offsprings.first);
            Config.population.getChromosomes().add(offsprings.second);
        }
        if(parents.size()%2 !=0){
            Config.population.getChromosomes().add(parents.get(parents.size()-1));
        }
    }

    /**
     * Two-point crossover implementation
     * @param parentA first parent
     * @param parentB second parent
     * @return
     */
    private Tuple<Chromosome, Chromosome> crossover(Chromosome parentA, Chromosome parentB){
        Chromosome offspringA = new Chromosome();
        Chromosome offspringB = new Chromosome();
        for(int i = 0;i<Config.chromosomeSize;++i){
             if(i>pointA && i<=pointB) {
                offspringA.getBinaryCode().set(i,parentB.getBinaryCode().get(i));
                offspringB.getBinaryCode().set(i,parentA.getBinaryCode().get(i));
            }
             else{
                 offspringA.getBinaryCode().set(i,parentA.getBinaryCode().get(i));
                 offspringB.getBinaryCode().set(i,parentB.getBinaryCode().get(i));
             }
        }
        return new Tuple<>(offspringA,offspringB);
    }
}
