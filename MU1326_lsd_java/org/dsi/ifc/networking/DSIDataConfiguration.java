/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.networking.CDataProfile;

public interface DSIDataConfiguration
extends DSIBase {
    public static final String VERSION = "2.11.14";
    public static final int ATTR_AVAILABLEPROFILES = 1;
    public static final int ATTR_ACTIVEPROFILE = 2;
    public static final int ATTR_ROAMINGSTATE = 3;
    public static final int ATTR_CONNECTIONMODE = 4;
    public static final int ATTR_DATAREQUEST = 6;
    public static final int ATTR_REQUESTSETTING = 9;
    public static final int ATTR_PACKETCOUNTER = 12;
    public static final int RESULT_RESULT_OK = 0;
    public static final int RESULT_RESULT_ABORTED = 1;
    public static final int RESULT_ERROR_GENERAL = 2;
    public static final int RESULT_ERROR_PROFILE_NOT_EXISTS = 3;
    public static final int RESULT_ERROR_NOT_SUPPORTED = 4;
    public static final int RESULT_ERROR_MAX_PROFILES = 5;
    public static final int RESULT_ERROR_DENIED = 6;
    public static final int RESULT_ERROR_CONNECTION_REFUSED = 7;
    public static final int RESULT_ERROR_APPLICATION_NOT_EXISTS = 8;
    public static final int CONNECTIONMODE_AUTOMATIC = 0;
    public static final int CONNECTIONMODE_MANUAL = 1;
    public static final int CONNECTIONMODE_NEVER = 2;
    public static final int REQUEST_ON = 1;
    public static final int REQUEST_OFF = 2;
    public static final int ROAMINGSTATE_ROAMING_ACTIVE = 0;
    public static final int ROAMINGSTATE_ROAMING_DEACTIVE = 1;
    public static final int DATAAUTHENTICATION_NORMAL = 0;
    public static final int DATAAUTHENTICATION_SECURED = 1;
    public static final int RT_SETDATAPROFILE = 1001;
    public static final int RT_AUTOMATICPROFILE = 1004;
    public static final int RT_SETROAMINGSTATE = 1005;
    public static final int RT_SETCONNECTIONMODE = 1006;
    public static final int RT_SETREQUESTSETTING = 1007;
    public static final int RT_ACCEPTDATAREQUEST = 1009;
    public static final int RT_RESETPACKETCOUNTER = 1010;
    public static final int RT_RESTOREFACTORYSETTINGS = 1011;
    public static final int RP_SETDATAPROFILERESPONSE = 2001;
    public static final int RP_AUTOMATICPROFILERESPONSE = 2002;
    public static final int RP_SETROAMINGSTATERESPONSE = 2005;
    public static final int RP_SETCONNECTIONMODERESPONSE = 2006;
    public static final int RP_SETREQUESTSETTINGRESPONSE = 2007;
    public static final int RP_RESETPACKETCOUNTERRESPONSE = 2009;
    public static final int RP_RESTOREFACTORYSETTINGSRESPONSE = 2010;
    public static final int RP_ACCEPTDATAREQUESTRESPONSE = 2011;

    public void setDataProfile(CDataProfile var1);

    public void automaticProfile(int var1);

    public void setRoamingState(int var1);

    public void setConnectionMode(int var1);

    public void setRequestSetting(int var1, int var2);

    public void acceptDataRequest(int var1, boolean var2);

    public void resetPacketCounter();

    public void restoreFactorySettings();
}

