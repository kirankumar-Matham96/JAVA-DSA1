package genericsPackage;

/**
 * If we want to use first and second values as different data types,
 * then we can declare the generic class with different types as below (T and S)
 * @param <T> type of first variable
 * @param <S> type of second variable
 */
public class Pair2<T,S> {
    private T first;
    private S second;

//    public Pair2(T first, S second){
//        this.first = first;
//        this.second = second;
//    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getFirst() {
        return first;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    public S getSecond() {
        return second;
    }
}
