package strategy;

import common.Config;
import domain.Chromosome;
import domain.Population;
import factory.OperationsFactory;
import operations.crossover.CrossoverOperation;
import operations.mutation.MutationOperation;
import operations.selection.SelectionOperation;

import java.util.List;

/**
 * Strategy design pattern in action. Different strategies use different Operations Factories providing
 * different behaviour of genetic algorithm, thus providing very powerful polymorphism. So we can easily change the strategy
 * without duplicating code or we can replace the strategy or easily add a new one.
 * All strategies have common operations(selection, crossover and mutation). They are created
 * using {@link OperationsFactory}.
 */
abstract class GAStrategy {
    OperationsFactory operationsFactory;
    SelectionOperation selectionOperation;
    CrossoverOperation crossoverOperation;
    MutationOperation mutationOperation;

    GAStrategy(OperationsFactory operationsFactory){
        this.operationsFactory = operationsFactory;
        createOperations();
    }

    /**
     * Creates genetic operations using abstract factory
     */
    private void createOperations(){
        if(this.operationsFactory != null){
            this.selectionOperation = this.operationsFactory.createSelectionOperation();
            this.crossoverOperation = this.operationsFactory.createCrossoverOperation();
            this.mutationOperation = this.operationsFactory.createMutationOperation();
        }
    }

    /**
     * executes genetic operations
     * What really happens here behind the scenes is Polymorhism. Some concrete implementation
     * of {@link OperationsFactory} is passed which created some concrete implementations of genetic operations which
     * all make use of the same interface ('execute()' method)
     */
    void execute(){
        int iterations = 0;
        do{
            iterations++;
            Config.population.getChromosomes().forEach(domain.Chromosome::updateRate);
            List<Chromosome> selectedParents = selectionOperation.execute(Config.population);
            crossoverOperation.execute(selectedParents);
            mutationOperation.execute(Config.population);

            Config.population.getChromosomes().forEach(domain.Chromosome::updateRate);
        }while (continueExecute(Config.population));
        System.out.println("Match found! Number of iterations required to find a match: "+ iterations);
    }

    /**
     *
     * @param population
     * @return true if a population contains a chromosome that is equal to goal chromosome
     */
    private boolean continueExecute(Population population){
        boolean continueExecute = true;
        for(Chromosome chromosome:population.getChromosomes()){
            if(chromosome.getRate() == Config.chromosomeSize){
                continueExecute = false;
                break;
            }
        }
        return continueExecute;
    }
}
