/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

public interface ContextGUIListener {
    public void increment(int var1, int var2);

    public void itemFocused(int var1, int var2);

    public void itemReleased(int var1, int var2);

    public void itemSelected(int var1, int var2, int var3, int var4);

    public void joystick(int var1, int var2);

    public void keyPressed(int var1, int var2);

    public void keyReleased(int var1, int var2);

    public void keyTyped(int var1, int var2);

    public void touchPadPositionMoved(int var1, int var2, int var3, int var4, int var5);

    public void touchScreenMoved(int var1, int var2, int var3, int var4, int var5);

    public void touchScreenPressed(int var1, int var2, int var3);

    public void touchScreenLongPressed(int var1, int var2, int var3);

    public void touchScreenReleased(int var1, int var2, int var3);

    public void touchScreenDoubleClick(int var1, int var2, int var3);

    public void touchScreenPinch(int var1, float var2, int var3, int var4);

    public void touchScreenRotate(int var1, short var2);
}

