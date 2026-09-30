/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.online.OperatorCallData;

public interface DSIOperatorCall
extends DSIBase {
    public static final String VERSION = "2.11.42";
    public static final int TRANSFERTYPE_NOD = 0;
    public static final int TRANSFERTYPE_DTMF = 1;
    public static final int SERVICETYPE_UNKNOWN = 0;
    public static final int SERVICETYPE_CONCIERGE = 1;
    public static final int SERVICETYPE_OPERATOR = 2;
    public static final int RESULTTYPE_OLDSESSION = 0;
    public static final int RESULTTYPE_NEWSESSION = 1;
    public static final int RESULTTYPE_CONNECTIONERROR = 2;
    public static final int RESULTTYPE_INVALIDSESSION = 3;
    public static final int RESULTTYPE_SERVERERROR = 4;
    public static final int RP_RESPONSEOPERATORCALLRESULT = 2000;
    public static final int RP_RESPONSEOPERATORPHONENUMBER = 2001;
    public static final int RT_REQUESTOPERATORCALLRESULT = 1000;
    public static final int RT_REQUESTOPERATORPHONENUMBER = 1001;
    public static final int RT_SETLANGUAGE = 1002;

    public void requestOperatorCallResult(String var1, int var2);

    public void requestOperatorPhoneNumber(int var1, OperatorCallData var2, boolean var3);

    public void setLanguage(String var1);
}

