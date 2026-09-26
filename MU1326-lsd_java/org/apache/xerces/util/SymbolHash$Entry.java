/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

public final class SymbolHash$Entry {
    public Object key;
    public Object value;
    public SymbolHash$Entry next;

    public SymbolHash$Entry() {
        this.key = null;
        this.value = null;
        this.next = null;
    }

    public SymbolHash$Entry(Object object, Object object2, SymbolHash$Entry symbolHash$Entry) {
        this.key = object;
        this.value = object2;
        this.next = symbolHash$Entry;
    }

    public SymbolHash$Entry makeClone() {
        SymbolHash$Entry symbolHash$Entry = new SymbolHash$Entry();
        symbolHash$Entry.key = this.key;
        symbolHash$Entry.value = this.value;
        if (this.next != null) {
            symbolHash$Entry.next = this.next.makeClone();
        }
        return symbolHash$Entry;
    }
}

