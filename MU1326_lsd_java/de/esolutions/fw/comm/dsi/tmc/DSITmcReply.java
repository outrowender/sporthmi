/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tmc;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.AreaWarningInfo;
import org.dsi.ifc.tmc.LocalHazardInformation;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TrafficSource;

public interface DSITmcReply {
    public static final String IPL_COMM_UUID = "a73f6b98-aa3b-5dba-a907-2d574d8b6cb8";
    public static final String IPL_COMM_INTERFACE_KEY = "1672f1b5-572a-5457-b33e-fd154fd0e075";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.36";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.36";

    public void updateEventsOnRoute(long var1, int var3) throws MethodException;

    public void updateEventsTotal(int var1, long var2, long var4, int var6) throws MethodException;

    public void updateTmcState(int var1, int var2) throws MethodException;

    public void updateActiveTrafficSources(int[] var1, int var2) throws MethodException;

    public void updateIsEngineeringMode(boolean var1, int var2) throws MethodException;

    public void updateCurrentLanguage(String var1, int var2) throws MethodException;

    public void updateIsTmcProAvailable(boolean var1, int var2) throws MethodException;

    public void windowChange(int var1) throws MethodException;

    public void tmcWindowResult(int var1, int var2, TmcListElement[] var3) throws MethodException;

    public void setMessageFilterResult(int var1, int var2) throws MethodException;

    public void getMessageIdsForListElementResult(long[] var1) throws MethodException;

    public void getBoundingRectangleForTrafficMessagesResult(NavRectangle var1) throws MethodException;

    public void updateAreaWarning(AreaWarningInfo var1, int var2) throws MethodException;

    public void updateAreaWarnings(AreaWarningInfo[] var1, int var2) throws MethodException;

    public void updateLocalHazardInformation(LocalHazardInformation[] var1, int var2) throws MethodException;

    public void updateTrafficFlowStatisticsStatus(boolean var1, int var2) throws MethodException;

    public void updateTrafficSourceInformation(TrafficSource[] var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

