package factory;

import operations.crossover.CrossoverOperation;
import operations.crossover.OnePointCrossoverOperation;
import operations.crossover.TwoPointCrossoverOperation;
import operations.mutation.BitInversionMutationOperation;
import operations.mutation.MutationOperation;
import operations.selection.RouletteWheelSelectionOperation;
import operations.selection.SelectionOperation;

/**
 * Concrete Operations Factory. Responsible for creating genetic operations for StrategyB
 */
public class GAStrategyBOperationsFactory extends OperationsFactory {
    @Override
    public SelectionOperation createSelectionOperation() {
        return new RouletteWheelSelectionOperation();
    }

    @Override
    public CrossoverOperation createCrossoverOperation() {
        return new OnePointCrossoverOperation();
    }

    @Override
    public MutationOperation createMutationOperation() {
        return new BitInversionMutationOperation();
    }
}
