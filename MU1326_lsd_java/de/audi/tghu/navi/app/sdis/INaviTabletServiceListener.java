/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sdis;

import de.audi.tghu.navi.app.NavigationEnv;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RgInfoForNextDestination;

public interface INaviTabletServiceListener {
    public void updateCarPosition(PosPosition var1);

    public void updateRouteGuidanceActive(boolean var1);

    public void updateNextDestinationInfo(RgInfoForNextDestination var1);

    public void updateDestinationInfo(NavRouteListData[] var1, NavLocation[] var2, NavigationEnv var3);
}

