/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio;

import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncAudioS {
    public void setAudioContext(int var1, ASIHMISyncAudioReply var2) throws MethodException;

    public void forceFrontAudioContext(int var1, ASIHMISyncAudioReply var2) throws MethodException;

    public void requestEnableA2LS(String var1, ASIHMISyncAudioReply var2) throws MethodException;

    public void disableA2LS(ASIHMISyncAudioReply var1) throws MethodException;

    public void setVolume(int var1, ASIHMISyncAudioReply var2) throws MethodException;

    public void increaseVolume(int var1, ASIHMISyncAudioReply var2) throws MethodException;

    public void decreaseVolume(int var1, ASIHMISyncAudioReply var2) throws MethodException;

    public void setNotification(ASIHMISyncAudioReply var1) throws MethodException;

    public void setNotification(long var1, ASIHMISyncAudioReply var3) throws MethodException;

    public void setNotification(long[] var1, ASIHMISyncAudioReply var2) throws MethodException;

    public void clearNotification(ASIHMISyncAudioReply var1) throws MethodException;

    public void clearNotification(long var1, ASIHMISyncAudioReply var3) throws MethodException;

    public void clearNotification(long[] var1, ASIHMISyncAudioReply var2) throws MethodException;
}

