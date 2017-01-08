package factory;

import operations.crossover.CrossoverOperation;
import operations.mutation.MutationOperation;
import operations.selection.SelectionOperation;

/**
 * Abstract factory. Provides an interface for creating 3 families of operations:
 * 1)Creates Selection operations
 * 2)Creates Crossover operations
 * 3)Creates Mutation operations
 */
public abstract class OperationsFactory {
    public abstract SelectionOperation createSelectionOperation();
    public abstract CrossoverOperation createCrossoverOperation();
    public abstract MutationOperation createMutationOperation();
}
