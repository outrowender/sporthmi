/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.smartphoneintegration;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSISmartphoneIntegrationC {
    public void connectDevice(int var1, int var2) throws MethodException;

    public void disconnectDevice(int var1) throws MethodException;

    public void requestFactorySettings(int var1) throws MethodException;

    public void requestAppConnectContextActive(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

