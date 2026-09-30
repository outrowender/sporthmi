/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tmc;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.AreaWarningInfo;
import org.dsi.ifc.tmc.LocalHazardInformation;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TrafficSource;

public interface DSITmcListener
extends DSIListener {
    public void updateEventsOnRoute(long var1, int var3);

    public void updateEventsTotal(int var1, long var2, long var4, int var6);

    public void updateTmcState(int var1, int var2);

    public void updateActiveTrafficSources(int[] var1, int var2);

    public void updateIsEngineeringMode(boolean var1, int var2);

    public void updateCurrentLanguage(String var1, int var2);

    public void updateIsTmcProAvailable(boolean var1, int var2);

    public void windowChange(int var1);

    public void tmcWindowResult(int var1, int var2, TmcListElement[] var3);

    public void setMessageFilterResult(int var1, int var2);

    public void getMessageIdsForListElementResult(long[] var1);

    public void getBoundingRectangleForTrafficMessagesResult(NavRectangle var1);

    public void updateAreaWarning(AreaWarningInfo var1, int var2);

    public void updateAreaWarnings(AreaWarningInfo[] var1, int var2);

    public void updateLocalHazardInformation(LocalHazardInformation[] var1, int var2);

    public void updateTrafficFlowStatisticsStatus(boolean var1, int var2);

    public void updateTrafficSourceInformation(TrafficSource[] var1, int var2);
}

