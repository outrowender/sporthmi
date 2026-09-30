/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.presentationmode;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.RGSetPosition;
import de.audi.tghu.navi.app.command.RGStopGuidanceCommand;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.presentationmode.EtcSetDemoModeCommand;
import de.audi.tghu.navi.app.presentationmode.IDemoModeModelAccess;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceManager;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.Route;

public class DemoModeManager
implements TimerListener {
    public static final int DEMO_MODE_REPEAT_TIME = 5000;
    public static final int DEMO_MODE_CHOICE_ON = 1;
    public static final int DEMO_MODE_CHOICE_OFF = 0;
    public static final boolean DEMO_MODE_BOOLEAN_OFF = false;
    public static final boolean DEMO_MODE_BOOLEAN_ON = true;
    private NavigationEnv env;
    private final LogChannel logChannel;
    private ICommandListFactory commandListFactory;
    private IVehicle vehicle;
    private IStartGuidanceManager startGuidanceManager;
    private NavLocation startPosition = null;
    private Timer repeatDemoModeTimer;
    private Route demoRoute;
    private IDemoModeModelAccess modelAccess;
    private volatile boolean moving = false;

    public DemoModeManager(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, IVehicle iVehicle, IDemoModeModelAccess iDemoModeModelAccess, IStartGuidanceManager iStartGuidanceManager) {
        this.modelAccess = iDemoModeModelAccess;
        this.vehicle = iVehicle;
        this.commandListFactory = iCommandListFactory;
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getDemoModeLogChannel();
        this.startGuidanceManager = iStartGuidanceManager;
        this.repeatDemoModeTimer = new Timer("RepeatDemoModeTimer", 5000L, true, this);
        iDemoModeModelAccess.setDemoStatus(this.isCarMoving() ? 3 : 1);
    }

    public void setDemoModeState(boolean bl) {
        CommandList commandList = this.getCommandListToTurnDemoMode(bl);
        commandList.execute("DemoModeManager#setDemoMode");
    }

    public CommandList getCommandListToTurnDemoMode(boolean bl, NavLocation navLocation) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (!bl && !Util.isHURegionAsia()) {
            commandList.add(new RGStopGuidanceCommand());
        }
        commandList.add(new NavCommand("DemoModeManager#getCommandListToTurnDemoMode - stopCurrentDemoModeGuidance"){

            public void execute() {
                DemoModeManager.this.stopCurrentDemoModeGuidance();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new EtcSetDemoModeCommand(bl));
        commandList.add(new NavCommand("DemoModeManager#getCommandListToTurnDemoMode - updateDemoModeState"){

            public void execute() {
                DemoModeManager.this.modelAccess.updateDemoModeState(this.env.getContainer().isEtcDemoMode());
                this.getCommandList().commandFinished();
            }
        });
        if (bl) {
            this.logChannel.log(10000000, "DemoModeManager#setDemoMode() - RGSetPosition will be added to the commandList");
            if (navLocation != null) {
                commandList.add(new RGSetPosition(navLocation));
            } else if (this.getStartPosition() != null) {
                commandList.add(new RGSetPosition(this.getStartPosition()));
            }
        }
        return commandList;
    }

    public CommandList getCommandListToTurnDemoMode(boolean bl) {
        return this.getCommandListToTurnDemoMode(bl, null);
    }

    public void finalDestinationReached() {
        if (this.repeatDemoModeTimer.isRunning()) {
            this.repeatDemoModeTimer.cancel();
        }
        if (this.env.getContainer().isEtcDemoMode() && this.demoRoute != null) {
            this.logChannel.log(10000000, "DemoModeManager#checkRepeatingDemoMode() - repeatDemoModeTimer restarted! ");
            this.repeatDemoModeTimer.restart();
        } else {
            this.logChannel.log(10000000, "DemoModeManager#checkRepeatingDemoMode() - condition not fulfilled!");
        }
    }

    public void restartDemoModeRoute() {
        this.logChannel.log(10000000, "DemoModeManager#restartDemoModeRoute()");
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(){

            public void execute() {
                boolean bl;
                boolean bl2 = this.dsiResponseContainer.isEtcDemoMode();
                boolean bl3 = this.dsiResponseContainer.isRgActive();
                boolean bl4 = bl = DemoModeManager.this.demoRoute != null;
                if (!bl2 || !bl || bl3) {
                    this.logger.log(100000, "DemoModeManager#restartDemoModeRoute() - etcDemoMode: %1, demoModeRouteSet: %2, rgActive: %3 ", bl2, bl, bl3);
                    this.getCommandList().commandAborted("Demo mode not longer active or RG restarted");
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        NavLocation navLocation = this.getStartPosition();
        commandList.add(new RGSetPosition(navLocation));
        commandList.add(this.startGuidanceManager.getRestartRouteGuidanceCommandList(false, this.demoRoute));
        commandList.execute("DemoModeManager#restartDemoModeRoute()");
    }

    public void stopCurrentDemoModeGuidance() {
        if (this.repeatDemoModeTimer.isRunning()) {
            this.repeatDemoModeTimer.cancel();
        }
        this.demoRoute = null;
    }

    public void setDemoModeRoute(Route route) {
        this.logChannel.log(10000000, "DemoModeManager#setDemoModeRoute( %1 ) ", (Object)RouteUtil.formatRouteShort(route));
        if (this.repeatDemoModeTimer.isRunning()) {
            this.repeatDemoModeTimer.cancel();
        }
        this.demoRoute = route;
    }

    public void setDemoModeLocation(NavLocation navLocation) {
        this.logChannel.log(10000000, "DemoModeManager#setDemoModeLocation( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.demoLocationWasSet(navLocation);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new RGSetPosition(this.getStartPosition()));
        commandList.execute("DemoModeManager#setDemoModeLocation()");
    }

    public void demoLocationWasSet(NavLocation navLocation) {
        this.startPosition = navLocation;
    }

    public void fireTimer(Timer timer) {
        if (timer == this.repeatDemoModeTimer) {
            this.restartDemoModeRoute();
        }
    }

    public void cancelTimer(Timer timer) {
        this.demoRoute = null;
    }

    public void updateEtcDemoModeState(boolean bl) {
        this.modelAccess.updateDemoModeState(bl);
    }

    public final boolean isCarMoving() {
        return this.moving;
    }

    public void cleanUp() {
        this.env = null;
        this.commandListFactory = null;
        this.modelAccess = null;
        this.startGuidanceManager = null;
        this.vehicle = null;
    }

    public synchronized void setIsCarMoving(boolean bl) {
        this.moving = bl;
    }

    public void setDemoStatus(int n) {
        this.modelAccess.setDemoStatus(n);
    }

    public NavLocation getStartPosition() {
        if (this.startPosition == null) {
            PosPosition posPosition = this.vehicle.getPosition();
            if (posPosition.longitude != 0 && posPosition.latitude != 0) {
                this.startPosition = Util.getLocationFromGeoPos(posPosition.longitude, posPosition.latitude);
                this.logChannel.log(10000000, "DemoModeManager#getStartPosition() - returning current vehicle position %1", (Object)LocationFormatter.formatLocationShort(this.startPosition));
            } else {
                this.startPosition = Util.getFallbackLocation();
                this.logChannel.log(10000000, "DemoModeManager#getStartPosition() - returning TOR9");
            }
        } else {
            this.logChannel.log(10000000, "DemoModeManager#getStartPosition() - returning %1", (Object)LocationFormatter.formatLocationShort(this.startPosition));
        }
        return this.startPosition;
    }
}

