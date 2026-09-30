/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSISDARSTunerC {
    public void selectStation(int var1, int var2) throws MethodException;

    public void getTime() throws MethodException;

    public void getEPG24Hour(int var1) throws MethodException;

    public void getEPGDescription(int var1, int var2) throws MethodException;

    public void notifyHMIReady(int var1) throws MethodException;

    public void reset(int var1) throws MethodException;

    public void setRadioText2Config(int var1, int var2) throws MethodException;

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

