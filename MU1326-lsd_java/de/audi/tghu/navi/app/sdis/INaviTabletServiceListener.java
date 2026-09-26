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
    default public void updateCarPosition(PosPosition posPosition) {
    }

    default public void updateRouteGuidanceActive(boolean bl) {
    }

    default public void updateNextDestinationInfo(RgInfoForNextDestination rgInfoForNextDestination) {
    }

    default public void updateDestinationInfo(NavRouteListData[] navRouteListDataArray, NavLocation[] navLocationArray, NavigationEnv navigationEnv) {
    }
}

