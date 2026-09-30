/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.intra;

public interface IAppSoundListener {
    public void updateMuteTheftProtection(boolean var1);

    public void updateLoweringEntertainment(int var1, int var2);

    public void updateVolumeRange(int var1, int var2);

    public void updateVolume(int var1, int var2, int var3);

    public void menuVolumeRange(int var1, int var2, int var3);

    public void menuVolEntRange(int var1, int var2, int var3);

    public void updateAmplifier(int var1);

    public void updatePresetPositionList(int var1);

    public void updatePresetPosition(int var1);

    public void inputGainOffsetRange(int var1, int var2);

    public void updateInputGainOffset(int var1, int var2);

    public void updateThreeDMode(int var1);

    public void updateThreeDModeRange(int var1, int var2);

    public void updatePresetEQList(int var1);

    public void updatePresetEQ(int var1);

    public void updateFader(int var1, int var2, int var3);

    public void updateFaderRanges(int var1, int var2);

    public void updateBalance(int var1, int var2, int var3);

    public void updateBalanceRange(int var1, int var2);
}

