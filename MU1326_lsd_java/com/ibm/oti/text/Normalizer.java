/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.text;

import com.ibm.oti.text.ComposeData;
import com.ibm.oti.text.DecompData;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public final class Normalizer
implements Cloneable {
    public static final char DONE = '\uffff';
    private static final int COMPAT_BIT = 1;
    private static final int DECOMP_BIT = 2;
    private static final int COMPOSE_BIT = 4;
    public static final Mode NO_OP = new Mode(0);
    public static final Mode COMPOSE = new Mode(4);
    public static final Mode COMPOSE_COMPAT = new Mode(5);
    public static final Mode DECOMP = new Mode(2);
    public static final Mode DECOMP_COMPAT = new Mode(3);
    public static final int IGNORE_HANGUL = 1;
    static final char HANGUL_BASE = '\uac00';
    static final char HANGUL_LIMIT = '\ud7a4';
    private static final char JAMO_LBASE = '\u1100';
    private static final char JAMO_VBASE = '\u1161';
    private static final char JAMO_TBASE = '\u11a7';
    private static final int JAMO_LCOUNT = 19;
    private static final int JAMO_VCOUNT = 21;
    private static final int JAMO_TCOUNT = 28;
    private static final int JAMO_NCOUNT = 588;
    private Mode mode = DECOMP;
    private int options = 0;
    private transient int minDecomp;
    private int currentIndex = 0;
    private int nextIndex = 0;
    private CharacterIterator text;
    private boolean atEnd = false;
    private StringBuffer buffer = null;
    private int bufferPos = 0;
    private char currentChar;
    private static final int EMPTY = -1;
    private StringBuffer explodeBuf = null;
    static final int STR_INDEX_SHIFT = 2;
    static final int STR_LENGTH_MASK = 3;

    public Normalizer(String string, Mode mode) {
        this(new StringCharacterIterator(string), mode, 0);
    }

    public Normalizer(String string, Mode mode, int n) {
        this(new StringCharacterIterator(string), mode, n);
    }

    public Normalizer(CharacterIterator characterIterator, Mode mode) {
        this(characterIterator, mode, 0);
    }

    public Normalizer(CharacterIterator characterIterator, Mode mode, int n) {
        this.text = characterIterator;
        this.mode = mode;
        this.options = n;
        this.minDecomp = mode.compat() ? 0 : 11177;
    }

    public Object clone() {
        try {
            Normalizer normalizer = (Normalizer)super.clone();
            normalizer.text = (CharacterIterator)this.text.clone();
            if (this.buffer != null) {
                normalizer.buffer = new StringBuffer();
                if (this.buffer.length() > 0) {
                    normalizer.buffer.append(this.buffer);
                }
            }
            return normalizer;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError(cloneNotSupportedException.toString());
        }
    }

    public static String normalize(String string, Mode mode, int n) {
        return Normalizer.normalize(string, mode, n, false);
    }

    public static String normalize(String string, Mode mode, int n, boolean bl) {
        if (mode.compose()) {
            return Normalizer.compose(string, mode.compat(), n);
        }
        if (mode.decomp()) {
            return Normalizer.decompose(string, mode.compat(), n, bl);
        }
        return string;
    }

    public static String compose(String string, boolean bl, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        int n2 = -1;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = bl ? 0 : 4341;
        int n8 = bl ? 0 : 11177;
        int n9 = 0;
        while (n9 < string.length() || n2 != -1) {
            int n10;
            int n11;
            char c2;
            char c3;
            if (n2 == -1) {
                c3 = string.charAt(n9++);
            } else {
                c3 = stringBuffer2.charAt(n2++);
                if (n2 >= stringBuffer2.length()) {
                    n2 = -1;
                    stringBuffer2.setLength(0);
                }
            }
            int n12 = Normalizer.composeLookup(c3);
            int n13 = n12 & 7;
            int n14 = n12 >>> 3;
            if (n13 == 1 || n13 == 2 && n14 < n7) {
                n6 = 0;
                n5 = 0;
                n4 = n14;
                n3 = stringBuffer.length();
                stringBuffer.append(c3);
                continue;
            }
            if (n13 == 3) {
                int n15;
                c2 = ComposeData.typeBit[n14];
                int n16 = n11 = (c2 < ' ' ? n5 & 1 << c2 : n6 & 1 << (c2 & 0x1F)) != 0 ? 1 : 0;
                if (n14 < 55 && n11 == 0 && (n15 = Normalizer.composeAction(n4, n14)) > 0) {
                    if (n15 > 64285) {
                        n10 = Normalizer.pairExplode(stringBuffer2, n15);
                        n2 = 0;
                        stringBuffer.setCharAt(n3, (char)n10);
                        n4 = Normalizer.composeLookup((char)n10) >>> 3;
                    } else {
                        n10 = n15;
                        stringBuffer.setCharAt(n3, (char)n10);
                        n4 = Normalizer.composeLookup((char)n10) >>> 3;
                    }
                    n10 = stringBuffer.length();
                    if (n10 - n3 <= 1) continue;
                    int n17 = n3 + 1;
                    while (n17 < n10) {
                        stringBuffer2.append(stringBuffer.charAt(n17));
                        ++n17;
                    }
                    stringBuffer.setLength(n3 + 1);
                    n6 = 0;
                    n5 = 0;
                    if (n2 != -1) continue;
                    n2 = 0;
                    continue;
                }
                Normalizer.bubbleAppend(stringBuffer, c3, c2);
                if (c2 < ' ') {
                    n5 |= 1 << c2;
                    continue;
                }
                n6 |= 1 << (c2 & 0x1F);
                continue;
            }
            if (n14 > n7) {
                Normalizer.explode(stringBuffer2, n14);
                n2 = 0;
                continue;
            }
            if (n13 == 7 && n7 == 0) {
                Normalizer.hangulToJamo(c3, stringBuffer2, n8);
                n2 = 0;
                continue;
            }
            if (n13 == 4) {
                n6 = 0;
                n5 = 0;
                n4 = 8983;
                n3 = stringBuffer.length();
                stringBuffer.append(c3);
                continue;
            }
            if (n13 == 5 && n5 == 0 && n6 == 0 && n4 == 8983) {
                c2 = stringBuffer.charAt(n3) - 4352;
                n11 = c3 - 4449;
                n10 = (char)(44032 + (c2 * 21 + n11) * 28);
                stringBuffer.setCharAt(n3, (char)n10);
                n4 = 8984;
                continue;
            }
            if (n13 == 6 && n5 == 0 && n6 == 0 && n4 == 8984) {
                c2 = (char)(stringBuffer.charAt(n3) + (c3 - 4519));
                stringBuffer.setCharAt(n3, c2);
                n4 = 0;
                n3 = -1;
                n6 = 0;
                n5 = 0;
                continue;
            }
            n4 = 0;
            n3 = -1;
            n6 = 0;
            n5 = 0;
            stringBuffer.append(c3);
        }
        return stringBuffer.toString();
    }

    private char nextCompose() {
        int n = -1;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        boolean bl = true;
        this.currentIndex = this.nextIndex;
        this.text.setIndex(this.currentIndex);
        int n6 = this.mode.compat() ? 0 : 4341;
        int n7 = this.mode.compat() ? 0 : 11177;
        this.initBuffer();
        if (this.explodeBuf == null) {
            this.explodeBuf = new StringBuffer();
        } else {
            this.explodeBuf.setLength(0);
        }
        char c2 = this.curForward();
        while (c2 != '\uffff') {
            int n8;
            int n9;
            char c3;
            int n10 = Normalizer.composeLookup(c2);
            int n11 = n10 & 7;
            int n12 = n10 >>> 3;
            if (n11 == 1 || n11 == 2 && n12 < n6) {
                if (this.getBufferLength() > 0 && bl && n == -1) break;
                n5 = 0;
                n4 = 0;
                n3 = n12;
                n2 = this.getBufferLength();
                this.buffer.append(c2);
            } else if (n11 == 3) {
                int n13;
                c3 = ComposeData.typeBit[n12];
                int n14 = n9 = (c3 < ' ' ? n4 & 1 << c3 : n5 & 1 << (c3 & 0x1F)) != 0 ? 1 : 0;
                if (n12 < 55 && n9 == 0 && (n13 = Normalizer.composeAction(n3, n12)) > 0) {
                    if (n13 > 64285) {
                        n8 = Normalizer.pairExplode(this.explodeBuf, n13);
                        n = 0;
                        this.buffer.setCharAt(n2, (char)n8);
                        n3 = Normalizer.composeLookup((char)n8) >>> 3;
                    } else {
                        n8 = n13;
                        this.buffer.setCharAt(n2, (char)n8);
                        n3 = Normalizer.composeLookup((char)n8) >>> 3;
                    }
                    n8 = this.getBufferLength();
                    if (n8 - n2 > 1) {
                        int n15 = n2 + 1;
                        while (n15 < n8) {
                            this.explodeBuf.append(this.buffer.charAt(n15));
                            ++n15;
                        }
                        this.buffer.setLength(n2 + 1);
                        n5 = 0;
                        n4 = 0;
                        if (n == -1) {
                            n = 0;
                        }
                    }
                } else {
                    Normalizer.bubbleAppend(this.buffer, c2, c3);
                    if (c3 < ' ') {
                        n4 |= 1 << c3;
                    } else {
                        n5 |= 1 << (c3 & 0x1F);
                    }
                }
            } else if (n12 > n6) {
                Normalizer.explode(this.explodeBuf, n12);
                n = 0;
            } else if (n11 == 7 && n6 == 0) {
                Normalizer.hangulToJamo(c2, this.explodeBuf, n7);
                n = 0;
            } else if (n11 == 4) {
                if (this.getBufferLength() > 0 && bl && n == -1) break;
                n5 = 0;
                n4 = 0;
                n3 = 8983;
                n2 = this.getBufferLength();
                this.buffer.append(c2);
            } else if (n11 == 5 && n4 == 0 && n5 == 0 && n3 == 8983) {
                c3 = this.buffer.charAt(n2) - 4352;
                n9 = c2 - 4449;
                n8 = (char)(44032 + (c3 * 21 + n9) * 28);
                this.buffer.setCharAt(n2, (char)n8);
                n3 = 8984;
            } else if (n11 == 6 && n4 == 0 && n5 == 0 && n3 == 8984) {
                c3 = (char)(this.buffer.charAt(n2) + (c2 - 4519));
                this.buffer.setCharAt(n2, c3);
                n3 = 0;
                n2 = -1;
                n5 = 0;
                n4 = 0;
            } else {
                n3 = 0;
                n2 = -1;
                n5 = 0;
                n4 = 0;
                this.buffer.append(c2);
            }
            if (n == -1) {
                c2 = this.text.next();
                bl = true;
                continue;
            }
            c2 = this.explodeBuf.charAt(n++);
            if (n >= this.explodeBuf.length()) {
                n = -1;
                this.explodeBuf.setLength(0);
            }
            bl = false;
        }
        c2 = this.getBufferLength() > 0 ? (char)this.buffer.charAt(0) : (char)'\uffff';
        this.nextIndex = this.text.getIndex();
        return c2;
    }

    private char prevCompose() {
        char c2;
        int n = this.mode.compat() ? 0 : 4341;
        this.nextIndex = this.currentIndex;
        this.initBuffer();
        while ((c2 = this.curBackward()) != '\uffff') {
            this.buffer.insert(0, c2);
            int n2 = Normalizer.composeLookup(c2);
            int n3 = n2 & 7;
            int n4 = n2 >>> 3;
            if (n3 == 1 || n3 == 2 && n4 < n || n3 == 7 || n3 == 4) break;
        }
        if (this.getBufferLength() > 0) {
            String string = Normalizer.compose(this.buffer.toString(), this.mode.compat(), this.options);
            this.buffer.setLength(0);
            this.buffer.append(string);
            if (this.getBufferLength() > 1) {
                this.bufferPos = this.getBufferLength() - 1;
                c2 = this.buffer.charAt(this.bufferPos);
            } else {
                c2 = this.buffer.charAt(0);
            }
        } else {
            c2 = '\uffff';
        }
        this.currentIndex = this.text.getIndex();
        return c2;
    }

    private static void bubbleAppend(StringBuffer stringBuffer, char c2, int n) {
        int n2 = stringBuffer.length() - 1;
        if (n != 1) {
            while (n2 >= 0) {
                int n3 = Normalizer.getComposeClass(stringBuffer.charAt(n2));
                if (n3 <= n) break;
                --n2;
            }
        }
        stringBuffer.insert(n2 + 1, c2);
    }

    private static int getComposeClass(char c2) {
        int n = 0;
        int n2 = Normalizer.composeLookup(c2);
        int n3 = n2 & 7;
        if (n3 == 3) {
            n = ComposeData.typeBit[n2 >>> 3];
        }
        return n;
    }

    static final int composeLookup(char c2) {
        return ComposeData.lookup.elementAt(c2);
    }

    static final int composeAction(int n, int n2) {
        return ComposeData.actions.elementAt((char)(n + 1024 * n2));
    }

    static final void explode(StringBuffer stringBuffer, int n) {
        char c2;
        while ((c2 = "".charAt(n++)) != '\u0000') {
            stringBuffer.append(c2);
        }
    }

    static final char pairExplode(StringBuffer stringBuffer, int n) {
        char c2 = ComposeData.actionIndex[n - 64285];
        Normalizer.explode(stringBuffer, c2 + '\u0001');
        return "".charAt(c2);
    }

    public static String decompose(String string, boolean bl, int n) {
        return Normalizer.decompose(string, bl, n, false);
    }

    public static String decompose(String string, boolean bl, int n, boolean bl2) {
        boolean bl3 = (n & 1) == 0;
        int n2 = bl ? 0 : 11177;
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = null;
        StringBuffer stringBuffer3 = null;
        int n3 = 0;
        int n4 = -1;
        if (bl2) {
            stringBuffer3 = new StringBuffer();
        }
        while (n3 < string.length() || n4 >= 0) {
            char c2;
            int n5;
            char c3;
            if (n4 >= 0) {
                c3 = stringBuffer2.charAt(n4++);
                if (n4 == stringBuffer2.length()) {
                    n4 = -1;
                }
            } else {
                c3 = string.charAt(n3++);
            }
            if ((n5 = (c2 = DecompData.offsets.elementAt(c3)) & Short.MAX_VALUE) > n2) {
                if ((c2 & 0x8000) != 0) {
                    if (stringBuffer2 == null) {
                        stringBuffer2 = new StringBuffer();
                    } else {
                        stringBuffer2.setLength(0);
                    }
                    Normalizer.doAppend("", n5, stringBuffer2);
                    n4 = 0;
                    continue;
                }
                if (!bl2) {
                    Normalizer.doAppend("", n5, stringBuffer);
                    continue;
                }
                stringBuffer3.setLength(0);
                Normalizer.doAppend("", n5, stringBuffer3);
                if (stringBuffer3.length() > 1 || c3 == '\u037e' || c3 == '\u1fef') {
                    int n6 = 0;
                    while (n6 < stringBuffer3.length()) {
                        char c4 = stringBuffer3.charAt(n6);
                        if (c4 >= '\t' && c4 <= '\r' || c4 >= ' ' && c4 <= '/' || c4 >= ':' && c4 <= '@' || c4 >= '[' && c4 <= '`' || c4 >= '{' && c4 <= '~') {
                            stringBuffer.append('\'');
                            stringBuffer.append(c4);
                            stringBuffer.append('\'');
                        } else {
                            stringBuffer.append(c4);
                        }
                        ++n6;
                    }
                    continue;
                }
                stringBuffer.append(stringBuffer3);
                continue;
            }
            if (c3 >= '\uac00' && c3 < '\ud7a4' && bl3) {
                Normalizer.hangulToJamo(c3, stringBuffer, n2);
                continue;
            }
            stringBuffer.append(c3);
        }
        Normalizer.fixCanonical(stringBuffer);
        return stringBuffer.toString();
    }

    private char nextDecomp() {
        boolean bl = (this.options & 1) == 0;
        this.currentIndex = this.nextIndex;
        char c2 = this.curForward();
        char c3 = DecompData.offsets.elementAt(c2);
        int n = c3 & Short.MAX_VALUE;
        this.initBuffer();
        if (n > this.minDecomp || DecompData.canonClass.elementAt(c2) != 0) {
            int n2;
            if (n > this.minDecomp) {
                Normalizer.doAppend("", n, this.buffer);
                if ((c3 & 0x8000) != 0) {
                    n2 = 0;
                    while (n2 < this.getBufferLength()) {
                        c2 = this.buffer.charAt(n2);
                        n = DecompData.offsets.elementAt(c2) & Short.MAX_VALUE;
                        if (n > this.minDecomp) {
                            n2 += Normalizer.doReplace("", n, this.buffer, n2);
                        }
                        ++n2;
                    }
                }
            } else {
                this.buffer.append(c2);
            }
            n2 = 0;
            while ((c2 = this.text.next()) != '\uffff' && DecompData.canonClass.elementAt(c2) != 0) {
                n2 = 1;
                n = DecompData.offsets.elementAt(c2) & Short.MAX_VALUE;
                if (n > this.minDecomp) {
                    Normalizer.doAppend("", n, this.buffer);
                    continue;
                }
                this.buffer.append(c2);
            }
            if (this.getBufferLength() > 1 && n2 != 0) {
                Normalizer.fixCanonical(this.buffer);
            }
            c2 = this.buffer.charAt(0);
        } else {
            this.text.next();
            this.buffer.setLength(0);
            this.buffer.append(c2);
            if (bl && c2 >= '\uac00' && c2 < '\ud7a4') {
                this.clearBuffer();
                Normalizer.hangulToJamo(c2, this.buffer, this.minDecomp);
                c2 = this.buffer.charAt(0);
            }
        }
        this.nextIndex = this.text.getIndex();
        return c2;
    }

    private char prevDecomp() {
        boolean bl = (this.options & 1) == 0;
        this.nextIndex = this.currentIndex;
        char c2 = this.curBackward();
        char c3 = DecompData.offsets.elementAt(c2);
        int n = c3 & Short.MAX_VALUE;
        this.initBuffer();
        if (n > this.minDecomp || DecompData.canonClass.elementAt(c2) != 0) {
            while (c2 != '\uffff') {
                this.buffer.insert(0, c2);
                if (DecompData.canonClass.elementAt(c2) == 0) break;
                c2 = this.text.previous();
            }
            int n2 = 0;
            while (n2 < this.getBufferLength()) {
                c2 = this.buffer.charAt(n2);
                c3 = DecompData.offsets.elementAt(c2);
                n = c3 & Short.MAX_VALUE;
                if (n > this.minDecomp) {
                    int n3 = Normalizer.doReplace("", n, this.buffer, n2);
                    if ((c3 & 0x8000) != 0) {
                        while (n2 < n3) {
                            c2 = this.buffer.charAt(n2);
                            n = DecompData.offsets.elementAt(c2) & Short.MAX_VALUE;
                            if (n > this.minDecomp) {
                                n2 += Normalizer.doReplace("", n, this.buffer, n2);
                            }
                            ++n2;
                        }
                    }
                    n2 = n3;
                }
                ++n2;
            }
            if (this.getBufferLength() > 1) {
                Normalizer.fixCanonical(this.buffer);
            }
            this.bufferPos = this.getBufferLength() - 1;
            c2 = this.buffer.charAt(this.bufferPos);
        } else if (bl && c2 >= '\uac00' && c2 < '\ud7a4') {
            Normalizer.hangulToJamo(c2, this.buffer, this.minDecomp);
            this.getBufferLength();
            this.bufferPos = this.getBufferLength() - 1;
            c2 = this.buffer.charAt(this.bufferPos);
        } else {
            this.buffer.append(c2);
            this.getBufferLength();
            this.bufferPos = this.getBufferLength() - 1;
        }
        this.currentIndex = this.text.getIndex();
        return c2;
    }

    public static final int getClass(char c2) {
        int n = DecompData.canonClass.elementAt(c2);
        return n >= 0 ? n : n + 256;
    }

    public char current() {
        if (this.bufferPos >= this.getBufferLength() || this.getBufferLength() == 0) {
            this.bufferPos = 0;
            if (this.mode.compose()) {
                this.currentChar = this.nextCompose();
                this.text.setIndex(this.currentIndex);
            } else if (this.mode.decomp()) {
                this.currentChar = this.nextDecomp();
                this.text.setIndex(this.currentIndex);
            } else {
                this.currentChar = this.currentIndex == 0 ? this.text.current() : this.text.current();
            }
        } else {
            this.currentChar = this.buffer.charAt(this.bufferPos);
        }
        return this.currentChar;
    }

    public char first() {
        this.reset();
        return this.next();
    }

    public char last() {
        this.currentIndex = this.nextIndex = this.text.getEndIndex() - 1;
        this.text.setIndex(this.currentIndex);
        this.atEnd = true;
        this.currentChar = (char)65535;
        this.clearBuffer();
        return this.previous();
    }

    public char next() {
        if (this.buffer != null && ++this.bufferPos < this.buffer.length()) {
            this.currentChar = this.buffer.charAt(this.bufferPos);
        } else {
            this.bufferPos = 0;
            if (this.mode.compose()) {
                this.currentChar = this.nextCompose();
            } else if (this.mode.decomp()) {
                this.currentChar = this.nextDecomp();
            } else {
                this.currentChar = this.text.current();
                this.text.next();
                if (this.currentChar != '\uffff') {
                    this.currentIndex = ++this.nextIndex;
                }
            }
        }
        return this.currentChar;
    }

    public char previous() {
        if (this.bufferPos > 0) {
            this.currentChar = this.buffer.charAt(--this.bufferPos);
        } else {
            this.bufferPos = 0;
            if (this.mode.compose()) {
                this.currentChar = this.prevCompose();
            } else if (this.mode.decomp()) {
                this.currentChar = this.prevDecomp();
            } else {
                this.text.setIndex(this.currentIndex);
                this.currentChar = this.text.previous();
                if (this.currentIndex != 0) {
                    this.currentIndex = --this.nextIndex;
                }
            }
        }
        return this.currentChar;
    }

    private int getBufferLength() {
        if (this.buffer == null) {
            return 0;
        }
        return this.buffer.length();
    }

    public char setIndex(int n) {
        this.setIndexOnly(n);
        return this.current();
    }

    public void setIndexOnly(int n) {
        this.currentIndex = this.nextIndex = n;
        this.text.setIndex(n);
        this.currentChar = (char)65535;
        this.clearBuffer();
    }

    public final int getIndex() {
        return this.text.getIndex();
    }

    public final int getBeginIndex() {
        return this.text.getBeginIndex();
    }

    public final int getEndIndex() {
        return this.text.getEndIndex();
    }

    public void setMode(Mode mode) {
        this.mode = mode;
        this.minDecomp = this.mode.compat() ? 0 : 11177;
    }

    public Mode getMode() {
        return this.mode;
    }

    public void setOption(int n, boolean bl) {
        if (n != 1) {
            throw new IllegalArgumentException();
        }
        this.options = bl ? (this.options |= n) : (this.options &= ~n);
    }

    public boolean getOption(int n) {
        return (this.options & n) != 0;
    }

    public void setText(String string) {
        this.text = new StringCharacterIterator(string);
        this.reset();
    }

    public void setText(CharacterIterator characterIterator) {
        this.text = characterIterator;
        this.reset();
    }

    private final char curForward() {
        char c2 = this.text.current();
        return c2;
    }

    private final char curBackward() {
        char c2 = this.atEnd ? this.text.current() : this.text.previous();
        this.atEnd = false;
        return c2;
    }

    static final int doAppend(String string, int n, StringBuffer stringBuffer) {
        int n2 = n >>> 2;
        int n3 = n & 3;
        if (n3 == 0) {
            char c2;
            while ((c2 = "".charAt(n2++)) != '\u0000') {
                stringBuffer.append(c2);
                ++n3;
            }
        } else {
            int n4 = 0;
            while (n4 < n3) {
                stringBuffer.append("".charAt(n2++));
                ++n4;
            }
        }
        return n3;
    }

    static final int doInsert(String string, int n, StringBuffer stringBuffer, int n2) {
        int n3 = n >>> 2;
        int n4 = n & 3;
        if (n4 == 0) {
            char c2;
            while ((c2 = "".charAt(n3++)) != '\u0000') {
                stringBuffer.insert(n2++, c2);
                ++n4;
            }
        } else {
            int n5 = 0;
            while (n5 < n4) {
                stringBuffer.insert(n2++, "".charAt(n3++));
                ++n5;
            }
        }
        return n4;
    }

    static final int doReplace(String string, int n, StringBuffer stringBuffer, int n2) {
        int n3 = n >>> 2;
        int n4 = n & 3;
        stringBuffer.setCharAt(n2++, "".charAt(n3++));
        if (n4 == 0) {
            char c2;
            while ((c2 = "".charAt(n3++)) != '\u0000') {
                stringBuffer.insert(n2++, c2);
                ++n4;
            }
        } else {
            int n5 = 1;
            while (n5 < n4) {
                stringBuffer.insert(n2++, "".charAt(n3++));
                ++n5;
            }
        }
        return n4;
    }

    public void reset() {
        this.currentIndex = this.nextIndex = this.text.getBeginIndex();
        this.text.setIndex(this.currentIndex);
        this.atEnd = false;
        this.bufferPos = 0;
        this.clearBuffer();
    }

    private final void initBuffer() {
        if (this.buffer == null) {
            this.buffer = new StringBuffer(10);
        } else {
            this.buffer.setLength(0);
        }
        this.clearBuffer();
    }

    private final void clearBuffer() {
        this.bufferPos = 0;
        if (this.buffer != null) {
            this.buffer.setLength(0);
        }
    }

    private static void fixCanonical(StringBuffer stringBuffer) {
        if (stringBuffer.length() == 0) {
            return;
        }
        int n = stringBuffer.length() - 1;
        int n2 = Normalizer.getClass(stringBuffer.charAt(n));
        --n;
        while (n >= 0) {
            int n3 = n2;
            n2 = Normalizer.getClass(stringBuffer.charAt(n));
            if (n2 > n3 && n3 != 0) {
                char c2 = stringBuffer.charAt(n);
                stringBuffer.setCharAt(n, stringBuffer.charAt(n + 1));
                stringBuffer.setCharAt(n + 1, c2);
                if (n < stringBuffer.length() - 2) {
                    n += 2;
                }
                n2 = Normalizer.getClass(stringBuffer.charAt(n));
            }
            --n;
        }
    }

    static int hangulToJamo(char c2, StringBuffer stringBuffer, int n) {
        char c3 = (char)(c2 - 44032);
        char c4 = (char)(4352 + c3 / 588);
        char c5 = (char)(4449 + c3 % 588 / 28);
        char c6 = (char)(4519 + c3 % 28);
        int n2 = 0;
        n2 += Normalizer.jamoAppend(c4, n, stringBuffer);
        n2 += Normalizer.jamoAppend(c5, n, stringBuffer);
        if (c6 != '\u11a7') {
            n2 += Normalizer.jamoAppend(c6, n, stringBuffer);
        }
        return n2;
    }

    static final int jamoAppend(char c2, int n, StringBuffer stringBuffer) {
        char c3 = DecompData.offsets.elementAt(c2);
        if (c3 > n) {
            return Normalizer.doAppend("", c3, stringBuffer);
        }
        stringBuffer.append(c2);
        return 1;
    }

    private static void jamoToHangul(StringBuffer stringBuffer, int n) {
        int n2 = 0;
        int n3 = stringBuffer.length() - 1;
        int n4 = n;
        while (n4 < n3) {
            int n5;
            char c2 = stringBuffer.charAt(n4);
            int n6 = c2 - 4352;
            if (n6 >= 0 && n6 < 19 && (n5 = stringBuffer.charAt(n4 + 1) - 4449) >= 0 && n5 < 21) {
                int n7 = ++n4 < n3 ? (int)stringBuffer.charAt(n4 + 1) : 0;
                if ((n7 -= 4519) >= 0 && n7 < 28) {
                    ++n4;
                } else {
                    n7 = 0;
                }
                stringBuffer.setCharAt(n2++, (char)((n6 * 21 + n5) * 28 + n7 + 44032));
            } else {
                stringBuffer.setCharAt(n2++, c2);
            }
            ++n4;
        }
        while (n4 < stringBuffer.length()) {
            stringBuffer.setCharAt(n2++, stringBuffer.charAt(n4++));
        }
        stringBuffer.setLength(n2);
    }

    public static Mode getMode(int n) {
        switch (n) {
            case 1: {
                return DECOMP;
            }
            case 2: {
                return DECOMP_COMPAT;
            }
        }
        return NO_OP;
    }

    public static final class Mode {
        final int mode;

        Mode(int n) {
            this.mode = n;
        }

        final boolean compat() {
            return (this.mode & 1) != 0;
        }

        final boolean compose() {
            return (this.mode & 4) != 0;
        }

        final boolean decomp() {
            return (this.mode & 2) != 0;
        }
    }
}

