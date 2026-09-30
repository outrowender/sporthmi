/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.interapp.IRouteGuidanceInterAppService;
import de.audi.tghu.navi.app.interapp.InterAppRouteGuidanceMapEventListener;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.routeguidance.AddSelectedDestinationAtIndexCommandListCreator;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
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

    public IDestinationHandler getDestinationHandler() {
        return this.destinationHandler;
    }

    public boolean getRgActiveStatus() {
        return this.env.getContainer().isRgActive();
    }

    public boolean isEtcDemoMode() {
        return this.env.getContainer().isEtcDemoMode();
    }

    public void stopRouteGuidance(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "RouteGuidanceInterAppService#stopRouteGuidance()");
        CommandList commandList = this.routeManager.getStopRouteGuidanceSequence();
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseStopRouteGuidance((byte)0);
            }
        });
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseStopRouteGuidance((byte)1);
            }
        });
        commandList.execute("RouteGuidanceInterAppService#stopRouteGuidance");
    }

    public void restartRouteGuidance(NaviServiceListener naviServiceListener) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(this.routeManager.getRestartRouteGuidanceCommandList(true, false));
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseStartRouteGuidance((byte)0);
            }
        });
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseStartRouteGuidance((byte)1);
            }
        });
        commandList.execute("RouteGuidanceInterAppService#startRouteGuidance");
    }

    public void startRouteGuidance(NaviServiceListener naviServiceListener, boolean bl) {
        this.logChannel.log(10000000, "RouteGuidanceInterAppService#startRouteGuidance()");
        NavLocation navLocation = this.destinationHandler.getLocation();
        this.logChannel.log(10000000, "RouteGuidanceInterAppService#startRouteGuidance( ) - location: %1 ", (Object)navLocation);
        CommandList commandList = this.commandListFactory.createCommandList();
        if (navLocation == null) {
            this.logChannel.log(10000000, "RouteGuidanceInterAppService#CheckStatus - no location was set.");
            commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

                protected void call(NaviServiceListener naviServiceListener) {
                    naviServiceListener.responseStartRouteGuidance((byte)1);
                }
            });
        } else {
            commandList.add(this.getStartRgCommandList(naviServiceListener, navLocation, bl));
        }
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseStartRouteGuidance((byte)1);
            }
        });
        commandList.execute("RouteGuidanceInterAppService#startRouteGuidance");
    }

    private CommandList getStartRgCommandList(final NaviServiceListener naviServiceListener, final NavLocation navLocation, final boolean bl) {
        this.logChannel.log(10000000, "RouteGuidanceInterAppService#getStartRgCommandList( )");
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("Check whethter route guidance is already started"){

            public void execute() {
                if (this.dsiResponseContainer.isRgActive() || this.dsiResponseContainer.isEtcDemoMode() || RouteGuidanceInterAppService.this.alternativeRouteCalculationActive()) {
                    CommandList commandList = RouteGuidanceInterAppService.this.commandListFactory.createCommandList();
                    if (navLocation.isPositionValid()) {
                        commandList.add(RouteGuidanceInterAppService.this.startGuidanceToDestinationSequence.getStartSequence(null, navLocation, false, bl));
                        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

                            protected void call(NaviServiceListener naviServiceListener) {
                                naviServiceListener.responseStartRouteGuidance((byte)0);
                            }
                        });
                    } else {
                        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

                            protected void call(NaviServiceListener naviServiceListener) {
                                naviServiceListener.responseStartRouteGuidance((byte)3);
                            }
                        });
                    }
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                } else {
                    this.getCommandList().commandFinishedWithPostSequence(RouteGuidanceInterAppService.this.startGuidanceToDestinationSequence.getStartSequence(null, navLocation, false, bl));
                }
            }
        });
        return commandList;
    }

    private boolean alternativeRouteCalculationActive() {
        return this.env.getChoiceModel(401134).getValue() == 1;
    }

    public void addSelectedDestinationAtIndex(int n, boolean bl, NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "RouteGuidanceInterAppService#addSelectedDestinationAtIndex( %1, %2 )", bl, (long)n);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(this.addSelectedDestinationAtIndexCommandListCreator.createAddSelectedDestinationAtIndexCommandList(n, bl));
        commandList.add(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseAddSelectedDestinationAtIndex((byte)0);
            }
        });
        commandList.setErrorCommand(new NotifyNaviServiceListenerCommand(naviServiceListener){

            protected void call(NaviServiceListener naviServiceListener) {
                naviServiceListener.responseAddSelectedDestinationAtIndex((byte)1);
            }
        });
        commandList.execute("RouteGuidanceInterAppService#addSelectedDestinationAtIndex");
    }
}

