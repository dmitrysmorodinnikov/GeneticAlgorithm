package domain;

import common.Config;

import java.util.ArrayList;
import java.util.List;

/**
 * Chromosome is the domain object of Application. It is the naive model of a real chromosome(in biology)
 * All fields are made private to hide the details of implementation from outer classes.
 * They are accessible through public methods.
 */
public class Chromosome {
    /** Binary representation of chromosome. */
    private List<Character> binaryCode;
    /** Indicates the similarity rate between current chromosome and goal chromosome*/
    private int rate;

    public Chromosome(){
        rate = 0;
        setBinaryCode();
    }
    public Chromosome(List<Character> binaryCode){
        super();
        this.binaryCode = binaryCode;
    }
    /** {@link Chromosome#binaryCode} getter */
    public List<Character>getBinaryCode(){
        return this.binaryCode;
    }
    /** rate getter */
    public int getRate(){
        return this.rate;
    }

    /** updates {@link Chromosome#rate} */
    public void updateRate(){
        int rate = 0;
        for(int i=0;i<Config.chromosomeSize;++i){
            if(this.binaryCode.get(i) == Config.goalChromosome.binaryCode.get(i))
                rate++;
        }
        this.rate = rate;
    }

    /** {@link Chromosome#binaryCode} private setter */
    private void setBinaryCode(){
        binaryCode  = new ArrayList<>(Config.chromosomeSize);
        for(int i = 0;i< Config.chromosomeSize;++i){
            this.binaryCode.add('0');
        }
    }
}
