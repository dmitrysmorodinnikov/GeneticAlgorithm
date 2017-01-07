package operations.selection;

import domain.Chromosome;
import domain.Population;

import java.util.List;

/**
 * Represents an interface for concrete Selection operations.
 * Selection operation selects parents from a population
 */
public abstract class SelectionOperation {
   public abstract List<Chromosome>execute(Population population);
}
