/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tmc;

public interface DSITmc {
    public static final String IPL_COMM_UUID = "b0705156-f7c6-5451-8ec6-98f2087373a8";
    public static final String IPL_COMM_INTERFACE_KEY = "8afb4932-acde-5ead-af35-b21ca415fb6d";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.36";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.36";

    public static interface Consts {
        public static final String VERSION = "2.11.36";
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
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

