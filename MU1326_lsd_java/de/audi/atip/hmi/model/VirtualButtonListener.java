/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.RangeListener;

public interface VirtualButtonListener
extends RangeListener {
    public void touchPadPositionMoved(int var1, int var2, int var3, int var4, int var5, int var6);

    public void stickN(int var1, int var2);

    public void stickNW(int var1, int var2);

    public void stickW(int var1, int var2);

    public void stickSW(int var1, int var2);

    public void stickS(int var1, int var2);

    public void stickSE(int var1, int var2);

    public void stickE(int var1, int var2);

    public void stickNE(int var1, int var2);

    public void stickIdle(int var1, int var2);

    public void touchScreenMoved(int var1, int var2, int var3, int var4, int var5, int var6);

    public void touchScreenPressed(int var1, int var2, int var3, int var4);

    public void touchScreenLongPressed(int var1, int var2, int var3, int var4);

    public void touchScreenReleased(int var1, int var2, int var3, int var4);

    public void touchScreenDoubleClick(int var1, int var2, int var3, int var4);

    public void touchScreenPinch(int var1, float var2, int var3, int var4, int var5);

    public void touchScreenRotate(int var1, short var2, int var3);

    public void touchPadReleased(int var1, int var2, int var3);

    public void touchPadPressed(int var1, int var2, int var3);
}

