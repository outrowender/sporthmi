/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.interapp.IRouteGuidanceInterAppService;
import de.audi.tghu.navi.app.interapp.InterAppRouteGuidanceMapEventListener;
import de.audi.tghu.navi.app.interapp.RouteGuidanceInterAppService$1;
import de.audi.tghu.navi.app.interapp.RouteGuidanceInterAppService$2;
import de.audi.tghu.navi.app.interapp.RouteGuidanceInterAppService$3;
import de.audi.tghu.navi.app.interapp.RouteGuidanceInterAppService$4;
import de.audi.tghu.navi.app.interapp.RouteGuidanceInterAppService$5;
import de.audi.tghu.navi.app.interapp.RouteGuidanceInterAppService$6;
import de.audi.tghu.navi.app.interapp.RouteGuidanceInterAppService$7;
import de.audi.tghu.navi.app.interapp.RouteGuidanceInterAppService$8;
import de.audi.tghu.navi.app.interapp.RouteGuidanceInterAppService$9;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.routeguidance.AddSelectedDestinationAtIndexCommandListCreator;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import org.dsi.ifc.global.NavLocation;

public class RouteGuidanceInterAppService
implements IRouteGuidanceInterAppService {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final IStartGuidanceToDestinationSequence startGuidanceToDestinationSequence;
    private final IDestinationHandler destinationHandler;
    private final IStartGuidanceManager routeManager;
    private final ICommandListFactory commandListFactory;
    private final AddSelectedDestinationAtIndexCommandListCreator addSelectedDestinationAtIndexCommandListCreator;
    private final InterAppRouteGuidanceMapEventListener routeGuidanceMapEventListener;

    public RouteGuidanceInterAppService(NavigationEnv navigationEnv, LogChannel logChannel, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IDestinationHandler iDestinationHandler, IStartGuidanceManager iStartGuidanceManager, ICommandListFactory iCommandListFactory, AddSelectedDestinationAtIndexCommandListCreator addSelectedDestinationAtIndexCommandListCreator, NaviServiceListener naviServiceListener, MapManager mapManager) {
        this.logChannel = logChannel;
        this.env = navigationEnv;
        this.startGuidanceToDestinationSequence = iStartGuidanceToDestinationSequence;
        this.destinationHandler = iDestinationHandler;
        this.routeManager = iStartGuidanceManager;
        this.commandListFactory = iCommandListFactory;
        this.addSelectedDestinationAtIndexCommandListCreator = addSelectedDestinationAtIndexCommandListCreator;
        this.routeGuidanceMapEventListener = new InterAppRouteGuidanceMapEventListener(naviServiceListener, logChannel);
        mapManager.getMapEventDispatcher().addListener(this.routeGuidanceMapEventListener);
    }

    @Override
    public IDestinationHandler getDestinationHandler() {
        return this.destinationHandler;
    }

    @Override
    public boolean getRgActiveStatus() {
        return this.env.getContainer().isRgActive();
    }

    @Override
    public boolean isEtcDemoMode() {
        return this.env.getContainer().isEtcDemoMode();
    }

    @Override
    public void stopRouteGuidance(NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "RouteGuidanceInterAppService#stopRouteGuidance()");
        CommandList commandList = this.routeManager.getStopRouteGuidanceSequence();
        commandList.add(new RouteGuidanceInterAppService$1(this, naviServiceListener));
        commandList.setErrorCommand(new RouteGuidanceInterAppService$2(this, naviServiceListener));
        commandList.execute("RouteGuidanceInterAppService#stopRouteGuidance");
    }

    @Override
    public void restartRouteGuidance(NaviServiceListener naviServiceListener) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(this.routeManager.getRestartRouteGuidanceCommandList(true, false));
        commandList.add(new RouteGuidanceInterAppService$3(this, naviServiceListener));
        commandList.setErrorCommand(new RouteGuidanceInterAppService$4(this, naviServiceListener));
        commandList.execute("RouteGuidanceInterAppService#startRouteGuidance");
    }

    @Override
    public void startRouteGuidance(NaviServiceListener naviServiceListener, boolean bl) {
        this.logChannel.log(-2137614336, "RouteGuidanceInterAppService#startRouteGuidance()");
        NavLocation navLocation = this.destinationHandler.getLocation();
        this.logChannel.log(-2137614336, "RouteGuidanceInterAppService#startRouteGuidance( ) - location: %1 ", (Object)navLocation);
        CommandList commandList = this.commandListFactory.createCommandList();
        if (navLocation == null) {
            this.logChannel.log(-2137614336, "RouteGuidanceInterAppService#CheckStatus - no location was set.");
            commandList.add(new RouteGuidanceInterAppService$5(this, naviServiceListener));
        } else {
            commandList.add(this.getStartRgCommandList(naviServiceListener, navLocation, bl));
        }
        commandList.setErrorCommand(new RouteGuidanceInterAppService$6(this, naviServiceListener));
        commandList.execute("RouteGuidanceInterAppService#startRouteGuidance");
    }

    private CommandList getStartRgCommandList(NaviServiceListener naviServiceListener, NavLocation navLocation, boolean bl) {
        this.logChannel.log(-2137614336, "RouteGuidanceInterAppService#getStartRgCommandList( )");
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new RouteGuidanceInterAppService$7(this, "Check whethter route guidance is already started", navLocation, bl, naviServiceListener));
        return commandList;
    }

    private boolean alternativeRouteCalculationActive() {
        return this.env.getChoiceModel(-300022272).getValue() == 1;
    }

    @Override
    public void addSelectedDestinationAtIndex(int n, boolean bl, NaviServiceListener naviServiceListener) {
        this.logChannel.log(-2137614336, "RouteGuidanceInterAppService#addSelectedDestinationAtIndex( %1, %2 )", bl, (long)n);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(this.addSelectedDestinationAtIndexCommandListCreator.createAddSelectedDestinationAtIndexCommandList(n, bl));
        commandList.add(new RouteGuidanceInterAppService$8(this, naviServiceListener));
        commandList.setErrorCommand(new RouteGuidanceInterAppService$9(this, naviServiceListener));
        commandList.execute("RouteGuidanceInterAppService#addSelectedDestinationAtIndex");
    }

    static /* synthetic */ boolean access$000(RouteGuidanceInterAppService routeGuidanceInterAppService) {
        return routeGuidanceInterAppService.alternativeRouteCalculationActive();
    }

    static /* synthetic */ ICommandListFactory access$100(RouteGuidanceInterAppService routeGuidanceInterAppService) {
        return routeGuidanceInterAppService.commandListFactory;
    }

    static /* synthetic */ IStartGuidanceToDestinationSequence access$200(RouteGuidanceInterAppService routeGuidanceInterAppService) {
        return routeGuidanceInterAppService.startGuidanceToDestinationSequence;
    }
}

