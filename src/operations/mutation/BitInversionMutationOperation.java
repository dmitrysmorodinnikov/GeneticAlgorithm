package operations.mutation;

import common.Config;
import common.Randomizer;
import domain.Chromosome;
import domain.Population;

/**
 * Inverse randomly selected bit of a chromosome
 */
public class BitInversionMutationOperation extends MutationOperation {
    /** index of random bit */
    private int index = 0;

    /**
     * Performs {@link BitInversionMutationOperation#mutate(Chromosome)} for each chromosome in a population
     * @param population
     */
    @Override
    public void execute(Population population) {
        index = Randomizer.randInt(0, Config.chromosomeSize-1);
        population.getChromosomes().forEach(this::mutate);
    }

    /**
     * BitInversionMutationOperation implementation
     * @param chromosome chromosome to be mutated
     */
    private void mutate(Chromosome chromosome){
        Character ch = chromosome.getBinaryCode().get(index);
        if(ch == '0')
            chromosome.getBinaryCode().set(index,'1');
        else
            chromosome.getBinaryCode().set(index,'0');
    }
}
