/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSINADC {
    public void requestNetworkRegistration(String var1, int var2) throws MethodException;

    public void requestAbortNetworkRegistration() throws MethodException;

    public void requestNetworkSearch() throws MethodException;

    public void requestAbortNetworkSearch() throws MethodException;

    public void requestSetAutomaticPinEntryActive(boolean var1) throws MethodException;

    public void requestTelPower(int var1) throws MethodException;

    public void requestUnlockSIM(int var1, String var2, String var3) throws MethodException;

    public void requestCheckSIMPINCode(String var1) throws MethodException;

    public void requestChangeSIMCode(int var1, String var2, String var3) throws MethodException;

    public void requestSIMPINRequired(String var1, boolean var2) throws MethodException;

    public void restoreFactorySettings() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

