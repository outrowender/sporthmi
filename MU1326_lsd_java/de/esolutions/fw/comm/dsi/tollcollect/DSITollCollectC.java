/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tollcollect;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSITollCollectC {
    public void requestPaymentHistoryList() throws MethodException;

    public void requestPaymentHistoryDetails(int var1) throws MethodException;

    public void setLanguage(String var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

