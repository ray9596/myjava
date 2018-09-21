package com.ray.test2;

public class Mykey implements Comparable<Mykey>{
    int n;

    public Mykey(int n) {
        this.n = n;
    }

    @Override
    public boolean equals(Object o) {

        return true;
    }

    @Override
    public int hashCode() {

        return 1;
    }

    @Override
    public int compareTo(Mykey o) {
        return this.n - o.n;
    }
}
