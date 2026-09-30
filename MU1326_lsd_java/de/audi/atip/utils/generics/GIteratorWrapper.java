/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GIterator;
import java.util.Iterator;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
class GIteratorWrapper<T>
implements GIterator<T> {
    private final Iterator iterator;

    GIteratorWrapper(Iterator iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public T next() {
        return (T)this.iterator.next();
    }

    @Override
    public void remove() {
        this.iterator.remove();
    }

    public boolean equals(Object object) {
        return this.iterator.equals(object);
    }

    public int hashCode() {
        return this.iterator.hashCode();
    }

    public String toString() {
        return this.iterator.toString();
    }
}

