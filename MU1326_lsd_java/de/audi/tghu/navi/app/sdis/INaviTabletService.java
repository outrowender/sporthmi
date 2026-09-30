/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sdis;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.sdis.IHMISyncNaviReplies;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.sdis.INaviTabletServiceListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RgInfoForNextDestination;

public interface INaviTabletService {
    public boolean isReady();

    public IHMISyncNaviReplies.LastDestination[] requestLastDestinationList();

    public void registerListener(INaviTabletServiceListener var1);

    public void updateCarPosition(PosPosition var1);

    public void updateRouteGuidanceActive(boolean var1);

    public void updateRgInfoForNextDestination(RgInfoForNextDestination var1);

    public void updateRgDestinationInfo(NavRouteListData[] var1, NavigationEnv var2);

    public void startGuidanceToDestinations(NavLocation[] var1, NavCommand var2, NavCommand var3);

    public CommandList getTransformCommandList(NavLocation[] var1);

    public void routeChanged();

    public void registerService(AbstractActivator var1);
}

