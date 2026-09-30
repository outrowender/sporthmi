/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio;

import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncAudioC {
    public void setAudioContext(int var1) throws MethodException;

    public void forceFrontAudioContext(int var1) throws MethodException;

    public void requestEnableA2LS(String var1) throws MethodException;

    public void disableA2LS() throws MethodException;

    public void setVolume(int var1) throws MethodException;

    public void increaseVolume(int var1) throws MethodException;

    public void decreaseVolume(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void setNotification(long var1) throws MethodException;

    public void setNotification(long[] var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void clearNotification(long var1) throws MethodException;

    public void clearNotification(long[] var1) throws MethodException;
}

