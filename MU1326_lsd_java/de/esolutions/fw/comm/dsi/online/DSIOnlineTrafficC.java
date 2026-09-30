/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIOnlineTrafficC {
    public void setOnlineTrafficDataStatus(int var1) throws MethodException;

    public void getNewData() throws MethodException;

    public void setNewData(String var1) throws MethodException;

    public void setTimeoutForFallback(long var1) throws MethodException;

    public void setNewSession() throws MethodException;

    public void getNewFCDInformation() throws MethodException;

    public void getInventory() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

