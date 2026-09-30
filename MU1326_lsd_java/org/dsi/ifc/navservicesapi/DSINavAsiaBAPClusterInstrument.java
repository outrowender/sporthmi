/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.base.DSIBase;

public interface DSINavAsiaBAPClusterInstrument
extends DSIBase {
    public static final String VERSION = "2.11.16";
    public static final int ATTR_COMPASSINFO = 1;
    public static final int ATTR_RGSTATUS = 2;
    public static final int ATTR_DISTANCETONEXTMANEUVER = 3;
    public static final int ATTR_CURRENTPOSITIONINFO = 4;
    public static final int ATTR_TURNTOINFO = 5;
    public static final int ATTR_DISTANCETODESTINATION = 6;
    public static final int ATTR_MANEUVERDESCRIPTOR = 8;
    public static final int ATTR_LANEGUIDANCE = 9;
    public static final int ATTR_VOICEGUIDANCESTATE = 10;
    public static final int ATTR_INFOSTATES = 11;
    public static final int ATTR_TRAFFICBLOCKINDICATION = 13;
    public static final int ATTR_DMLASTDESTINATIONSLIST = 14;
    public static final int ATTR_NAVANNOUNCEMENTSTATE = 16;
    public static final int ATTR_TRAFFICINFORMATION = 17;
    public static final int ATTR_NAVIGATIONTIMEINFOTYPE = 18;
    public static final int ATTR_RTT = 19;
    public static final int ATTR_ETA = 20;
    public static final int ATTR_CITYNAME = 21;
    public static final int ATTR_SEMIDYNROUTE = 22;
    public static final int ATTR_TRAFFICOFFSET = 23;
    public static final int RT_STARTROUTEGUIDANCE = 1000;
    public static final int RT_STOPROUTEGUIDANCE = 1002;
    public static final int RT_REPEATLASTNAVANNOUNCEMENT = 1003;
    public static final int RT_SETVOICEGUIDANCESTATE = 1004;
    public static final int RT_SETACTIVERGTYPE = 1005;
    public static final int RT_CONFIRMTRAFFICINFOMESSAGE = 1006;
    public static final int RT_DMLASTDESTINATIONSGET = 1007;
    public static final int RT_ABORTCURRENTNAVANNOUNCEMENT = 1008;
    public static final int RP_ROUTEGUIDANCEACTDEACTRESULT = 2000;
    public static final int RP_REPEATLASTNAVANNOUNCEMENTRESULT = 2001;
    public static final int RP_SETACTIVERGTYPERESULT = 2002;
    public static final int RP_DMLASTDESTINATIONSGETRESULT = 2003;

    public void startRouteGuidance(int var1, long var2);

    public void stopRouteGuidance();

    public void repeatLastNavAnnouncement();

    public void abortCurrentNavAnnouncement();

    public void setVoiceGuidanceState(int var1);

    public void setActiveRGType(int var1);

    public void confirmTrafficInfoMessage(int var1);

    public void dmLastDestinationsGet(long var1);
}

