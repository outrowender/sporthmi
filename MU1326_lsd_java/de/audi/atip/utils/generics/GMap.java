/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GCollection;
import de.audi.atip.utils.generics.GSet;
import java.util.Map;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface GMap<K, V> {
    public void clear();

    public boolean containsKey(K var1);

    public boolean containsValue(V var1);

    public GSet<GEntry<K, V>> entrySet();

    public V get(K var1);

    public boolean isEmpty();

    public GSet<K> keySet();

    public V put(K var1, V var2);

    public void putAll(GMap<K, V> var1);

    public V remove(K var1);

    public int size();

    public GCollection<V> values();

    public Map getBackingMap();

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface GEntry<K, V> {
        public boolean equals(Object var1);

        public K getKey();

        public V getValue();

        public int hashCode();

        public V setValue(V var1);
    }
}

