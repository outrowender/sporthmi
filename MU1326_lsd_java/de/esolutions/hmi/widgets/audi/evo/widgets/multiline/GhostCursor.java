/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.multiline;

import de.audi.atip.hmi.model.texteditor.DoubleCursor;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.MLDisplayData;

public class GhostCursor {
    public static final int TYPE_START_PREF = 0;
    public static final int TYPE_NL_PREF = 1;
    public static final int TYPE_WORD = 2;
    public static final int TYPE_SUFFIX = 3;
    private int currentWordType;
    private DoubleCursor m_cursor;

    public GhostCursor(DoubleCursor doubleCursor, MLDisplayData mLDisplayData) {
        this.m_cursor = doubleCursor;
    }

    public int currentCharIdx() {
        return this.m_cursor.currentCharIdx();
    }

    public int[] currentWordIdx() {
        this.updateCursorMode(this.m_cursor.getCursorMode());
        int[] nArray = this.m_cursor.currentWordIdx();
        if (this.currentWordType == 1 || this.currentWordType == 0) {
            nArray = new int[]{nArray[0], nArray[0]};
        } else if (this.currentWordType == 3) {
            nArray = new int[]{nArray[1], nArray[1]};
        }
        return nArray;
    }

    public int getCursorMode() {
        int n = this.m_cursor.getCursorMode();
        this.updateCursorMode(n);
        return n;
    }

    public char[] getCharArray() {
        return this.m_cursor.getCharArray();
    }

    public String getString() {
        return this.m_cursor.getString();
    }

    public int getCurrentWordType() {
        this.updateCursorMode(this.m_cursor.getCursorMode());
        return this.currentWordType;
    }

    public void resetToWordType() {
        this.currentWordType = 2;
    }

    public int[] next() {
        return this.m_cursor.next();
    }

    public int[] prev() {
        return this.m_cursor.prev();
    }

    public int[] currentIdx() {
        return this.m_cursor.currentIdx();
    }

    public void setCursorMode(int n) {
        this.m_cursor.setCursorMode(n);
        this.updateCursorMode(n);
    }

    public int length() {
        return this.m_cursor.length();
    }

    public boolean mtxAquireLock() {
        return this.m_cursor.mtxAquireLock();
    }

    public void mtxReleaseLock() {
        this.m_cursor.mtxReleaseLock();
    }

    public String toString() {
        return this.m_cursor.toString();
    }

    private void updateCursorMode(int n) {
        if (n == 1) {
            this.currentWordType = 2;
        }
    }
}

