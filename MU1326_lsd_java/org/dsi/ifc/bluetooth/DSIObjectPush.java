/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

import org.dsi.ifc.base.DSIBase;

public interface DSIObjectPush
extends DSIBase {
    public static final String VERSION = "2.11.13";
    public static final int ATTR_OPPINCOMINGOBJECT = 1;
    public static final int ATTR_VCARDSRECEIVED = 2;
    public static final int RT_REQUESTOPPABORTSENDING = 1000;
    public static final int RT_REQUESTOPPACCEPTOBJECT = 1001;
    public static final int RT_REQUESTOPPSENDBINARY = 1003;
    public static final int RT_REQUESTOPPSENDCONTACTS = 1004;
    public static final int RT_REQUESTOPPSENDMESSAGES = 1005;
    public static final int RP_RESPONSEOPPABORTSENDING = 2000;
    public static final int RP_RESPONSEOPPACCEPTOBJECT = 2001;
    public static final int RP_RESPONSEOPPSENDBINARY = 2003;
    public static final int RP_RESPONSEOPPSENDCONTACTS = 2004;
    public static final int RP_RESPONSEOPPSENDMESSAGES = 2005;
    public static final int OBJECTTYPE_ADDRESS = 0;
    public static final int OBJECTTYPE_APPOINTMENT = 1;
    public static final int OBJECTTYPE_MESSAGE = 2;
    public static final int OBJECTTYPE_BINARY = 3;
    public static final int OBJECTTYPE_UNKNOWN = 4;
    public static final int OBJECTTYPE_TODO = 5;
    public static final int OBJECTTYPE_NOTE = 6;

    public void requestOPPAbortSending();

    public void requestOPPAcceptObject(String var1, boolean var2);

    public void requestOPPSendContacts(String var1, String var2);

    public void requestOPPSendMessages(String var1, int[] var2);

    public void requestOPPSendBinary(String var1, String[] var2);
}

