/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

public final class SymbolTable$Entry {
    public String symbol;
    public char[] characters;
    public SymbolTable$Entry next;

    public SymbolTable$Entry(String string, SymbolTable$Entry symbolTable$Entry) {
        this.symbol = string.intern();
        this.characters = new char[string.length()];
        string.getChars(0, this.characters.length, this.characters, 0);
        this.next = symbolTable$Entry;
    }

    public SymbolTable$Entry(char[] cArray, int n, int n2, SymbolTable$Entry symbolTable$Entry) {
        this.characters = new char[n2];
        System.arraycopy((Object)cArray, n, (Object)this.characters, 0, n2);
        this.symbol = new String(this.characters).intern();
        this.next = symbolTable$Entry;
    }
}

