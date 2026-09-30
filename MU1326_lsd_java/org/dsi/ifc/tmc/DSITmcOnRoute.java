/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tmc;

import org.dsi.ifc.base.DSIBase;

public interface DSITmcOnRoute
extends DSIBase {
    public static final String VERSION = "2.11.36";
    public static final int TMCWARNINGMODE_OFF = 0;
    public static final int TMCWARNINGMODE_CONGESTION_ACOUSTICAL_ONLY = 1;
    public static final int TMCWARNINGMODE_CONGESTION_VISUAL_ONLY = 2;
    public static final int TMCWARNINGMODE_CONGESTION_ACOUSTIC_AND_VISUAL = 3;
    public static final int BLOCKREQUESTRESULTCODE_OK = 0;
    public static final int BLOCKREQUESTRESULTCODE_FAILED = 1;
    public static final int NAVICOREAVAILABLETOCHANGEBLOCKINGS_READY = 0;
    public static final int NAVICOREAVAILABLETOCHANGEBLOCKINGS_BUSY = 1;
    public static final int FLOWSEVERITY_UNKNOWN = 0;
    public static final int FLOWSEVERITY_FREE_FLOW = 1;
    public static final int FLOWSEVERITY_HEAVY_TRAFFIC = 2;
    public static final int FLOWSEVERITY_SLOW_TRAFFIC = 3;
    public static final int FLOWSEVERITY_QUEUING_TRAFFIC = 4;
    public static final int FLOWSEVERITY_QUEUING_STATIONARY = 5;
    public static final int FLOWSEVERITY_NO_TRAFFIC_FLOW = 6;
    public static final int ATTR_TMCMESSAGESAHEAD = 1;
    public static final int ATTR_URGENTMESSAGES = 2;
    public static final int ATTR_TMCMESSAGESAHEADCALCULATIONHORIZON = 3;
    public static final int ATTR_NAVICOREAVAILABLETOCHANGETMCBLOCKINGS = 4;
    public static final int ATTR_CURRENTLYBLOCKEDTMCMESSAGES = 5;
    public static final int ATTR_SPEEDANDFLOWAHEAD = 6;
    public static final int RT_GETTMCMESSAGE = 1000;
    public static final int RT_SETTMCWARNINGMODE = 1001;
    public static final int RT_BLOCKTMCMESSAGES = 1002;
    public static final int RT_UNBLOCKALLTMCMESSAGES = 1003;
    public static final int RT_UNBLOCKTMCMESSAGES = 1004;
    public static final int RP_TMCMESSAGE = 2000;
    public static final int RP_SETTMCWARNINGMODERESULT = 2001;
    public static final int RP_UNBLOCKTMCMESSAGESRESULT = 2002;
    public static final int RP_UNBLOCKALLTMCMESSAGESRESULT = 2003;
    public static final int RP_BLOCKTMCMESSAGESRESULT = 2004;
    public static final int IN_INDICATETRAFFICEVENTNOTICEMAP = 3000;

    public void getTmcMessage(int var1);

    public void setTmcWarningMode(int var1);

    public void blockTMCMessages(long[] var1, boolean var2);

    public void unblockTMCMessages(long[] var1);

    public void unblockAllTMCMessages();
}

