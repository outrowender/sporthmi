/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.HMIModelGUI;

public interface OptionModelGUI
extends HMIModelGUI {
    public static final int ACTION_SAVE_FAVORITE_DISABLED = 0;

    public void keyPressed(int var1, int var2, int var3, int var4);

    public void keyReleased(int var1, int var2, int var3, int var4);

    public void keyTyped(int var1, int var2, int var3, int var4);

    public void customAction(int var1, int var2, int var3, int var4);
}

