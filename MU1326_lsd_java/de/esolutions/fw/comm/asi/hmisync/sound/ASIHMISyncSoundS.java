/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound;

import de.esolutions.fw.comm.asi.hmisync.sound.ASIHMISyncSoundReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncSoundS {
    public void setBassValue(int var1, ASIHMISyncSoundReply var2) throws MethodException;

    public void setTrebleValue(int var1, ASIHMISyncSoundReply var2) throws MethodException;

    public void setBalanceValue(int var1, ASIHMISyncSoundReply var2) throws MethodException;

    public void setFaderValue(int var1, ASIHMISyncSoundReply var2) throws MethodException;

    public void setSubwooferValue(int var1, ASIHMISyncSoundReply var2) throws MethodException;

    public void setSurroundValue(int var1, ASIHMISyncSoundReply var2) throws MethodException;

    public void setNoiseCompensationValue(int var1, ASIHMISyncSoundReply var2) throws MethodException;

    public void setThreeDModeValue(int var1, ASIHMISyncSoundReply var2) throws MethodException;

    public void setSoundShape(int var1, int var2, int var3, ASIHMISyncSoundReply var4) throws MethodException;

    public void setPresetPosition(int var1, ASIHMISyncSoundReply var2) throws MethodException;

    public void setPresetEQ(int var1, ASIHMISyncSoundReply var2) throws MethodException;

    public void setNotification(ASIHMISyncSoundReply var1) throws MethodException;

    public void setNotification(long var1, ASIHMISyncSoundReply var3) throws MethodException;

    public void setNotification(long[] var1, ASIHMISyncSoundReply var2) throws MethodException;

    public void clearNotification(ASIHMISyncSoundReply var1) throws MethodException;

    public void clearNotification(long var1, ASIHMISyncSoundReply var3) throws MethodException;

    public void clearNotification(long[] var1, ASIHMISyncSoundReply var2) throws MethodException;
}

