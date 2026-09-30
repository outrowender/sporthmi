/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIAMFMTunerC {
    public void tuneFrequencySteps(int var1) throws MethodException;

    public void selectStation(int var1, int var2, int var3) throws MethodException;

    public void prepareTuning(int var1, int var2, int var3) throws MethodException;

    public void seekStation(int var1) throws MethodException;

    public void switchAF(boolean var1) throws MethodException;

    public void switchME(boolean var1) throws MethodException;

    public void switchREG(int var1) throws MethodException;

    public void switchLinkingDeviceUsage(int var1) throws MethodException;

    public void reset(int var1) throws MethodException;

    public void selectFrequency(int var1) throws MethodException;

    public void setAMBandRange(int var1) throws MethodException;

    public void isOnPreset(int var1, int var2, int var3, String var4) throws MethodException;

    public void forceFMUpdate(int var1) throws MethodException;

    public void switchPiIgnore(boolean var1) throws MethodException;

    public void freePreset(int var1) throws MethodException;

    public void forceAMUpdate(int var1) throws MethodException;

    public void switchRDSIgnore(boolean var1) throws MethodException;

    public void enableRadiotextPlus(int[] var1) throws MethodException;

    public void setModeHD(int var1) throws MethodException;

    public void setERTPrefered(boolean var1) throws MethodException;

    public void setERTDisplayable(boolean var1) throws MethodException;

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

