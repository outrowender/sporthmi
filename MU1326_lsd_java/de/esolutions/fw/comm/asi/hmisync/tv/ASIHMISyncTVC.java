/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv;

import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncTVC {
    public void setActiveStation(long var1) throws MethodException;

    public void logonToTV() throws MethodException;

    public void logoffFromTV() throws MethodException;

    public void sendPressedPanelKey(byte var1) throws MethodException;

    public void searchChannel(byte var1) throws MethodException;

    public void setTerminalMode(byte var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void setNotification(long var1) throws MethodException;

    public void setNotification(long[] var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void clearNotification(long var1) throws MethodException;

    public void clearNotification(long[] var1) throws MethodException;
}

