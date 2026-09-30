/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

public class SymbolHash {
    protected int fTableSize = 101;
    protected Entry[] fBuckets;
    protected int fNum = 0;

    public SymbolHash() {
        this.fBuckets = new Entry[this.fTableSize];
    }

    public SymbolHash(int n) {
        this.fTableSize = n;
        this.fBuckets = new Entry[this.fTableSize];
    }

    public void put(Object object, Object object2) {
        int n = (object.hashCode() & Integer.MAX_VALUE) % this.fTableSize;
        Entry entry = this.search(object, n);
        if (entry != null) {
            entry.value = object2;
        } else {
            this.fBuckets[n] = entry = new Entry(object, object2, this.fBuckets[n]);
            ++this.fNum;
        }
    }

    public Object get(Object object) {
        int n = (object.hashCode() & Integer.MAX_VALUE) % this.fTableSize;
        Entry entry = this.search(object, n);
        if (entry != null) {
            return entry.value;
        }
        return null;
    }

    public int getLength() {
        return this.fNum;
    }

    public int getValues(Object[] objectArray, int n) {
        int n2 = 0;
        for (int i2 = 0; i2 < this.fTableSize && n2 < this.fNum; ++i2) {
            Entry entry = this.fBuckets[i2];
            while (entry != null) {
                objectArray[n + n2] = entry.value;
                ++n2;
                entry = entry.next;
            }
        }
        return this.fNum;
    }

    public SymbolHash makeClone() {
        SymbolHash symbolHash = new SymbolHash(this.fTableSize);
        symbolHash.fNum = this.fNum;
        for (int i2 = 0; i2 < this.fTableSize; ++i2) {
            if (this.fBuckets[i2] == null) continue;
            symbolHash.fBuckets[i2] = this.fBuckets[i2].makeClone();
        }
        return symbolHash;
    }

    public void clear() {
        for (int i2 = 0; i2 < this.fTableSize; ++i2) {
            this.fBuckets[i2] = null;
        }
        this.fNum = 0;
    }

    protected Entry search(Object object, int n) {
        Entry entry = this.fBuckets[n];
        while (entry != null) {
            if (object.equals(entry.key)) {
                return entry;
            }
            entry = entry.next;
        }
        return null;
    }

    protected static final class Entry {
        public Object key;
        public Object value;
        public Entry next;

        public Entry() {
            this.key = null;
            this.value = null;
            this.next = null;
        }

        public Entry(Object object, Object object2, Entry entry) {
            this.key = object;
            this.value = object2;
            this.next = entry;
        }

        public Entry makeClone() {
            Entry entry = new Entry();
            entry.key = this.key;
            entry.value = this.value;
            if (this.next != null) {
                entry.next = this.next.makeClone();
            }
            return entry;
        }
    }
}

