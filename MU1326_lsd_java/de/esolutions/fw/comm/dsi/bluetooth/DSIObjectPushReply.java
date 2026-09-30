/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bluetooth;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIObjectPushReply {
    public static final String IPL_COMM_UUID = "cadd98a6-ed14-5525-a167-28ccee45b259";
    public static final String IPL_COMM_INTERFACE_KEY = "f444e780-ab12-56fe-b796-99483239ba21";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.13";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.13";

    public void updateOPPIncomingObject(String var1, String var2, int var3, int var4) throws MethodException;

    public void responseOPPAbortSending(int var1) throws MethodException;

    public void responseOPPAcceptObject(int var1) throws MethodException;

    public void responseOPPSendContacts(int var1) throws MethodException;

    public void responseOPPSendMessages(int var1) throws MethodException;

    public void responseOPPSendBinary(int var1) throws MethodException;

    public void updateVCardsReceived(String var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

