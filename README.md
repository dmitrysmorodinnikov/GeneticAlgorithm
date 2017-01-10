## GeneticAlgorithm
The basic implementation of the genetic algorithm written in Java. It simulates the work of Genetic Algorithm by implementing 3 core stages: selection, crossover and mutation. I'm working with Chromosome model which is represented by binary String (i.e 1010101010). A group of chromosomes is called a Population. Population gets changed while going through 3 stages(selection, crossover and mutation) until some chromosome of a population is equal to our goal chromosome. 

## How to use Demo
Demo is interactive. Firstly, you need to enter the goal chromosome' binary code. You're asked to enter a  string of '1' and '0' without spaces. The length of the String should be from 3 to 10 symbols. This constraint can be explained by two reasons:
<ol>
    <li> It's easier to analyse and check results. </li><p/>
   <li> For genetic algorithms, it's really important to obtain a math proof that the algorithm has a property of convergence. I didn't do it for my algorithm(because the task is focused primarily on software design) - the solution doesn't converge sometimes on big numbers.</li><p/>
</ol>
Then you're asked to choose one of two possible strategies. Enter 1 or 2.

*Input*:      
       Goal Chromosome, initial Population(randomly generated by the program), strategy to use. Strategies differ by the way genetic operations(selection, crossover and mutation) are implemented.    
          
*Output*:      
       The number of iterations(a single iteration consists of selection, crossover and mutation stages) required to find a match; the final Population where one of the Chromosomes is equal to Goal Chromosome.  


## How to use 'doc' folder

The 'doc' folder contains 'javadoc' documentation. All the technical details, design patterns explanation, classes and methods desriptions can be found inside. A perfect way to begin is to run 'index.html' inside 'doc' folder.


## Author

* [@d_smorodinnikov](https://twitter.com/d_smorodinnikov) <br/>
* [Dmitry Smorodinnikov's Blog](http://smorodinnikov.com/)<br/>
