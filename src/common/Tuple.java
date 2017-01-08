package common;

/**
 * Simple Generic Tuple implementation which may hold two values of different types
 */
public class Tuple<T1,T2> {
    public T1 first;
    public T2 second;

    public Tuple(T1 first, T2 second){
        this.first = first;
        this.second = second;
    }
}
