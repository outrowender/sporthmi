/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.trafficregulation;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;
import org.dsi.ifc.trafficregulation.TrafficSignInformationOnRoute;

public interface DSITrafficRegulationListener
extends DSIListener {
    public void updateCountrySpeedInformation(RoadClassSpeedInfo[] var1, int var2);

    public void updateCurrentTrafficSign(TrafficSignInformation var1, int var2);

    public void updateTrafficSignOnRoute(TrafficSignInformationOnRoute[] var1, int var2);

    public void requestRoadClassSpeedInfoForCountryResult(RoadClassSpeedInfo[] var1, int var2);

    public void updateTrailerStatus(int var1, int var2);
}

