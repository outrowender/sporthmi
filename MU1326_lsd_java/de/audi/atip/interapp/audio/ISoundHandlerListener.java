/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio;

public interface ISoundHandlerListener {
    public void updateBalance(short var1);

    public void updateBalanceRange(int var1, int var2);

    public void updateFader(short var1);

    public void updateFaderRange(int var1, int var2);

    public void updateBass(short var1);

    public void updateBassRange(int var1, int var2);

    public void updateTreble(short var1);

    public void updateTrebleRange(int var1, int var2);

    public void updateSubwoofer(short var1);

    public void updateSubwooferRange(int var1, int var2);

    public void updateSurroundLevel(short var1);

    public void updateSurroundLevelRange(int var1, int var2);

    public void updateNoiseCompensation(short var1);

    public void updateNoiseCompensationRange(int var1, int var2);

    public void updateThreeDMode(int var1);

    public void updateThreeDModeRange(int var1, int var2);

    public void updateAmplifier(int var1);

    public void updatePresetPositionList(int var1);

    public void updatePresetPosition(int var1);

    public void updatePresetEqList(int var1);

    public void updatePresetEq(int var1);

    public void distributeValuesAndRanges(ISoundHandlerListener var1);
}

