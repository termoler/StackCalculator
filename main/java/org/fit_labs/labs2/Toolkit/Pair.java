package org.fit_labs.labs2.Toolkit;

import java.util.Objects;

/**
 * This class implements an entity of the Pair data type
 * @param <X> the first data type
 * @param <Y> the second data type
 */
public class Pair<X, Y> {
    public X first;
    public Y second;

    public Pair(X x, Y y) {
        this.first = x;
        this.second = y;
    }

    @Override
    public String toString() {
        return first.toString() + " " + second.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }
}