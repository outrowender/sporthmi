/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

public interface ButtonListener {
    public void keyPressed(int var1, int var2, int var3);

    public void keyReleased(int var1, int var2, int var3);

    public void keyTyped(int var1, int var2, int var3);

    public void keyLongTyped(int var1, int var2, int var3);
}

