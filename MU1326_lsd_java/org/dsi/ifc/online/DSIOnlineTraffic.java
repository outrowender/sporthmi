/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIBase;

public interface DSIOnlineTraffic
extends DSIBase {
    public static final String VERSION = "2.11.42";
    public static final int IN_GETDOWNLOADFILERESULT = 3000;
    public static final int ATTR_CONSUMERREADY = 1;
    public static final int ATTR_WANTONLINETRAFFICDATA = 2;
    public static final int REQUEST_CONSUMER_READY = 1;
    public static final int REQUEST_WANTONLINETRAFFICDATA = 2;
    public static final int TRAFFICDATASTATUS_IDLE = 0;
    public static final int TRAFFICDATASTATUS_NO_DATA_AVAILABLE = 1;
    public static final int TRAFFICDATASTATUS_PREPARING_DATA = 2;
    public static final int TRAFFICDATASTATUS_DATA_AVAILABLE = 3;
    public static final int TRAFFICDATASTATUS_NO_DATA_FOR_THIS_AREA = 4;
    public static final int TRAFFICDATASTATUS_DISABLED = 5;
    public static final int ONLINETRAFFICCONSUMERSTATE_STATUS_OK = 0;
    public static final int ONLINETRAFFICCONSUMERSTATE_STATUS_BUSY = 1;
    public static final int ONLINETRAFFICCONSUMERSTATE_STATUS_NOT_AVAILABLE = 2;
    public static final int ONLINETRAFFICCONSUMERSTATE_DATA_ERROR = 3;
    public static final int UPDATERATE_DATA_WANTED_STD_INTERVAL = 1;
    public static final int UPDATERATE_DATA_WANTED_SHORT_INTERVAL = 2;
    public static final int UPDATERATE_DATA_WANTED_IMMEDIATELY = 3;
    public static final int UPDATERATE_NOT_INTERESTED_IN_DATA = 0;
    public static final long FCDVALID_TIME = 1L;
    public static final long FCDVALID_POSITION = 2L;
    public static final long FCDVALID_FORMOFWAY = 4L;
    public static final long FCDVALID_FUNCTIONALROADCLASS = 8L;
    public static final long FCDVALID_ROADNUMBER = 16L;
    public static final long FCDVALID_HEADING = 32L;
    public static final long FCDVALID_SPEED = 64L;
    public static final long FCDVALID_TEMPERATURE = 128L;
    public static final long FCDVALID_RAIN = 256L;
    public static final int RT_SETONLINETRAFFICDATASTATUS = 1000;
    public static final int RT_GETNEWDATA = 1001;
    public static final int RT_SETNEWDATA = 1002;
    public static final int RT_SETTIMEOUTFORFALLBACK = 1003;
    public static final int RT_SETNEWSESSION = 1004;
    public static final int RT_GETNEWFCDINFORMATION = 1005;
    public static final int RT_GETINVENTORY = 1006;
    public static final int RP_GETNEWDATARESULT = 2000;
    public static final int RP_SETNEWDATARESULT = 2001;
    public static final int RP_GETNEWSESSION = 2002;
    public static final int RP_SETTIMEOUTFORFALLBACKRESULT = 2003;
    public static final int RP_GETNEWFCDINFORMATIONRESULT = 2004;
    public static final int RP_GETINVENTORYRESULT = 2005;

    public void setOnlineTrafficDataStatus(int var1);

    public void getNewData();

    public void setNewData(String var1);

    public void setTimeoutForFallback(long var1);

    public void setNewSession();

    public void getNewFCDInformation();

    public void getInventory();
}

