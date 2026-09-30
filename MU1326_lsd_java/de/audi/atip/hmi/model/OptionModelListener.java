/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

public interface OptionModelListener {
    public static final int ACTION_SAVE_FAVORITE_DISABLED = 0;

    public void keyPressed(int var1, int var2, int var3, int var4, int var5);

    public void keyReleased(int var1, int var2, int var3, int var4, int var5);

    public void keyTyped(int var1, int var2, int var3, int var4, int var5);

    public void customAction(int var1, int var2, int var3, int var4, int var5);
}

