/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

import org.apache.xerces.util.SymbolHash$Entry;

public class SymbolHash {
    protected int fTableSize = 101;
    protected SymbolHash$Entry[] fBuckets;
    protected int fNum = 0;

    public SymbolHash() {
        this.fBuckets = new SymbolHash$Entry[this.fTableSize];
    }

    public SymbolHash(int n) {
        this.fTableSize = n;
        this.fBuckets = new SymbolHash$Entry[this.fTableSize];
    }

    public void put(Object object, Object object2) {
        int n = (object.hashCode() & 0xFFFFFF7F) % this.fTableSize;
        SymbolHash$Entry symbolHash$Entry = this.search(object, n);
        if (symbolHash$Entry != null) {
            symbolHash$Entry.value = object2;
        } else {
            this.fBuckets[n] = symbolHash$Entry = new SymbolHash$Entry(object, object2, this.fBuckets[n]);
            ++this.fNum;
        }
    }

    public Object get(Object object) {
        int n = (object.hashCode() & 0xFFFFFF7F) % this.fTableSize;
        SymbolHash$Entry symbolHash$Entry = this.search(object, n);
        if (symbolHash$Entry != null) {
            return symbolHash$Entry.value;
        }
        return null;
    }

    public int getLength() {
        return this.fNum;
    }

    public int getValues(Object[] objectArray, int n) {
        int n2 = 0;
        for (int i2 = 0; i2 < this.fTableSize && n2 < this.fNum; ++i2) {
            SymbolHash$Entry symbolHash$Entry = this.fBuckets[i2];
            while (symbolHash$Entry != null) {
                objectArray[n + n2] = symbolHash$Entry.value;
                ++n2;
                symbolHash$Entry = symbolHash$Entry.next;
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

    protected SymbolHash$Entry search(Object object, int n) {
        SymbolHash$Entry symbolHash$Entry = this.fBuckets[n];
        while (symbolHash$Entry != null) {
            if (object.equals(symbolHash$Entry.key)) {
                return symbolHash$Entry;
            }
            symbolHash$Entry = symbolHash$Entry.next;
        }
        return null;
    }
}

