/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.texteditor.mlcursorll;

import de.audi.atip.hmi.model.texteditor.MLCursor;
import de.audi.atip.hmi.model.texteditor.mlcursorll.Op;

public class NextWordOp
implements Op {
    public int[] doOp(MLCursor mLCursor) {
        return mLCursor.getNextWord();
    }

    public int[] noOp(MLCursor mLCursor) {
        return mLCursor.getCurrentWord();
    }

    public int[] doNotOp(MLCursor mLCursor) {
        return mLCursor.getPrevWord();
    }
}

