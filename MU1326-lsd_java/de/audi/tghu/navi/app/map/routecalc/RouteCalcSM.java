/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.WaitForMapReadyCommand;
import de.audi.tghu.navi.app.map.context.CtxRubberBand;
import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator;
import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator$IRouteCalcEnv;
import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator$RouteCalculationListener;
import de.audi.tghu.navi.app.map.routecalc.RcciEvent;
import de.audi.tghu.navi.app.map.routecalc.RcsBase;
import de.audi.tghu.navi.app.map.routecalc.RcsBetterRouteAvailable;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingAlternative;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingAlternativeNew;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingBaseRouteAfterRubberband;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingFurtherAlternative;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingFurtherAlternativeAsia;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingSingle;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingSingleOffroad;
import de.audi.tghu.navi.app.map.routecalc.RcsIdle;
import de.audi.tghu.navi.app.map.routecalc.RcsRGActivated;
import de.audi.tghu.navi.app.map.routecalc.RcsRestartAfterAltRoutesCanceled;
import de.audi.tghu.navi.app.map.routecalc.RcsWaitForActivation;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcDataContainer;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM$1;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM$2;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM$3;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM$4;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM$5;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM$6;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM$7;
import de.audi.tghu.navi.app.map.routecalc.RubberbandFactory;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.NavRouteListDataIcon;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;

