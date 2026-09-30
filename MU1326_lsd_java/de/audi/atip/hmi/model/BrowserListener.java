/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

public interface BrowserListener {
    public void keyPressed(int var1, int var2, int var3);

    public void keyReleased(int var1, int var2, int var3);

    public void keyTyped(int var1, int var2, int var3);

    public void decrement(int var1, int var2, int var3);

    public void increment(int var1, int var2, int var3);

    public void moveNW(int var1, int var2, int var3);

    public void moveN(int var1, int var2, int var3);

    public void moveNE(int var1, int var2, int var3);

    public void moveE(int var1, int var2, int var3);

    public void moveSE(int var1, int var2, int var3);

    public void moveS(int var1, int var2, int var3);

    public void moveSW(int var1, int var2, int var3);

    public void moveW(int var1, int var2, int var3);

    public void moveMiddle(int var1, int var2);
}

