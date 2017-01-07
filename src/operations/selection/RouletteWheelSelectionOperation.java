package operations.selection;

import domain.Chromosome;
import domain.Population;

import java.util.List;

/**
 * Concrete implementation of {@link SelectionOperation}
 * The random chromosome stays in population. Others are parents for new offsprings
 */
public class RouletteWheelSelectionOperation extends SelectionOperation {
    @Override
    public List<Chromosome> execute(Population population) {
        List<Chromosome> parents = population.removeAllExceptRandom(population);
        return parents;
    }
}
