/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GComparator;

final class Comparators$1
implements GComparator {
    Comparators$1() {
    }

    public int compare(Integer n, Integer n2) {
        return n.compareTo(n2);
    }

    @Override
    public /* synthetic */ int compare(Object object, Object object2) {
        return this.compare((Integer)object, (Integer)object2);
    }
}

