/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

import org.dsi.ifc.base.DSIBase;

public interface DSIDataConnection
extends DSIBase {
    public static final String VERSION = "2.11.14";
    public static final int ATTR_STATEDATACONNECTION = 1;
    public static final int ATTR_ERRORSTATE = 2;
    public static final int ATTR_CONNECTIONSTATEINFORMATION = 3;
    public static final int ATTR_ROAMINGSTATE = 4;
    public static final int DATACONTEXTSTATE_ATTACHED_GPRS = 0;
    public static final int DATACONTEXTSTATE_ATTACHED_EDGE = 1;
    public static final int DATACONTEXTSTATE_ATTACHED_UMTS = 2;
    public static final int DATACONTEXTSTATE_ATTACHED_HSDPA = 3;
    public static final int DATACONTEXTSTATE_NOT_ATTACHED = 4;
    public static final int DATACONTEXTSTATE_DATA_DIAGNOSE_NOT_ALLOWED = 5;
    public static final int DATACONTEXTSTATE_DATA_NOT_FUNCTIONAL = 6;
    public static final int RESULT_RESULT_OK = 0;
    public static final int RESULT_RESULT_ABORTED = 1;
    public static final int RESULT_ERROR_GENERAL = 2;
    public static final int RESULT_ERROR_CONNECTION_REQUEST_RUNNING = 3;
    public static final int RESULT_ERROR_PROFILE_NOT_EXISTS = 4;
    public static final int RESULT_ERROR_SYSTEM_ERROR = 5;
    public static final int RESULT_ERROR_TIME_OUT = 6;
    public static final int RESULT_ERROR_NOT_SUPPORTED = 7;
    public static final int RESULT_ERROR_DENIED = 8;
    public static final int RESULT_ERROR_CONNECTION_REFUSED = 9;
    public static final int DATAOPERATIONMODE_DATA_OPERATIONMODE_UNKNOWN = 0;
    public static final int DATAOPERATIONMODE_DATA_OPERATIONMODE_FULL = 1;
    public static final int DATAOPERATIONMODE_DATA_OPERATIONMODE_LIMITED = 2;
    public static final int CONNECTION_IDLE_ALLOWED = 21;
    public static final int CONNECTION_CONNECTED_ALLOWED = 22;
    public static final int CONNECTION_PENDING = 23;
    public static final int CONNECTION_BLOCKED = 24;
    public static final int CONNECTION_UNKNOWN = 25;
    public static final int CONNECTION_LOCAL_NET = 26;
    public static final int ROAMING_ACTIVE = 11;
    public static final int ROAMING_NOT_ACTIVE = 12;
    public static final int RP_FORCEDISCONNECTRESPONSE = 2000;
    public static final int RT_FORCEDISCONNECTREQUEST = 1000;

    public void forceDisconnectRequest();
}

