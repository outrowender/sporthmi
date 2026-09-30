/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.generics.GComparator;
import java.util.Comparator;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class GComparatorWrapper<T>
implements GComparator<T> {
    private Comparator backingComparator;

    public GComparatorWrapper(Comparator comparator) {
        Preconditions.checkNotNull((Object)comparator, "comparator");
        this.backingComparator = comparator;
    }

    @Override
    public int compare(T t, T t2) {
        return this.backingComparator.compare(t, t2);
    }

    public Comparator getBackingComparator() {
        return this.backingComparator;
    }
}

