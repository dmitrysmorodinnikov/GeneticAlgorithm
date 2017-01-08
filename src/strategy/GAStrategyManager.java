package strategy;

/**
 * Sets and executes {@link GAStrategy}
 * I need only one instance of this class so it is designed as a Singleton.
 */
public class GAStrategyManager {
    private GAStrategy strategy;

    private static GAStrategyManager instance = new GAStrategyManager();
    private GAStrategyManager(){}

    public static GAStrategyManager getInstance(){
        return instance;
    }

    public void setStrategy(GAStrategy strategy){
        this.strategy = strategy;
    }
    public void executeStrategy(){
        strategy.execute();
    }
}
