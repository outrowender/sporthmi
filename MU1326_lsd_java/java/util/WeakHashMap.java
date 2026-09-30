/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class WeakHashMap
extends AbstractMap
implements Map {
    private final ReferenceQueue referenceQueue;
    int elementCount;
    Entry[] elementData;
    private final int loadFactor;
    private int threshold;
    transient int modCount = 0;
    private static final int DEFAULT_SIZE = 16;

    public WeakHashMap() {
        this(16);
    }

    public WeakHashMap(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.elementCount = 0;
        this.elementData = new Entry[n == 0 ? 1 : n];
        this.loadFactor = 7500;
        this.computeMaxSize();
        this.referenceQueue = new ReferenceQueue();
    }

    public WeakHashMap(int n, float f2) {
        if (n < 0 || !(f2 > 0.0f)) {
            throw new IllegalArgumentException();
        }
        this.elementCount = 0;
        this.elementData = new Entry[n == 0 ? 1 : n];
        this.loadFactor = (int)(f2 * 10000.0f);
        this.computeMaxSize();
        this.referenceQueue = new ReferenceQueue();
    }

    public WeakHashMap(Map map) {
        this(map.size() < 6 ? 11 : map.size() * 2);
        this.putAll(map);
    }

    public void clear() {
        if (this.elementCount > 0) {
            this.elementCount = 0;
            Arrays.fill(this.elementData, null);
            ++this.modCount;
            while (this.referenceQueue.poll() != null) {
            }
        }
    }

    private void computeMaxSize() {
        this.threshold = (int)((long)this.elementData.length * (long)this.loadFactor / 10000L);
    }

    public boolean containsKey(Object object) {
        return this.getEntry(object) != null;
    }

    public Set entrySet() {
        this.poll();
        return new AbstractSet(){

            public int size() {
                return WeakHashMap.this.size();
            }

            public void clear() {
                WeakHashMap.this.clear();
            }

            public boolean remove(Object object) {
                if (this.contains(object)) {
                    WeakHashMap.this.remove(((Map.Entry)object).getKey());
                    return true;
                }
                return false;
            }

            public boolean contains(Object object) {
                Object object2;
                Entry entry;
                if (object instanceof Map.Entry && (entry = WeakHashMap.this.getEntry(((Map.Entry)object).getKey())) != null && ((object2 = entry.get()) != null || entry.isNull)) {
                    return object.equals(entry);
                }
                return false;
            }

            public Iterator iterator() {
                return new HashIterator(new Entry.Type(){

                    public Object get(Map.Entry entry) {
                        return entry;
                    }
                });
            }
        };
    }

    public Set keySet() {
        this.poll();
        if (this.keySet == null) {
            this.keySet = new AbstractSet(){

                public boolean contains(Object object) {
                    return WeakHashMap.this.containsKey(object);
                }

                public int size() {
                    return WeakHashMap.this.size();
                }

                public void clear() {
                    WeakHashMap.this.clear();
                }

                public boolean remove(Object object) {
                    if (WeakHashMap.this.containsKey(object)) {
                        WeakHashMap.this.remove(object);
                        return true;
                    }
                    return false;
                }

                public Iterator iterator() {
                    return new HashIterator(new Entry.Type(){

                        public Object get(Map.Entry entry) {
                            return entry.getKey();
                        }
                    });
                }
            };
        }
        return this.keySet;
    }

    public Collection values() {
        this.poll();
        if (this.valuesCollection == null) {
            this.valuesCollection = new AbstractCollection(){

                public int size() {
                    return WeakHashMap.this.size();
                }

                public void clear() {
                    WeakHashMap.this.clear();
                }

                public boolean contains(Object object) {
                    return WeakHashMap.this.containsValue(object);
                }

                public Iterator iterator() {
                    return new HashIterator(new Entry.Type(){

                        public Object get(Map.Entry entry) {
                            return entry.getValue();
                        }
                    });
                }
            };
        }
        return this.valuesCollection;
    }

    public Object get(Object object) {
        this.poll();
        if (object != null) {
            int n = (object.hashCode() & Integer.MAX_VALUE) % this.elementData.length;
            Entry entry = this.elementData[n];
            while (entry != null) {
                if (object.equals(entry.get())) {
                    return entry.value;
                }
                entry = entry.next;
            }
            return null;
        }
        Entry entry = this.elementData[0];
        while (entry != null) {
            if (entry.isNull) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    Entry getEntry(Object object) {
        this.poll();
        if (object != null) {
            int n = (object.hashCode() & Integer.MAX_VALUE) % this.elementData.length;
            Entry entry = this.elementData[n];
            while (entry != null) {
                if (object.equals(entry.get())) {
                    return entry;
                }
                entry = entry.next;
            }
            return null;
        }
        Entry entry = this.elementData[0];
        while (entry != null) {
            if (entry.isNull) {
                return entry;
            }
            entry = entry.next;
        }
        return null;
    }

    public boolean containsValue(Object object) {
        this.poll();
        if (object != null) {
            int n = this.elementData.length;
            while (--n >= 0) {
                Entry entry = this.elementData[n];
                while (entry != null) {
                    Object object2 = entry.get();
                    if ((object2 != null || entry.isNull) && object.equals(entry.value)) {
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
                    Object object3 = entry.get();
                    if ((object3 != null || entry.isNull) && entry.value == null) {
                        return true;
                    }
                    entry = entry.next;
                }
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    void poll() {
        Entry entry;
        while ((entry = (Entry)this.referenceQueue.poll()) != null) {
            this.removeEntry(entry);
        }
    }

    void removeEntry(Entry entry) {
        Entry entry2 = null;
        int n = (entry.hash & Integer.MAX_VALUE) % this.elementData.length;
        Entry entry3 = this.elementData[n];
        while (entry3 != null) {
            if (entry == entry3) {
                ++this.modCount;
                if (entry2 == null) {
                    this.elementData[n] = entry3.next;
                } else {
                    entry2.next = entry3.next;
                }
                --this.elementCount;
                break;
            }
            entry2 = entry3;
            entry3 = entry3.next;
        }
    }

    public Object put(Object object, Object object2) {
        Entry entry;
        this.poll();
        int n = 0;
        if (object != null) {
            n = (object.hashCode() & Integer.MAX_VALUE) % this.elementData.length;
            entry = this.elementData[n];
            while (entry != null && !object.equals(entry.get())) {
                entry = entry.next;
            }
        } else {
            entry = this.elementData[0];
            while (entry != null && !entry.isNull) {
                entry = entry.next;
            }
        }
        if (entry == null) {
            ++this.modCount;
            if (++this.elementCount > this.threshold) {
                this.rehash();
                n = object == null ? 0 : (object.hashCode() & Integer.MAX_VALUE) % this.elementData.length;
            }
            entry = new Entry(object, object2, this.referenceQueue);
            entry.next = this.elementData[n];
            this.elementData[n] = entry;
            return null;
        }
        Object object3 = entry.value;
        entry.value = object2;
        return object3;
    }

    private void rehash() {
        int n = this.elementData.length << 1;
        if (n == 0) {
            n = 1;
        }
        Entry[] entryArray = new Entry[n];
        int n2 = 0;
        while (n2 < this.elementData.length) {
            Entry entry = this.elementData[n2];
            while (entry != null) {
                int n3 = entry.isNull ? 0 : (entry.hash & Integer.MAX_VALUE) % n;
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
        Entry entry;
        this.poll();
        int n = 0;
        Entry entry2 = null;
        if (object != null) {
            n = (object.hashCode() & Integer.MAX_VALUE) % this.elementData.length;
            entry = this.elementData[n];
            while (entry != null && !object.equals(entry.get())) {
                entry2 = entry;
                entry = entry.next;
            }
        } else {
            entry = this.elementData[0];
            while (entry != null && !entry.isNull) {
                entry2 = entry;
                entry = entry.next;
            }
        }
        if (entry != null) {
            ++this.modCount;
            if (entry2 == null) {
                this.elementData[n] = entry.next;
            } else {
                entry2.next = entry.next;
            }
            --this.elementCount;
            return entry.value;
        }
        return null;
    }

    public int size() {
        this.poll();
        return this.elementCount;
    }

    private static final class Entry
    extends WeakReference
    implements Map.Entry {
        int hash;
        boolean isNull;
        Object value;
        Entry next;

        Entry(Object object, Object object2, ReferenceQueue referenceQueue) {
            super(object, referenceQueue);
            this.isNull = object == null;
            this.hash = this.isNull ? 0 : object.hashCode();
            this.value = object2;
        }

        public Object getKey() {
            return super.get();
        }

        public Object getValue() {
            return this.value;
        }

        public Object setValue(Object object) {
            Object object2 = this.value;
            this.value = object;
            return object2;
        }

        public boolean equals(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry)object;
            Object object2 = super.get();
            return (object2 == null ? object2 == entry.getKey() : object2.equals(entry.getKey())) && (this.value == null ? this.value == entry.getValue() : this.value.equals(entry.getValue()));
        }

        public int hashCode() {
            return this.hash + (this.value == null ? 0 : this.value.hashCode());
        }

        public String toString() {
            return super.get() + "=" + this.value;
        }

        static interface Type {
            public Object get(Map.Entry var1);
        }
    }

    class HashIterator
    implements Iterator {
        private int position = 0;
        private int expectedModCount;
        private Entry currentEntry;
        private Entry nextEntry;
        private Object nextKey;
        final Entry.Type type;

        HashIterator(Entry.Type type) {
            this.type = type;
            this.expectedModCount = WeakHashMap.this.modCount;
        }

        public boolean hasNext() {
            if (this.nextEntry != null) {
                return true;
            }
            while (true) {
                if (this.nextEntry == null) {
                    while (this.position < WeakHashMap.this.elementData.length) {
                        if ((this.nextEntry = WeakHashMap.this.elementData[this.position++]) != null) break;
                    }
                    if (this.nextEntry == null) {
                        return false;
                    }
                }
                this.nextKey = this.nextEntry.get();
                if (this.nextKey != null || this.nextEntry.isNull) {
                    return true;
                }
                this.nextEntry = this.nextEntry.next;
            }
        }

        public Object next() {
            if (this.expectedModCount == WeakHashMap.this.modCount) {
                if (this.hasNext()) {
                    this.currentEntry = this.nextEntry;
                    this.nextEntry = this.currentEntry.next;
                    Object object = this.type.get(this.currentEntry);
                    this.nextKey = null;
                    return object;
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public void remove() {
            if (this.expectedModCount != WeakHashMap.this.modCount) throw new ConcurrentModificationException();
            if (this.currentEntry == null) throw new IllegalStateException();
            WeakHashMap.this.removeEntry(this.currentEntry);
            this.currentEntry = null;
            ++this.expectedModCount;
        }
    }
}

