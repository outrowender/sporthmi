/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound;

import de.esolutions.fw.comm.asi.hmisync.sound.SoundRange;
import de.esolutions.fw.comm.asi.hmisync.sound.SoundShapeRange;
import de.esolutions.fw.comm.asi.hmisync.sound.SoundShapeValue;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncSoundReply {
    public static final String IPL_COMM_UUID = "7ba5c63b-4ccf-465c-abe4-f731a4967351";
    public static final String IPL_COMM_INTERFACE_KEY = "da12fd01-0f0a-58b3-ba2e-73b6664e9062";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.2.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.1.00";

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateRequestIDs(short[] var1, boolean var2) throws MethodException;

    public void updateReplyIDs(short[] var1, boolean var2) throws MethodException;

    public void updateSoundState(int var1, boolean var2) throws MethodException;

    public void updateAmplifier(int var1, boolean var2) throws MethodException;

    public void updateBassRange(SoundRange var1, boolean var2) throws MethodException;

    public void updateBassValue(int var1, boolean var2) throws MethodException;

    public void updateTrebleRange(SoundRange var1, boolean var2) throws MethodException;

    public void updateTrebleValue(int var1, boolean var2) throws MethodException;

    public void updateBalanceRange(SoundRange var1, boolean var2) throws MethodException;

    public void updateBalanceValue(int var1, boolean var2) throws MethodException;

    public void updateFaderRange(SoundRange var1, boolean var2) throws MethodException;

    public void updateFaderValue(int var1, boolean var2) throws MethodException;

    public void updateSubwooferRange(SoundRange var1, boolean var2) throws MethodException;

    public void updateSubwooferValue(int var1, boolean var2) throws MethodException;

    public void updateSurroundRange(SoundRange var1, boolean var2) throws MethodException;

    public void updateSurroundValue(int var1, boolean var2) throws MethodException;

    public void updateNoiseCompensationRange(SoundRange var1, boolean var2) throws MethodException;

    public void updateNoiseCompensationValue(int var1, boolean var2) throws MethodException;

    public void updateThreeDModeRange(SoundRange var1, boolean var2) throws MethodException;

    public void updateThreeDModeValue(int var1, boolean var2) throws MethodException;

    public void updateSoundShapeRange(SoundShapeRange var1, boolean var2) throws MethodException;

    public void updateSoundShapeValue(SoundShapeValue var1, boolean var2) throws MethodException;

    public void updatePresetPositionList(int var1, boolean var2) throws MethodException;

    public void updatePresetPosition(int var1, boolean var2) throws MethodException;

    public void updatePresetEQList(int var1, boolean var2) throws MethodException;

    public void updatePresetEQ(int var1, boolean var2) throws MethodException;
}

