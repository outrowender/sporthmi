/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.AbstractCollection;
import edu.emory.mathcs.backport.java.util.AbstractMap;
import edu.emory.mathcs.backport.java.util.AbstractSet;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentMap;
import edu.emory.mathcs.backport.java.util.concurrent.locks.ReentrantLock;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class ConcurrentHashMap
extends AbstractMap
implements ConcurrentMap,
Serializable {
    private static final long serialVersionUID = 7249069246763182397L;
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    static final int MAXIMUM_CAPACITY = 0x40000000;
    static final int MAX_SEGMENTS = 65536;
    static final int RETRIES_BEFORE_LOCK = 2;
    final int segmentMask;
    final int segmentShift;
    final Segment[] segments;
    transient Set keySet;
    transient Set entrySet;
    transient Collection values;

    private static int hash(int n) {
        n += n << 15 ^ 0xFFFFCD7D;
        n ^= n >>> 10;
        n += n << 3;
        n ^= n >>> 6;
        n += (n << 2) + (n << 14);
        return n ^ n >>> 16;
    }

    final Segment segmentFor(int n) {
        return this.segments[n >>> this.segmentShift & this.segmentMask];
    }

    public ConcurrentHashMap(int n, float f2, int n2) {
        int n3;
        int n4;
        int n5;
        if (!(f2 > 0.0f) || n < 0 || n2 <= 0) {
            throw new IllegalArgumentException();
        }
        if (n2 > 65536) {
            n2 = 65536;
        }
        int n6 = 0;
        for (n5 = 1; n5 < n2; n5 <<= 1) {
            ++n6;
        }
        this.segmentShift = 32 - n6;
        this.segmentMask = n5 - 1;
        this.segments = Segment.newArray(n5);
        if (n > 0x40000000) {
            n = 0x40000000;
        }
        if ((n4 = n / n5) * n5 < n) {
            ++n4;
        }
        for (n3 = 1; n3 < n4; n3 <<= 1) {
        }
        for (int i2 = 0; i2 < this.segments.length; ++i2) {
            this.segments[i2] = new Segment(n3, f2);
        }
    }

    public ConcurrentHashMap(int n, float f2) {
        this(n, f2, 16);
    }

    public ConcurrentHashMap(int n) {
        this(n, 0.75f, 16);
    }

    public ConcurrentHashMap() {
        this(16, 0.75f, 16);
    }

    public ConcurrentHashMap(Map map) {
        this(Math.max((int)((float)map.size() / 0.75f) + 1, 16), 0.75f, 16);
        this.putAll(map);
    }

    public boolean isEmpty() {
        int n;
        Segment[] segmentArray = this.segments;
        int[] nArray = new int[segmentArray.length];
        int n2 = 0;
        for (n = 0; n < segmentArray.length; ++n) {
            if (segmentArray[n].count != 0) {
                return false;
            }
            nArray[n] = segmentArray[n].modCount;
            n2 += nArray[n];
        }
        if (n2 != 0) {
            for (n = 0; n < segmentArray.length; ++n) {
                if (segmentArray[n].count == 0 && nArray[n] == segmentArray[n].modCount) continue;
                return false;
            }
        }
        return true;
    }

    public int size() {
        int n;
        Segment[] segmentArray = this.segments;
        long l = 0L;
        long l2 = 0L;
        int[] nArray = new int[segmentArray.length];
        for (n = 0; n < 2; ++n) {
            int n2;
            l2 = 0L;
            l = 0L;
            int n3 = 0;
            for (n2 = 0; n2 < segmentArray.length; ++n2) {
                l += (long)segmentArray[n2].count;
                nArray[n2] = segmentArray[n2].modCount;
                n3 += nArray[n2];
            }
            if (n3 != 0) {
                for (n2 = 0; n2 < segmentArray.length; ++n2) {
                    l2 += (long)segmentArray[n2].count;
                    if (nArray[n2] == segmentArray[n2].modCount) continue;
                    l2 = -1L;
                    break;
                }
            }
            if (l2 == l) break;
        }
        if (l2 != l) {
            l = 0L;
            for (n = 0; n < segmentArray.length; ++n) {
                segmentArray[n].lock();
            }
            for (n = 0; n < segmentArray.length; ++n) {
                l += (long)segmentArray[n].count;
            }
            for (n = 0; n < segmentArray.length; ++n) {
                segmentArray[n].unlock();
            }
        }
        if (l > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)l;
    }

    public Object get(Object object) {
        int n = ConcurrentHashMap.hash(object.hashCode());
        return this.segmentFor(n).get(object, n);
    }

    public boolean containsKey(Object object) {
        int n = ConcurrentHashMap.hash(object.hashCode());
        return this.segmentFor(n).containsKey(object, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean containsValue(Object object) {
        int n;
        boolean bl;
        if (object == null) {
            throw new NullPointerException();
        }
        Segment[] segmentArray = this.segments;
        int[] nArray = new int[segmentArray.length];
        for (bl = false; bl < 2 != 0; bl += 1) {
            int n2;
            int n3;
            n = 0;
            int n4 = 0;
            for (n3 = 0; n3 < segmentArray.length; ++n3) {
                n2 = segmentArray[n3].count;
                nArray[n3] = segmentArray[n3].modCount;
                n4 += nArray[n3];
                if (!segmentArray[n3].containsValue(object)) continue;
                return true;
            }
            n3 = 1;
            if (n4 != 0) {
                for (n2 = 0; n2 < segmentArray.length; ++n2) {
                    int n5 = segmentArray[n2].count;
                    if (nArray[n2] == segmentArray[n2].modCount) continue;
                    n3 = 0;
                    break;
                }
            }
            if (n3 == 0) continue;
            return false;
        }
        for (bl = false; bl < segmentArray.length; bl += 1) {
            segmentArray[bl].lock();
        }
        bl = false;
        try {
            for (n = 0; n < segmentArray.length; ++n) {
                if (!segmentArray[n].containsValue(object)) continue;
                bl = true;
                break;
            }
        }
        finally {
            for (int i2 = 0; i2 < segmentArray.length; ++i2) {
                segmentArray[i2].unlock();
            }
        }
        return bl;
    }

    public boolean contains(Object object) {
        return this.containsValue(object);
    }

    public Object put(Object object, Object object2) {
        if (object2 == null) {
            throw new NullPointerException();
        }
        int n = ConcurrentHashMap.hash(object.hashCode());
        return this.segmentFor(n).put(object, n, object2, false);
    }

    public Object putIfAbsent(Object object, Object object2) {
        if (object2 == null) {
            throw new NullPointerException();
        }
        int n = ConcurrentHashMap.hash(object.hashCode());
        return this.segmentFor(n).put(object, n, object2, true);
    }

    public void putAll(Map map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            this.put(entry.getKey(), entry.getValue());
        }
    }

    public Object remove(Object object) {
        int n = ConcurrentHashMap.hash(object.hashCode());
        return this.segmentFor(n).remove(object, n, null);
    }

    public boolean remove(Object object, Object object2) {
        if (object2 == null) {
            return false;
        }
        int n = ConcurrentHashMap.hash(object.hashCode());
        return this.segmentFor(n).remove(object, n, object2) != null;
    }

    public boolean replace(Object object, Object object2, Object object3) {
        if (object2 == null || object3 == null) {
            throw new NullPointerException();
        }
        int n = ConcurrentHashMap.hash(object.hashCode());
        return this.segmentFor(n).replace(object, n, object2, object3);
    }

    public Object replace(Object object, Object object2) {
        if (object2 == null) {
            throw new NullPointerException();
        }
        int n = ConcurrentHashMap.hash(object.hashCode());
        return this.segmentFor(n).replace(object, n, object2);
    }

    public void clear() {
        for (int i2 = 0; i2 < this.segments.length; ++i2) {
            this.segments[i2].clear();
        }
    }

    public Set keySet() {
        Set set = this.keySet;
        return set != null ? set : (this.keySet = new KeySet());
    }

    public Collection values() {
        Collection collection = this.values;
        return collection != null ? collection : (this.values = new Values());
    }

    public Set entrySet() {
        Set set = this.entrySet;
        return set != null ? set : (this.entrySet = new EntrySet());
    }

    public Enumeration keys() {
        return new KeyIterator();
    }

    public Enumeration elements() {
        return new ValueIterator();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        for (int i2 = 0; i2 < this.segments.length; ++i2) {
            Segment segment = this.segments[i2];
            segment.lock();
            try {
                HashEntry[] hashEntryArray = segment.table;
                for (int i3 = 0; i3 < hashEntryArray.length; ++i3) {
                    HashEntry hashEntry = hashEntryArray[i3];
                    while (hashEntry != null) {
                        objectOutputStream.writeObject(hashEntry.key);
                        objectOutputStream.writeObject(hashEntry.value);
                        hashEntry = hashEntry.next;
                    }
                }
                continue;
            }
            finally {
                segment.unlock();
            }
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(null);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        for (int i2 = 0; i2 < this.segments.length; ++i2) {
            this.segments[i2].setTable(new HashEntry[1]);
        }
        while (true) {
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            if (object == null) break;
            this.put(object, object2);
        }
    }

    final class KeySet
    extends AbstractSet {
        KeySet() {
        }

        public Iterator iterator() {
            return new KeyIterator();
        }

        public int size() {
            return ConcurrentHashMap.this.size();
        }

        public boolean contains(Object object) {
            return ConcurrentHashMap.this.containsKey(object);
        }

        public boolean remove(Object object) {
            return ConcurrentHashMap.this.remove(object) != null;
        }

        public void clear() {
            ConcurrentHashMap.this.clear();
        }
    }

    final class Values
    extends AbstractCollection {
        Values() {
        }

        public Iterator iterator() {
            return new ValueIterator();
        }

        public int size() {
            return ConcurrentHashMap.this.size();
        }

        public boolean contains(Object object) {
            return ConcurrentHashMap.this.containsValue(object);
        }

        public void clear() {
            ConcurrentHashMap.this.clear();
        }
    }

    static final class Segment
    extends ReentrantLock
    implements Serializable {
        private static final long serialVersionUID = 2249069246763182397L;
        volatile transient int count;
        transient int modCount;
        transient int threshold;
        volatile transient HashEntry[] table;
        final float loadFactor;

        Segment(int n, float f2) {
            this.loadFactor = f2;
            this.setTable(HashEntry.newArray(n));
        }

        static final Segment[] newArray(int n) {
            return new Segment[n];
        }

        void setTable(HashEntry[] hashEntryArray) {
            this.threshold = (int)((float)hashEntryArray.length * this.loadFactor);
            this.table = hashEntryArray;
        }

        HashEntry getFirst(int n) {
            HashEntry[] hashEntryArray = this.table;
            return hashEntryArray[n & hashEntryArray.length - 1];
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        Object readValueUnderLock(HashEntry hashEntry) {
            this.lock();
            try {
                Object object = hashEntry.value;
                return object;
            }
            finally {
                this.unlock();
            }
        }

        Object get(Object object, int n) {
            if (this.count != 0) {
                HashEntry hashEntry = this.getFirst(n);
                while (hashEntry != null) {
                    if (hashEntry.hash == n && object.equals(hashEntry.key)) {
                        Object object2 = hashEntry.value;
                        if (object2 != null) {
                            return object2;
                        }
                        return this.readValueUnderLock(hashEntry);
                    }
                    hashEntry = hashEntry.next;
                }
            }
            return null;
        }

        boolean containsKey(Object object, int n) {
            if (this.count != 0) {
                HashEntry hashEntry = this.getFirst(n);
                while (hashEntry != null) {
                    if (hashEntry.hash == n && object.equals(hashEntry.key)) {
                        return true;
                    }
                    hashEntry = hashEntry.next;
                }
            }
            return false;
        }

        boolean containsValue(Object object) {
            if (this.count != 0) {
                HashEntry[] hashEntryArray = this.table;
                int n = hashEntryArray.length;
                for (int i2 = 0; i2 < n; ++i2) {
                    HashEntry hashEntry = hashEntryArray[i2];
                    while (hashEntry != null) {
                        Object object2 = hashEntry.value;
                        if (object2 == null) {
                            object2 = this.readValueUnderLock(hashEntry);
                        }
                        if (object.equals(object2)) {
                            return true;
                        }
                        hashEntry = hashEntry.next;
                    }
                }
            }
            return false;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        boolean replace(Object object, int n, Object object2, Object object3) {
            this.lock();
            try {
                HashEntry hashEntry = this.getFirst(n);
                while (!(hashEntry == null || hashEntry.hash == n && object.equals(hashEntry.key))) {
                    hashEntry = hashEntry.next;
                }
                boolean bl = false;
                if (hashEntry != null && object2.equals(hashEntry.value)) {
                    bl = true;
                    hashEntry.value = object3;
                }
                boolean bl2 = bl;
                return bl2;
            }
            finally {
                this.unlock();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        Object replace(Object object, int n, Object object2) {
            this.lock();
            try {
                HashEntry hashEntry = this.getFirst(n);
                while (!(hashEntry == null || hashEntry.hash == n && object.equals(hashEntry.key))) {
                    hashEntry = hashEntry.next;
                }
                Object object3 = null;
                if (hashEntry != null) {
                    object3 = hashEntry.value;
                    hashEntry.value = object2;
                }
                Object object4 = object3;
                return object4;
            }
            finally {
                this.unlock();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        Object put(Object object, int n, Object object2, boolean bl) {
            this.lock();
            try {
                Object object3;
                HashEntry hashEntry;
                int n2 = this.count;
                if (n2++ > this.threshold) {
                    this.rehash();
                }
                HashEntry[] hashEntryArray = this.table;
                int n3 = n & hashEntryArray.length - 1;
                HashEntry hashEntry2 = hashEntry = hashEntryArray[n3];
                while (!(hashEntry2 == null || hashEntry2.hash == n && object.equals(hashEntry2.key))) {
                    hashEntry2 = hashEntry2.next;
                }
                if (hashEntry2 != null) {
                    object3 = hashEntry2.value;
                    if (!bl) {
                        hashEntry2.value = object2;
                    }
                } else {
                    object3 = null;
                    ++this.modCount;
                    hashEntryArray[n3] = new HashEntry(object, n, hashEntry, object2);
                    this.count = n2;
                }
                Object object4 = object3;
                return object4;
            }
            finally {
                this.unlock();
            }
        }

        void rehash() {
            HashEntry[] hashEntryArray = this.table;
            int n = hashEntryArray.length;
            if (n >= 0x40000000) {
                return;
            }
            HashEntry[] hashEntryArray2 = HashEntry.newArray(n << 1);
            this.threshold = (int)((float)hashEntryArray2.length * this.loadFactor);
            int n2 = hashEntryArray2.length - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                int n3;
                HashEntry hashEntry = hashEntryArray[i2];
                if (hashEntry == null) continue;
                HashEntry hashEntry2 = hashEntry.next;
                int n4 = hashEntry.hash & n2;
                if (hashEntry2 == null) {
                    hashEntryArray2[n4] = hashEntry;
                    continue;
                }
                HashEntry hashEntry3 = hashEntry;
                int n5 = n4;
                HashEntry hashEntry4 = hashEntry2;
                while (hashEntry4 != null) {
                    n3 = hashEntry4.hash & n2;
                    if (n3 != n5) {
                        n5 = n3;
                        hashEntry3 = hashEntry4;
                    }
                    hashEntry4 = hashEntry4.next;
                }
                hashEntryArray2[n5] = hashEntry3;
                hashEntry4 = hashEntry;
                while (hashEntry4 != hashEntry3) {
                    n3 = hashEntry4.hash & n2;
                    HashEntry hashEntry5 = hashEntryArray2[n3];
                    hashEntryArray2[n3] = new HashEntry(hashEntry4.key, hashEntry4.hash, hashEntry5, hashEntry4.value);
                    hashEntry4 = hashEntry4.next;
                }
            }
            this.table = hashEntryArray2;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        Object remove(Object object, int n, Object object2) {
            this.lock();
            try {
                Object object3;
                HashEntry hashEntry;
                int n2 = this.count - 1;
                HashEntry[] hashEntryArray = this.table;
                int n3 = n & hashEntryArray.length - 1;
                HashEntry hashEntry2 = hashEntry = hashEntryArray[n3];
                while (!(hashEntry2 == null || hashEntry2.hash == n && object.equals(hashEntry2.key))) {
                    hashEntry2 = hashEntry2.next;
                }
                Object object4 = null;
                if (hashEntry2 != null) {
                    object3 = hashEntry2.value;
                    if (object2 == null || object2.equals(object3)) {
                        object4 = object3;
                        ++this.modCount;
                        HashEntry hashEntry3 = hashEntry2.next;
                        HashEntry hashEntry4 = hashEntry;
                        while (hashEntry4 != hashEntry2) {
                            hashEntry3 = new HashEntry(hashEntry4.key, hashEntry4.hash, hashEntry3, hashEntry4.value);
                            hashEntry4 = hashEntry4.next;
                        }
                        hashEntryArray[n3] = hashEntry3;
                        this.count = n2;
                    }
                }
                object3 = object4;
                return object3;
            }
            finally {
                this.unlock();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        void clear() {
            if (this.count != 0) {
                this.lock();
                try {
                    HashEntry[] hashEntryArray = this.table;
                    for (int i2 = 0; i2 < hashEntryArray.length; ++i2) {
                        hashEntryArray[i2] = null;
                    }
                    ++this.modCount;
                    this.count = 0;
                }
                finally {
                    this.unlock();
                }
            }
        }
    }

    final class EntrySet
    extends AbstractSet {
        EntrySet() {
        }

        public Iterator iterator() {
            return new EntryIterator();
        }

        public boolean contains(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry)object;
            Object object2 = ConcurrentHashMap.this.get(entry.getKey());
            return object2 != null && object2.equals(entry.getValue());
        }

        public boolean remove(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry)object;
            return ConcurrentHashMap.this.remove(entry.getKey(), entry.getValue());
        }

        public int size() {
            return ConcurrentHashMap.this.size();
        }

        public void clear() {
            ConcurrentHashMap.this.clear();
        }
    }

    static final class HashEntry {
        final Object key;
        final int hash;
        volatile Object value;
        final HashEntry next;

        HashEntry(Object object, int n, HashEntry hashEntry, Object object2) {
            this.key = object;
            this.hash = n;
            this.next = hashEntry;
            this.value = object2;
        }

        static final HashEntry[] newArray(int n) {
            return new HashEntry[n];
        }
    }

    final class KeyIterator
    extends HashIterator
    implements Iterator,
    Enumeration {
        KeyIterator() {
        }

        public Object next() {
            return super.nextEntry().key;
        }

        public Object nextElement() {
            return super.nextEntry().key;
        }
    }

    abstract class HashIterator {
        int nextSegmentIndex;
        int nextTableIndex;
        HashEntry[] currentTable;
        HashEntry nextEntry;
        HashEntry lastReturned;

        HashIterator() {
            this.nextSegmentIndex = ConcurrentHashMap.this.segments.length - 1;
            this.nextTableIndex = -1;
            this.advance();
        }

        public boolean hasMoreElements() {
            return this.hasNext();
        }

        final void advance() {
            if (this.nextEntry != null && (this.nextEntry = this.nextEntry.next) != null) {
                return;
            }
            while (this.nextTableIndex >= 0) {
                if ((this.nextEntry = this.currentTable[this.nextTableIndex--]) == null) continue;
                return;
            }
            while (this.nextSegmentIndex >= 0) {
                Segment segment = ConcurrentHashMap.this.segments[this.nextSegmentIndex--];
                if (segment.count == 0) continue;
                this.currentTable = segment.table;
                for (int i2 = this.currentTable.length - 1; i2 >= 0; --i2) {
                    this.nextEntry = this.currentTable[i2];
                    if (this.nextEntry == null) continue;
                    this.nextTableIndex = i2 - 1;
                    return;
                }
            }
        }

        public boolean hasNext() {
            return this.nextEntry != null;
        }

        HashEntry nextEntry() {
            if (this.nextEntry == null) {
                throw new NoSuchElementException();
            }
            this.lastReturned = this.nextEntry;
            this.advance();
            return this.lastReturned;
        }

        public void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            ConcurrentHashMap.this.remove(this.lastReturned.key);
            this.lastReturned = null;
        }
    }

    final class EntryIterator
    extends HashIterator
    implements Iterator {
        EntryIterator() {
        }

        public Object next() {
            HashEntry hashEntry = super.nextEntry();
            return new WriteThroughEntry(hashEntry.key, hashEntry.value);
        }
    }

    final class ValueIterator
    extends HashIterator
    implements Iterator,
    Enumeration {
        ValueIterator() {
        }

        public Object next() {
            return super.nextEntry().value;
        }

        public Object nextElement() {
            return super.nextEntry().value;
        }
    }

    final class WriteThroughEntry
    extends AbstractMap.SimpleEntry {
        WriteThroughEntry(Object object, Object object2) {
            super(object, object2);
        }

        public Object setValue(Object object) {
            if (object == null) {
                throw new NullPointerException();
            }
            Object object2 = super.setValue(object);
            ConcurrentHashMap.this.put(this.getKey(), object);
            return object2;
        }
    }
}

