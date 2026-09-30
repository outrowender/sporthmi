/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.generics.GCollection;
import de.audi.atip.utils.generics.GCollectionWrapper;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.GSet;
import de.audi.atip.utils.generics.GSetWrapper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class GMapWrapper<K, V>
implements GMap<K, V> {
    protected Map backingMap;

    protected GMapWrapper() {
    }

    public GMapWrapper(Map map) {
        Preconditions.checkNotNull(map);
        this.backingMap = map;
    }

    @Override
    public void clear() {
        this.backingMap.clear();
    }

    @Override
    public boolean containsKey(K k2) {
        return this.backingMap.containsKey(k2);
    }

    @Override
    public boolean containsValue(V v) {
        return this.backingMap.containsValue(v);
    }

    @Override
    public GSet<GMap.GEntry<K, V>> entrySet() {
        Set set = this.backingMap.entrySet();
        GSetWrapper<GMap.GEntry<K, V>> gSetWrapper = new GSetWrapper<GMap.GEntry<K, V>>(new HashSet(set.size()));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            gSetWrapper.add(new GEntryWrapper(entry));
        }
        return gSetWrapper;
    }

    @Override
    public V get(K k2) {
        return (V)this.backingMap.get(k2);
    }

    @Override
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override
    public GSet<K> keySet() {
        return new GSetWrapper(this.backingMap.keySet());
    }

    @Override
    public V put(K k2, V v) {
        return (V)this.backingMap.put(k2, v);
    }

    @Override
    public void putAll(GMap<K, V> gMap) {
        Preconditions.checkNotNull(gMap);
        Map map = gMap.getBackingMap();
        Preconditions.checkNotNull(map);
        this.backingMap.putAll(map);
    }

    @Override
    public V remove(K k2) {
        return (V)this.backingMap.remove(k2);
    }

    @Override
    public int size() {
        return this.backingMap.size();
    }

    @Override
    public GCollection<V> values() {
        return new GCollectionWrapper(this.backingMap.values());
    }

    @Override
    public Map getBackingMap() {
        return this.backingMap;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        GMapWrapper gMapWrapper = (GMapWrapper)object;
        return !(this.backingMap == null ? gMapWrapper.backingMap != null : !((Object)this.backingMap).equals(gMapWrapper.backingMap));
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.backingMap == null ? 0 : ((Object)this.backingMap).hashCode());
        return n;
    }

    public String toString() {
        return this.backingMap.toString();
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class GEntryWrapper<K, V>
    implements GMap.GEntry<K, V> {
        private final Map.Entry entry;

        GEntryWrapper(Map.Entry entry) {
            this.entry = entry;
        }

        @Override
        public K getKey() {
            return (K)this.entry.getKey();
        }

        @Override
        public V getValue() {
            return (V)this.entry.getValue();
        }

        @Override
        public V setValue(V v) {
            return (V)this.entry.setValue(v);
        }
    }
}

