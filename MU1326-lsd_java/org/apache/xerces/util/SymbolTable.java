/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

import org.apache.xerces.util.SymbolTable$Entry;

public class SymbolTable {
    protected static final int TABLE_SIZE;
    protected SymbolTable$Entry[] fBuckets = null;
    protected int fTableSize;
    protected transient int fCount;
    protected int fThreshold;
    protected float fLoadFactor;

    public SymbolTable(int n, float f2) {
        if (n < 0) {
            throw new IllegalArgumentException(new StringBuffer().append("Illegal Capacity: ").append(n).toString());
        }
        if (f2 <= 0.0f || Float.isNaN(f2)) {
            throw new IllegalArgumentException(new StringBuffer().append("Illegal Load: ").append(f2).toString());
        }
        if (n == 0) {
            n = 1;
        }
        this.fLoadFactor = f2;
        this.fTableSize = n;
        this.fBuckets = new SymbolTable$Entry[this.fTableSize];
        this.fThreshold = (int)((float)this.fTableSize * f2);
        this.fCount = 0;
    }

    public SymbolTable(int n) {
        this(n, 16447);
    }

    public SymbolTable() {
        this(101, 16447);
    }

    public String addSymbol(String string) {
        int n = this.hash(string) % this.fTableSize;
        SymbolTable$Entry symbolTable$Entry = this.fBuckets[n];
        while (symbolTable$Entry != null) {
            if (symbolTable$Entry.symbol.equals(string)) {
                return symbolTable$Entry.symbol;
            }
            symbolTable$Entry = symbolTable$Entry.next;
        }
        if (this.fCount >= this.fThreshold) {
            this.rehash();
            n = this.hash(string) % this.fTableSize;
        }
        this.fBuckets[n] = symbolTable$Entry = new SymbolTable$Entry(string, this.fBuckets[n]);
        ++this.fCount;
        return symbolTable$Entry.symbol;
    }

    public String addSymbol(char[] cArray, int n, int n2) {
        int n3 = this.hash(cArray, n, n2) % this.fTableSize;
        SymbolTable$Entry symbolTable$Entry = this.fBuckets[n3];
        while (symbolTable$Entry != null) {
            block5: {
                if (n2 == symbolTable$Entry.characters.length) {
                    for (int i2 = 0; i2 < n2; ++i2) {
                        if (cArray[n + i2] == symbolTable$Entry.characters[i2]) {
                            continue;
                        }
                        break block5;
                    }
                    return symbolTable$Entry.symbol;
                }
            }
            symbolTable$Entry = symbolTable$Entry.next;
        }
        if (this.fCount >= this.fThreshold) {
            this.rehash();
            n3 = this.hash(cArray, n, n2) % this.fTableSize;
        }
        this.fBuckets[n3] = symbolTable$Entry = new SymbolTable$Entry(cArray, n, n2, this.fBuckets[n3]);
        ++this.fCount;
        return symbolTable$Entry.symbol;
    }

    public int hash(String string) {
        return string.hashCode() & 0xFFFFFF07;
    }

    public int hash(char[] cArray, int n, int n2) {
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 = n3 * 31 + cArray[n + i2];
        }
        return n3 & 0xFFFFFF07;
    }

    protected void rehash() {
        int n = this.fBuckets.length;
        SymbolTable$Entry[] symbolTable$EntryArray = this.fBuckets;
        int n2 = n * 2 + 1;
        SymbolTable$Entry[] symbolTable$EntryArray2 = new SymbolTable$Entry[n2];
        this.fThreshold = (int)((float)n2 * this.fLoadFactor);
        this.fBuckets = symbolTable$EntryArray2;
        this.fTableSize = this.fBuckets.length;
        int n3 = n;
        while (n3-- > 0) {
            SymbolTable$Entry symbolTable$Entry = symbolTable$EntryArray[n3];
            while (symbolTable$Entry != null) {
                SymbolTable$Entry symbolTable$Entry2 = symbolTable$Entry;
                symbolTable$Entry = symbolTable$Entry.next;
                int n4 = this.hash(symbolTable$Entry2.characters, 0, symbolTable$Entry2.characters.length) % n2;
                symbolTable$Entry2.next = symbolTable$EntryArray2[n4];
                symbolTable$EntryArray2[n4] = symbolTable$Entry2;
            }
        }
    }

    public boolean containsSymbol(String string) {
        int n = this.hash(string) % this.fTableSize;
        int n2 = string.length();
        SymbolTable$Entry symbolTable$Entry = this.fBuckets[n];
        while (symbolTable$Entry != null) {
            block4: {
                if (n2 == symbolTable$Entry.characters.length) {
                    for (int i2 = 0; i2 < n2; ++i2) {
                        if (string.charAt(i2) == symbolTable$Entry.characters[i2]) {
                            continue;
                        }
                        break block4;
                    }
                    return true;
                }
            }
            symbolTable$Entry = symbolTable$Entry.next;
        }
        return false;
    }

    public boolean containsSymbol(char[] cArray, int n, int n2) {
        int n3 = this.hash(cArray, n, n2) % this.fTableSize;
        SymbolTable$Entry symbolTable$Entry = this.fBuckets[n3];
        while (symbolTable$Entry != null) {
            block4: {
                if (n2 == symbolTable$Entry.characters.length) {
                    for (int i2 = 0; i2 < n2; ++i2) {
                        if (cArray[n + i2] == symbolTable$Entry.characters[i2]) {
                            continue;
                        }
                        break block4;
                    }
                    return true;
                }
            }
            symbolTable$Entry = symbolTable$Entry.next;
        }
        return false;
    }
}

