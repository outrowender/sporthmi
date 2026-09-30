/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public interface RangeModelApp
extends ButtonModelApp {
    public void setLimits(int var1, int var2, int var3);

    public void setLimits(int var1, int var2, int var3, int var4);

    public void setMedialPosition(int var1);

    public int getMaximum();

    public int getMinimum();

    public void setRangeListener(RangeListener var1);

    public int getStep();

    public void setValue(int var1);

    public int getValue();

    public int getMedialPosition();

    public void forceUpdate(boolean var1);
}