public class RouteCalcSM
extends RouteCalcDataContainer
implements IRouteCalculator {
    private static final long THRESHOLD_DEFINITIVE_BETTER;
    private static final int SCREEN_SWITCH_DELAY;
    private int currentState = 0;
    private int lastState = 0;
    private final LogChannel logger;
    private final RcsBase[] states;
    List routeCalculationListeners = null;
    private boolean isRGAboutToBeStarted = false;
    private boolean isSingleRoute = true;
    private Object newRoutevanishedLock = new Object();
    private boolean isRubberbandActive = false;
    protected final Timer screenSwitchDelayer;
    protected final Timer abortCalculationTimer;
    private boolean isAutoStartRGAndSwitchEnabled = true;
    private WaitForMapReadyCommand waitForMapReadyCommand = null;
    protected NavigationEnv env;
    private RouteOptions[] routeOptionsUsedForCalculation;
    private NavRouteListData[] lastRgDestinationInfo = null;
    protected final IRouteCalculator$IRouteCalcEnv naviMap;

    public RouteCalcSM(NavigationEnv navigationEnv, IRouteCalculator$IRouteCalcEnv iRouteCalculator$IRouteCalcEnv) {
        this.logger = navigationEnv.getLogChannel("App.Map.RouteCalc");
        this.env = navigationEnv;
        this.naviMap = iRouteCalculator$IRouteCalcEnv;
        this.currentState = 0;
        this.states = new RcsBase[13];
        this.states[0] = new RcsIdle(this);
        this.states[1] = new RcsCalculatingSingle(this);
        this.states[2] = new RcsCalculatingFurtherAlternative(this);
        this.states[3] = new RubberbandFactory(navigationEnv).getRcsCalculatingRubberband(this);
        this.states[4] = new RcsCalculatingAlternative(this);
        this.states[5] = new RcsCalculatingAlternativeNew(this);
        this.states[6] = new RcsCalculatingBaseRouteAfterRubberband(this);
        this.states[7] = new RcsRGActivated(this);
        this.states[8] = new RcsWaitForActivation(this);
        this.states[9] = this.createRcsBetterRouteAvailable(this);
        this.states[10] = new RcsCalculatingFurtherAlternativeAsia(this);
        this.states[11] = new RcsRestartAfterAltRoutesCanceled(this);
        this.states[12] = new RcsCalculatingSingleOffroad(this);
        this.startRGTimer = new Timer("StartRGTimer", 0, true, new RouteCalcSM$1(this, iRouteCalculator$IRouteCalcEnv));
        this.screenSwitchDelayer = new Timer("", 0, true, new RouteCalcSM$2(this, iRouteCalculator$IRouteCalcEnv));
        this.shortBetterRouteAvailableInfoTimer = new Timer("availableRouteTimer", 0, true, new RouteCalcSM$3(this, iRouteCalculator$IRouteCalcEnv));
        this.abortCalculationTimer = new Timer("abortCalculationTimer", 0, true, new RouteCalcSM$4(this));
        this.createSwitchToSemiDynListener(navigationEnv, iRouteCalculator$IRouteCalcEnv);
        this.createIgnoreBetterRouteListener(iRouteCalculator$IRouteCalcEnv);
        this.createIgnoreDetourListener(iRouteCalculator$IRouteCalcEnv);
        this.createDetourNowListener(navigationEnv, iRouteCalculator$IRouteCalcEnv);
        int n = this.getState().getValue4Model();
        navigationEnv.getChoiceModel(706545152).setValue(n);
    }

    protected void createDetourNowListener(NavigationEnv navigationEnv, IRouteCalculator$IRouteCalcEnv iRouteCalculator$IRouteCalcEnv) {
    }

    protected void createIgnoreDetourListener(IRouteCalculator$IRouteCalcEnv iRouteCalculator$IRouteCalcEnv) {
        iRouteCalculator$IRouteCalcEnv.getViews().getSemidynRGView().setIgnoreDetourListener(new RouteCalcSM$5(this, iRouteCalculator$IRouteCalcEnv));
    }

    protected void createIgnoreBetterRouteListener(IRouteCalculator$IRouteCalcEnv iRouteCalculator$IRouteCalcEnv) {
        iRouteCalculator$IRouteCalcEnv.getViews().getSemidynRGView().setIgnoreBetterRouteListener(new RouteCalcSM$6(this, iRouteCalculator$IRouteCalcEnv));
    }

    protected void createSwitchToSemiDynListener(NavigationEnv navigationEnv, IRouteCalculator$IRouteCalcEnv iRouteCalculator$IRouteCalcEnv) {
        iRouteCalculator$IRouteCalcEnv.getViews().getSemidynRGView().addSwitchToSemidynListener(new RouteCalcSM$7(this, navigationEnv));
    }

    protected RcsBase createRcsBetterRouteAvailable(RouteCalcSM routeCalcSM) {
        return new RcsBetterRouteAvailable(routeCalcSM);
    }

    protected LogChannel getLogger() {
        return this.logger;
    }

    @Override
    public void abortRouteCalculation(boolean bl) {
        this.getLogger().log(-2137614336, "RouteCalcSM#abortRouteCalculation()");
        this.getState().reset();
        this.setCalcFurtherAltRoutes(false);
        this.setWaitForAvailableRoute(false);
        this.env.getChoiceModel(1360856576).setValue(0);
        if (this.naviMap.getNavigationEnv().getFramework().isFrontMU()) {
            this.naviMap.getNaviInterface().stopRouteGuidance();
        } else {
            this.naviMap.getNaviInterface().setNavigationMode(1);
        }
        int n = this.naviMap.getActiveContextIndex();
        if (n == 20 || n == 5 || n == 33) {
            this.naviMap.switchToAShownContext();
        } else if (n == 34) {
            if (bl) {
                this.isBaseRouteReconstructable = false;
                this.setRubberbandActive(false);
            }
            ((CtxRubberBand)this.naviMap.getActiveContext()).checkAndFireBackEvent();
            this.naviMap.switchToAShownContext();
        }
        this.cancelAbortCalculationTimer();
        this.fireEvent(211);
        this.goTo(0);
    }

    @Override
    public void cancelTimer() {
        this.getLogger().log(-2137614336, "RouteCalcSM#cancelTimer()");
        this.startRGTimer.cancel();
    }

    private boolean check(int n, int n2) {
        if (n2 == 9 && !Util.isSemidynamicRgAvailable(this.env.getFramework())) {
            this.getLogger().log(-1601830656, "RouteCalcSM#check() - invalid switch from %1 to %2, ignored. Rubberband not available", (long)n, (long)n2);
            return false;
        }
        if (n == 7 && n2 == 8) {
            this.getLogger().log(-1601830656, "RouteCalcSM#check() - invalid switch from %1 to %2, ignored", (long)n, (long)n2);
            return false;
        }
        return true;
    }

    @Override
    public void cleanup() {
        this.getLogger().log(-2137614336, "RouteCalcSM#cleanup()");
        this.reset();
    }

    @Override
    public void reset() {
        this.getLogger().log(-2137614336, "RouteCalcSM#reset()");
        this.isRGAboutToBeStarted = false;
        this.cancelAbortCalculationTimer();
        this.getState().reset();
        this.goTo(0);
    }

    @Override
    public void enableTimer(boolean bl) {
        this.getLogger().log(-2137614336, "RouteCalcSM#enableTimer( %1 )", bl);
        this.getState().enableTimer(bl);
        this.disableTimer = !bl;
    }

    @Override
    public CalculatedRouteListElement[] getCalculatedRouteListElement() {
        return this.mCalculatedRouteListElement;
    }

    @Override
    public RgRouteCostChangeInformation getRgRCCI() {
        return this.rgRCCI;
    }

    @Override
    public int getRgRouteCalculationState() {
        return this.iRgRouteCalculationState;
    }

    @Override
    public Route getRoute() {
        return this.currentRoute;
    }

    @Override
    public int getSelectedRouteIndex() {
        return this.iRouteIndex;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    RcsBase getState() {
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            return this.states[this.currentState];
        }
    }

    int getLastState() {
        return this.lastState;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void goTo(int n) {
        boolean bl = false;
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            if (this.currentState == n) {
                this.logger.log(1078071040, "RouteCalcSM#goTo() - it is alreay in state %1, cancel switch.", (Object)this.states[n]);
                return;
            }
            if (this.check(this.currentState, n)) {
                this.logger.log(1078071040, "RouteCalcSM#goTo() - %1 -> %2 ", (Object)this.states[this.currentState], (Object)this.states[n]);
                try {
                    this.states[this.currentState].exit();
                    this.lastState = this.currentState;
                    this.currentState = n;
                    this.states[n].enter();
                    this.currentState = n;
                    bl = true;
                }
                catch (Exception exception) {
                    this.logger.log(10000, "RouteCalcSM#goTo() - %1 enter : %2", (Object)this.states[n], (Throwable)exception);
                }
            } else {
                this.logger.log(-1601830656, "RouteCalcSM#goTo() - %1 -> %2 : invalid or not allowed", (Object)this.states[this.currentState], (Object)this.states[n]);
            }
        }
        if (bl) {
            this.postSwitch();
        }
        int n2 = this.getState().getValue4Model();
        this.env.getChoiceModel(706545152).setValue(n2);
    }

    private void postSwitch() {
        try {
            this.isBaseRouteReconstructable = this.currentState == 3 && this.lastState != 4;
        }
        catch (Exception exception) {
            this.logger.log(10000, "RouteCalcSM#postSwitch() - %1", (Throwable)exception);
        }
    }

    @Override
    public boolean isCalculatingAltRoutes() {
        switch (this.currentState) {
            case 2: 
            case 4: 
            case 5: 
            case 10: {
                return true;
            }
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isMatchingRoutesFound() {
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            return this.getState().isMatchingRoutesFound();
        }
    }

    @Override
    public boolean isRouteCalculationActive() {
        switch (this.currentState) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 10: {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isRouteCalculationNotIdle() {
        return this.currentState != 0;
    }

    @Override
    public boolean isRubberbandReady() {
        return this.iRgRouteCalculationState == 3;
    }

    @Override
    public boolean isWaitingForAlternativRoutes() {
        return this.currentState == 2 || this.currentState == 10;
    }

    @Override
    public void removeRouteCalculationListener(IRouteCalculator$RouteCalculationListener iRouteCalculator$RouteCalculationListener) {
        this.getLogger().log(-2137614336, "RouteCalcSM#removeRouteCalculationListener()");
        if (this.routeCalculationListeners == null) {
            this.getLogger().log(-1601830656, "RouteCalcSM#removeRouteCalculationListener() - no listener.");
        } else {
            this.routeCalculationListeners.remove(iRouteCalculator$RouteCalculationListener);
        }
    }

    @Override
    public void restartTimerIfCalculationStateIsReady() {
        if (this.disableTimer) {
            this.getLogger().log(-2137614336, "RouteCalcSM#restartTimerIfCalculationStateIsReady() - ignored: timer disabled");
            this.cancelTimer();
            return;
        }
        if (!this.isAutoStartRGAndSwitchEnabled) {
            this.getLogger().log(-2137614336, "RouteCalcSM#restartTimerIfCalculationStateIsReady() - ignored: auto start temporarily disabled");
            this.cancelTimer();
            return;
        }
        if (this.iRgRouteCalculationState != 2) {
            this.getLogger().log(-2137614336, "RouteCalcSM#restartTimerIfCalculationStateIsReady() - ignored: calculation state = %1", (long)this.iRgRouteCalculationState);
            this.cancelTimer();
            return;
        }
        int n = -1;
        switch (this.currentState) {
            case 2: 
            case 4: 
            case 5: 
            case 10: {
                n = 15000;
                break;
            }
            case 3: {
                this.getLogger().log(14808325, "RouteCalcSM#restartTimerIfCalculationStateIsReady() - ignore");
                break;
            }
            default: {
                this.getLogger().log(-1601830656, "RouteCalcSM#restartTimerIfCalculationStateIsReady() - unknown state : %1", (long)this.currentState);
            }
        }
        if (n > 0) {
            this.getLogger().log(1078071040, "RouteCalcSM#restartTimerIfCalculationStateIsReady() - rcsState:%1, delay:%2", (long)this.currentState, (long)n);
            this.startRGTimer.setDelay(n);
            this.startRGTimer.restart();
        }
    }

    @Override
    public void setRouteCalculationListener(IRouteCalculator$RouteCalculationListener iRouteCalculator$RouteCalculationListener) {
        this.getLogger().log(-2137614336, "RouteCalcSM#setRouteCalculationListener()");
        if (this.routeCalculationListeners == null) {
            this.routeCalculationListeners = new ArrayList();
            this.routeCalculationListeners.add(iRouteCalculator$RouteCalculationListener);
        } else if (!this.routeCalculationListeners.contains(iRouteCalculator$RouteCalculationListener)) {
            this.routeCalculationListeners.add(iRouteCalculator$RouteCalculationListener);
        } else {
            this.getLogger().log(14808325, "RouteCalcSM#setRouteCalculationListener() - listener already registered");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setSelectedRouteIndex(int n) {
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.getState().setSelectedRouteIndex(n);
        }
    }

    @Override
    public boolean startRG(int n) {
        try {
            boolean bl = this.isCalculatingAltRoutes();
            boolean bl2 = this.startRG(n, false);
            if (bl2 && bl) {
                this.goTo(7);
            }
            return bl2;
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "RouteCalcSM#startRG( %1 ) - %2", (long)n, (Throwable)exception);
            return false;
        }
    }

    public boolean dorestartAfterAltRoutesCancelled(int n) {
        try {
            if (this.isInRestartAfterAltRoutes()) {
                int n2;
                int n3 = n2 = this.getCalculatedRouteListElement() != null ? this.getCalculatedRouteListElement().length : 0;
                if (0 > n || n >= n2) {
                    this.getLogger().log(-1601830656, "RouteCalcSM#doRestartAfterAlRoutes( ) - invalid route index = %1, route count = %2", (long)n, (long)n2);
                    return false;
                }
                if (!MapUtils.isCRLElementCalculated(this.getCalculatedRouteListElement()[n])) {
                    this.getLogger().log(-1601830656, "RouteCalcSM#doRestartAfterAlRoutes( ) - invalid route index = %1, not calculated", (long)n);
                    return false;
                }
                this.iRouteIndex = n;
                this.currentNavSegmentID = this.getCalculatedRouteListElement()[n].getSegmentIDList();
                this.getLogger().log(1078071040, "RouteCalcSM#doRestartAfterAlRoutes() - routeIndex = %3, waitForAvailableRoute = %2, %1", (Object)this.currentNavSegmentID, (Object)Boolean.toString(this.getWaitForAvailableRoute()), (long)n);
                this.setCalcFurtherAltRoutes(false);
                if (this.isRGAboutToBeStarted()) {
                    this.getLogger().log(-1601830656, "RouteCalcSM#doRestartAfterAlRoutes( ) - isRGAboutToBeStarted = true : this should have been set to false.");
                    this.isRGAboutToBeStarted = false;
                }
                this.cancelAbortCalculationTimer();
                this.naviMap.getNaviInterface().startGuidanceCalculatedRoute(n);
                RcciEvent rcciEvent = RcciEvent.create(this.getCalculatedRouteListElement()[n], this.getTresholdDefinitiveBetter());
                this.dispatchRcciEvent(rcciEvent);
                this.setWaitForAvailableRoute(true);
                this.fireEvent(212);
                return true;
            }
            return false;
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "RouteCalcSM#startRG( %1 ) - %2", (long)n, (Throwable)exception);
            return false;
        }
    }

    public boolean isInRestartAfterAltRoutes() {
        return this.currentState == 11;
    }

    @Override
    public boolean gotoRestartAfterAltRoutesCancelled(int n) {
        try {
            if (this.currentState != 7) {
                this.goTo(11);
            } else {
                this.getLogger().log(10000, "RouteCalcSM#gotoRestartAfterAltRoutesCancelled ignore call as rg is already active");
            }
            return true;
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "RouteCalcSM#gotoRestartAfterAltRoutesCancelled( %1 ) - %2", (long)n, (Throwable)exception);
            return false;
        }
    }

    boolean startRG(int n, boolean bl) {
        int n2;
        int n3 = n2 = this.getCalculatedRouteListElement() != null ? this.getCalculatedRouteListElement().length : 0;
        if (0 > n || n >= n2) {
            this.getLogger().log(-1601830656, "RouteCalcSM#startRG( ) - invalid route index = %1, route count = %2", (long)n, (long)n2);
            return false;
        }
        if (!MapUtils.isCRLElementCalculated(this.getCalculatedRouteListElement()[n])) {
            this.getLogger().log(-1601830656, "RouteCalcSM#startRG( ) - invalid route index = %1, not calculated", (long)n);
            return false;
        }
        this.iRouteIndex = n;
        this.currentNavSegmentID = this.getCalculatedRouteListElement()[n].getSegmentIDList();
        this.getLogger().log(1078071040, "RouteCalcSM#startRG() - routeIndex = %3, waitForAvailableRoute = %2, %1", (Object)this.currentNavSegmentID, (Object)Boolean.toString(this.getWaitForAvailableRoute()), (long)n);
        this.setCalcFurtherAltRoutes(false);
        if (this.isRGAboutToBeStarted()) {
            this.getLogger().log(-1601830656, "RouteCalcSM#startRG( ) - isRGAboutToBeStarted = true : this should have been set to false.");
            this.isRGAboutToBeStarted = false;
        }
        this.cancelAbortCalculationTimer();
        this.goTo(8);
        this.naviMap.getNaviInterface().startGuidanceCalculatedRoute(n);
        RcciEvent rcciEvent = RcciEvent.create(this.getCalculatedRouteListElement()[n], this.getTresholdDefinitiveBetter());
        this.dispatchRcciEvent(rcciEvent);
        if (!this.getWaitForAvailableRoute()) {
            this.naviMap.switchToAShownContext();
        }
        this.setWaitForAvailableRoute(true);
        if (n == 0 && !bl) {
            this.cleanCalculatedRouteListElements(false);
        }
        this.fireEvent(212);
        return true;
    }

    @Override
    public void startRGByUID(NavSegmentID navSegmentID) {
        this.currentNavSegmentID = navSegmentID;
        this.getLogger().log(1078071040, "RouteCalcSM#startRGByUID( ) - %1", (Object)this.currentNavSegmentID);
        this.setCalcFurtherAltRoutes(false);
        this.cancelTimer();
        CommandList commandList = this.naviMap.getNaviInterface().startGuidanceCalculatedRouteByUID(navSegmentID);
        commandList.execute("RouteCalcSM#startRGByUID()");
        this.goTo(7);
        this.naviMap.switchToAShownContext();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void startRGByUID(int n) {
        Object object;
        switch (n) {
            case 0: {
                if (this.origialRoute == null) {
                    this.getLogger().log(10000, "RouteCalcSM#startRGByUID( %1 ) - original route = null", (long)n);
                    return;
                }
                this.currentNavSegmentID = this.origialRoute.getSegmentIDList();
                object = this.newRoutevanishedLock;
                synchronized (object) {
                    if (!this.newRouteVanished) {
                        if (!Util.isPorsche(this.env.getFramework())) {
                            this.isBetterRouteIgnored = true;
                        }
                    } else {
                        this.getLogger().log(-2137614336, "RouteCalcSM#startRGByUID( %1 ) - new Route vansished do not set isBetterRouteIgnored flag", (long)n);
                    }
                    this.newRouteVanished = false;
                    break;
                }
            }
            case 1: {
                if (this.betterRoute == null) {
                    this.getLogger().log(10000, "RouteCalcSM#startRGByUID( %1 ) - better route = null", (long)n);
                    return;
                }
                this.currentNavSegmentID = this.betterRoute.getSegmentIDList();
                this.origialRoute = this.betterRoute;
                break;
            }
            default: {
                this.getLogger().log(10000, "RouteCalcSM#startRGByUID( %1 ) - invalid", (long)n);
                return;
            }
        }
        this.isAutoStartRGAndSwitchEnabled = false;
        this.setCalcFurtherAltRoutes(false);
        this.setSelectedRouteIndex(n);
        this.getLogger().log(1078071040, "RouteCalcSM#startRGByUID( %2 ) - %1", (Object)this.currentNavSegmentID, (long)n);
        this.cancelTimer();
        object = this.naviMap.getNaviInterface().startGuidanceCalculatedRouteByUID(this.currentNavSegmentID);
        ((CommandList)object).execute("RouteCalcSM#startRGByUID()");
        RcciEvent rcciEvent = null;
        if (n == 1) {
            rcciEvent = RcciEvent.create(this.betterRoute, this.getTresholdDefinitiveBetter());
            this.goTo(7);
        } else {
            rcciEvent = this.getRcciEvent();
        }
        this.dispatchRcciEvent(rcciEvent);
        this.naviMap.getNaviInterface().getTMCGateWay().leaveMapSemidynamicRouteScreen();
        this.naviMap.switchToAShownContext();
    }

    void dispatchRcciEvent(RcciEvent rcciEvent) {
        this.getLogger().log(-2137614336, "RouteCalcSM#dispatchRcciEvent() - %1", (Object)rcciEvent);
        this.pushRcciEvent(rcciEvent);
        try {
            this.naviMap.getViews().getMainMapView().setTrafficDelay(rcciEvent.reliable ? this.rcciEvent.delay : -1L);
        }
        catch (Exception exception) {
            this.getLogger().log(-1601830656, "RouteCalcSM#dispatchRcciEvent() - %1", (Throwable)exception);
        }
        try {
            this.naviMap.getNaviInterface().getClusterService().updateSemidynamicRouteGuidance(rcciEvent);
        }
        catch (Exception exception) {
            this.getLogger().log(-1601830656, "RouteCalcSM#dispatchRcciEvent() - %1", (Throwable)exception);
        }
        try {
            this.naviMap.getNaviInterface().getTMCGateWay().updateSemidynamicRouteGuidance(rcciEvent.delay, rcciEvent.reliable, rcciEvent.hasBetterRoute, (int)(rcciEvent.savingTime / 0));
        }
        catch (Exception exception) {
            this.getLogger().log(-1601830656, "RouteCalcSM#dispatchRcciEvent() - %1", (Throwable)exception);
        }
        try {
            this.naviMap.getNaviInterface().updateDelayOnCurrentRoute(rcciEvent.delay);
        }
        catch (Exception exception) {
            this.getLogger().log(-1601830656, "RouteCalcSM#dispatchRcciEvent() - %1", (Throwable)exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void startRouteCalculation(Route route, int n, boolean bl, boolean bl2, boolean bl3) {
        Buffer buffer = new Buffer();
        buffer.append("numOfAltRoutes:").append(n);
        buffer.append(" prepareMap:").append(bl);
        buffer.append(" waitForAltRoutes:").append(bl2);
        buffer.append(" route:").append(route);
        this.getLogger().log(1078071040, "RouteCalcSM#startRouteCalculation() - %1", (Object)buffer.toString());
        this.iRouteIndex = 0;
        if (route != null && route.getRoutelist() != null && route.getRoutelist().length > 0 && route.getRoutelist()[0] != null) {
            int n2;
            buffer = new Buffer();
            buffer.append("routeType = [");
            this.routeOptionsUsedForCalculation = route.getRoutelist()[0].routeOptions;
            for (n2 = 0; n2 < this.routeOptionsUsedForCalculation.length; ++n2) {
                buffer.append(this.routeOptionsUsedForCalculation[n2].routeType).append(" ");
            }
            buffer.append("], dynamic = [");
            for (n2 = 0; n2 < this.routeOptionsUsedForCalculation.length; ++n2) {
                buffer.append(this.routeOptionsUsedForCalculation[n2].dynamic).append(" ");
            }
            buffer.append("]");
            this.getLogger().log(-2137614336, "RouteCalcSM#startRouteCalculation() - %1", (Object)buffer.toString());
            n2 = RouteUtil.getNumberOfDestinations(route, 1);
            this.env.getChoiceModel(1360856576).setValue(n2);
        }
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.getState().startRouteCalculation(route, n, bl, bl2, bl3);
            this.setIsRGAboutToBeStarted(false, n <= 1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateAvailableRoutes(AvailableRoute[] availableRouteArray, int n) {
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.getState().updateAvailableRoutes(availableRouteArray, n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        this.getLogger().log(-2137614336, "RouteCalcSM#updateRgCalculatedRoutes(%1)", (Object)(calculatedRouteListElementArray == null || calculatedRouteListElementArray.length == 0 ? "empty" : Integer.toString(calculatedRouteListElementArray.length)));
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.getState().updateRgCalculatedRoutes(calculatedRouteListElementArray);
            try {
                this.naviMap.getActiveContext().updateRgCalculatedRoutes(calculatedRouteListElementArray);
            }
            catch (Exception exception) {
                this.getLogger().log(10000, "RouteCalcSM#updateRgCalculatedRoutes() - %1", (Throwable)exception);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateRgRouteCalculationState(int n) {
        this.getLogger().log(-2137614336, "RouteCalcSM#updateRgRouteCalculationState(%1)", (long)n);
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.getState().updateRgRouteCalculationState(n);
        }
        this.refreshRubberbandActiveFlag();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
        this.getLogger().log(-2137614336, "RouteCalcSM#updateRgRouteCostChangeInformation(%1), current Route calc state: --[%2]--", (Object)(rgRouteCostChangeInformation == null ? "null" : rgRouteCostChangeInformation.toString()), (Object)Util.getClassNameFromPackageName(super.getClass()));
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.getState().updateRgRouteCostChangeInformation(rgRouteCostChangeInformation);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateRgActive(boolean bl) {
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.getLogger().log(-2137614336, "RouteCalcSM#updateRgActive(%1)", bl);
            this.getState().updateRgActive(bl);
            this.refreshRubberbandActiveFlag();
            if (!bl) {
                this.lastRgDestinationInfo = null;
                this.sRGInfoForNextDestReceived = false;
            }
        }
    }

    @Override
    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
        this.getLogger().log(-2137614336, "RouteCalcSM#updateRgInfoForNextDestination()");
        this.sRGInfoForNextDestReceived = true;
    }

    @Override
    public boolean isRgInfoForNexDestinationReceived() {
        return this.sRGInfoForNextDestReceived;
    }

    protected void resetIgnoreBetterRouteFlags() {
        this.getLogger().log(-2137614336, "RouteCalcSM#resetIgnoreBetterRouteFlags()");
        this.isBetterRouteIgnored = false;
        this.isPopupDefinitiveBetterIgnored = false;
        this.isPopupDueToBlockingIgnored = false;
        this.wasOnceVisible = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void fireOnMatchFound() {
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.naviMap.onEvent(200);
            if (this.routeCalculationListeners != null) {
                for (int i2 = 0; i2 < this.routeCalculationListeners.size(); ++i2) {
                    try {
                        ((IRouteCalculator$RouteCalculationListener)this.routeCalculationListeners.get(i2)).onMatchFound();
                        continue;
                    }
                    catch (Exception exception) {
                        this.getLogger().log(-1601830656, "RouteCalcSM#fireOnMatchFound() %1", (Throwable)exception);
                    }
                }
            } else {
                this.getLogger().log(-1601830656, "RouteCalcSM#fireOnMatchFound() - no listener.");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void fireOnAllMatchFound(int n) {
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.naviMap.onEvent(201);
            if (this.routeCalculationListeners != null) {
                for (int i2 = 0; i2 < this.routeCalculationListeners.size(); ++i2) {
                    try {
                        ((IRouteCalculator$RouteCalculationListener)this.routeCalculationListeners.get(i2)).onAllMatchFound(n);
                        continue;
                    }
                    catch (Exception exception) {
                        this.getLogger().log(-1601830656, "RouteCalcSM#fireOnAllMatchFound() %1", (Throwable)exception);
                    }
                }
            } else {
                this.getLogger().log(-1601830656, "RouteCalcSM#fireOnAllMatchFound() - no listener.");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void fireOnFailedCalculation() {
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.naviMap.onEvent(202);
            if (this.routeCalculationListeners != null) {
                for (int i2 = 0; i2 < this.routeCalculationListeners.size(); ++i2) {
                    try {
                        ((IRouteCalculator$RouteCalculationListener)this.routeCalculationListeners.get(i2)).onFailedCalculation();
                        continue;
                    }
                    catch (Exception exception) {
                        this.getLogger().log(-1601830656, "RouteCalcSM#fireOnFailedCalculation() %1", (Throwable)exception);
                    }
                }
            } else {
                this.getLogger().log(-1601830656, "RouteCalcSM#fireOnFailedCalculation() - no listener.");
            }
        }
    }

    void setIsRGAboutToBeStarted(boolean bl, boolean bl2) {
        this.getLogger().log(-2137614336, "RouteCalcSM#setIsRGAboutToBeStarted( about2Start:%1, isSingle:%2 ) - rgActive:%3", bl, bl2, this.isRGActive);
        this.isRGAboutToBeStarted = bl;
        this.isSingleRoute = bl2;
    }

    @Override
    public boolean isRGAboutToBeStarted() {
        return this.isRGAboutToBeStarted;
    }

    @Override
    public boolean isSingleRoute() {
        return this.isSingleRoute;
    }

    @Override
    public void onStartRouteCalculation(boolean bl, boolean bl2, NavLocation navLocation) {
        this.getLogger().log(-2137614336, "RouteCalcSM#onStartRouteCalculation() - isSingle:%1, state:%2, dest:%3", bl, (Object)Integer.toString(this.currentState), (Object)navLocation);
        this.startAbortCalculationTimer();
        this.isAutoStartRGAndSwitchEnabled = bl2;
        if (navLocation != null) {
            this.sDestination = navLocation;
            this.currentRoute = null;
            this.cleanCalculatedRouteListElements(true);
            this.goTo(0);
        } else if (this.currentState == 0) {
            this.currentRoute = null;
            this.cleanCalculatedRouteListElements(true);
        }
        this.setIsRGAboutToBeStarted(true, bl);
    }

    @Override
    public void calculateAlternativeRoutes() {
        this.getLogger().log(-2137614336, "RouteCalcSM#calculateAlternativeRoutes( )");
        int n = Util.isHURegionAsia() && !Util.isPorsche(this.env.getFramework()) && !Util.isPorscheGen2(this.env.getFramework()) && !Util.isBentley(this.env.getFramework()) ? 10 : 2;
        this.goTo(n);
    }

    @Override
    public boolean isAutoStartRGAndSwitchEnabled() {
        return this.isAutoStartRGAndSwitchEnabled;
    }

    @Override
    public boolean isCalculatingRubberband() {
        return this.currentState == 3;
    }

    @Override
    public boolean isCalculatingSingleRoute() {
        return this.currentState == 1 || this.currentState == 6;
    }

    @Override
    public void switchToSemidynamic(int n) {
        if (!Util.isSemidynamicRgAvailable(this.env.getFramework())) {
            this.getLogger().log(-1601830656, "RouteCalcSM#switchToSemidynamic() - Semidynamic Route Guidance is not available");
            return;
        }
        this.naviMap.getMapDataContainer().sRcciEnterTrigger = n;
        if (this.currentState == 9) {
            this.getLogger().log(-2137614336, "RouteCalcSM#switchToSemidynamic()");
            try {
                this.switchToRCCIContext();
            }
            catch (Exception exception) {
                this.getLogger().log(10000, "RouteCalcSM#<SwitchToSemidynListener>#keyPressed() - %1", (Throwable)exception);
            }
        } else {
            this.getLogger().log(-1601830656, "RouteCalcSM#switchToSemidynamic() - no better route, ignore");
            this.naviMap.getNavigationEnv().getListModel(1125910016).fireEvent(0);
        }
    }

    protected void switchToRCCIContext() {
        this.naviMap.switchToContext(20);
    }

    @Override
    public NavLocation getDestination() {
        return this.sDestination;
    }

    @Override
    public int getSemidynRouteState() {
        return this.iBetterRouteState;
    }

    @Override
    public boolean isBetterRouteIgnored() {
        return this.isBetterRouteIgnored || this.isPopupDefinitiveBetterIgnored || this.isPopupDueToBlockingIgnored;
    }

    @Override
    public boolean hasBetterRoute() {
        this.getLogger().log(-2137614336, "RouteCalcSM#hasBetterRoute() - current state = %1", (long)this.currentState);
        return this.currentState == 9;
    }

    @Override
    public int getSavingTime() {
        if (this.hasBetterRoute()) {
            this.getLogger().log(-2137614336, "RouteCalcSM#getSavingTime() - better route exists");
            if (this.sSavingTimeOfBetterRoute < 0L) {
                this.getLogger().log(-2137614336, "RouteCalcSM#getSavingTime() - saved time < 0, beacause of blocking route");
                return -1;
            }
            return (int)(this.sSavingTimeOfBetterRoute / 0);
        }
        this.getLogger().log(-2137614336, "RouteCalcSM#getSavingTime() - better route doesn't exist");
        return -1;
    }

    @Override
    public void selectRoute(int n, boolean bl) {
        if (n != 0 && n != 1) {
            this.getLogger().log(-2137614336, "RouteCalcSM#selectRoute( ) - invalid route index : %1", (long)n);
            return;
        }
        if (!this.hasBetterRoute()) {
            this.getLogger().log(-2137614336, "RouteCalcSM#selectRoute( ) - abort : no better route");
            return;
        }
        if (this.naviMap.getActiveContextIndex() != 20) {
            this.naviMap.switchToContext(20);
        }
        this.naviMap.getActiveContext().itemFocused(-1, n);
        if (bl) {
            this.naviMap.getActiveContext().itemSelected(1125910016, n, 1, -1);
        }
    }

    @Override
    public void setWaitForAvailableRoute(boolean bl) {
        this.getLogger().log(-2137614336, "RouteCalcSM#setWaitForAvailableRoute( %1 )", bl);
        this.sWaitForAvailableRoute = bl;
    }

    @Override
    public boolean getWaitForAvailableRoute() {
        return this.sWaitForAvailableRoute;
    }

    @Override
    public int getCountOfMatchRoute(int n) {
        if (0 <= n && n < this.sMatchingRoutesFound.length) {
            return this.sMatchingRoutesFound[n];
        }
        return 0;
    }

    @Override
    public boolean isCalculationFinished() {
        switch (this.iRgRouteCalculationState) {
            case 2: 
            case 3: {
                return true;
            }
        }
        return false;
    }

    private void startAbortCalculationTimer() {
        this.getLogger().log(-2137614336, "RouteCalcSM#startAbortCalculationTimer()");
        this.abortCalculationTimer.restart();
    }

    void cancelAbortCalculationTimer() {
        this.getLogger().log(-2137614336, "RouteCalcSM#cancelAbortCalculationTimer()");
        this.abortCalculationTimer.cancel();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void cleanCalculatedRouteListElements(boolean bl) {
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            if (this.mCalculatedRouteListElement != null && this.mCalculatedRouteListElement.length > 0) {
                if (bl) {
                    this.getLogger().log(-1601830656, "RouteCalcSM#cleanCalculatedRouteListElements( %1 ) - clean up all 3 CalculatedRouteListElement", bl);
                    this.mCalculatedRouteListElement = new CalculatedRouteListElement[0];
                } else {
                    this.getLogger().log(-1601830656, "RouteCalcSM#cleanCalculatedRouteListElements( %1 ) - clean up 2nd and 3rd CalculatedRouteListElement", bl);
                    this.mCalculatedRouteListElement = new CalculatedRouteListElement[]{this.mCalculatedRouteListElement[0]};
                }
            }
        }
    }

    @Override
    public long getTrafficDelayOnCurrentRoute() {
        RcciEvent rcciEvent = this.getRcciEvent();
        if (rcciEvent != null) {
            return rcciEvent.reliable ? rcciEvent.delay : -1L;
        }
        return 0L;
    }

    @Override
    public void setCalcFurtherAltRoutes(boolean bl) {
        this.getLogger().log(-2137614336, "RouteCalcSM#setCalcFurtherAltRoutes( %1 )", bl);
        this.calcFurtherAltRoute = bl;
    }

    @Override
    public boolean isCalcFurtherAltRoutes() {
        return this.currentState == 2 || this.currentState == 10;
    }

    @Override
    public RcciEvent getRcciEvent() {
        return this.rcciEvent;
    }

    private void pushRcciEvent(RcciEvent rcciEvent) {
        this.rcciEvent = rcciEvent;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
        boolean bl = this.onlyRemainingTravelTimeChanged(navRouteListDataArray);
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.lastRgDestinationInfo = navRouteListDataArray;
            if (bl) {
                return;
            }
            this.getState().updateRgDestinationInfo(navRouteListDataArray);
        }
    }

    private boolean onlyRemainingTravelTimeChanged(NavRouteListData[] navRouteListDataArray) {
        if (this.lastRgDestinationInfo == null || this.lastRgDestinationInfo.length <= 0 || navRouteListDataArray == null || navRouteListDataArray.length <= 0 || this.lastRgDestinationInfo.length != navRouteListDataArray.length) {
            return false;
        }
        for (int i2 = 0; i2 < navRouteListDataArray.length; ++i2) {
            NavRouteListData navRouteListData = navRouteListDataArray[i2];
            NavRouteListData navRouteListData2 = this.lastRgDestinationInfo[i2];
            if (navRouteListData.carTrainOnWay != navRouteListData2.carTrainOnWay) {
                return false;
            }
            if (navRouteListData.ferryOnWay != navRouteListData2.ferryOnWay) {
                return false;
            }
            if (navRouteListData.inProgressData != navRouteListData2.inProgressData) {
                return false;
            }
            if (navRouteListData.seasonalRestricted != navRouteListData2.seasonalRestricted) {
                return false;
            }
            if (navRouteListData.timeRestricted != navRouteListData2.timeRestricted) {
                return false;
            }
            if (navRouteListData.tunnelOnWay != navRouteListData2.tunnelOnWay) {
                return false;
            }
            if (navRouteListData.vignetteNeededOnWay != navRouteListData2.vignetteNeededOnWay) {
                return false;
            }
            if (navRouteListData.endDistance != navRouteListData2.endDistance) {
                return false;
            }
            if (this.iconsDiffer(navRouteListData.icons, navRouteListData2.icons)) {
                return false;
            }
            if (navRouteListData.motorwayLength != navRouteListData2.motorwayLength) {
                return false;
            }
            if (navRouteListData.remainingTravelTimeStatus != navRouteListData2.remainingTravelTimeStatus) {
                return false;
            }
            if (navRouteListData.startDistance != navRouteListData2.startDistance) {
                return false;
            }
            if (navRouteListData.streetname == null && navRouteListData2.streetname != null || navRouteListData.streetname != null && navRouteListData2.streetname == null) {
                return false;
            }
            if (navRouteListData.streetname != null && !navRouteListData.streetname.equals(navRouteListData2.streetname)) {
                return false;
            }
            if (navRouteListData.timeLagToNextDest != navRouteListData2.timeLagToNextDest) {
                return false;
            }
            if (navRouteListData.tollCostAmount != navRouteListData2.tollCostAmount) {
                return false;
            }
            if (navRouteListData.tollCostCurrency != navRouteListData2.tollCostCurrency) {
                return false;
            }
            if (navRouteListData.tollLength == navRouteListData2.tollLength) continue;
            return false;
        }
        return true;
    }

    private boolean iconsDiffer(NavRouteListDataIcon[] navRouteListDataIconArray, NavRouteListDataIcon[] navRouteListDataIconArray2) {
        if (navRouteListDataIconArray == null && navRouteListDataIconArray2 != null || navRouteListDataIconArray != null && navRouteListDataIconArray2 == null) {
            return true;
        }
        if (navRouteListDataIconArray == null) {
            return false;
        }
        if (navRouteListDataIconArray.length != navRouteListDataIconArray2.length) {
            return true;
        }
        for (int i2 = 0; i2 < navRouteListDataIconArray.length; ++i2) {
            NavRouteListDataIcon navRouteListDataIcon = navRouteListDataIconArray[i2];
            NavRouteListDataIcon navRouteListDataIcon2 = navRouteListDataIconArray2[i2];
            if (navRouteListDataIcon.type != navRouteListDataIcon2.type) {
                return true;
            }
            if (navRouteListDataIcon.criteria1 != navRouteListDataIcon2.criteria1) {
                return true;
            }
            if (navRouteListDataIcon.criteria2 != navRouteListDataIcon2.criteria2) {
                return true;
            }
            if (Arrays.equals(navRouteListDataIcon.iconDecoratorInformation, navRouteListDataIcon2.iconDecoratorInformation)) continue;
            return true;
        }
        return false;
    }

    @Override
    public void setMapReadyCallback(WaitForMapReadyCommand waitForMapReadyCommand) {
        if (this.waitForMapReadyCommand != null) {
            this.getLogger().log(10000, "RouteCalcSM#setMapReadyCallback() - waitForMapReadyCommand still registered - unblock previous command!");
            this.notifyMapUnfrozen();
        }
        this.waitForMapReadyCommand = waitForMapReadyCommand;
    }

    @Override
    public void notifyMapUnfrozen() {
        if (this.waitForMapReadyCommand != null) {
            this.getLogger().log(-2137614336, "RouteCalcSM#notifyMapUnfrozen()");
            this.waitForMapReadyCommand.mapReadyCallBack();
            this.waitForMapReadyCommand = null;
        } else {
            this.getLogger().log(14808325, "RouteCalcSM#notifyMapUnfrozen() - no active waitForMapReadyCommand");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void prepareRubberband(boolean bl, int n) {
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.getLogger().log(-2137614336, "RouteCalcSM#prepareRubberband()");
            this.env.getChoiceModel(1360856576).setValue(0);
            this.goTo(3);
            this.getState().prepareRubberband(bl, n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void startRubberband(int n) {
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.getState().startRubberband(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void initRubberbandPoint(NavLocationWgs84 navLocationWgs84) {
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.getState().initRubberbandPoint(navLocationWgs84);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void cancel() {
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.getState().cancel();
        }
    }

    @Override
    public NavLocationWgs84 getRubberbandPoint() {
        return this.rbbPoint;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setRubberbandPoint(NavLocationWgs84 navLocationWgs84) {
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.getState().setRubberbandPoint(navLocationWgs84);
        }
    }

    @Override
    public int getRubberbandState() {
        return this.rbbState;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void startRubberbandRG() {
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.getState().startRubberbandRG();
        }
    }

    @Override
    public boolean isRubberbandActive() {
        return this.isRubberbandActive;
    }

    @Override
    public void setRubberbandActive(boolean bl) {
        this.getLogger().log(1078071040, "RouteCalcSM#setRubberbandActive( %1 ) ", bl);
        this.isRubberbandActive = bl;
    }

    private void refreshRubberbandActiveFlag() {
        if (this.isRubberbandActive() && this.env.getContainer().isRgActive() && this.env.getContainer().getRgRouteCalculationState() == 0) {
            this.setRubberbandActive(false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void rgStartRubberbandManipulationResult(int n) {
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.getState().rgStartRubberbandManipulationResult(n);
        }
    }

    void fireEvent(int n) {
        this.getLogger().log(-2137614336, "RouteCalcSM#fireEvent( %1 )", (long)n);
        this.naviMap.getMapEventDispatcher().fireEvent(n);
    }

    @Override
    public RouteOptions[] getRouteOptionsUsedForCalculation() {
        return this.routeOptionsUsedForCalculation;
    }

    @Override
    public boolean isBaseRouteReconstructable() {
        this.getLogger().log(-2137614336, "RouteCalcSM#isBaseRouteReconstructable() - %1", this.isBaseRouteReconstructable);
        return this.isBaseRouteReconstructable;
    }

    protected void prepareMap(int n, boolean bl) {
        this.naviMap.showRouteBriefing(n);
    }

    protected long getTresholdDefinitiveBetter() {
        return 0;
    }

    protected long getThresholdDefinitiveBetter(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
        return this.getTresholdDefinitiveBetter();
    }

    @Override
    public void setNewRouteVanished(boolean bl) {
        this.getLogger().log(-2137614336, "RouteCalcSM#setNewRouteVanished() %1", bl);
        this.newRouteVanished = bl;
    }

    public NavigationEnv getEnv() {
        return this.env;
    }

    @Override
    public void setIsSingleRoute(boolean bl) {
        this.isSingleRoute = bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateRGCurrentRouteOptions(RouteOptions routeOptions) {
        Object object = this.naviMap.getMutexSwitchToContext();
        synchronized (object) {
            this.getState().updateRGCurrentRouteOptions(routeOptions);
        }
    }
}

