/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navservicesapi.AddressData;
import org.dsi.ifc.navservicesapi.BapManeuverDescriptor;
import org.dsi.ifc.navservicesapi.LDListElement;
import org.dsi.ifc.navservicesapi.NavLaneGuidanceData;
import org.dsi.ifc.navservicesapi.TrafficInfo;

public interface DSINavAsiaBAPClusterInstrumentListener
extends DSIListener {
    public void updateCompassInfo(int var1, int var2, int var3);

    public void updateRGStatus(int var1, int var2);

    public void updateDistanceToNextManeuver(int var1, int var2, boolean var3, int var4, int var5);

    public void updateCurrentPositionInfo(String var1, int var2);

    public void updateTurnToInfo(String var1, String var2, int var3);

    public void updateDistanceToDestination(int var1, int var2, int var3);

    public void updateNavigationTimeInfoType(int var1, int var2);

    public void updateRTT(long var1, int var3);

    public void updateETA(int var1, long var2, boolean var4, int var5);

    public void updateCityName(String var1, int var2);

    public void updateSemiDynRoute(boolean var1, int var2);

    public void updateTrafficOffset(int var1, short var2, short var3, short var4, boolean var5, int var6);

    public void updateManeuverDescriptor(BapManeuverDescriptor[] var1, int var2);

    public void updateLaneGuidance(boolean var1, NavLaneGuidanceData[] var2, int var3);

    public void updateTrafficInformation(TrafficInfo[] var1, int var2, int var3);

    public void updateDMLastDestinationsList(LDListElement[] var1, int var2);

    public void dmLastDestinationsGetResult(int var1, AddressData[] var2);

    public void routeGuidanceActDeactResult(int var1);

    public void repeatLastNavAnnouncementResult(int var1);

    public void updateNavAnnouncementState(boolean var1, int var2);

    public void updateVoiceGuidanceState(int var1, int var2);

    public void updateInfoStates(int var1, int var2);

    public void setActiveRGTypeResult(int var1);

    public void updateTrafficBlockIndication(int var1, int var2);
}

