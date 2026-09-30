/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.online.FCDPosition;
import org.dsi.ifc.online.LocatablePosition;

public interface DSIOnlineTrafficReply {
    public static final String IPL_COMM_UUID = "a6541574-206f-51ef-b0df-9f6f80e9edfb";
    public static final String IPL_COMM_INTERFACE_KEY = "a94f3724-0361-547e-b190-41d13b2282ad";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.42";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.42";

    public void updateConsumerReady(int var1, int var2) throws MethodException;

    public void updateWantOnlineTrafficData(int var1, int var2) throws MethodException;

    public void getNewDataResult(int var1, LocatablePosition[] var2) throws MethodException;

    public void setNewDataResult(String var1, int var2) throws MethodException;

    public void getNewSession() throws MethodException;

    public void setTimeoutForFallbackResult(int var1) throws MethodException;

    public void getNewFCDInformationResult(FCDPosition var1) throws MethodException;

    public void getInventoryResult(String var1) throws MethodException;

    public void getDownloadFileResult(String var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

