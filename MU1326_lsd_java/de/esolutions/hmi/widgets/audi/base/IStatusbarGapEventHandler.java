/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

public interface IStatusbarGapEventHandler {
    public int getCurrentGapWidth();

    public boolean setGapWidth(int var1, boolean var2);

    public int getMaxGapWidth();

    public float getGapHeight();

    public void setGapHeight(float var1);
}

