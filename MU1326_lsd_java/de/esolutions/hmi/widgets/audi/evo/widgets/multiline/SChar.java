/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.multiline;

public class SChar {
    public static final int TYPE_NORMAL;
    public static final int TYPE_PREFIX_NEW_LINE;
    public static final int TYPE_PREFIX_FIRST_LINE_CHAR;
    public static final int TYPE_SUFFIX_LAST_CHAR;
    public short[] word;
    public short w;
    public short x;
    public short line;
    public short idx;
    public int type;

    public SChar(short s, short[] sArray, short s2) {
        this.w = s;
        this.word = sArray;
        this.idx = s2;
        this.x = 0;
        this.line = (short)-1;
        this.type = 0;
    }

    public boolean isOfType(int n) {
        return (this.type & n) == n;
    }

    public void appendType(int n) {
        this.type |= n;
    }
}

