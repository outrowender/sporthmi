/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.MapEntry;
import java.util.NoSuchElementException;
import java.util.Set;

public class Hashtable
extends Dictionary
implements Map,
Cloneable,
Serializable {
    private static final long serialVersionUID = 1421746759512286392L;
    transient int elementCount;
    transient Entry[] elementData;
    private float loadFactor;
    private int threshold;
    transient int firstSlot = 0;
    transient int lastSlot = -1;
    transient int modCount = 0;
    private static final Enumeration emptyEnumerator = new Hashtable(0).getEmptyEnumerator();

    private static Entry newEntry(Object object, Object object2, int n) {
        return new Entry(object, object2);
    }

    public Hashtable() {
        this(11);
    }

    public Hashtable(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.elementCount = 0;
        this.elementData = new Entry[n == 0 ? 1 : n];
        this.firstSlot = this.elementData.length;
        this.loadFactor = 0.75f;
        this.computeMaxSize();
    }

    public Hashtable(int n, float f2) {
        if (n < 0 || !(f2 > 0.0f)) {
            throw new IllegalArgumentException();
        }
        this.elementCount = 0;
        this.firstSlot = n;
        this.elementData = new Entry[n == 0 ? 1 : n];
        this.loadFactor = f2;
        this.computeMaxSize();
    }

    public Hashtable(Map map) {
        this(map.size() < 6 ? 11 : map.size() * 4 / 3 + 11);
        this.putAll(map);
    }

    private HashEnumerator getEmptyEnumerator() {
        return new HashEnumerator(false);
    }

    public synchronized void clear() {
        this.elementCount = 0;
        Arrays.fill(this.elementData, null);
        ++this.modCount;
    }

    public synchronized Object clone() {
        try {
            Hashtable hashtable = (Hashtable)super.clone();
            hashtable.elementData = new Entry[this.elementData.length];
            int n = this.elementData.length;
            while (--n >= 0) {
                Entry entry = this.elementData[n];
                if (entry == null) continue;
                hashtable.elementData[n] = (Entry)entry.clone();
            }
            return hashtable;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    private void computeMaxSize() {
        this.threshold = (int)((float)this.elementData.length * this.loadFactor);
    }

    public synchronized boolean contains(Object object) {
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
            return false;
        }
        throw new NullPointerException();
    }

    public synchronized boolean containsKey(Object object) {
        return this.getEntry(object) != null;
    }

    public boolean containsValue(Object object) {
        return this.contains(object);
    }

    public synchronized Enumeration elements() {
        if (this.elementCount == 0) {
            return emptyEnumerator;
        }
        return new HashEnumerator(false);
    }

    public Set entrySet() {
        return new Collections.SynchronizedSet(new AbstractSet(){

            public int size() {
                return Hashtable.this.elementCount;
            }

            public void clear() {
                Hashtable.this.clear();
            }

            public boolean remove(Object object) {
                if (this.contains(object)) {
                    Hashtable.this.remove(((Map.Entry)object).getKey());
                    return true;
                }
                return false;
            }

            public boolean contains(Object object) {
                if (object instanceof Map.Entry) {
                    Entry entry = Hashtable.this.getEntry(((Map.Entry)object).getKey());
                    return object.equals(entry);
                }
                return false;
            }

            public Iterator iterator() {
                return new HashIterator(new MapEntry.Type(){

                    public Object get(MapEntry mapEntry) {
                        return mapEntry;
                    }
                });
            }
        }, (Object)this);
    }

    public synchronized boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Map) {
            Map map = (Map)object;
            if (this.size() != map.size()) {
                return false;
            }
            Set set = map.entrySet();
            Iterator iterator = this.entrySet().iterator();
            while (iterator.hasNext()) {
                if (set.contains(iterator.next())) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public synchronized Object get(Object object) {
        int n = object.hashCode();
        int n2 = (n & Integer.MAX_VALUE) % this.elementData.length;
        Entry entry = this.elementData[n2];
        while (entry != null) {
            if (entry.equalsKey(object, n)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    Entry getEntry(Object object) {
        int n = object.hashCode();
        int n2 = (n & Integer.MAX_VALUE) % this.elementData.length;
        Entry entry = this.elementData[n2];
        while (entry != null) {
            if (entry.equalsKey(object, n)) {
                return entry;
            }
            entry = entry.next;
        }
        return null;
    }

    public synchronized int hashCode() {
        int n = 0;
        Iterator iterator = this.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Object object = entry.getKey();
            Object object2 = entry.getValue();
            int n2 = (object != this ? object.hashCode() : 0) ^ (object2 != this ? (object2 != null ? object2.hashCode() : 0) : 0);
            n += n2;
        }
        return n;
    }

    public synchronized boolean isEmpty() {
        return this.elementCount == 0;
    }

    public synchronized Enumeration keys() {
        if (this.elementCount == 0) {
            return emptyEnumerator;
        }
        return new HashEnumerator(true);
    }

    public Set keySet() {
        return new Collections.SynchronizedSet(new AbstractSet(){

            public boolean contains(Object object) {
                return Hashtable.this.containsKey(object);
            }

            public int size() {
                return Hashtable.this.elementCount;
            }

            public void clear() {
                Hashtable.this.clear();
            }

            public boolean remove(Object object) {
                if (Hashtable.this.containsKey(object)) {
                    Hashtable.this.remove(object);
                    return true;
                }
                return false;
            }

            public Iterator iterator() {
                return new HashIterator(new MapEntry.Type(){

                    public Object get(MapEntry mapEntry) {
                        return mapEntry.key;
                    }
                });
            }
        }, (Object)this);
    }

    public synchronized Object put(Object object, Object object2) {
        if (object != null && object2 != null) {
            int n = object.hashCode();
            int n2 = (n & Integer.MAX_VALUE) % this.elementData.length;
            Entry entry = this.elementData[n2];
            while (entry != null && !entry.equalsKey(object, n)) {
                entry = entry.next;
            }
            if (entry == null) {
                ++this.modCount;
                if (++this.elementCount > this.threshold) {
                    this.rehash();
                    n2 = (n & Integer.MAX_VALUE) % this.elementData.length;
                }
                if (n2 < this.firstSlot) {
                    this.firstSlot = n2;
                }
                if (n2 > this.lastSlot) {
                    this.lastSlot = n2;
                }
                entry = Hashtable.newEntry(object, object2, n);
                entry.next = this.elementData[n2];
                this.elementData[n2] = entry;
                return null;
            }
            Object object3 = entry.value;
            entry.value = object2;
            return object3;
        }
        throw new NullPointerException();
    }

    public synchronized void putAll(Map map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            this.put(entry.getKey(), entry.getValue());
        }
    }

    protected void rehash() {
        int n = (this.elementData.length << 1) + 1;
        if (n == 0) {
            n = 1;
        }
        int n2 = n;
        int n3 = -1;
        Entry[] entryArray = new Entry[n];
        int n4 = this.lastSlot + 1;
        while (--n4 >= this.firstSlot) {
            Entry entry = this.elementData[n4];
            while (entry != null) {
                int n5 = (entry.getKeyHash() & Integer.MAX_VALUE) % n;
                if (n5 < n2) {
                    n2 = n5;
                }
                if (n5 > n3) {
                    n3 = n5;
                }
                Entry entry2 = entry.next;
                entry.next = entryArray[n5];
                entryArray[n5] = entry;
                entry = entry2;
            }
        }
        this.firstSlot = n2;
        this.lastSlot = n3;
        this.elementData = entryArray;
        this.computeMaxSize();
    }

    public synchronized Object remove(Object object) {
        int n = object.hashCode();
        int n2 = (n & Integer.MAX_VALUE) % this.elementData.length;
        Entry entry = null;
        Entry entry2 = this.elementData[n2];
        while (entry2 != null && !entry2.equalsKey(object, n)) {
            entry = entry2;
            entry2 = entry2.next;
        }
        if (entry2 != null) {
            ++this.modCount;
            if (entry == null) {
                this.elementData[n2] = entry2.next;
            } else {
                entry.next = entry2.next;
            }
            --this.elementCount;
            Object object2 = entry2.value;
            entry2.value = null;
            return object2;
        }
        return null;
    }

    public synchronized int size() {
        return this.elementCount;
    }

    public synchronized String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuffer stringBuffer = new StringBuffer(this.size() * 28);
        stringBuffer.append('{');
        int n = this.lastSlot;
        while (n >= this.firstSlot) {
            Entry entry = this.elementData[n];
            while (entry != null) {
                if (entry.key != this) {
                    stringBuffer.append(entry.key);
                } else {
                    stringBuffer.append("(this Map)");
                }
                stringBuffer.append('=');
                if (entry.value != this) {
                    stringBuffer.append(entry.value);
                } else {
                    stringBuffer.append("(this Map)");
                }
                stringBuffer.append(", ");
                entry = entry.next;
            }
            --n;
        }
        if (this.elementCount > 0) {
            stringBuffer.setLength(stringBuffer.length() - 2);
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public Collection values() {
        return new Collections.SynchronizedCollection(new AbstractCollection(){

            public boolean contains(Object object) {
                return Hashtable.this.contains(object);
            }

            public int size() {
                return Hashtable.this.elementCount;
            }

            public void clear() {
                Hashtable.this.clear();
            }

            public Iterator iterator() {
                return new HashIterator(new MapEntry.Type(){

                    public Object get(MapEntry mapEntry) {
                        return mapEntry.value;
                    }
                });
            }
        }, this);
    }

    private synchronized void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.elementData.length);
        objectOutputStream.writeInt(this.elementCount);
        int n = this.elementData.length;
        while (--n >= 0) {
            Entry entry = this.elementData[n];
            while (entry != null) {
                objectOutputStream.writeObject(entry.key);
                objectOutputStream.writeObject(entry.value);
                entry = entry.next;
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int n = objectInputStream.readInt();
        this.elementData = new Entry[n];
        int n2 = this.elementCount = objectInputStream.readInt();
        while (--n2 >= 0) {
            Object object = objectInputStream.readObject();
            int n3 = object.hashCode();
            int n4 = (n3 & Integer.MAX_VALUE) % n;
            if (n4 < this.firstSlot) {
                this.firstSlot = n4;
            }
            if (n4 > this.lastSlot) {
                this.lastSlot = n4;
            }
            Entry entry = Hashtable.newEntry(object, objectInputStream.readObject(), n3);
            entry.next = this.elementData[n4];
            this.elementData[n4] = entry;
        }
    }

    private static class Entry
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

        public Object setValue(Object object) {
            if (object == null) {
                throw new NullPointerException();
            }
            Object object2 = this.value;
            this.value = object;
            return object2;
        }

        public int getKeyHash() {
            return this.key.hashCode();
        }

        public boolean equalsKey(Object object, int n) {
            return this.key.equals(object);
        }

        public String toString() {
            return this.key + "=" + this.value;
        }
    }

    private final class HashIterator
    implements Iterator {
        private int position;
        private int expectedModCount;
        private MapEntry.Type type;
        private Entry lastEntry;
        private int lastPosition;
        private boolean canRemove = false;

        HashIterator(MapEntry.Type type) {
            this.type = type;
            this.position = Hashtable.this.lastSlot;
            this.expectedModCount = Hashtable.this.modCount;
        }

        /*
         * Unable to fully structure code
         */
        public boolean hasNext() {
            if (this.lastEntry == null || this.lastEntry.next == null) ** GOTO lbl7
            return true;
lbl-1000:
            // 1 sources

            {
                if (Hashtable.this.elementData[this.position] == null) {
                    --this.position;
                    continue;
                }
                return true;
lbl7:
                // 2 sources

                ** while (this.position >= Hashtable.this.firstSlot)
            }
lbl8:
            // 1 sources

            return false;
        }

        public Object next() {
            if (this.expectedModCount == Hashtable.this.modCount) {
                if (this.lastEntry != null) {
                    this.lastEntry = this.lastEntry.next;
                }
                if (this.lastEntry == null) {
                    while (this.position >= Hashtable.this.firstSlot && (this.lastEntry = Hashtable.this.elementData[this.position]) == null) {
                        --this.position;
                    }
                    if (this.lastEntry != null) {
                        this.lastPosition = this.position--;
                    }
                }
                if (this.lastEntry != null) {
                    this.canRemove = true;
                    return this.type.get(this.lastEntry);
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void remove() {
            if (this.expectedModCount != Hashtable.this.modCount) throw new ConcurrentModificationException();
            if (!this.canRemove) throw new IllegalStateException();
            this.canRemove = false;
            Hashtable hashtable = Hashtable.this;
            synchronized (hashtable) {
                boolean bl = false;
                Entry entry = Hashtable.this.elementData[this.lastPosition];
                if (entry == this.lastEntry) {
                    Hashtable.this.elementData[this.lastPosition] = entry.next;
                    bl = true;
                } else {
                    while (true) {
                        if (entry == null || entry.next == this.lastEntry) {
                            if (entry == null) break;
                            entry.next = this.lastEntry.next;
                            bl = true;
                            break;
                        }
                        entry = entry.next;
                    }
                }
                if (!bl) throw new ConcurrentModificationException();
                ++Hashtable.this.modCount;
                --Hashtable.this.elementCount;
                ++this.expectedModCount;
                return;
            }
        }
    }

    private final class HashEnumerator
    implements Enumeration {
        boolean key;
        int start;
        Entry entry;

        HashEnumerator(boolean bl) {
            this.key = bl;
            this.start = Hashtable.this.lastSlot + 1;
        }

        /*
         * Unable to fully structure code
         */
        public boolean hasMoreElements() {
            if (this.entry == null) ** GOTO lbl6
            return true;
lbl-1000:
            // 1 sources

            {
                if (Hashtable.this.elementData[this.start] == null) continue;
                this.entry = Hashtable.this.elementData[this.start];
                return true;
lbl6:
                // 2 sources

                ** while (--this.start >= Hashtable.this.firstSlot)
            }
lbl7:
            // 1 sources

            return false;
        }

        public Object nextElement() {
            if (this.hasMoreElements()) {
                Object object = this.key ? this.entry.key : this.entry.value;
                this.entry = this.entry.next;
                return object;
            }
            throw new NoSuchElementException();
        }
    }
}

