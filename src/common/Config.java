package common;

import domain.Chromosome;
import domain.Population;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for generating and storing core Application objects. Contains only static methods.
 */
public class Config {
    public static int chromosomeSize;
    public static Population population = Population.getInstance();
    public static Chromosome goalChromosome = new Chromosome();

    /**
     * Initialise goalChromosome and chromosomeSize
     * @param goalChromosomeString Goal chromosome entered by user
     */
    public static void initialize(String goalChromosomeString){
        for(char c:goalChromosomeString.toCharArray()){
            goalChromosome.getBinaryCode().add(c);
        }
        chromosomeSize = goalChromosomeString.length();
        generatePopulation();
    }

    /**
     * Fills population with randomly generated chromosomes
     */
    private static void generatePopulation(){
        System.out.println("Generating random Population...");
        for(int i=0;i<chromosomeSize;++i){
            List<Character>binaryCode = new ArrayList<>();
            for(int j=0;j<chromosomeSize;++j){
                int rand = Randomizer.randInt(0, 1);
                char ch = Character.forDigit(rand,10);
                binaryCode.add(ch);

            }
            Chromosome chromosome = new Chromosome(binaryCode);
            population.getChromosomes().add(chromosome);
            System.out.println(binaryCode.toString());
        }
    }
}
