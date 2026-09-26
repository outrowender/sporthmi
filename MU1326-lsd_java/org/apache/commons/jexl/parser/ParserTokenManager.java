/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

import java.io.IOException;
import java.io.PrintStream;
import org.apache.commons.jexl.parser.ParserConstants;
import org.apache.commons.jexl.parser.SimpleCharStream;
import org.apache.commons.jexl.parser.Token;
import org.apache.commons.jexl.parser.TokenMgrError;

public class ParserTokenManager
implements ParserConstants {
    public PrintStream debugStream = System.out;
    static final long[] jjbitVec0 = new long[]{0L, 0L, 2882303761517117313L, 2882303761517117313L};
    static final int[] jjnextStates = new int[]{13, 14, 15, 1, 2, 7, 8, 10, 11};
    public static final String[] jjstrLiteralImages = new String[]{"", null, null, null, null, null, null, null, null, "{", "}", "empty", "(", ")", "size", "=", "||", "or", "&&", "and", "|", "^", "&", "==", "eq", "!=", "ne", "<", "lt", ">", "gt", "<=", "le", ">=", "ge", "+", "-", "*", "/", "div", "%", "mod", "~", "!", "not", "null", "true", "false", ";", "if", "else", "while", "foreach", "in", ",", "[", "]", ".", null, null, null, null};
    public static final String[] lexStateNames = new String[]{"DEFAULT"};
    static final long[] jjtoToken = new long[]{0};
    static final long[] jjtoSkip = new long[]{0};
    private SimpleCharStream input_stream;
    private final int[] jjrounds = new int[17];
    private final int[] jjstateSet = new int[34];
    protected char curChar;
    int curLexState = 0;
    int defaultLexState = 0;
    int jjnewStateCnt;
    int jjround;
    int jjmatchedPos;
    int jjmatchedKind;

    public void setDebugStream(PrintStream printStream) {
        this.debugStream = printStream;
    }

    private final int jjStopStringLiteralDfa_0(int n, long l) {
        switch (n) {
            case 0: {
                if ((l & 0x3EF285550A4800L) != 0L) {
                    this.jjmatchedKind = 58;
                    return 5;
                }
                return -1;
            }
            case 1: {
                if ((l & 0x1CF28000084800L) != 0L) {
                    this.jjmatchedKind = 58;
                    this.jjmatchedPos = 1;
                    return 5;
                }
                if ((l & 0x22000555020000L) != 0L) {
                    return 5;
                }
                return -1;
            }
            case 2: {
                if ((l & 0) != 0L) {
                    this.jjmatchedKind = 58;
                    this.jjmatchedPos = 2;
                    return 5;
                }
                if ((l & 0x128000080000L) != 0L) {
                    return 5;
                }
                return -1;
            }
            case 3: {
                if ((l & 0x18800000000800L) != 0L) {
                    this.jjmatchedKind = 58;
                    this.jjmatchedPos = 3;
                    return 5;
                }
                if ((l & 0) != 0L) {
                    return 5;
                }
                return -1;
            }
            case 4: {
                if ((l & 0) != 0L) {
                    this.jjmatchedKind = 58;
                    this.jjmatchedPos = 4;
                    return 5;
                }
                if ((l & 0x8800000000800L) != 0L) {
                    return 5;
                }
                return -1;
            }
            case 5: {
                if ((l & 0) != 0L) {
                    this.jjmatchedKind = 58;
                    this.jjmatchedPos = 5;
                    return 5;
                }
                return -1;
            }
        }
        return -1;
    }

    private final int jjStartNfa_0(int n, long l) {
        return this.jjMoveNfa_0(this.jjStopStringLiteralDfa_0(n, l), n + 1);
    }

    private final int jjStopAtPos(int n, int n2) {
        this.jjmatchedKind = n2;
        this.jjmatchedPos = n;
        return n + 1;
    }

    private final int jjStartNfaWithStates_0(int n, int n2, int n3) {
        this.jjmatchedKind = n2;
        this.jjmatchedPos = n;
        try {
            this.curChar = this.input_stream.readChar();
        }
        catch (IOException iOException) {
            return n + 1;
        }
        return this.jjMoveNfa_0(n3, n + 1);
    }

    private final int jjMoveStringLiteralDfa0_0() {
        switch (this.curChar) {
            case '!': {
                this.jjmatchedKind = 43;
                return this.jjMoveStringLiteralDfa1_0(0);
            }
            case '%': {
                return this.jjStopAtPos(0, 40);
            }
            case '&': {
                this.jjmatchedKind = 22;
                return this.jjMoveStringLiteralDfa1_0(0);
            }
            case '(': {
                return this.jjStopAtPos(0, 12);
            }
            case ')': {
                return this.jjStopAtPos(0, 13);
            }
            case '*': {
                return this.jjStopAtPos(0, 37);
            }
            case '+': {
                return this.jjStopAtPos(0, 35);
            }
            case ',': {
                return this.jjStopAtPos(0, 54);
            }
            case '-': {
                return this.jjStopAtPos(0, 36);
            }
            case '.': {
                return this.jjStopAtPos(0, 57);
            }
            case '/': {
                return this.jjStopAtPos(0, 38);
            }
            case ';': {
                return this.jjStopAtPos(0, 48);
            }
            case '<': {
                this.jjmatchedKind = 27;
                return this.jjMoveStringLiteralDfa1_0(0);
            }
            case '=': {
                this.jjmatchedKind = 15;
                return this.jjMoveStringLiteralDfa1_0(0);
            }
            case '>': {
                this.jjmatchedKind = 29;
                return this.jjMoveStringLiteralDfa1_0(0);
            }
            case '[': {
                return this.jjStopAtPos(0, 55);
            }
            case ']': {
                return this.jjStopAtPos(0, 56);
            }
            case '^': {
                return this.jjStopAtPos(0, 21);
            }
            case 'a': {
                return this.jjMoveStringLiteralDfa1_0(0);
            }
            case 'd': {
                return this.jjMoveStringLiteralDfa1_0(0);
            }
            case 'e': {
                return this.jjMoveStringLiteralDfa1_0(1125899923621888L);
            }
            case 'f': {
                return this.jjMoveStringLiteralDfa1_0(0x10800000000000L);
            }
            case 'g': {
                return this.jjMoveStringLiteralDfa1_0(0x440000000L);
            }
            case 'i': {
                return this.jjMoveStringLiteralDfa1_0(0x22000000000000L);
            }
            case 'l': {
                return this.jjMoveStringLiteralDfa1_0(0);
            }
            case 'm': {
                return this.jjMoveStringLiteralDfa1_0(0x300004000000L);
            }
            case 'n': {
                return this.jjMoveStringLiteralDfa1_0(0);
            }
            case 'o': {
                return this.jjMoveStringLiteralDfa1_0(0);
            }
            case 's': {
                return this.jjMoveStringLiteralDfa1_0(0x400000000000L);
            }
            case 't': {
                return this.jjMoveStringLiteralDfa1_0(0x8000000000000L);
            }
            case 'w': {
                return this.jjMoveStringLiteralDfa1_0(0);
            }
            case '{': {
                return this.jjStopAtPos(0, 9);
            }
            case '|': {
                this.jjmatchedKind = 20;
                return this.jjMoveStringLiteralDfa1_0(0);
            }
            case '}': {
                return this.jjStopAtPos(0, 10);
            }
            case '~': {
                return this.jjStopAtPos(0, 42);
            }
        }
        return this.jjMoveNfa_0(3, 0);
    }

    private final int jjMoveStringLiteralDfa1_0(long l) {
        try {
            this.curChar = this.input_stream.readChar();
        }
        catch (IOException iOException) {
            this.jjStopStringLiteralDfa_0(0, l);
            return 1;
        }
        switch (this.curChar) {
            case '&': {
                if ((l & 0) == 0L) break;
                return this.jjStopAtPos(1, 18);
            }
            case '=': {
                if ((l & 0) != 0L) {
                    return this.jjStopAtPos(1, 23);
                }
                if ((l & 0) != 0L) {
                    return this.jjStopAtPos(1, 25);
                }
                if ((l & 0) != 0L) {
                    return this.jjStopAtPos(1, 31);
                }
                if ((l & 0) == 0L) break;
                return this.jjStopAtPos(1, 33);
            }
            case 'a': {
                return this.jjMoveStringLiteralDfa2_0(l, 0);
            }
            case 'e': {
                if ((l & 0) != 0L) {
                    return this.jjStartNfaWithStates_0(1, 26, 5);
                }
                if ((l & 0) != 0L) {
                    return this.jjStartNfaWithStates_0(1, 32, 5);
                }
                if ((l & 0) == 0L) break;
                return this.jjStartNfaWithStates_0(1, 34, 5);
            }
            case 'f': {
                if ((l & 0x8000004000L) == 0L) break;
                return this.jjStartNfaWithStates_0(1, 49, 5);
            }
            case 'h': {
                return this.jjMoveStringLiteralDfa2_0(l, 0);
            }
            case 'i': {
                return this.jjMoveStringLiteralDfa2_0(l, 0);
            }
            case 'l': {
                return this.jjMoveStringLiteralDfa2_0(l, 0);
            }
            case 'm': {
                return this.jjMoveStringLiteralDfa2_0(l, 0);
            }
            case 'n': {
                if ((l & 0x10120000000000L) != 0L) {
                    return this.jjStartNfaWithStates_0(1, 53, 5);
                }
                return this.jjMoveStringLiteralDfa2_0(l, 0);
            }
            case 'o': {
                return this.jjMoveStringLiteralDfa2_0(l, 0);
            }
            case 'q': {
                if ((l & 0) == 0L) break;
                return this.jjStartNfaWithStates_0(1, 24, 5);
            }
            case 'r': {
                if ((l & 0) != 0L) {
                    return this.jjStartNfaWithStates_0(1, 17, 5);
                }
                return this.jjMoveStringLiteralDfa2_0(l, 0x8000000000000L);
            }
            case 't': {
                if ((l & 0) != 0L) {
                    return this.jjStartNfaWithStates_0(1, 28, 5);
                }
                if ((l & 0) == 0L) break;
                return this.jjStartNfaWithStates_0(1, 30, 5);
            }
            case 'u': {
                return this.jjMoveStringLiteralDfa2_0(l, 0);
            }
            case '|': {
                if ((l & 0) == 0L) break;
                return this.jjStopAtPos(1, 16);
            }
        }
        return this.jjStartNfa_0(0, l);
    }

    private final int jjMoveStringLiteralDfa2_0(long l, long l2) {
        if ((l2 &= l) == 0L) {
            return this.jjStartNfa_0(0, l);
        }
        try {
            this.curChar = this.input_stream.readChar();
        }
        catch (IOException iOException) {
            this.jjStopStringLiteralDfa_0(1, l2);
            return 2;
        }
        switch (this.curChar) {
            case 'd': {
                if ((l2 & 0) != 0L) {
                    return this.jjStartNfaWithStates_0(2, 19, 5);
                }
                if ((l2 & 0x300004000000L) == 0L) break;
                return this.jjStartNfaWithStates_0(2, 41, 5);
            }
            case 'i': {
                return this.jjMoveStringLiteralDfa3_0(l2, 0);
            }
            case 'l': {
                return this.jjMoveStringLiteralDfa3_0(l2, 0x100000000000L);
            }
            case 'p': {
                return this.jjMoveStringLiteralDfa3_0(l2, 0);
            }
            case 'r': {
                return this.jjMoveStringLiteralDfa3_0(l2, 0);
            }
            case 's': {
                return this.jjMoveStringLiteralDfa3_0(l2, 0);
            }
            case 't': {
                if ((l2 & 0x3FF000000000000L) == 0L) break;
                return this.jjStartNfaWithStates_0(2, 44, 5);
            }
            case 'u': {
                return this.jjMoveStringLiteralDfa3_0(l2, 0x8000000000000L);
            }
            case 'v': {
                if ((l2 & 0) == 0L) break;
                return this.jjStartNfaWithStates_0(2, 39, 5);
            }
            case 'z': {
                return this.jjMoveStringLiteralDfa3_0(l2, 0x400000000000L);
            }
        }
        return this.jjStartNfa_0(1, l2);
    }

    private final int jjMoveStringLiteralDfa3_0(long l, long l2) {
        if ((l2 &= l) == 0L) {
            return this.jjStartNfa_0(1, l);
        }
        try {
            this.curChar = this.input_stream.readChar();
        }
        catch (IOException iOException) {
            this.jjStopStringLiteralDfa_0(2, l2);
            return 3;
        }
        switch (this.curChar) {
            case 'e': {
                if ((l2 & 0x400000000000L) != 0L) {
                    return this.jjStartNfaWithStates_0(3, 14, 5);
                }
                if ((l2 & 0x8000000000000L) != 0L) {
                    return this.jjStartNfaWithStates_0(3, 46, 5);
                }
                if ((l2 & 0) != 0L) {
                    return this.jjStartNfaWithStates_0(3, 50, 5);
                }
                return this.jjMoveStringLiteralDfa4_0(l2, 0);
            }
            case 'l': {
                if ((l2 & 0) != 0L) {
                    return this.jjStartNfaWithStates_0(3, 45, 5);
                }
                return this.jjMoveStringLiteralDfa4_0(l2, 0);
            }
            case 's': {
                return this.jjMoveStringLiteralDfa4_0(l2, 0);
            }
            case 't': {
                return this.jjMoveStringLiteralDfa4_0(l2, 0);
            }
        }
        return this.jjStartNfa_0(2, l2);
    }

    private final int jjMoveStringLiteralDfa4_0(long l, long l2) {
        if ((l2 &= l) == 0L) {
            return this.jjStartNfa_0(2, l);
        }
        try {
            this.curChar = this.input_stream.readChar();
        }
        catch (IOException iOException) {
            this.jjStopStringLiteralDfa_0(3, l2);
            return 4;
        }
        switch (this.curChar) {
            case 'a': {
                return this.jjMoveStringLiteralDfa5_0(l2, 0);
            }
            case 'e': {
                if ((l2 & 0) != 0L) {
                    return this.jjStartNfaWithStates_0(4, 47, 5);
                }
                if ((l2 & 0) == 0L) break;
                return this.jjStartNfaWithStates_0(4, 51, 5);
            }
            case 'y': {
                if ((l2 & 0) == 0L) break;
                return this.jjStartNfaWithStates_0(4, 11, 5);
            }
        }
        return this.jjStartNfa_0(3, l2);
    }

    private final int jjMoveStringLiteralDfa5_0(long l, long l2) {
        if ((l2 &= l) == 0L) {
            return this.jjStartNfa_0(3, l);
        }
        try {
            this.curChar = this.input_stream.readChar();
        }
        catch (IOException iOException) {
            this.jjStopStringLiteralDfa_0(4, l2);
            return 5;
        }
        switch (this.curChar) {
            case 'c': {
                return this.jjMoveStringLiteralDfa6_0(l2, 0);
            }
        }
        return this.jjStartNfa_0(4, l2);
    }

    private final int jjMoveStringLiteralDfa6_0(long l, long l2) {
        if ((l2 &= l) == 0L) {
            return this.jjStartNfa_0(4, l);
        }
        try {
            this.curChar = this.input_stream.readChar();
        }
        catch (IOException iOException) {
            this.jjStopStringLiteralDfa_0(5, l2);
            return 6;
        }
        switch (this.curChar) {
            case 'h': {
                if ((l2 & 0) == 0L) break;
                return this.jjStartNfaWithStates_0(6, 52, 5);
            }
        }
        return this.jjStartNfa_0(5, l2);
    }

    private final void jjCheckNAdd(int n) {
        if (this.jjrounds[n] != this.jjround) {
            this.jjstateSet[this.jjnewStateCnt++] = n;
            this.jjrounds[n] = this.jjround;
        }
    }

    private final void jjAddStates(int n, int n2) {
        do {
            this.jjstateSet[this.jjnewStateCnt++] = jjnextStates[n];
        } while (n++ != n2);
    }

    private final void jjCheckNAddTwoStates(int n, int n2) {
        this.jjCheckNAdd(n);
        this.jjCheckNAdd(n2);
    }

    private final void jjCheckNAddStates(int n, int n2) {
        do {
            this.jjCheckNAdd(jjnextStates[n]);
        } while (n++ != n2);
    }

    private final void jjCheckNAddStates(int n) {
        this.jjCheckNAdd(jjnextStates[n]);
        this.jjCheckNAdd(jjnextStates[n + 1]);
    }

    private final int jjMoveNfa_0(int n, int n2) {
        int n3 = 0;
        this.jjnewStateCnt = 17;
        int n4 = 1;
        this.jjstateSet[0] = n;
        int n5 = -129;
        while (true) {
            if (++this.jjround == -129) {
                this.ReInitRounds();
            }
            if (this.curChar < '@') {
                long l = 1L << this.curChar;
                block33: do {
                    switch (this.jjstateSet[--n4]) {
                        case 3: {
                            if ((0xFFFFFFFBFFFFDBFFL & l) != 0L) {
                                if (n5 > 7) {
                                    n5 = 7;
                                }
                                this.jjCheckNAddStates(0, 2);
                                break;
                            }
                            if (this.curChar == '\'') {
                                this.jjCheckNAddTwoStates(10, 11);
                                break;
                            }
                            if (this.curChar == '\"') {
                                this.jjCheckNAddTwoStates(7, 8);
                                break;
                            }
                            if (this.curChar == '$') {
                                if (n5 > 58) {
                                    n5 = 58;
                                }
                                this.jjCheckNAdd(5);
                                break;
                            }
                            if (this.curChar != '#') break;
                            this.jjstateSet[this.jjnewStateCnt++] = 0;
                            break;
                        }
                        case 0: {
                            if (this.curChar != '#') break;
                            this.jjCheckNAddTwoStates(1, 2);
                            break;
                        }
                        case 1: {
                            if ((0 & l) == 0L) break;
                            this.jjCheckNAddTwoStates(1, 2);
                            break;
                        }
                        case 2: {
                            if ((0x3FF001000000000L & l) == 0L) break;
                            n5 = 1;
                            break;
                        }
                        case 4: {
                            if (this.curChar != '$') continue block33;
                            if (n5 > 58) {
                                n5 = 58;
                            }
                            this.jjCheckNAdd(5);
                            break;
                        }
                        case 5: {
                            if ((0xFFFFFF7FFFFFDBFFL & l) == 0L) continue block33;
                            if (n5 > 58) {
                                n5 = 58;
                            }
                            this.jjCheckNAdd(5);
                            break;
                        }
                        case 6: {
                            if (this.curChar != '\"') break;
                            this.jjCheckNAddTwoStates(7, 8);
                            break;
                        }
                        case 7: {
                            if ((0 & l) == 0L) break;
                            this.jjCheckNAddTwoStates(7, 8);
                            break;
                        }
                        case 8: {
                            if (this.curChar != '\"' || n5 <= 61) continue block33;
                            n5 = 61;
                            break;
                        }
                        case 9: {
                            if (this.curChar != '\'') break;
                            this.jjCheckNAddTwoStates(10, 11);
                            break;
                        }
                        case 10: {
                            if ((0x7FFFFFE87FFFFFEL & l) == 0L) break;
                            this.jjCheckNAddTwoStates(10, 11);
                            break;
                        }
                        case 11: {
                            if (this.curChar != '\'' || n5 <= 61) continue block33;
                            n5 = 61;
                            break;
                        }
                        case 12: {
                            if ((0xFFFFFFFBFFFFDBFFL & l) == 0L) continue block33;
                            if (n5 > 7) {
                                n5 = 7;
                            }
                            this.jjCheckNAddStates(0, 2);
                            break;
                        }
                        case 13: {
                            if ((0xFFFFFFFBFFFFDBFFL & l) == 0L) continue block33;
                            if (n5 > 7) {
                                n5 = 7;
                            }
                            this.jjCheckNAdd(13);
                            break;
                        }
                        case 14: {
                            if ((0xFFFFFFFBFFFFDBFFL & l) == 0L) break;
                            this.jjCheckNAddTwoStates(14, 15);
                            break;
                        }
                        case 15: {
                            if (this.curChar != '.') break;
                            this.jjCheckNAdd(16);
                            break;
                        }
                        case 16: {
                            if ((0xFFFFFFFBFFFFDBFFL & l) == 0L) continue block33;
                            if (n5 > 8) {
                                n5 = 8;
                            }
                            this.jjCheckNAdd(16);
                            break;
                        }
                    }
                } while (n4 != n3);
            } else if (this.curChar < '\u0080') {
                long l = 1L << (this.curChar & 0x3F);
                block34: do {
                    switch (this.jjstateSet[--n4]) {
                        case 3: 
                        case 5: {
                            if ((0 & l) == 0L) continue block34;
                            if (n5 > 58) {
                                n5 = 58;
                            }
                            this.jjCheckNAdd(5);
                            break;
                        }
                        case 1: {
                            this.jjAddStates(3, 4);
                            break;
                        }
                        case 7: {
                            this.jjAddStates(5, 6);
                            break;
                        }
                        case 10: {
                            this.jjAddStates(7, 8);
                            break;
                        }
                    }
                } while (n4 != n3);
            } else {
                int n6 = (this.curChar & 0xFF) >> 6;
                long l = 1L << (this.curChar & 0x3F);
                do {
                    switch (this.jjstateSet[--n4]) {
                        case 1: {
                            if ((jjbitVec0[n6] & l) == 0L) break;
                            this.jjAddStates(3, 4);
                            break;
                        }
                        case 7: {
                            if ((jjbitVec0[n6] & l) == 0L) break;
                            this.jjAddStates(5, 6);
                            break;
                        }
                        case 10: {
                            if ((jjbitVec0[n6] & l) == 0L) break;
                            this.jjAddStates(7, 8);
                            break;
                        }
                    }
                } while (n4 != n3);
            }
            if (n5 != -129) {
                this.jjmatchedKind = n5;
                this.jjmatchedPos = n2;
                n5 = -129;
            }
            ++n2;
            n4 = this.jjnewStateCnt;
            this.jjnewStateCnt = n3;
            if (n4 == (n3 = 17 - this.jjnewStateCnt)) {
                return n2;
            }
            try {
                this.curChar = this.input_stream.readChar();
            }
            catch (IOException iOException) {
                return n2;
            }
        }
    }

    public ParserTokenManager(SimpleCharStream simpleCharStream) {
        this.input_stream = simpleCharStream;
    }

    public ParserTokenManager(SimpleCharStream simpleCharStream, int n) {
        this(simpleCharStream);
        this.SwitchTo(n);
    }

    public void ReInit(SimpleCharStream simpleCharStream) {
        this.jjnewStateCnt = 0;
        this.jjmatchedPos = 0;
        this.curLexState = this.defaultLexState;
        this.input_stream = simpleCharStream;
        this.ReInitRounds();
    }

    private final void ReInitRounds() {
        this.jjround = 0x1000080;
        int n = 17;
        while (n-- > 0) {
            this.jjrounds[n] = 128;
        }
    }

    public void ReInit(SimpleCharStream simpleCharStream, int n) {
        this.ReInit(simpleCharStream);
        this.SwitchTo(n);
    }

    public void SwitchTo(int n) {
        if (n >= 1 || n < 0) {
            throw new TokenMgrError(new StringBuffer().append("Error: Ignoring invalid lexical state : ").append(n).append(". State unchanged.").toString(), 2);
        }
        this.curLexState = n;
    }

    private final Token jjFillToken() {
        Token token = Token.newToken(this.jjmatchedKind);
        token.kind = this.jjmatchedKind;
        String string = jjstrLiteralImages[this.jjmatchedKind];
        token.image = string == null ? this.input_stream.GetImage() : string;
        token.beginLine = this.input_stream.getBeginLine();
        token.beginColumn = this.input_stream.getBeginColumn();
        token.endLine = this.input_stream.getEndLine();
        token.endColumn = this.input_stream.getEndColumn();
        return token;
    }

    public final Token getNextToken() {
        int n;
        block11: {
            Object var2_1 = null;
            n = 0;
            while (true) {
                try {
                    this.curChar = this.input_stream.BeginToken();
                }
                catch (IOException iOException) {
                    this.jjmatchedKind = 0;
                    Token token = this.jjFillToken();
                    return token;
                }
                try {
                    this.input_stream.backup(0);
                    while (this.curChar <= ' ' && (0xFFFFFFFFFFFFFFFFL & 1L << this.curChar) != 0L) {
                        this.curChar = this.input_stream.BeginToken();
                    }
                }
                catch (IOException iOException) {
                    continue;
                }
                this.jjmatchedKind = -129;
                this.jjmatchedPos = 0;
                n = this.jjMoveStringLiteralDfa0_0();
                if (this.jjmatchedKind == -129) break block11;
                if (this.jjmatchedPos + 1 < n) {
                    this.input_stream.backup(n - this.jjmatchedPos - 1);
                }
                if ((jjtoToken[this.jjmatchedKind >> 6] & 1L << (this.jjmatchedKind & 0x3F)) != 0L) break;
            }
            Token token = this.jjFillToken();
            return token;
        }
        int n2 = this.input_stream.getEndLine();
        int n3 = this.input_stream.getEndColumn();
        String string = null;
        boolean bl = false;
        try {
            this.input_stream.readChar();
            this.input_stream.backup(1);
        }
        catch (IOException iOException) {
            bl = true;
            String string2 = string = n <= 1 ? "" : this.input_stream.GetImage();
            if (this.curChar == '\n' || this.curChar == '\r') {
                ++n2;
                n3 = 0;
            }
            ++n3;
        }
        if (!bl) {
            this.input_stream.backup(1);
            string = n <= 1 ? "" : this.input_stream.GetImage();
        }
        throw new TokenMgrError(bl, this.curLexState, n2, n3, string, this.curChar, 0);
    }
}

