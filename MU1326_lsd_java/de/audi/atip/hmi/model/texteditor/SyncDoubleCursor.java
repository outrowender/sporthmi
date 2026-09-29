/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.texteditor;

import de.audi.atip.hmi.model.texteditor.DoubleCursor;

public class SyncDoubleCursor {
    public static final int[] INVALID_DIM = new int[]{-1, -1};
    public static final String INVALID_STR;
    DoubleCursor m_cursor;

    public String[] getAlternatives() {
        String[] stringArray = null;
        stringArray = this.m_cursor.getAlternatives();
        return stringArray;
    }

    public boolean selectAlternative(int n) {
        boolean bl = false;
        this.m_cursor.selectAlternative(n);
        return bl;
    }

    public void insertChar(char c2) {
        this.m_cursor.insertChar(c2);
    }

    public void insertWord(String string) {
        this.m_cursor.insertWord(string);
    }

    public void insertWord(String[] stringArray) {
        this.m_cursor.insertWord(stringArray);
    }

    public void insertWords(String[][] stringArray) {
        this.m_cursor.insertWords(stringArray);
    }

    public void remove() {
        this.m_cursor.remove();
    }

    public int removeChar() {
        int n = -1;
        n = this.m_cursor.removeChar();
        return n;
    }

    public int[] removeWord() {
        int[] nArray = INVALID_DIM;
        nArray = this.m_cursor.removeWord();
        return nArray;
    }

    public void remove(int n, int n2, int n3) {
        this.m_cursor.remove(n, n2, n3);
    }

    public void replace(String[] stringArray) {
        this.m_cursor.replace(stringArray);
    }

    public int nextChar() {
        int n = -1;
        n = this.m_cursor.nextChar();
        return n;
    }

    public int[] nextWord() {
        int[] nArray = INVALID_DIM;
        nArray = this.m_cursor.nextWord();
        return nArray;
    }

    public int[] next() {
        int[] nArray = INVALID_DIM;
        nArray = this.m_cursor.next();
        return nArray;
    }

    public int prevChar() {
        int n = -1;
        n = this.m_cursor.prevChar();
        return n;
    }

    public int[] prevWord() {
        int[] nArray = INVALID_DIM;
        nArray = this.m_cursor.prevWord();
        return nArray;
    }

    public int[] prev() {
        int[] nArray = INVALID_DIM;
        nArray = this.m_cursor.prev();
        return nArray;
    }

    public String current() {
        String string = "";
        string = this.m_cursor.current();
        return string;
    }

    public int[] currentIdx() {
        int[] nArray = INVALID_DIM;
        nArray = this.m_cursor.currentIdx();
        return nArray;
    }

    public char[] getCharArray() {
        char[] cArray = null;
        cArray = this.m_cursor.getCharArray();
        return cArray;
    }

    public char currentChar() {
        char c2 = '\u0000';
        c2 = this.m_cursor.currentChar();
        return c2;
    }

    public int currentCharIdx() {
        int n = 0;
        n = this.m_cursor.currentCharIdx();
        return n;
    }

    public String currentWord() {
        String string = null;
        string = this.m_cursor.currentWord();
        return string;
    }

    public int[] currentWordIdx() {
        int[] nArray = INVALID_DIM;
        nArray = this.m_cursor.currentWordIdx();
        return nArray;
    }

    public int currentWordLen() {
        int n = 0;
        n = this.m_cursor.currentWordLen();
        return n;
    }

    public int getCursorPos() {
        int n = 0;
        n = this.m_cursor.getCursorPos();
        return n;
    }

    public void setCursorPos(int n) {
        this.m_cursor.setCursorPos(n);
    }

    public String getString() {
        String string = null;
        string = this.m_cursor.getString();
        return string;
    }

    public int getCursorMode() {
        int n = 0;
        n = this.m_cursor.getCursorMode();
        return n;
    }

    public void setCursorMode(int n) {
        this.m_cursor.setCursorMode(n);
    }

    public int length() {
        int n = 0;
        n = this.m_cursor.length();
        return n;
    }

    public boolean isDirty() {
        boolean bl = true;
        bl = this.m_cursor.isDirty();
        return bl;
    }

    public void resetDirty() {
        this.m_cursor.resetDirty();
    }

    public int getLastFixedChar() {
        int n = 0;
        n = this.m_cursor.getLastFixedChar();
        return n;
    }

    public void clear() {
        this.m_cursor.clear();
    }

    public String lastAdded() {
        String string = null;
        string = this.m_cursor.lastAdded();
        return string;
    }

    public boolean removeLastAdded() {
        boolean bl = false;
        bl = this.m_cursor.removeLastAdded();
        return bl;
    }

    public void lockLL(boolean bl) {
        this.m_cursor.lockLL(bl);
    }

    public void syncLL() {
        this.m_cursor.syncLL();
    }
}

