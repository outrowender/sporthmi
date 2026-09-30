/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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

    public synchronized void clear() {
        HashMap hashMap = new HashMap();
        hashMap.clear();
        this.realMap = hashMap;
    }

    public boolean containsKey(Object object) {
        return this.realMap.containsKey(object);
    }

    public boolean containsValue(Object object) {
        return this.realMap.containsValue(object);
    }

    public Set entrySet() {
        return new CopyOnWriteMapSet(this.realMap.entrySet());
    }

    public Object get(Object object) {
        return this.realMap.get(object);
    }

    public boolean isEmpty() {
        return this.realMap.isEmpty();
    }

    public Set keySet() {
        return new CopyOnWriteMapSet(this.realMap.keySet());
    }

    public synchronized Object put(Object object, Object object2) {
        HashMap hashMap = new HashMap(this.realMap);
        Object object3 = hashMap.put(object, object2);
        this.realMap = hashMap;
        return object3;
    }

    public synchronized void putAll(Map map) {
        HashMap hashMap = new HashMap(this.realMap);
        hashMap.putAll(map);
        this.realMap = hashMap;
    }

    public synchronized Object remove(Object object) {
        HashMap hashMap = new HashMap(this.realMap);
        Object object2 = hashMap.remove(object);
        this.realMap = hashMap;
        return object2;
    }

    public int size() {
        return this.realMap.size();
    }

    public Collection values() {
        return new CopyOnWriteMapEntriesCollection(this.realMap.values());
    }

    public synchronized void putIfAbsent(Object object, Object object2) {
        if (!this.realMap.containsKey(object)) {
            this.realMap.put(object, object2);
        }
    }

    public boolean equals(Object object) {
        return ((Object)this.realMap).equals(object);
    }

    public int hashCode() {
        return ((Object)this.realMap).hashCode();
    }

    public String toString() {
        return this.realMap.toString();
    }

    private class CopyOnWriteMapSet
    implements Set {
        private final Set realSet;

        public CopyOnWriteMapSet(Set set) {
            this.realSet = set;
        }

        public boolean add(Object object) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
        }

        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
        }

        public void clear() {
            throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
        }

        public boolean contains(Object object) {
            return this.realSet.contains(object);
        }

        public boolean containsAll(Collection collection) {
            return this.realSet.containsAll(collection);
        }

        public boolean isEmpty() {
            return this.realSet.isEmpty();
        }

        public Iterator iterator() {
            return new CopyOnWriteIterator(this.realSet.iterator());
        }

        public boolean remove(Object object) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
        }

        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
        }

        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
        }

        public int size() {
            return this.realSet.size();
        }

        public Object[] toArray() {
            return this.realSet.toArray();
        }

        public Object[] toArray(Object[] objectArray) {
            return this.realSet.toArray(objectArray);
        }
    }

    private class CopyOnWriteIterator
    implements Iterator {
        private final Iterator realIterator;

        public CopyOnWriteIterator(Iterator iterator) {
            this.realIterator = iterator;
        }

        public boolean hasNext() {
            return this.realIterator.hasNext();
        }

        public Object next() {
            return this.realIterator.next();
        }

        public void remove() {
            throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
        }
    }

    private class CopyOnWriteMapEntriesCollection
    implements Collection {
        private final Collection realCollection;

        public CopyOnWriteMapEntriesCollection(Collection collection) {
            this.realCollection = collection;
        }

        public boolean add(Object object) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
        }

        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
        }

        public void clear() {
            throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
        }

        public boolean contains(Object object) {
            return this.realCollection.contains(object);
        }

        public boolean containsAll(Collection collection) {
            return this.realCollection.containsAll(collection);
        }

        public boolean isEmpty() {
            return this.realCollection.isEmpty();
        }

        public Iterator iterator() {
            return new CopyOnWriteIterator(this.realCollection.iterator());
        }

        public boolean remove(Object object) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
        }

        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
        }

        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException("not supported by CopyOnWriteMap");
        }

        public int size() {
            return this.realCollection.size();
        }

        public Object[] toArray() {
            return this.realCollection.toArray();
        }

        public Object[] toArray(Object[] objectArray) {
            return this.realCollection.toArray(objectArray);
        }
    }
}

