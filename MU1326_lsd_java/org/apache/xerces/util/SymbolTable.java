/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

public class SymbolTable {
    protected static final int TABLE_SIZE = 101;
    protected Entry[] fBuckets = null;
    protected int fTableSize;
    protected transient int fCount;
    protected int fThreshold;
    protected float fLoadFactor;

    public SymbolTable(int n, float f2) {
        if (n < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + n);
        }
        if (f2 <= 0.0f || Float.isNaN(f2)) {
            throw new IllegalArgumentException("Illegal Load: " + f2);
        }
        if (n == 0) {
            n = 1;
        }
        this.fLoadFactor = f2;
        this.fTableSize = n;
        this.fBuckets = new Entry[this.fTableSize];
        this.fThreshold = (int)((float)this.fTableSize * f2);
        this.fCount = 0;
    }

    public SymbolTable(int n) {
        this(n, 0.75f);
    }

    public SymbolTable() {
        this(101, 0.75f);
    }

    public String addSymbol(String string) {
        int n = this.hash(string) % this.fTableSize;
        Entry entry = this.fBuckets[n];
        while (entry != null) {
            if (entry.symbol.equals(string)) {
                return entry.symbol;
            }
            entry = entry.next;
        }
        if (this.fCount >= this.fThreshold) {
            this.rehash();
            n = this.hash(string) % this.fTableSize;
        }
        this.fBuckets[n] = entry = new Entry(string, this.fBuckets[n]);
        ++this.fCount;
        return entry.symbol;
    }

    public String addSymbol(char[] cArray, int n, int n2) {
        int n3 = this.hash(cArray, n, n2) % this.fTableSize;
        Entry entry = this.fBuckets[n3];
        while (entry != null) {
            block5: {
                if (n2 == entry.characters.length) {
                    for (int i2 = 0; i2 < n2; ++i2) {
                        if (cArray[n + i2] == entry.characters[i2]) {
                            continue;
                        }
                        break block5;
                    }
                    return entry.symbol;
                }
            }
            entry = entry.next;
        }
        if (this.fCount >= this.fThreshold) {
            this.rehash();
            n3 = this.hash(cArray, n, n2) % this.fTableSize;
        }
        this.fBuckets[n3] = entry = new Entry(cArray, n, n2, this.fBuckets[n3]);
        ++this.fCount;
        return entry.symbol;
    }

    public int hash(String string) {
        return string.hashCode() & 0x7FFFFFF;
    }

    public int hash(char[] cArray, int n, int n2) {
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 = n3 * 31 + cArray[n + i2];
        }
        return n3 & 0x7FFFFFF;
    }

    protected void rehash() {
        int n = this.fBuckets.length;
        Entry[] entryArray = this.fBuckets;
        int n2 = n * 2 + 1;
        Entry[] entryArray2 = new Entry[n2];
        this.fThreshold = (int)((float)n2 * this.fLoadFactor);
        this.fBuckets = entryArray2;
        this.fTableSize = this.fBuckets.length;
        int n3 = n;
        while (n3-- > 0) {
            Entry entry = entryArray[n3];
            while (entry != null) {
                Entry entry2 = entry;
                entry = entry.next;
                int n4 = this.hash(entry2.characters, 0, entry2.characters.length) % n2;
                entry2.next = entryArray2[n4];
                entryArray2[n4] = entry2;
            }
        }
    }

    public boolean containsSymbol(String string) {
        int n = this.hash(string) % this.fTableSize;
        int n2 = string.length();
        Entry entry = this.fBuckets[n];
        while (entry != null) {
            block4: {
                if (n2 == entry.characters.length) {
                    for (int i2 = 0; i2 < n2; ++i2) {
                        if (string.charAt(i2) == entry.characters[i2]) {
                            continue;
                        }
                        break block4;
                    }
                    return true;
                }
            }
            entry = entry.next;
        }
        return false;
    }

    public boolean containsSymbol(char[] cArray, int n, int n2) {
        int n3 = this.hash(cArray, n, n2) % this.fTableSize;
        Entry entry = this.fBuckets[n3];
        while (entry != null) {
            block4: {
                if (n2 == entry.characters.length) {
                    for (int i2 = 0; i2 < n2; ++i2) {
                        if (cArray[n + i2] == entry.characters[i2]) {
                            continue;
                        }
                        break block4;
                    }
                    return true;
                }
            }
            entry = entry.next;
        }
        return false;
    }

    protected static final class Entry {
        public String symbol;
        public char[] characters;
        public Entry next;

        public Entry(String string, Entry entry) {
            this.symbol = string.intern();
            this.characters = new char[string.length()];
            string.getChars(0, this.characters.length, this.characters, 0);
            this.next = entry;
        }

        public Entry(char[] cArray, int n, int n2, Entry entry) {
            this.characters = new char[n2];
            System.arraycopy((Object)cArray, n, (Object)this.characters, 0, n2);
            this.symbol = new String(this.characters).intern();
            this.next = entry;
        }
    }
}

