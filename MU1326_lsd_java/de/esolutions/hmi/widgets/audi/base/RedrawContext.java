/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

public interface RedrawContext {
    public static final int BLACK = -16777216;
    public static final int WHITE = -1;
    public static final int CYAN = -16711681;
    public static final int DISABLED_OPACITY = 0x4D000000;
    public static final int TRANSPARENT = 0;

    public int[] setColorIndices(int[] var1);

    public void setActiveColorPlate(int[] var1);

    public int[] getActiveColorPlate();

    public void setScreenID(int var1);

    public int getScreenID();

    public void setNodeIndex(int var1);

    public int getNodeIndex();

    public int getCalculatedNodeIndex(int var1);

    public int getColor(int var1);
}

