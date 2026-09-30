/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.HMIModelGUI;

public interface BrowserModelGUI
extends HMIModelGUI {
    public void keyPressed(int var1, int var2);

    public void keyReleased(int var1, int var2);

    public void keyTyped(int var1, int var2);

    public void decrement(int var1, int var2);

    public void increment(int var1, int var2);

    public void moveNW(int var1, int var2);

    public void moveN(int var1, int var2);

    public void moveNE(int var1, int var2);

    public void moveE(int var1, int var2);

    public void moveSE(int var1, int var2);

    public void moveS(int var1, int var2);

    public void moveSW(int var1, int var2);

    public void moveW(int var1, int var2);

    public void moveMiddle(int var1);
}

