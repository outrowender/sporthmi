/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.HMIModelGUI;

public interface ButtonModelGUI
extends HMIModelGUI {
    public boolean getPressed();

    public void keyPressed(int var1, int var2);

    public void keyReleased(int var1, int var2);

    public void keyTyped(int var1, int var2);

    public void keyLongTyped(int var1, int var2);
}

