interface PairInterface<T> {
    T getFirst();
    T getSecond();
    void setFirst(T first);
    void setSecond(T second);
}

class myPair<T> implements PairInterface<T>{
    private T first;
    private T second;
    
    public myPair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst(){
        return first;
    }

    public T getSecond(){
        return second;
    }

    public void setFirst(T first){
        this.first = first;
    }

    public void setSecond(T second){
        this.second = second;
    }
}

class ArrayPair<T> implements PairInterface<T>{
    public T[]pair;

    public ArrayPair(T first, T second){
        pair = (T[]) new Object[2];
        pair[0] = first;
        pair[1] = second;
    }

    public T getFirst() {
        return pair[0];
    }

    public T getSecond() {
        return pair[1];
    }

    public void setFirst(T first){
        pair[0] = first;
    }

    public void setSecond(T second) {
        pair[1] = second;
    }

}