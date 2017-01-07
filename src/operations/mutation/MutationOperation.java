package operations.mutation;

import domain.Population;

/**
 * Represents an interface for concrete Mutation operations.
 * Mutation operation changes existing chromosomes in a population
 */
public abstract class MutationOperation {
   public abstract void execute(Population population);
}
