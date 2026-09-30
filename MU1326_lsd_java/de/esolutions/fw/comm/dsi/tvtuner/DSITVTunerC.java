/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tvtuner;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSITVTunerC {
    public void selectService(long var1, int var3, int var4) throws MethodException;

    public void selectNextService(int var1, int var2) throws MethodException;

    public void abortSeek() throws MethodException;

    public void switchSource(int var1) throws MethodException;

    public void setAudioChannel(int var1) throws MethodException;

    public void setNormArea(int var1) throws MethodException;

    public void enableServiceLinking(boolean var1) throws MethodException;

    public void setTerminalMode(int var1, int var2) throws MethodException;

    public void setNormAreaSubList(int[] var1) throws MethodException;

    public void setAVNorm(int var1) throws MethodException;

    public void incMoved(byte var1) throws MethodException;

    public void setCoordinateRel(short var1, short var2, short var3) throws MethodException;

    public void setTMTVKeyPanel(short var1, short var2) throws MethodException;

    public void enableSubtitle(boolean var1) throws MethodException;

    public void setBrowserListSort(int var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

