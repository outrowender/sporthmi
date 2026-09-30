/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bluetooth;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIObjectPushC {
    public void requestOPPAbortSending() throws MethodException;

    public void requestOPPAcceptObject(String var1, boolean var2) throws MethodException;

    public void requestOPPSendContacts(String var1, String var2) throws MethodException;

    public void requestOPPSendMessages(String var1, int[] var2) throws MethodException;

    public void requestOPPSendBinary(String var1, String[] var2) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

