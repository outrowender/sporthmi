/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.gui.ViewFactory;
import de.audi.tghu.navi.app.map.routecalc.RcciEvent;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcDataContainer;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;

public abstract class RcsBase {
    protected final RouteCalcSM stateMachine;
    protected final RouteCalcDataContainer data;
    protected final String NAME;
    public static final int MODEL_VALUE_IDLE = 0;
    public static final int MODEL_VALUE_CALCULATING_SINGLE_ROUTE = 1;
    public static final int MODEL_VALUE_CALCULATING_MULTIPLE_ROUTES = 2;
    public static final int MODEL_VALUE_CALCULATING_ALTERNATIVE_ROUTES_DURING_ACTIVE_RG = 3;
    public static final int MODEL_VALUE_CALCULATING_RUBBERBAND_ROUTE = 4;
    public static final int MODEL_VALUE_WAITING_FOR_RG_TO_BECOME_ACTIVE = 5;
    public static final int MODEL_VALUE_RG_ACTIVE = 6;
    public static final int MODEL_VALUE_RESTART_AFTER_ALTROUTES = 7;

    RcsBase(RouteCalcSM routeCalcSM, String string) {
        this.stateMachine = routeCalcSM;
        this.data = routeCalcSM;
        this.NAME = string;
    }

    protected LogChannel getLogger() {
        return this.stateMachine.getLogger();
    }

    protected RouteCalcDataContainer getData() {
        return this.stateMachine;
    }

    public String toString() {
        return this.NAME;
    }

    protected final Object getMutex() {
        return this.stateMachine;
    }

    protected final RouteCalcSM getStateMachine() {
        return this.stateMachine;
    }

    protected final ViewFactory getViews() {
        return this.stateMachine.naviMap.getViews();
    }

    protected int getActiveRendererID() {
        return this.getStateMachine().naviMap.getSatelliteManager().getActiveRendererID();
    }

    public void enter() {
    }

    public void exit() {
    }

    protected void goTo(int n) {
        this.stateMachine.goTo(n);
    }

    public void reset() {
    }

    public void restartTimerIfCalculationStateIsReady() {
        this.warn("restartTimerIfCalculationStateIsReady");
    }

