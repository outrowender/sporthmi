/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GComparator;
import de.audi.atip.utils.generics.GComparatorWrapper;
import de.audi.atip.utils.generics.GMapWrapper;
import de.audi.atip.utils.generics.GSortedMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class GSortedMapWrapper<K, V>
extends GMapWrapper<K, V>
implements GSortedMap<K, V> {
    private SortedMap sortedBackingMap;
    private GComparator<? super K> comparator;

    protected GSortedMapWrapper() {
    }

    public GSortedMapWrapper(Map map) {
        super(new TreeMap(map));
        this.sortedBackingMap = (SortedMap)this.getBackingMap();
    }

    public GSortedMapWrapper(SortedMap sortedMap) {
        super(sortedMap);
        this.sortedBackingMap = (SortedMap)this.getBackingMap();
    }

    public GSortedMapWrapper(GComparatorWrapper<? super K> gComparatorWrapper) {
        this(new TreeMap(gComparatorWrapper.getBackingComparator()));
        this.comparator = gComparatorWrapper;
    }

    @Override
    public GComparator<? super K> comparator() {
        return this.comparator;
    }

    @Override
    public K firstKey() {
        return (K)this.sortedBackingMap.firstKey();
    }

    @Override
    public GSortedMap<K, V> headMap(K k2) {
        return (GSortedMap)((Object)this.sortedBackingMap.headMap(k2));
    }

    @Override
    public K lastKey() {
        return (K)this.sortedBackingMap.lastKey();
    }

    @Override
    public GSortedMap<K, V> subMap(K k2, K k3) {
        return (GSortedMap)((Object)this.sortedBackingMap.subMap(k2, k3));
    }

    @Override
    public GSortedMap<K, V> tailMap(K k2) {
        return (GSortedMap)((Object)this.sortedBackingMap.tailMap(k2));
    }
}

