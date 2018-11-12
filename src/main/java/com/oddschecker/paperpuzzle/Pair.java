package com.oddschecker.paperpuzzle;

/**
 * Facilitates the storage of a pair of Objects
 * @param <A> first side of a pair
 * @param <B> second side of a pair
 */
public class Pair<A, B> {

    private final A first;
    private final B second;

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }



}


