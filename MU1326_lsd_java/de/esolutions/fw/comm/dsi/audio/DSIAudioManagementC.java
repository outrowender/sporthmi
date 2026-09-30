/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.audio;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIAudioManagementC {
    public void fadeToConnection(int var1, int var2) throws MethodException;

    public void releaseConnection(int var1, int var2) throws MethodException;

    public void getActiveConnection(int var1) throws MethodException;

    public void getActiveEntertainmentConnection(int var1) throws MethodException;

    public void requestConnection(int var1, int var2, int var3) throws MethodException;

    public void setVolumelock(int var1, int var2, boolean var3) throws MethodException;

    public void getVolumelock(int var1, int var2) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

