/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tmc;

import org.dsi.ifc.base.DSIBase;

public interface DSITmc
extends DSIBase {
    public static final String VERSION = "2.11.36";
    public static final int ATTR_EVENTSONROUTE = 1;
    public static final int ATTR_EVENTSTOTAL = 2;
    public static final int ATTR_TMCSTATE = 5;
    public static final int ATTR_ISENGINEERINGMODE = 6;
    public static final int ATTR_CURRENTLANGUAGE = 7;
    public static final int ATTR_ISTMCPROAVAILABLE = 8;
    public static final int ATTR_ACTIVETRAFFICSOURCES = 11;
    public static final int ATTR_AREAWARNING = 12;
    public static final int ATTR_AREAWARNINGS = 13;
    public static final int ATTR_LOCALHAZARDINFORMATION = 14;
    public static final int ATTR_TRAFFICFLOWSTATISTICSSTATUS = 15;
    public static final int ATTR_TRAFFICSOURCEINFORMATION = 16;
    public static final int LISTCONTENT_TOPLEVELNODES = -1;
    public static final int LISTCONTENT_LEAFNODES = -2;
    public static final int LISTCONTENT_ALLNODES = -3;
    public static final int LISTCONTENT_COMBINEDNODES = -4;
    public static final int TMCSTATE_NOT_AVAILABLE = 0;
    public static final int TMCSTATE_AVAILABLE_NOT_VALID = 1;
    public static final int TMCSTATE_AVAILABLE_AND_VALID = 2;
    public static final int TMCSTATE_NAR_AVAILABLE_AND_UNLOCKED = 3;
    public static final int TMCSTATE_NAR_NOT_AVAILABLE_AND_UNLOCKED = 4;
    public static final int TMCSTATE_NAR_LOCKED = 5;
    public static final int TMCSTATE_TLT_NOT_AVAILABLE = 6;
    public static final int TMCSTATE_DEACTIVATED = 7;
    public static final int TMCMESSAGEROUTESTATE_MESSAGE_ON_ROUTE = 0;
    public static final int TMCMESSAGEROUTESTATE_MESSAGE_NOT_ON_ROUTE = 1;
    public static final int TMCMESSAGEROUTESTATE_MESSAGE_BYPASSED = 2;
    public static final int TMCMESSAGEROUTESTATE_MESSAGE_BYPASSED_DISAPPEARS = 3;
    public static final int TMCLISTELEMENTTYPE_UNDEFINED = 0;
    public static final int TMCLISTELEMENTTYPE_NODE = 1;
    public static final int TMCLISTELEMENTTYPE_MSG = 2;
    public static final int TMCMESSAGEFILTER_ALL = 0;
    public static final int TMCMESSAGEFILTER_ONROAD = 1;
    public static final int TMCMESSAGEFILTER_URGENT = 2;
    public static final int TRAFFICSOURCE_UNDEFINED = 0;
    public static final int TRAFFICSOURCE_TMC = 1;
    public static final int TRAFFICSOURCE_TMC_PRO = 2;
    public static final int TRAFFICSOURCE_TPEG = 3;
    public static final int TRAFFICSOURCE_ONLINE = 4;
    public static final int TRAFFICSOURCE_CAR2X = 5;
    public static final int TRAFFICSOURCE_VICS = 6;
    public static final int TRAFFICSOURCESTATE_UNDEFINED = 0;
    public static final int TRAFFICSOURCESTATE_NODATA = 1;
    public static final int TRAFFICSOURCESTATE_ACTIVE = 2;
    public static final int ROUTEDEVIATIONINDICATION_TI_NOEFFECT = 0;
    public static final int ROUTEDEVIATIONINDICATION_TI_CAUSED_ROUTE_DEVIATION = 1;
    public static final int ROUTEDEVIATIONINDICATION_VANISHED_TI_CAUSED_ROUTE_DEVIATION = 2;
    public static final int AREAWARNINGTYPE_UNDEFINED = 0;
    public static final int AREAWARNINGTYPE_FOG = 1;
    public static final int AREAWARNINGTYPE_SLIPPERINESS = 2;
    public static final int LOCALHAZARDWARNINGEVENTTYPE_NOEVENT = 0;
    public static final int LOCALHAZARDWARNINGEVENTTYPE_ACCIDENT = 1;
    public static final int LOCALHAZARDWARNINGEVENTTYPE_REDUCEDVISIBILITY = 2;
    public static final int LOCALHAZARDWARNINGEVENTTYPE_BREAKDOWN = 3;
    public static final int LOCALHAZARDWARNINGEVENTTYPE_TRACTIONLOSS = 4;
    public static final int TMCEVENTTYPE_UNKNOWN = 0;
    public static final int TMCEVENTTYPE_NATURALCATASTROPHE = 1;
    public static final int TMCEVENTTYPE_OTHER = 255;
    public static final int RT_SETMESSAGEFILTER = 1003;
    public static final int RT_REQUESTTMCWINDOW = 1004;
    public static final int RT_GETMESSAGEIDSFORLISTELEMENT = 1005;
    public static final int RT_GETBOUNDINGRECTANGLEFORTRAFFICMESSAGES = 1006;
    public static final int RT_ENABLEAREAWARNINGS = 1007;
    public static final int RT_ENABLETRAFFICFLOWSTATISTICS = 1008;
    public static final int RP_SETMESSAGEFILTERRESULT = 2003;
    public static final int RP_TMCWINDOWRESULT = 2004;
    public static final int RP_GETMESSAGEIDSFORLISTELEMENTRESULT = 2005;
    public static final int RP_GETBOUNDINGRECTANGLEFORTRAFFICMESSAGESRESULT = 2006;
    public static final int IN_WINDOWCHANGE = 3000;

    public void requestTmcWindow(int var1, int var2, int var3, int[] var4, int var5);

    public void setMessageFilter(int var1, int var2);

    public void getMessageIdsForListElement(long var1);

    public void getBoundingRectangleForTrafficMessages(long[] var1);

    public void enableAreaWarnings(boolean var1);

    public void enableTrafficFlowStatistics(boolean var1);
}

