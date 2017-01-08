package strategy;

import factory.GAStrategyAOperationsFactory;
import factory.GAStrategyBOperationsFactory;

/**
 * Concrete strategy.
 * Uses {@link GAStrategyBOperationsFactory} which creates concrete implementations
 * of {@link operations.selection.SelectionOperation},
 * {@link operations.crossover.CrossoverOperation},
 * {@link operations.mutation.MutationOperation}
 */
public class GAStrategyB extends GAStrategy {
    public GAStrategyB(){
        super(new GAStrategyBOperationsFactory());
    }
}
