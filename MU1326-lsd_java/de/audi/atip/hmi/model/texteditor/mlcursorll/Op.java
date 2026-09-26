/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.texteditor.mlcursorll;

import de.audi.atip.hmi.model.texteditor.MLCursor;

public interface Op {
    default public int[] doOp(MLCursor mLCursor) {
    }

    default public int[] noOp(MLCursor mLCursor) {
    }

    default public int[] doNotOp(MLCursor mLCursor) {
    }
}

