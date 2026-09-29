/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.collections;

import de.audi.atip.utils.collections.CopyOnWriteMap$CopyOnWriteMapEntriesCollection;
import de.audi.atip.utils.collections.CopyOnWriteMap$CopyOnWriteMapSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CopyOnWriteMap
implements Map {
    private volatile Map realMap;

    public CopyOnWriteMap(int n) {
        this.realMap = new HashMap(n);
    }

    public CopyOnWriteMap(Map map) {
        this.realMap = new HashMap(map);
    }

    public CopyOnWriteMap() {
        this.realMap = new HashMap();
    }

    @Override
    public synchronized void clear() {
        HashMap hashMap = new HashMap();
        hashMap.clear();
        this.realMap = hashMap;
    }

    @Override
    public boolean containsKey(Object object) {
        return this.realMap.containsKey(object);
    }

    @Override
    public boolean containsValue(Object object) {
        return this.realMap.containsValue(object);
    }

    @Override
    public Set entrySet() {
        return new CopyOnWriteMap$CopyOnWriteMapSet(this, this.realMap.entrySet());
    }

    @Override
    public Object get(Object object) {
        return this.realMap.get(object);
    }

    @Override
    public boolean isEmpty() {
        return this.realMap.isEmpty();
    }

    @Override
    public Set keySet() {
        return new CopyOnWriteMap$CopyOnWriteMapSet(this, this.realMap.keySet());
    }

    @Override
    public synchronized Object put(Object object, Object object2) {
        HashMap hashMap = new HashMap(this.realMap);
        Object object3 = hashMap.put(object, object2);
        this.realMap = hashMap;
        return object3;
    }

    @Override
    public synchronized void putAll(Map map) {
        HashMap hashMap = new HashMap(this.realMap);
        hashMap.putAll(map);
        this.realMap = hashMap;
    }

    @Override
    public synchronized Object remove(Object object) {
        HashMap hashMap = new HashMap(this.realMap);
        Object object2 = hashMap.remove(object);
        this.realMap = hashMap;
        return object2;
    }

    @Override
    public int size() {
        return this.realMap.size();
    }

    @Override
    public Collection values() {
        return new CopyOnWriteMap$CopyOnWriteMapEntriesCollection(this, this.realMap.values());
    }

    public synchronized void putIfAbsent(Object object, Object object2) {
        if (!this.realMap.containsKey(object)) {
            this.realMap.put(object, object2);
        }
    }

    @Override
    public boolean equals(Object object) {
        return ((Object)this.realMap).equals(object);
    }

    @Override
    public int hashCode() {
        return ((Object)this.realMap).hashCode();
    }

    public String toString() {
        return this.realMap.toString();
    }
}

