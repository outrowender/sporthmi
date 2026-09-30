/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.texteditor.mlcursorll;

import de.audi.atip.hmi.model.texteditor.MLCursor;

public interface Op {
    public int[] doOp(MLCursor var1);

    public int[] noOp(MLCursor var1);

    public int[] doNotOp(MLCursor var1);
}

