/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.RangeModelGUI;

public interface VirtualButtonModelGUI
extends RangeModelGUI {
    public void joyN(int var1);

    public void joyNW(int var1);

    public void joyW(int var1);

    public void joySW(int var1);

    public void joyS(int var1);

    public void joySE(int var1);

    public void joyE(int var1);

    public void joyNE(int var1);

    public void joyIdle(int var1);

    public void touchPadPositionMoved(int var1, int var2, int var3, int var4, int var5);

    public void touchPadReleased(int var1, int var2, int var3);

    public void touchPadPressed(int var1, int var2, int var3);

    public void touchScreenMoved(int var1, int var2, int var3, int var4, int var5);

    public void touchScreenFlicked(int var1, int var2, int var3, int var4, int var5);

    public void touchScreenPressed(int var1, int var2, int var3);

    public void touchScreenLongPressed(int var1, int var2, int var3);

    public void touchScreenReleased(int var1, int var2, int var3);

    public void touchScreenDoubleClick(int var1, int var2, int var3);

    public void touchScreenPinch(float var1, int var2, int var3, int var4);

    public void touchScreenRotate(short var1, int var2);
}

