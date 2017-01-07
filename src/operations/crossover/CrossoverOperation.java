package operations.crossover;

import domain.Chromosome;

import java.util.List;

/**
 * Represents an interface for concrete Crossover operations.
 * Crossover operation produces new offsprings from parents and adds them to population
 */
public abstract class CrossoverOperation {
    public abstract void execute(List<Chromosome>parents);
}
