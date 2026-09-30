/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIDABTunerC {
    public void selectService(int var1, long var2, int var4, int var5, int var6, int var7, long var8) throws MethodException;

    public void seekService(int var1) throws MethodException;

    public void tuneEnsemble(int var1, int var2, int var3, long var4) throws MethodException;

    public void selectDataService(int var1, int var2, long var3, int var5) throws MethodException;

    public void switchDRC(boolean var1) throws MethodException;

    public void switchLinking(int var1) throws MethodException;

    public void switchLinkingDeviceUsage(int var1) throws MethodException;

    public void switchFrequencyTable(int var1) throws MethodException;

    public void reset(int var1) throws MethodException;

    public void forceLMUpdate(int var1) throws MethodException;

    public void prepareTuning(int var1, long var2, int var4, int var5, int var6, int var7) throws MethodException;

    public void enableRadioTextPlus(int[] var1) throws MethodException;

    public void setEpgMode(int var1) throws MethodException;

    public void setSlideShowMode(int var1) throws MethodException;

    public void setIntellitextMode(int var1) throws MethodException;

    public void getEPGDetailData(int var1, int var2, long var3, int var5) throws MethodException;

    public void profileChange(int var1) throws MethodException;

    public void profileCopy(int var1, int var2) throws MethodException;

    public void profileReset(int var1) throws MethodException;

    public void profileResetAll() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

