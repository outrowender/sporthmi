/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.ButtonModelGUI;

public interface RangeModel2DGUI
extends ButtonModelGUI {
    public int getMaximumX();

    public int getMaximumY();

    public int getMinimumX();

    public int getMinimumY();

    public int getStepX();

    public int getStepY();

    public int getValueX();

    public int getValueY();

    public int getMedialPositionX();

    public int getMedialPositionY();

    public void setValueHit(int var1, int var2, int var3);

    public void forceUpdate(boolean var1);

    public boolean isForceUpdateEnabled();
}

