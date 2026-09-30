/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.texteditor.mlcursorll;

import de.audi.atip.hmi.model.texteditor.MLCursor;
import de.audi.atip.hmi.model.texteditor.mlcursorll.Op;

public class NexCharOp
implements Op {
    int[] retOp = new int[1];
    int[] retNoOp = new int[1];
    int[] retNotOp = new int[1];

    public int[] doOp(MLCursor mLCursor) {
        this.retOp[0] = mLCursor.getNextChar();
        return this.retOp;
    }

    public int[] noOp(MLCursor mLCursor) {
        this.retNoOp[0] = mLCursor.getCurrentChar();
        return this.retNoOp;
    }

    public int[] doNotOp(MLCursor mLCursor) {
        this.retNotOp[0] = mLCursor.getPrevChar();
        return this.retNotOp;
    }
}

