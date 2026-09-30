/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

public interface IAsyncLabelController {
    public static final int UNLIMITED_FRAME_SIZE = Integer.MAX_VALUE;
    public static final int AUTO_FRAME_SIZE = 0;

    public void setFrameSize(int var1);

    public int getFrameSize();
}

