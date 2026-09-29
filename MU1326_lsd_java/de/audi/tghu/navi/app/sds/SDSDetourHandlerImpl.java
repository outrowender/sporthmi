/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.guidance.SimpleDetourHandler;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.sds.ISDSDetourHandler;
import de.audi.tghu.navi.app.sds.SDSDetourHandlerImpl$1;
import de.audi.tghu.navi.app.sds.SDSDetourHandlerImpl$2;

public class SDSDetourHandlerImpl
implements ISDSDetourHandler {
    private LogChannel logChannel;
    private ICommandListFactory commandListFactory;
    private SimpleDetourHandler simpleDetourHandler;
    private IRouteManager routeManager;
    private IVehicle vehicle;

    public SDSDetourHandlerImpl(IVehicle iVehicle, IRouteManager iRouteManager, SimpleDetourHandler simpleDetourHandler, LogChannel logChannel, ICommandListFactory iCommandListFactory) {
        this.vehicle = iVehicle;
        this.routeManager = iRouteManager;
        this.simpleDetourHandler = simpleDetourHandler;
        this.logChannel = logChannel;
        this.commandListFactory = iCommandListFactory;
    }

    @Override
    public void blockRoute(int n, NaviServiceListener naviServiceListener) {
        int n2 = n == -1 ? 300 : n;
        int n3 = this.vehicle.getCarVelocity();
        int n4 = Math.max((int)((float)n3 / 0x66666640 * 8257), 10);
        int n5 = this.routeManager.getTripDataAuto().distanceToFinalDestination - n4;
        this.logChannel.log(-2137614336, "SDSHandlerImpl#blockRoute() - speed: %1 km/h --> block offset: %2 m, block length: %3 m", (long)n3, (long)n5, (long)n2);
        this.simpleDetourHandler.deleteBlockRouteBasedOnLength();
        boolean bl = this.simpleDetourHandler.blockRouteExt(n5, n2);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new SDSDetourHandlerImpl$1(this, naviServiceListener, bl));
        commandList.execute("SDSHandlerImpl#blockRoute");
    }

    @Override
    public void unblockRoute(NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "SDSHandlerImpl#unblockRoute()");
        this.simpleDetourHandler.deleteBlockRouteBasedOnLength();
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new SDSDetourHandlerImpl$2(this, naviServiceListener));
        commandList.execute("SDSHandlerImpl#unblockRoute");
    }
}

