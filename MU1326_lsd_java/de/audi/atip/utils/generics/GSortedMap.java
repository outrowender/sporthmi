/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GComparator;
import de.audi.atip.utils.generics.GMap;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface GSortedMap<K, V>
extends GMap<K, V> {
    public GComparator<? super K> comparator();

    public K firstKey();

    public GSortedMap<K, V> headMap(K var1);

    public K lastKey();

    public GSortedMap<K, V> subMap(K var1, K var2);

    public GSortedMap<K, V> tailMap(K var1);
}

