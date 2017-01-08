import common.Config;
import domain.Chromosome;
import strategy.GAStrategyA;
import strategy.GAStrategyB;
import strategy.GAStrategyManager;

import java.util.Scanner;

/**
 * Main class with main() method
 */
public class Main {
    public static void main(String[] args) {
        Init();
        printResultPopulation();
    }

    /**
     * Initialisation method. Provides initial interaction with the user.
     */
    private static void Init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! This is a 'Genetic Algorithm Demo'");
        System.out.println("Choose from 2 strategies: Strategy1(Enter 1), Strategy2(Enter 2)");
        String strategyNumber = (scanner.nextLine());
        System.out.println("Enter the goal Chromosome code(from 3 to 10 symbols without spaces) consisting of 0 or 1(for instance:0101)");
        String goalChromosome = scanner.nextLine();
        System.out.println("Initializing...");
        sleep();
        Config.initialize(goalChromosome);

        run(strategyNumber);
    }

    /**
     * Creates {@link GAStrategyManager} which is responsible for setting and executing the strategy
     * @param strategyNumber number of strategy picked by user
     */
    private static void run(String strategyNumber){
        GAStrategyManager manager = GAStrategyManager.getInstance();
        if(strategyNumber == "1")
            manager.setStrategy(new GAStrategyA());
        else
            manager.setStrategy(new GAStrategyB());
        manager.executeStrategy();
    }

    /**
     * Prints the final Population(set of chromosomes)
     */
    private static void printResultPopulation(){
        System.out.println("Result Population:");
        for(Chromosome chromosome:Config.population.getChromosomes()){
            System.out.println(chromosome.getBinaryCode().toString());
        }
    }

    private static void sleep(){
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}


