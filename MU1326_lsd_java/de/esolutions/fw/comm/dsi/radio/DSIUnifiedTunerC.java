/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIUnifiedTunerC {
    public void selectStation(int var1, long var2, int var4, int var5, int var6, int var7) throws MethodException;

    public void setStationFollowingMode(int var1) throws MethodException;

    public void setListMode(int var1) throws MethodException;

    public void enableRadioTextPlus(int[] var1) throws MethodException;

    public void setSoftLinkSwitch(int var1) throws MethodException;

    public void setRegMode(int var1) throws MethodException;

    public void switchDeviceUsage(int var1) throws MethodException;

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

