/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sdis;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.sdis.IHMISyncNaviReplies$LastDestination;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.sdis.INaviTabletServiceListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RgInfoForNextDestination;

public interface INaviTabletService {
    default public boolean isReady() {
    }

    default public IHMISyncNaviReplies$LastDestination[] requestLastDestinationList() {
    }

    default public void registerListener(INaviTabletServiceListener iNaviTabletServiceListener) {
    }

    default public void updateCarPosition(PosPosition posPosition) {
    }

    default public void updateRouteGuidanceActive(boolean bl) {
    }

    default public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
    }

    default public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray, NavigationEnv navigationEnv) {
    }

    default public void startGuidanceToDestinations(NavLocation[] navLocationArray, NavCommand navCommand, NavCommand navCommand2) {
    }

    default public CommandList getTransformCommandList(NavLocation[] navLocationArray) {
    }

    default public void routeChanged() {
    }

    default public void registerService(AbstractActivator abstractActivator) {
    }
}

