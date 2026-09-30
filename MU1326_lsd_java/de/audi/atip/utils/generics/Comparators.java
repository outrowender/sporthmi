/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GComparator;

public class Comparators {
    public static final GComparator<Integer> INTEGER_ASCENDING = new GComparator<Integer>(){

        @Override
        public int compare(Integer n, Integer n2) {
            return n.compareTo(n2);
        }

        @Override
        public /* synthetic */ int compare(Object object, Object object2) {
            return this.compare((Integer)object, (Integer)object2);
        }
    };
    public static final GComparator<Integer> INTEGER_DESCENDING = new GComparator<Integer>(){

        @Override
        public int compare(Integer n, Integer n2) {
            return n2.compareTo(n);
        }

        @Override
        public /* synthetic */ int compare(Object object, Object object2) {
            return this.compare((Integer)object, (Integer)object2);
        }
    };
}

