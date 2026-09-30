/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.MapEntry;
import java.util.NoSuchElementException;
import java.util.Set;

public class IdentityHashMap
extends AbstractMap
implements Map,
Serializable,
Cloneable {
    private static final long serialVersionUID = 8188218128353913216L;
    transient Object[] elementData;
    int size;
    transient int threshold;
    private static final int DEFAULT_MAX_SIZE = 21;
    private static final int loadFactor = 7500;
    transient int modCount = 0;
    private static final Object NULL_OBJECT = new Object();

    public IdentityHashMap() {
        this(21);
    }

    public IdentityHashMap(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.size = 0;
        this.threshold = this.getThreshold(n);
        this.elementData = this.newElementArray(this.computeElementArraySize());
    }

    private int getThreshold(int n) {
        return n > 3 ? n : 3;
    }

    private int computeElementArraySize() {
        return (int)((long)this.threshold * 10000L / 7500L) * 2;
    }

    private Object[] newElementArray(int n) {
        return new Object[n];
    }

    public IdentityHashMap(Map map) {
        this(map.size() < 6 ? 11 : map.size() * 2);
        this.putAll(map);
    }

    public void clear() {
        this.size = 0;
        int n = 0;
        while (n < this.elementData.length) {
            this.elementData[n] = null;
            ++n;
        }
        ++this.modCount;
    }

    public boolean containsKey(Object object) {
        int n;
        if (object == null) {
            object = NULL_OBJECT;
        }
        return this.elementData[n = this.findIndex(object, this.elementData)] == object;
    }

    public boolean containsValue(Object object) {
        if (object == null) {
            object = NULL_OBJECT;
        }
        int n = 1;
        while (n < this.elementData.length) {
            if (this.elementData[n] == object) {
                return true;
            }
            n += 2;
        }
        return false;
    }

    public Object get(Object object) {
        int n;
        if (object == null) {
            object = NULL_OBJECT;
        }
        if (this.elementData[n = this.findIndex(object, this.elementData)] == object) {
            Object object2 = this.elementData[n + 1];
            return object2 == NULL_OBJECT ? null : object2;
        }
        return null;
    }

    private IdentityHashMapEntry getEntry(Object object) {
        int n;
        if (object == null) {
            object = NULL_OBJECT;
        }
        if (this.elementData[n = this.findIndex(object, this.elementData)] == object) {
            return this.getEntry(n);
        }
        return null;
    }

    private IdentityHashMapEntry getEntry(int n) {
        Object object = this.elementData[n];
        Object object2 = this.elementData[n + 1];
        if (object == NULL_OBJECT) {
            object = null;
        }
        if (object2 == NULL_OBJECT) {
            object2 = null;
        }
        return new IdentityHashMapEntry(object, object2);
    }

    private int findIndex(Object object, Object[] objectArray) {
        int n = objectArray.length;
        int n2 = this.getModuloHash(object, n);
        int n3 = (n2 + n - 2) % n;
        while (n2 != n3) {
            if (objectArray[n2] == object || objectArray[n2] == null) break;
            n2 = (n2 + 2) % n;
        }
        return n2;
    }

    private int getModuloHash(Object object, int n) {
        return (System.identityHashCode(object) & Integer.MAX_VALUE) % (n / 2) * 2;
    }

    public Object put(Object object, Object object2) {
        int n;
        if (object == null) {
            object = NULL_OBJECT;
        }
        if (object2 == null) {
            object2 = NULL_OBJECT;
        }
        if (this.elementData[n = this.findIndex(object, this.elementData)] != object) {
            ++this.modCount;
            if (++this.size > this.threshold) {
                this.rehash();
                n = this.findIndex(object, this.elementData);
            }
            this.elementData[n] = object;
            this.elementData[n + 1] = null;
        }
        Object object3 = this.elementData[n + 1];
        this.elementData[n + 1] = object2;
        return object3 == NULL_OBJECT ? null : object3;
    }

    private void rehash() {
        int n = this.elementData.length << 1;
        if (n == 0) {
            n = 1;
        }
        Object[] objectArray = this.newElementArray(n);
        int n2 = 0;
        while (n2 < this.elementData.length) {
            Object object = this.elementData[n2];
            if (object != null) {
                int n3 = this.findIndex(object, objectArray);
                objectArray[n3] = object;
                objectArray[n3 + 1] = this.elementData[n2 + 1];
            }
            n2 += 2;
        }
        this.elementData = objectArray;
        this.computeMaxSize();
    }

    private void computeMaxSize() {
        this.threshold = (int)((long)(this.elementData.length / 2) * 7500L / 10000L);
    }

    public Object remove(Object object) {
        Object object2;
        int n;
        int n2;
        if (object == null) {
            object = NULL_OBJECT;
        }
        if (this.elementData[n2 = (n = this.findIndex(object, this.elementData))] != object) {
            return null;
        }
        Object object3 = this.elementData[n2 + 1];
        int n3 = this.elementData.length;
        while ((object2 = this.elementData[n = (n + 2) % n3]) != null) {
            boolean bl;
            int n4 = this.getModuloHash(object2, n3);
            boolean bl2 = bl = n4 > n2;
            if (n < n2) {
                bl = bl || n4 <= n;
            } else {
                boolean bl3 = bl = bl && n4 <= n;
            }
            if (bl) continue;
            this.elementData[n2] = object2;
            this.elementData[n2 + 1] = this.elementData[n + 1];
            n2 = n;
        }
        --this.size;
        ++this.modCount;
        this.elementData[n2] = null;
        this.elementData[n2 + 1] = null;
        return object3 == NULL_OBJECT ? null : object3;
    }

    public Set entrySet() {
        return new IdentityHashMapEntrySet(this);
    }

    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new AbstractSet(){

                public boolean contains(Object object) {
                    return IdentityHashMap.this.containsKey(object);
                }

                public int size() {
                    return IdentityHashMap.this.size();
                }

                public void clear() {
                    IdentityHashMap.this.clear();
                }

                public boolean remove(Object object) {
                    if (IdentityHashMap.this.containsKey(object)) {
                        IdentityHashMap.this.remove(object);
                        return true;
                    }
                    return false;
                }

                public Iterator iterator() {
                    return new IdentityHashMapIterator(new MapEntry.Type(){

                        public Object get(MapEntry mapEntry) {
                            return mapEntry.key;
                        }
                    }, IdentityHashMap.this);
                }
            };
        }
        return this.keySet;
    }

    public Collection values() {
        if (this.valuesCollection == null) {
            this.valuesCollection = new AbstractCollection(){

                public boolean contains(Object object) {
                    return IdentityHashMap.this.containsValue(object);
                }

                public int size() {
                    return IdentityHashMap.this.size();
                }

                public void clear() {
                    IdentityHashMap.this.clear();
                }

                public Iterator iterator() {
                    return new IdentityHashMapIterator(new MapEntry.Type(){

                        public Object get(MapEntry mapEntry) {
                            return mapEntry.value;
                        }
                    }, IdentityHashMap.this);
                }

                public boolean remove(Object object) {
                    Iterator iterator = this.iterator();
                    while (iterator.hasNext()) {
                        if (object != iterator.next()) continue;
                        iterator.remove();
                        return true;
                    }
                    return false;
                }
            };
        }
        return this.valuesCollection;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Map) {
            Map map = (Map)object;
            if (this.size() != map.size()) {
                return false;
            }
            Set set = this.entrySet();
            return set.equals(map.entrySet());
        }
        return false;
    }

    public Object clone() {
        try {
            return (IdentityHashMap)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.size);
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            MapEntry mapEntry = (MapEntry)iterator.next();
            objectOutputStream.writeObject(mapEntry.key);
            objectOutputStream.writeObject(mapEntry.value);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int n = objectInputStream.readInt();
        this.threshold = this.getThreshold(21);
        this.elementData = this.newElementArray(this.computeElementArraySize());
        int n2 = n;
        while (--n2 >= 0) {
            Object object = objectInputStream.readObject();
            this.put(object, objectInputStream.readObject());
        }
    }

    static class IdentityHashMapEntry
    extends MapEntry {
        IdentityHashMapEntry(Object object, Object object2) {
            super(object, object2);
        }

        public Object clone() {
            return (IdentityHashMapEntry)super.clone();
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry)object;
                return this.key == entry.getKey() && this.value == entry.getValue();
            }
            return false;
        }

        public int hashCode() {
            return System.identityHashCode(this.key) ^ System.identityHashCode(this.value);
        }

        public String toString() {
            return this.key + "=" + this.value;
        }
    }

    static class IdentityHashMapEntrySet
    extends AbstractSet {
        private final IdentityHashMap associatedMap;

        public IdentityHashMapEntrySet(IdentityHashMap identityHashMap) {
            this.associatedMap = identityHashMap;
        }

        IdentityHashMap hashMap() {
            return this.associatedMap;
        }

        public int size() {
            return this.associatedMap.size;
        }

        public void clear() {
            this.associatedMap.clear();
        }

        public boolean remove(Object object) {
            if (this.contains(object)) {
                this.associatedMap.remove(((Map.Entry)object).getKey());
                return true;
            }
            return false;
        }

        public boolean contains(Object object) {
            if (object instanceof Map.Entry) {
                IdentityHashMapEntry identityHashMapEntry = this.associatedMap.getEntry(((Map.Entry)object).getKey());
                return identityHashMapEntry != null && identityHashMapEntry.equals(object);
            }
            return false;
        }

        public Iterator iterator() {
            return new IdentityHashMapIterator(new MapEntry.Type(){

                public Object get(MapEntry mapEntry) {
                    return mapEntry;
                }
            }, this.associatedMap);
        }
    }

    static class IdentityHashMapIterator
    implements Iterator {
        private int position = 0;
        private int lastPosition = 0;
        final IdentityHashMap associatedMap;
        int expectedModCount;
        final MapEntry.Type type;
        boolean canRemove = false;

        IdentityHashMapIterator(MapEntry.Type type, IdentityHashMap identityHashMap) {
            this.associatedMap = identityHashMap;
            this.type = type;
            this.expectedModCount = identityHashMap.modCount;
        }

        public boolean hasNext() {
            while (this.position < this.associatedMap.elementData.length) {
                if (this.associatedMap.elementData[this.position] == null) {
                    this.position += 2;
                    continue;
                }
                return true;
            }
            return false;
        }

        void checkConcurrentMod() throws ConcurrentModificationException {
            if (this.expectedModCount != this.associatedMap.modCount) {
                throw new ConcurrentModificationException();
            }
        }

        public Object next() {
            this.checkConcurrentMod();
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            IdentityHashMapEntry identityHashMapEntry = this.associatedMap.getEntry(this.position);
            this.lastPosition = this.position;
            this.position += 2;
            this.canRemove = true;
            return this.type.get(identityHashMapEntry);
        }

        public void remove() {
            this.checkConcurrentMod();
            if (!this.canRemove) {
                throw new IllegalStateException();
            }
            this.canRemove = false;
            this.associatedMap.remove(this.associatedMap.elementData[this.lastPosition]);
            this.position = this.lastPosition;
            ++this.expectedModCount;
        }
    }
}

