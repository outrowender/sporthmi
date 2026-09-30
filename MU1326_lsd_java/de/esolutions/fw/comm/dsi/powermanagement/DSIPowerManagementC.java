/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.powermanagement;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIPowerManagementC {
    public void setHMIReady() throws MethodException;

    public void rebootSystem() throws MethodException;

    public void displayReady() throws MethodException;

    public void rebootSystemCritical() throws MethodException;

    public void setChildLockRSE(int var1) throws MethodException;

    public void setLastOn(int var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

