package operations.selection;

import domain.Chromosome;
import domain.Population;

import java.util.List;

/**
 * Concrete implementation of {@link SelectionOperation}
 * The best chromosome stays in population. Others are parents for new offsprings
 */
public class ElitismSelectionOperation extends SelectionOperation {
    @Override
    public List<Chromosome> execute(Population population) {
        List<Chromosome> parents = population.removeAllExceptBest(population);
        return parents;
    }
}
