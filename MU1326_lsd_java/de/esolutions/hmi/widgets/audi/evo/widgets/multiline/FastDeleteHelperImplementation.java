/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.multiline;

import de.audi.atip.hmi.model.texteditor.DoubleCursor;
import de.audi.atip.hmi.model.texteditor.MLUtils;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.FastDeleteHelper;

public class FastDeleteHelperImplementation
implements FastDeleteHelper {
    private final DoubleCursor m_cursor;

    public FastDeleteHelperImplementation(DoubleCursor doubleCursor) {
        this.m_cursor = doubleCursor;
    }

    @Override
    public boolean isEditMode() {
        return this.m_cursor.getCursorMode() == 1;
    }

    @Override
    public int getWordLength() {
        int[] nArray = this.m_cursor.currentWordIdx();
        int n = 0;
        if (nArray[0] != -1) {
            n = nArray[1] - nArray[0] + 1;
        }
        return n;
    }

    @Override
    public int getTextLength() {
        return this.m_cursor.getString().length();
    }

    @Override
    public void deleteWordIncludingPrecedingWhitespaces() {
        int[] nArray = this.m_cursor.currentWordIdx();
        if (nArray[0] != -1) {
            boolean bl = MLUtils.getCharType(this.m_cursor.getCharArray()[nArray[0]]) != 1;
            nArray = this.m_cursor.removeWord();
            if (bl && nArray[0] != -1 && MLUtils.getCharType(this.m_cursor.getCharArray()[nArray[0]]) == 0) {
                this.m_cursor.remove(nArray[0], nArray[1], nArray[0]);
            }
        }
    }

    @Override
    public boolean deleteOneChar() {
        boolean bl;
        int n = this.m_cursor.currentCharIdx();
        boolean bl2 = bl = n == -1;
        if (!bl) {
            char c2 = this.m_cursor.getCharArray()[n];
            this.m_cursor.removeChar();
            int n2 = this.m_cursor.currentCharIdx();
            boolean bl3 = bl = n2 == -1;
            if (!bl) {
                char c3 = this.m_cursor.getCharArray()[n2];
                bl = this.isEndOfWord(c2, c3);
            }
        }
        return bl;
    }

    private boolean isWhitespace(char c2) {
        return MLUtils.getCharType(c2) == 0;
    }

    private boolean isInterpunctation(char c2) {
        return MLUtils.getCharType(c2) == 1;
    }

    private boolean isEndOfWord(char c2, char c3) {
        return this.isWhitespace(c2) && !this.isWhitespace(c3) || this.isInterpunctation(c3) && !this.isWhitespace(c2) && !this.isInterpunctation(c2);
    }

    @Override
    public boolean lock() {
        return this.m_cursor.mtxAquireLock();
    }

    @Override
    public void unlock() {
        this.m_cursor.mtxReleaseLock();
    }
}

