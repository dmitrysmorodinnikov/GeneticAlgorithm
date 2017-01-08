package strategy;

import factory.GAStrategyAOperationsFactory;

/**
 * Concrete strategy.
 * Uses {@link GAStrategyAOperationsFactory} which creates concrete implementations
 * of {@link operations.selection.SelectionOperation},
 * {@link operations.crossover.CrossoverOperation},
 * {@link operations.mutation.MutationOperation}
 */
public class GAStrategyA extends GAStrategy {

    public GAStrategyA(){
        super(new GAStrategyAOperationsFactory());
    }
}
