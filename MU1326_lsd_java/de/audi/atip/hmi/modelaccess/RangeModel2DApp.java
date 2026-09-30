/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.RangeListener2D;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public interface RangeModel2DApp
extends ButtonModelApp {
    public void setLimitsX(int var1, int var2, int var3);

    public void setLimitsY(int var1, int var2, int var3);

    public void setLimitsX(int var1, int var2, int var3, int var4);

    public void setLimitsY(int var1, int var2, int var3, int var4);

    public void setLimitsXY(int var1, int var2, int var3, int var4, int var5, int var6);

    public void setLimitsXY(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8);

    public void setMedialPositionX(int var1);

    public void setMedialPositionY(int var1);

    public int getMaximumX();

    public int getMaximumY();

    public int getMinimumX();

    public int getMinimumY();

    public void setRangeListener(RangeListener2D var1);

    public int getStepX();

    public int getStepY();

    public void setValue(int var1, int var2);

    public int getValueX();

    public int getValueY();

    public int getMedialPositionX();

    public int getMedialPositionY();

    public void forceUpdate(boolean var1);
}

