package factory;

import operations.crossover.CrossoverOperation;
import operations.crossover.OnePointCrossoverOperation;
import operations.crossover.TwoPointCrossoverOperation;
import operations.mutation.BitInversionMutationOperation;
import operations.mutation.MutationOperation;
import operations.selection.ElitismSelectionOperation;
import operations.selection.SelectionOperation;

/**
 * Concrete Operations Factory. Responsible for creating genetic operations for StrategyA
 */
public class GAStrategyAOperationsFactory extends OperationsFactory {
    @Override
    public SelectionOperation createSelectionOperation() {
        return new ElitismSelectionOperation();
    }

    @Override
    public CrossoverOperation createCrossoverOperation() {
        return new TwoPointCrossoverOperation();
    }

    @Override
    public MutationOperation createMutationOperation() {
        return new BitInversionMutationOperation();
    }
}
