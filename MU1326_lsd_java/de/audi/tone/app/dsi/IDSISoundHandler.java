/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.dsi;

import de.audi.tone.app.AmplifierVariant;
import org.dsi.ifc.audio.DSISound;

public interface IDSISoundHandler {
    public void registerDSI(DSISound var1);

    public void deregisterDSISound();

    public void increaseVolume(int var1, int var2, int var3);

    public void decreaseVolume(int var1, int var2, int var3);

    public void changeBalance(int var1, int var2);

    public void setBalance(int var1, int var2);

    public void changeFader(int var1, int var2);

    public void setFader(int var1, int var2);

    public void changeBass(int var1, int var2);

    public void changeTreble(int var1, int var2);

    public void changeNoiseCompensation(int var1);

    public void setNoiseCompensation(int var1);

    public void changeSubwoofer(int var1, int var2);

    public void changeSurroundLevel(int var1, int var2);

    public void setVolume(int var1, int var2, int var3);

    public void getVolume(int var1, int var2);

    public void changeLoweringEntertainment(int var1, int var2, int var3);

    public void setLoweringEntertainment(int var1, int var2);

    public void revertToFactorySettings(int var1, int[] var2, String var3);

    public void revertToFactorySettings(int var1, int var2);

    public void setPresetPosition(int var1, int var2);

    public void setPresetEQ(int var1, int var2);

    public void getMenuVolumeRange(int var1, int var2);

    public void getMenuVolEntRange(int var1);

    public void getInputGainOffsetRange(int var1, int var2);

    public void getInputGainOffset(int var1, int var2);

    public void changeInputGainOffset(int var1, int var2, int var3);

    public void setMicGainLevel(int var1);

    public void setThreeDMode(int var1);

    public void setThreeDMode(int var1, int var2, int var3);

    public void setSurround(int var1, int var2, boolean var3);

    public void setSurround(int var1, boolean var2);

    public void setInputGainOffSet(int var1, int var2, short var3);

    public void setDuration(int var1, int var2);

    public void getLoweringEntertainment(int var1, int var2, int var3);

    public AmplifierVariant getAmplifierVariant();
}

