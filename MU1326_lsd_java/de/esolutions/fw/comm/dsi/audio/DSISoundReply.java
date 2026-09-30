/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.audio;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.audio.AmplifierCapabilities;

public interface DSISoundReply {
    public static final String IPL_COMM_UUID = "781e4762-ef2b-5a94-972a-3c284bdb0fd4";
    public static final String IPL_COMM_INTERFACE_KEY = "e1e9715f-7c10-5394-b9b3-c506acbe5ba0";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.45";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.45";

    public void inputGainOffsetRange(int var1, int var2, int var3, int var4) throws MethodException;

    public void menuVolEntRange(int var1, int var2, int var3) throws MethodException;

    public void menuVolumeRange(int var1, int var2, int var3, int var4) throws MethodException;

    public void volumeRange(int var1, int var2, int var3, int var4, int var5) throws MethodException;

    public void updateSurroundOnOff(int var1, int var2, boolean var3, int var4) throws MethodException;

    public void updateBalance(int var1, int var2, short var3, int var4) throws MethodException;

    public void updateBalanceRange(int var1, int var2, int var3) throws MethodException;

    public void updateBass(int var1, int var2, short var3, int var4) throws MethodException;

    public void updateBassRange(int var1, int var2, int var3) throws MethodException;

    public void createExportFileResult(int var1, boolean var2) throws MethodException;

    public void updateFader(int var1, int var2, short var3, int var4) throws MethodException;

    public void updateFaderRange(int var1, int var2, int var3) throws MethodException;

    public void importFileResponse(int var1, boolean var2) throws MethodException;

    public void updateInputGainOffset(int var1, int var2, short var3, int var4) throws MethodException;

    public void updateLoweringEntertainment(int var1, int var2, int var3, short var4, int var5) throws MethodException;

    public void updateMutePinState(boolean var1, int var2) throws MethodException;

    public void updateSubwoofer(int var1, int var2, short var3, int var4) throws MethodException;

    public void updateSubwooferRange(int var1, int var2, int var3) throws MethodException;

    public void updateSurrLevelRange(int var1, int var2, int var3) throws MethodException;

    public void updateSurroundLevel(int var1, int var2, short var3, int var4) throws MethodException;

    public void updateTreble(int var1, int var2, short var3, int var4) throws MethodException;

    public void updateTrebleRange(int var1, int var2, int var3) throws MethodException;

    public void updateVolume(int var1, int var2, short var3, int var4) throws MethodException;

    public void updateVolumeRange(int var1, int var2, int var3) throws MethodException;

    public void updateMiddle(int var1, int var2, short var3, int var4) throws MethodException;

    public void updateMiddleRange(int var1, int var2, int var3) throws MethodException;

    public void updateEqualizerRange(int var1, int var2, int[] var3, int var4) throws MethodException;

    public void updateEqualizer(int[] var1, int[] var2, int var3) throws MethodException;

    public void updateOnVolumeLimit(int var1, int var2) throws MethodException;

    public void updateOnVolumeLimitRange(int var1, int var2, int var3) throws MethodException;

    public void updateActiveAmplifierCapabilities(AmplifierCapabilities var1, int var2) throws MethodException;

    public void updateMuteTheftProtection(boolean var1, int var2) throws MethodException;

    public void updateMicGainLevel(int var1, int var2) throws MethodException;

    public void updateVolumeFocus(int var1, int var2, int var3) throws MethodException;

    public void updateNoiseCompensation(int var1, int var2, short var3, int var4) throws MethodException;

    public void updateNoiseCompensationRange(int var1, int var2, int var3) throws MethodException;

    public void updateThreeDMode(int var1, int var2, int var3, int var4) throws MethodException;

    public void updateThreeDModeRange(int var1, int var2, int var3) throws MethodException;

    public void updatePresetPosition(int var1, int var2, int var3, int var4) throws MethodException;

    public void updatePresetPositionList(int var1, int var2) throws MethodException;

    public void updatePresetEQList(int var1, int var2) throws MethodException;

    public void updatePresetEQ(int var1, int var2, int var3, int var4) throws MethodException;

    public void updateSubwooferActivity(int var1, int var2, boolean var3, int var4) throws MethodException;

    public void responseWidebandSpeech(int var1, boolean var2) throws MethodException;

    public void updateSoundShapeActive(boolean var1, int var2) throws MethodException;

    public void updateSoundShape(short var1, short var2, short var3, int var4) throws MethodException;

    public void updateSoundShapeRange(int var1, int var2, int var3, int var4, int var5, int var6, int var7) throws MethodException;

    public void updateICCAvailable(boolean var1, int var2, int var3) throws MethodException;

    public void updateProfileState(int var1, int var2, int var3) throws MethodException;

    public void profileChanged(int var1, int var2) throws MethodException;

    public void profileCopied(int var1, int var2, int var3) throws MethodException;

    public void profileReset(int var1, int var2) throws MethodException;

    public void profileResetAll(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

