/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.command.RGStopGuidanceCommand;
import de.audi.tghu.navi.app.command.RmMakeRoutePersistentCommand;
import de.audi.tghu.navi.app.routeguidance.RoutePersistenceController$State;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;
import de.audi.tghu.navi.app.sds.ISDSController;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;

public class RoutePersistenceController
implements PowerEventListener {
    private static final long minLoggingIntervall;
    private final LogChannel logChannel;
    private final NavigationEnv env;
    private final OperationManager operationManager;
    private final ICommandListFactory commandListFactory;
    public static final int INSIDEAREA_NONE;
    public static final int AREA_RADIUS;
    private static final int AREA_DISTANCE_INVALID;
    public static final int TIME_IGNORE_GUIDANCE;
    private boolean savedRGActive = false;
    private int savedInsideArea = -1;
    private long savedTimeStamp = 0L;
    private boolean restartRG = false;
    private long lastLoggingTimeStamp = 0L;

    public RoutePersistenceController(LogChannel logChannel, NavigationEnv navigationEnv, OperationManager operationManager, ICommandListFactory iCommandListFactory) {
        this.logChannel = logChannel;
        this.env = navigationEnv;
        this.operationManager = operationManager;
        this.commandListFactory = iCommandListFactory;
    }

    public void loadState() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (this.env.getFramework().isFrontMU() && iStorageAccess != null) {
            RoutePersistenceController$State routePersistenceController$State = new RoutePersistenceController$State(iStorageAccess, this.logChannel);
            routePersistenceController$State.readAndDeserialize();
            this.savedRGActive = routePersistenceController$State.isRgActive();
            this.savedInsideArea = routePersistenceController$State.getInsideArea();
            this.savedTimeStamp = routePersistenceController$State.getTimeStamp();
        }
        this.logChannel.log(1078071040, "[RouteGuidance] RoutePersistenceController#loadState() - savedRGActive: %3, savedInsideArea: %1, savedTimeStamp: %2", (Object)Integer.toString(this.savedInsideArea), (Object)Util.formatDate(this.savedTimeStamp), (Object)Boolean.toString(this.savedRGActive));
    }

    public void storeGuidanceStatus(boolean bl, Route route) {
        int n;
        boolean bl2;
        long l = this.env.getFramework().getKombiTime();
        boolean bl3 = bl2 = l - this.lastLoggingTimeStamp >= 0;
        if (bl2) {
            this.lastLoggingTimeStamp = l;
        }
        if (!this.env.getFramework().isFrontMU()) {
            if (bl2) {
                this.logChannel.log(-2137614336, "[RouteGuidance] RoutePersistenceController#storeGuidanceStatus() - not FrontMu. Storing ignored ...");
            }
            return;
        }
        if (!this.operationManager.isFullyOperable()) {
            if (bl2) {
                this.logChannel.log(-2137614336, "[RouteGuidance] RoutePersistenceController#storeGuidanceStatus() - navigation not operable. Storing ignored ...");
            }
            return;
        }
        boolean bl4 = this.env.getContainer().isRgActive();
        if (bl4 && !this.env.getFramework().getSysApp().isClockAdjusted()) {
            if (bl2) {
                this.logChannel.log(-2137614336, "[RouteGuidance] RoutePersistenceController#storeGuidanceStatus() - rg is active, but clock not adjusted. Storing ignored ...");
            }
            return;
        }
        RgInfoForNextDestination rgInfoForNextDestination = this.env.getContainer().getRgInfoForNextDestination();
        if (rgInfoForNextDestination == null) {
            if (bl2) {
                this.logChannel.log(-2137614336, "[RouteGuidance] RoutePersistenceController#storeGuidanceStatus() - rgInfoForNextDestination is null");
            }
            n = this.savedInsideArea;
        } else {
            boolean bl5 = rgInfoForNextDestination.getAirDistanceToNextDest() >= 0L;
            int n2 = bl5 ? (int)rgInfoForNextDestination.getAirDistanceToNextDest() : -1;
            int n3 = RouteUtil.getIndexOfCurrentDestination(route);
            int n4 = n = bl4 && bl5 && n2 <= 200 ? n3 : -1;
            if (bl2) {
                this.logChannel.log(-2137614336, "[RouteGuidance] RoutePersistenceController#storeGuidanceStatus() - rgActive: %1, airDistance: %2, insideArea: %3", bl4, (Object)Util.formatDistance(n2, 1), (Object)Integer.toString(n));
            }
        }
        try {
            IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
            long l2 = this.env.getFramework().getKombiTime() & 0xFFFFFFFFFFFF8000L;
            if (bl4 != this.savedRGActive || n != this.savedInsideArea || bl && l2 != this.savedTimeStamp) {
                RoutePersistenceController$State routePersistenceController$State = new RoutePersistenceController$State(iStorageAccess, this.logChannel);
                routePersistenceController$State.setRgActive(bl4);
                routePersistenceController$State.setInsideArea(n);
                routePersistenceController$State.setTimeStamp(l2);
                routePersistenceController$State.serializeAndWrite();
                this.logChannel.log(-2137614336, "[RouteGuidance] RoutePersistenceController#storeGuidanceStatus() savedRGActive: %3, savedInsideArea: %1, savedTimeStamp: %2", (Object)Integer.toString(this.savedInsideArea), (Object)Util.formatDate(this.savedTimeStamp), (Object)Boolean.toString(this.savedRGActive));
                this.logChannel.log(-2137614336, "[RouteGuidance] RoutePersistenceController#storeGuidanceStatus() - save new values rgActive: %3, insideArea: %1, timeStamp: %2", (Object)Integer.toString(n), (Object)Util.formatDate(l2), (Object)Boolean.toString(bl4));
                this.savedRGActive = bl4;
                this.savedInsideArea = n;
                this.savedTimeStamp = l2;
            }
        }
        catch (Exception exception) {
            this.logChannel.log(-1601830656, "[RouteGuidance] RoutePersistenceController#storeGuidanceStatus() - %1 ", (Throwable)exception);
        }
    }

    public boolean restartRouteGuidance(StartRouteGuidanceSequences startRouteGuidanceSequences, Route route, ISDSController iSDSController) {
        boolean bl;
        boolean bl2 = this.env.getContainer().isEtcDemoMode();
        this.logChannel.log(1078071040, "[RouteGuidance] RoutePersistenceController#restartRouteGuidance() - restartRG: %1, demoMode: %2", this.restartRG, bl2);
        boolean bl3 = bl = this.env.getFramework().isFrontMU() && this.restartRG;
        if (bl) {
            Util.logStartupEvent(this.env.getFramework(), "[Startup] GuidanceListener#restartRG() - restarting route guidance ");
            this.logChannel.log(1078071040, "[RouteGuidance] RoutePersistenceController#restartRouteGuidance() - restarting route guidance ");
            this.operationManager.checkTTS();
            if (route != null && route.getRouteID() == 0) {
                startRouteGuidanceSequences.resumeRouteGuidanceToOffroad(route, true, iSDSController);
            } else {
                startRouteGuidanceSequences.resumeRouteGuidance(route, true, iSDSController);
            }
        } else {
            this.logChannel.log(1078071040, "[RouteGuidance] RoutePersistenceController#restartRouteGuidance() - route guidance not restarted, demoMode: %1 restartRG: %2!", bl2, this.restartRG);
        }
        return bl;
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    @Override
    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    @Override
    public void notifyPowerTriggerAction(int n, int n2) {
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    public CommandList evaluateGuidanceStatus(Route route) {
        int n;
        this.logChannel.log(1078071040, "[RouteGuidance] RoutePersistenceController#evaluateGuidanceStatus() - savedRGActive: %3, savedInsideArea: %1, savedTimeStamp: %2", (long)this.savedInsideArea, this.savedTimeStamp, this.savedRGActive);
        this.logChannel.log(1078071040, "[RouteGuidance] RoutePersistenceController#evaluateGuidanceStatus() - routeID: %1", (long)RouteUtil.getRouteID(route));
        if (!this.savedRGActive) {
            return null;
        }
        boolean bl = false;
        int n2 = RouteUtil.getRouteLength(route);
        this.logChannel.log(1078071040, "[RouteGuidance] RoutePersistenceController#evaluateGuidanceStatus() - savedRGActive: %3, savedInsideArea: %1, savedTimeStamp: %2", (long)this.savedInsideArea, this.savedTimeStamp, this.savedRGActive);
        if (this.env.getFramework().isFrontMU() && this.savedRGActive) {
            boolean bl2 = this.env.getFramework().getSysApp().isClockAdjusted();
            if (this.doesVariantCareForTime() && bl2) {
                long l = this.env.getFramework().getKombiTime();
                long l2 = (l - this.savedTimeStamp) / 0;
                n = 0L <= l2 && l2 < 0 ? 1 : 0;
                this.logChannel.log(1078071040, "[RouteGuidance] RoutePersistenceController#evaluateGuidanceStatus() - '%1' -> '%2' (diff: %3 min) ", (Object)Util.formatDate(this.savedTimeStamp), (Object)Util.formatDate(l), l2);
            } else {
                n = 1;
                this.logChannel.log(1078071040, "[RouteGuidance] RoutePersistenceController#evaluateGuidanceStatus() - clock was not adjusted; inTime flag will be ignored");
            }
            if (n != 0 && n2 > 0) {
                int n3 = RouteUtil.getRouteID(route);
                int n4 = RouteUtil.getIndexOfCurrentDestination(route);
                if (this.savedInsideArea != -1) {
                    if (this.savedInsideArea == n4) {
                        if (n4 < n2 - 1) {
                            this.logChannel.log(1078071040, "[RouteGuidance] RoutePersistenceController#evaluateGuidanceStatus() - mark stopover (%1/%2) as passed. ", (long)n4, (long)n2);
                            bl = true;
                            this.restartRG = true;
                        } else {
                            this.logChannel.log(1078071040, "[RouteGuidance] RoutePersistenceController#evaluateGuidanceStatus() - final destination reached in area. ");
                            this.restartRG = false;
                            bl = false;
                        }
                    } else {
                        this.logChannel.log(-1601830656, "[RouteGuidance] RoutePersistenceController#evaluateGuidanceStatus() - index: %1 and savedInsideArea: %2 mismatch! InsideArea ignored.", (long)n4, (long)this.savedInsideArea);
                        this.restartRG = true;
                        bl = false;
                    }
                } else {
                    this.logChannel.log(1078071040, "[RouteGuidance] RoutePersistenceController#evaluateGuidanceStatus() - destination (%1/%2) not reached yet. ", (long)n4, (long)n2);
                    this.restartRG = true;
                    bl = false;
                }
            } else {
                this.logChannel.log(1078071040, "[RouteGuidance] RoutePersistenceController#evaluateGuidanceStatus() - guidance will not be started! inTime: %1, routeLength: %2", n != 0, (long)n2);
            }
        }
        this.logChannel.log(1078071040, "[RouteGuidance] RoutePersistenceController#evaluateGuidanceStatus() - restartRG: %1, markNextStopoverAsPassed: %2 ", this.restartRG, bl);
        if (!this.restartRG) {
            return null;
        }
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new RGStopGuidanceCommand());
        if (bl && (n = RouteUtil.getIndexOfCurrentDestination(route)) + 1 < n2) {
            RouteUtil.setIndexOfCurrentDestination(route, n + 1, this.logChannel);
            commandList.add(new RmMakeRoutePersistentCommand(route));
        }
        return commandList;
    }

    protected boolean doesVariantCareForTime() {
        return !Util.isPorsche(this.env.getFramework()) && !Util.isPorscheGen2(this.env.getFramework()) && !Util.isBentley(this.env.getFramework());
    }
}