    public void cancelTimer() {
        this.warn("cancelTimer");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateAvailableRoutes(AvailableRoute[] availableRouteArray, int n) {
        Object object;
        boolean bl = this.data.sAvailableRoutesValid[n] = availableRouteArray != null && availableRouteArray.length > 0;
        if (this.data.sAvailableRoutesValid[n] && this.getLogger().isDebug2()) {
            object = new Buffer();
            for (int i2 = 0; i2 < availableRouteArray.length; ++i2) {
                if (i2 > 0) {
                    ((Buffer)object).append("; ");
                }
                ((Buffer)object).append(availableRouteArray[i2]);
            }
            this.getLogger().log(100000000, "RcsBase#updateAvailableRoutes() - ResponserID = %2, %1", (Object)((Buffer)object).toString(), (long)n);
        }
        object = this.getMutex();
        synchronized (object) {
            this.getLogger().log(10000000, "RcsBase#updateAvailableRoutes() - active renderer = %1, response = %2, valid = %3", (long)this.getActiveRendererID(), (long)n, this.data.sAvailableRoutesValid[n]);
            this.data.sAvailableRoutes[n] = availableRouteArray;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        Object object;
        if (this.getLogger().isDebug()) {
            object = new Buffer();
            if (calculatedRouteListElementArray != null && calculatedRouteListElementArray.length > 0) {
                for (int i2 = 0; i2 < calculatedRouteListElementArray.length; ++i2) {
                    if (i2 > 0) {
                        ((Buffer)object).append("; ");
                    }
                    ((Buffer)object).append("[").append(i2).append("]=").append(MapUtils.toPrettyString(calculatedRouteListElementArray[i2]));
                }
                this.getLogger().log(10000000, "RcsBase#updateRgCalculatedRoutes() - %1", (Object)((Buffer)object).toString());
            }
        }
        object = this.getMutex();
        synchronized (object) {
            this.data.sCalculatedRoutesValid = this.isCalulatedRoutesValid(calculatedRouteListElementArray);
            this.data.mOldCrleFingerprint = this.getFingerprintOfValidCRLE(this.data.mCalculatedRouteListElement);
            this.data.mCalculatedRouteListElement = calculatedRouteListElementArray;
        }
    }

    protected boolean isCalulatedRoutesValid(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        return calculatedRouteListElementArray != null && calculatedRouteListElementArray.length > 0 && MapUtils.isCRLElementCalculated(calculatedRouteListElementArray[0]);
    }

    public boolean isMatchingRoutesFound() {
        this.warn("isMatchingRoutesFound");
        return false;
    }

    protected String getFingerprintOfValidCRLE(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        Buffer buffer = new Buffer();
        if (calculatedRouteListElementArray != null && calculatedRouteListElementArray.length > 0) {
            for (int i2 = 0; i2 < calculatedRouteListElementArray.length; ++i2) {
                if (!MapUtils.isCRLElementCalculated(calculatedRouteListElementArray[i2])) continue;
                buffer.append(MapUtils.getFingerprint(calculatedRouteListElementArray[i2]));
            }
        }
        return buffer.toString();
    }

    public void startRouteCalculation(Route route, int n, boolean bl, boolean bl2, boolean bl3) {
        this.warn("startRouteCalculation");
    }

    public void enableTimer(boolean bl) {
        this.warn("enableTimer");
    }

    public void updateRgRouteCalculationState(int n) {
        this.getLogger().log(10000000, "RcsBase#updateRgRouteCalculationState( %1 )", (long)n);
        if (this.data.iRgRouteCalculationState != n) {
            this.data.iRgRouteCalculationState = n;
            this.stateMachine.naviMap.getActiveContext().updateRgRouteCalculationState(n);
            this.stateMachine.restartTimerIfCalculationStateIsReady();
        }
    }

    public void setRouteCalculationActive(boolean bl) {
        this.warn("setRouteCalculationActive");
    }

    public void setSelectingAltRoutesInProgress(boolean bl) {
        this.warn("setSelectingAltRoutesInProgress");
    }

    public void setSelectingDynamicBypassInProgress(boolean bl) {
        this.warn("setSelectingDynamicBypassInProgress");
    }

    public void abortRouteCalculation() {
        this.warn("abortRouteCalculation");
    }

    public void setSelectedRouteIndex(int n) {
        this.warn("setSelectedRouteIndex");
    }

    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
        this.getLogger().log(1000000, "RcsBase#updateRgRouteCostChangeInformation() called from State class: --[%1]--", (Object)Util.getClassNameFromPackageName(this.getClass()));
        this.data.rgRCCI = rgRouteCostChangeInformation;
        if (rgRouteCostChangeInformation != null) {
            this.data.origialRoute = rgRouteCostChangeInformation.getOldRoute();
            this.data.betterRoute = rgRouteCostChangeInformation.getNewRoute();
        } else {
            this.data.origialRoute = null;
            this.data.betterRoute = null;
        }
        if (this.data.origialRoute == null) {
            try {
                this.data.origialRoute = this.data.mCalculatedRouteListElement[0];
            }
            catch (Exception exception) {
                this.getLogger().log(10000, "RcsBase#updateRgRouteCostChangeInformation() - no calculated route");
            }
        }
    }

    private void warn(String string) {
        this.getLogger().log(100000, "RcsBase[%2]#%1() - unexpected call", (Object)string, (Object)this.getClass().getName());
    }

    public void updateRgActive(boolean bl) {
        this.data.isRGActive = bl;
        if (!bl) {
            this.data.rgRCCI = null;
            this.getStateMachine().dispatchRcciEvent(RcciEvent.EMPTY);
            this.stateMachine.resetIgnoreBetterRouteFlags();
        }
    }

    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
    }

    protected INaviInterface getNaviInterface() {
        return this.getStateMachine().naviMap.getNaviInterface();
    }

    public void prepareRubberband(boolean bl, int n) {
    }

    public void startRubberband(int n) {
    }

    public void initRubberbandPoint(NavLocationWgs84 navLocationWgs84) {
    }

    public void cancel() {
    }

    public void startRubberbandRG() {
    }

    public void setRubberbandPoint(NavLocationWgs84 navLocationWgs84) {
    }

    public void rgStartRubberbandManipulationResult(int n) {
        this.getLogger().log(10000000, "RcsBase#rgStartRubberbandManipulationResult( %2 ) - rgStartRubberbandManipulationResultOK: %1", this.data.rgStartRubberbandManipulationResultOK, (long)n);
        if (!this.data.rgStartRubberbandManipulationResultOK && n == 0) {
            this.data.rgStartRubberbandManipulationResultOK = true;
        }
    }

    public abstract int getValue4Model();

    public void updateRGCurrentRouteOptions(RouteOptions routeOptions) {
    }
}

