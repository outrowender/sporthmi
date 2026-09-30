/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.IPopupKeyConsumptionListener;

public interface IPopupKeyConsuptionStrategy {
    public int getPopupID();

    public void setConsumeHKReturn(int var1);

    public void setConsumeDDSPress(int var1);

    public void setConsumeKeyTurned(int var1);

    public void setConsumeSKPress(int var1);

    public void setConsumeTouchPad(int var1);

    public void setConsumeGenericKeys(int var1, int[] var2);

    public void setHKPressFilter(int[] var1);

    public int[] getHKPressFilter();

    public void registerPopupKeyConsumptionListener(IPopupKeyConsumptionListener var1);

    public boolean doesHKFilterContainsKey(int var1);

    public int getConsumeHKReturn();

    public int getConsumeDDSPress();

    public int getConsumeKeyTurned();

    public int getConsumeSKPress();

    public int getConsumeTouchPad();

    public int getConsumeGenericStrategy();

    public int[] getConsumeGenericKeys();
}

