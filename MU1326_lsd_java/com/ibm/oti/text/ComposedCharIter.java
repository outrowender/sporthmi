/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.text;

import com.ibm.oti.text.DecompData;
import com.ibm.oti.text.Normalizer;

public final class ComposedCharIter {
    public static final char DONE = '\uffff';
    private final int minDecomp;
    private final boolean hangul;
    private char curChar = '\u0000';
    private char nextChar = (char)65535;
    private static final char HANGUL_BASE = '\uac00';
    private static final char HANGUL_LIMIT = '\ud7a4';

    public ComposedCharIter() {
        this.minDecomp = 11177;
        this.hangul = false;
    }

    public ComposedCharIter(boolean bl, int n) {
        this.minDecomp = bl ? 0 : 11177;
        this.hangul = (n & 1) == 0;
    }

    public boolean hasNext() {
        if (this.nextChar == '\uffff') {
            this.findNextChar();
        }
        return this.nextChar != '\uffff';
    }

    public char next() {
        if (this.nextChar == '\uffff') {
            this.findNextChar();
        }
        this.curChar = this.nextChar;
        this.nextChar = (char)65535;
        return this.curChar;
    }

    public String decomposition() {
        StringBuffer stringBuffer = new StringBuffer();
        char c2 = (char)(DecompData.offsets.elementAt(this.curChar) & Short.MAX_VALUE);
        if (c2 > this.minDecomp) {
            Normalizer.doAppend("", c2, stringBuffer);
        } else if (this.hangul && this.curChar >= '\uac00' && this.curChar < '\ud7a4') {
            Normalizer.hangulToJamo(this.curChar, stringBuffer, this.minDecomp);
        } else {
            stringBuffer.append(this.curChar);
        }
        return stringBuffer.toString();
    }

    private void findNextChar() {
        if (this.curChar != '\uffff') {
            char c2 = this.curChar;
            while ((c2 = (char)(c2 + '\u0001')) < '\uffff') {
                int n = DecompData.offsets.elementAt(c2) & Short.MAX_VALUE;
                if (n <= this.minDecomp && (!this.hangul || c2 < '\uac00' || c2 >= '\ud7a4')) continue;
                this.nextChar = c2;
                break;
            }
        }
    }
}

