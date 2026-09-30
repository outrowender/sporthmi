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
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.MapEntry;
import java.util.NoSuchElementException;
import java.util.Set;

public class HashMap
extends AbstractMap
implements Map,
Cloneable,
Serializable {
    private static final long serialVersionUID = 362498820763181265L;
    transient int elementCount;
    transient Entry[] elementData;
    final float loadFactor;
    int threshold;
    transient int modCount = 0;
    private static final int DEFAULT_SIZE = 16;

    Entry[] newElementArray(int n) {
        return new Entry[n];
    }

    public HashMap() {
        this(16);
    }

    public HashMap(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.elementCount = 0;
        this.elementData = this.newElementArray(n == 0 ? 1 : n);
        this.loadFactor = 0.75f;
        this.computeMaxSize();
    }

    public HashMap(int n, float f2) {
        if (n < 0 || !(f2 > 0.0f)) {
            throw new IllegalArgumentException();
        }
        this.elementCount = 0;
        this.elementData = this.newElementArray(n == 0 ? 1 : n);
        this.loadFactor = f2;
        this.computeMaxSize();
    }

    public HashMap(Map map) {
        this(map.size() < 6 ? 11 : map.size() * 2);
        this.putAll(map);
    }

    public void clear() {
        if (this.elementCount > 0) {
            this.elementCount = 0;
            Arrays.fill(this.elementData, null);
            ++this.modCount;
        }
    }

    public Object clone() {
        try {
            HashMap hashMap = (HashMap)super.clone();
            hashMap.elementData = this.newElementArray(this.elementData.length);
            int n = 0;
            while (n < this.elementData.length) {
                Entry entry = this.elementData[n];
                if (entry != null) {
                    hashMap.elementData[n] = (Entry)entry.clone();
                }
                ++n;
            }
            return hashMap;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    private void computeMaxSize() {
        this.threshold = (int)((float)this.elementData.length * this.loadFactor);
    }

    public boolean containsKey(Object object) {
        return this.getEntry(object) != null;
    }

    public boolean containsValue(Object object) {
        if (object != null) {
            int n = this.elementData.length;
            while (--n >= 0) {
                Entry entry = this.elementData[n];
                while (entry != null) {
                    if (object.equals(entry.value)) {
                        return true;
                    }
                    entry = entry.next;
                }
            }
        } else {
            int n = this.elementData.length;
            while (--n >= 0) {
                Entry entry = this.elementData[n];
                while (entry != null) {
                    if (entry.value == null) {
                        return true;
                    }
                    entry = entry.next;
                }
            }
        }
        return false;
    }

    public Set entrySet() {
        return new HashMapEntrySet(this);
    }

    public Object get(Object object) {
        Entry entry = this.getEntry(object);
        if (entry != null) {
            return entry.value;
        }
        return null;
    }

    Entry getEntry(Object object) {
        int n = this.getModuloHash(object);
        return this.findEntry(object, n);
    }

    int getModuloHash(Object object) {
        if (object == null) {
            return 0;
        }
        return (object.hashCode() & Integer.MAX_VALUE) % this.elementData.length;
    }

    /*
     * Unable to fully structure code
     */
    Entry findEntry(Object var1_1, int var2_2) {
        block2: {
            var3_3 = this.elementData[var2_2];
            if (var1_1 == null) ** GOTO lbl8
            while (var3_3 != null && !var3_3.equalsKey(var1_1, var1_1.hashCode())) {
                var3_3 = var3_3.next;
            }
            break block2;
lbl-1000:
            // 1 sources

            {
                var3_3 = var3_3.next;
lbl8:
                // 2 sources

                ** while (var3_3 != null && var3_3.key != null)
            }
        }
        return var3_3;
    }

    public boolean isEmpty() {
        return this.elementCount == 0;
    }

    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new AbstractSet(){

                public boolean contains(Object object) {
                    return HashMap.this.containsKey(object);
                }

                public int size() {
                    return HashMap.this.size();
                }

                public void clear() {
                    HashMap.this.clear();
                }

                public boolean remove(Object object) {
                    if (HashMap.this.containsKey(object)) {
                        HashMap.this.remove(object);
                        return true;
                    }
                    return false;
                }

                public Iterator iterator() {
                    return new HashMapIterator(new MapEntry.Type(){

                        public Object get(MapEntry mapEntry) {
                            return mapEntry.key;
                        }
                    }, HashMap.this);
                }
            };
        }
        return this.keySet;
    }

    public Object put(Object object, Object object2) {
        int n = this.getModuloHash(object);
        Entry entry = this.findEntry(object, n);
        if (entry == null) {
            ++this.modCount;
            if (++this.elementCount > this.threshold) {
                this.rehash();
                n = object == null ? 0 : (object.hashCode() & Integer.MAX_VALUE) % this.elementData.length;
            }
            entry = this.createEntry(object, n, null);
        }
        Object object3 = entry.value;
        entry.value = object2;
        return object3;
    }

    Entry createEntry(Object object, int n, Object object2) {
        Entry entry = new Entry(object, object2);
        entry.next = this.elementData[n];
        this.elementData[n] = entry;
        return entry;
    }

    public void putAll(Map map) {
        super.putAll(map);
    }

    void rehash() {
        int n = this.elementData.length << 1;
        if (n == 0) {
            n = 1;
        }
        Entry[] entryArray = this.newElementArray(n);
        int n2 = 0;
        while (n2 < this.elementData.length) {
            Entry entry = this.elementData[n2];
            while (entry != null) {
                Object object = entry.key;
                int n3 = object == null ? 0 : (object.hashCode() & Integer.MAX_VALUE) % n;
                Entry entry2 = entry.next;
                entry.next = entryArray[n3];
                entryArray[n3] = entry;
                entry = entry2;
            }
            ++n2;
        }
        this.elementData = entryArray;
        this.computeMaxSize();
    }

    public Object remove(Object object) {
        Entry entry = this.removeEntry(object);
        if (entry != null) {
            return entry.value;
        }
        return null;
    }

    Entry removeEntry(Object object) {
        Entry entry;
        int n = 0;
        Entry entry2 = null;
        if (object != null) {
            n = (object.hashCode() & Integer.MAX_VALUE) % this.elementData.length;
            entry = this.elementData[n];
            while (entry != null && !entry.equalsKey(object, object.hashCode())) {
                entry2 = entry;
                entry = entry.next;
            }
        } else {
            entry = this.elementData[0];
            while (entry != null && entry.key != null) {
                entry2 = entry;
                entry = entry.next;
            }
        }
        if (entry == null) {
            return null;
        }
        if (entry2 == null) {
            this.elementData[n] = entry.next;
        } else {
            entry2.next = entry.next;
        }
        ++this.modCount;
        --this.elementCount;
        return entry;
    }

    public int size() {
        return this.elementCount;
    }

    public Collection values() {
        if (this.valuesCollection == null) {
            this.valuesCollection = new AbstractCollection(){

                public boolean contains(Object object) {
                    return HashMap.this.containsValue(object);
                }

                public int size() {
                    return HashMap.this.size();
                }

                public void clear() {
                    HashMap.this.clear();
                }

                public Iterator iterator() {
                    return new HashMapIterator(new MapEntry.Type(){

                        public Object get(MapEntry mapEntry) {
                            return mapEntry.value;
                        }
                    }, HashMap.this);
                }
            };
        }
        return this.valuesCollection;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.elementData.length);
        objectOutputStream.writeInt(this.elementCount);
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry entry = (Entry)iterator.next();
            objectOutputStream.writeObject(entry.key);
            objectOutputStream.writeObject(entry.value);
            entry = entry.next;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int n = objectInputStream.readInt();
        this.elementData = new Entry[n];
        int n2 = this.elementCount = objectInputStream.readInt();
        while (--n2 >= 0) {
            Object object = objectInputStream.readObject();
            int n3 = (object.hashCode() & Integer.MAX_VALUE) % n;
            this.createEntry(object, n3, objectInputStream.readObject());
        }
    }

    static class Entry
    extends MapEntry {
        Entry next;

        Entry(Object object, Object object2) {
            super(object, object2);
        }

        public Object clone() {
            Entry entry = (Entry)super.clone();
            if (this.next != null) {
                entry.next = (Entry)this.next.clone();
            }
            return entry;
        }

        public boolean equalsKey(Object object, int n) {
            if (this.key != null) {
                return this.key.equals(object);
            }
            return object == null;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }
    }

    static class HashMapEntrySet
    extends AbstractSet {
        private final HashMap associatedMap;

        public HashMapEntrySet(HashMap hashMap) {
            this.associatedMap = hashMap;
        }

        HashMap hashMap() {
            return this.associatedMap;
        }

        public int size() {
            return this.associatedMap.elementCount;
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
                Entry entry = this.associatedMap.getEntry(((Map.Entry)object).getKey());
                return object.equals(entry);
            }
            return false;
        }

        public Iterator iterator() {
            return new HashMapIterator(new MapEntry.Type(){

                public Object get(MapEntry mapEntry) {
                    return mapEntry;
                }
            }, this.associatedMap);
        }
    }

    static class HashMapIterator
    implements Iterator {
        private int position = 0;
        int expectedModCount;
        final MapEntry.Type type;
        boolean canRemove = false;
        Entry entry;
        Entry lastEntry;
        final HashMap associatedMap;

        HashMapIterator(MapEntry.Type type, HashMap hashMap) {
            this.associatedMap = hashMap;
            this.type = type;
            this.expectedModCount = hashMap.modCount;
        }

        /*
         * Unable to fully structure code
         */
        public boolean hasNext() {
            if (this.entry == null) ** GOTO lbl7
            return true;
lbl-1000:
            // 1 sources

            {
                if (this.associatedMap.elementData[this.position] == null) {
                    ++this.position;
                    continue;
                }
                return true;
lbl7:
                // 2 sources

                ** while (this.position < this.associatedMap.elementData.length)
            }
lbl8:
            // 1 sources

            return false;
        }

        void checkConcurrentMod() throws ConcurrentModificationException {
            if (this.expectedModCount != this.associatedMap.modCount) {
                throw new ConcurrentModificationException();
            }
        }

        public Object next() {
            Entry entry;
            this.checkConcurrentMod();
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.entry == null) {
                entry = this.lastEntry = this.associatedMap.elementData[this.position++];
                this.entry = this.lastEntry.next;
            } else {
                if (this.lastEntry.next != this.entry) {
                    this.lastEntry = this.lastEntry.next;
                }
                entry = this.entry;
                this.entry = this.entry.next;
            }
            this.canRemove = true;
            return this.type.get(entry);
        }

        public void remove() {
            this.checkConcurrentMod();
            if (!this.canRemove) {
                throw new IllegalStateException();
            }
            this.canRemove = false;
            ++this.associatedMap.modCount;
            if (this.lastEntry.next == this.entry) {
                while (this.associatedMap.elementData[--this.position] == null) {
                }
                this.associatedMap.elementData[this.position] = this.associatedMap.elementData[this.position].next;
                this.entry = null;
            } else {
                this.lastEntry.next = this.entry;
            }
            --this.associatedMap.elementCount;
            ++this.expectedModCount;
        }
    }
}

