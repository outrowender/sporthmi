/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.ButtonModelGUI;

public interface RangeModelGUI
extends ButtonModelGUI {
    public int getMaximum();

    public int getMinimum();

    public int getStep();

    public int getValue();

    public int getMedialPosition();

    public void decrement(int var1, int var2);

    public void increment(int var1, int var2);

    public void forceUpdate(boolean var1);

    public boolean isForceUpdateEnabled();
}

