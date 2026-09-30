/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.audio;

import org.dsi.ifc.audio.AmplifierCapabilities;
import org.dsi.ifc.base.DSIListener;

public interface DSISoundListener
extends DSIListener {
    public void inputGainOffsetRange(int var1, int var2, int var3, int var4);

    public void menuVolEntRange(int var1, int var2, int var3);

    public void menuVolumeRange(int var1, int var2, int var3, int var4);

    public void volumeRange(int var1, int var2, int var3, int var4, int var5);

    public void updateSurroundOnOff(int var1, int var2, boolean var3, int var4);

    public void updateBalance(int var1, int var2, short var3, int var4);

    public void updateBalanceRange(int var1, int var2, int var3);

    public void updateBass(int var1, int var2, short var3, int var4);

    public void updateBassRange(int var1, int var2, int var3);

    public void createExportFileResult(int var1, boolean var2);

    public void updateFader(int var1, int var2, short var3, int var4);

    public void updateFaderRange(int var1, int var2, int var3);

    public void importFileResponse(int var1, boolean var2);

    public void updateInputGainOffset(int var1, int var2, short var3, int var4);

    public void updateLoweringEntertainment(int var1, int var2, int var3, short var4, int var5);

    public void updateMutePinState(boolean var1, int var2);

    public void updateSubwoofer(int var1, int var2, short var3, int var4);

    public void updateSubwooferRange(int var1, int var2, int var3);

    public void updateSurrLevelRange(int var1, int var2, int var3);

    public void updateSurroundLevel(int var1, int var2, short var3, int var4);

    public void updateTreble(int var1, int var2, short var3, int var4);

    public void updateTrebleRange(int var1, int var2, int var3);

    public void updateVolume(int var1, int var2, short var3, int var4);

    public void updateVolumeRange(int var1, int var2, int var3);

    public void updateMiddle(int var1, int var2, short var3, int var4);

    public void updateMiddleRange(int var1, int var2, int var3);

    public void updateEqualizerRange(int var1, int var2, int[] var3, int var4);

    public void updateEqualizer(int[] var1, int[] var2, int var3);

    public void updateOnVolumeLimit(int var1, int var2);

    public void updateOnVolumeLimitRange(int var1, int var2, int var3);

    public void updateActiveAmplifierCapabilities(AmplifierCapabilities var1, int var2);

    public void updateMuteTheftProtection(boolean var1, int var2);

    public void updateMicGainLevel(int var1, int var2);

    public void updateVolumeFocus(int var1, int var2, int var3);

    public void updateNoiseCompensation(int var1, int var2, short var3, int var4);

    public void updateNoiseCompensationRange(int var1, int var2, int var3);

    public void updateThreeDMode(int var1, int var2, int var3, int var4);

    public void updateThreeDModeRange(int var1, int var2, int var3);

    public void updatePresetPosition(int var1, int var2, int var3, int var4);

    public void updatePresetPositionList(int var1, int var2);

    public void updatePresetEQList(int var1, int var2);

    public void updatePresetEQ(int var1, int var2, int var3, int var4);

    public void updateSubwooferActivity(int var1, int var2, boolean var3, int var4);

    public void responseWidebandSpeech(int var1, boolean var2);

    public void updateSoundShapeActive(boolean var1, int var2);

    public void updateSoundShape(short var1, short var2, short var3, int var4);

    public void updateSoundShapeRange(int var1, int var2, int var3, int var4, int var5, int var6, int var7);

    public void updateICCAvailable(boolean var1, int var2, int var3);

    public void updateProfileState(int var1, int var2, int var3);

    public void profileChanged(int var1, int var2);

    public void profileCopied(int var1, int var2, int var3);

    public void profileReset(int var1, int var2);

    public void profileResetAll(int var1);
}

