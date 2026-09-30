/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.RcsBase;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;
import de.audi.tghu.navi.app.map.utils.ConstantUtils;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.navigation.CalculatedRouteListElement;

abstract class RcsCalculatingBase
extends RcsBase {
    RcsCalculatingBase(RouteCalcSM routeCalcSM, String string) {
        super(routeCalcSM, string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected final int matchCalculatedAndVisibleRoutes() {
        Object object = this.getMutex();
        synchronized (object) {
            int n = this.getActiveRendererID();
            if (this.getData().sMatchingRoutesFound[n] > 0 && this.getData().iRgRouteCalculationState == 1) {
                this.getLogger().log(10000000, "RcsCalculatingBase#matchCalculatedAndVisibleRoutes(): 1 match already found, ignore.");
                return this.getData().sMatchingRoutesFound[n];
            }
            int n2 = 0;
            if (this.getData().sCalculatedRoutesValid && this.getData().sAvailableRoutesValid[n]) {
                this.getLogger().log(10000000, "RcsCalculatingBase#matchCalculatedAndVisibleRoutes(): checking if any calculated route is matching any visible route");
                NavSegmentID navSegmentID = null;
                NavSegmentID navSegmentID2 = null;
                block5: for (int i2 = 0; i2 < this.getData().sAvailableRoutes[n].length; ++i2) {
                    navSegmentID2 = this.getData().sAvailableRoutes[n][i2].getNavSegmentID();
                    for (int i3 = 0; i3 < this.getData().mCalculatedRouteListElement.length; ++i3) {
                        CalculatedRouteListElement calculatedRouteListElement = this.getData().mCalculatedRouteListElement[i3];
                        navSegmentID = calculatedRouteListElement != null && MapUtils.isCRLElementCalculated(calculatedRouteListElement) ? this.getData().mCalculatedRouteListElement[i3].getSegmentIDList() : null;
                        if (navSegmentID == null) {
                            this.getLogger().log(100000, "RcsCalculatingBase#matchCalculatedAndVisibleRoutes(): no segment ID list found!");
                            continue block5;
                        }
                        if (!MapUtils.isEqual(navSegmentID2, navSegmentID)) continue;
                        this.getLogger().log(1000000, "RcsCalculatingBase#matchCalculatedAndVisibleRoutes(): match found %1", (Object)navSegmentID2);
                        ++n2;
                    }
                }
            } else {
                this.getLogger().log(10000000, "RcsCalculatingBase#matchCalculatedAndVisibleRoutes(): no available route");
            }
            this.getLogger().log(10000000, "RcsCalculatingBase#matchCalculatedAndVisibleRoutes() - count = %1", (long)n2);
            if (this.getData().sMatchingRoutesFound[n] == 0 && n2 == 1) {
                this.getData().sMatchingRoutesFound[n] = n2;
                this.stateMachine.cancelAbortCalculationTimer();
                this.onFirstMatchFound();
            } else if (n2 == 3) {
                this.getData().sMatchingRoutesFound[n] = n2;
                try {
                    this.onAllMatched(n2);
                }
                catch (Exception exception) {
                    this.getLogger().log(100000, "RcsCalculatingBase#matchCalculatedAndVisibleRoutes() - count = %1, call onAllMatched() - %1", (Throwable)exception);
                }
            }
            return n2;
        }
    }

    protected abstract void onFirstMatchFound();

    protected void onAllMatched(int n) {
        this.getLogger().log(100000000, "RcsCalculatingBase#onAllMatched()");
    }

    public void updateAvailableRoutes(AvailableRoute[] availableRouteArray, int n) {
        super.updateAvailableRoutes(availableRouteArray, n);
        if (this.getData().sAvailableRoutesValid[this.getActiveRendererID()]) {
            try {
                this.matchCalculatedAndVisibleRoutes();
            }
            catch (Exception exception) {
                this.getLogger().log(100000, "RcsCalculatingBase#updateAvailableRoutes() - matchCalculatedAndVisibleRoutes -> %1", (Throwable)exception);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        super.updateRgCalculatedRoutes(calculatedRouteListElementArray);
        if (!this.getStateMachine().getWaitForAvailableRoute() && this.getData().sCalculatedRoutesValid) {
            this.getLogger().log(100000, "RcsCalculatingBase#updateRgCalculatedRoutes() - start RG without waiting for available route");
            this.getStateMachine().startRG(0);
            this.goTo(8);
            return;
        }
        Object object = this.getMutex();
        synchronized (object) {
            String string = this.getFingerprintOfValidCRLE(calculatedRouteListElementArray);
            if (string.equals(this.data.mOldCrleFingerprint)) {
                this.getLogger().log(100000000, "RcsCalculatingBase#updateRgCalculatedRoutes() - no change of fingerprint: %1", (Object)string);
                return;
            }
            this.getLogger().log(10000000, "RcsCalculatingBase#updateRgCalculatedRoutes() - changed fingerprint: %1", (Object)string);
            this.getStateMachine().cancelAbortCalculationTimer();
            int n = 0;
            if (calculatedRouteListElementArray != null) {
                for (int i2 = 0; i2 < calculatedRouteListElementArray.length; ++i2) {
                    if (!MapUtils.isCRLElementCalculated(calculatedRouteListElementArray[i2])) continue;
                    ++n;
                }
                this.getStateMachine().naviMap.getNavigationEnv().getChoiceModel(400872).setValue(n);
            }
            if (this.getData().sCalculatedRoutesValid) {
                this.getStateMachine().naviMap.getActiveContext().refreshRoutes();
                try {
                    this.matchCalculatedAndVisibleRoutes();
                }
                catch (Exception exception) {
                    this.getLogger().log(100000, "RcsCalculatingBase#updateRgCalculatedRoutes() - matchCalculatedAndVisibleRoutes -> %1", (Throwable)exception);
                }
            }
        }
    }

    public boolean isMatchingRoutesFound() {
        return this.getData().sMatchingRoutesFound[this.getActiveRendererID()] > 0;
    }

    public void updateRgRouteCalculationState(int n) {
        super.updateRgRouteCalculationState(n);
        if (n == 2 || n == 3) {
            this.getLogger().log(10000000, "RcsCalculatingBase#updateRgRouteCalculationState( %1 ) - calculation is finished", (Object)ConstantUtils.ROUTECALCULATIONSTATE[n]);
            if (this.getData().mCalculatedRouteListElement != null && this.getData().mCalculatedRouteListElement.length >= 1 && this.getData().mCalculatedRouteListElement[0].getCalculationState() == 4) {
                this.getLogger().log(10000000, "RcsCalculatingBase#updateRgRouteCalculationState( %1 ) - calculation is failed", (Object)ConstantUtils.ROUTECALCULATIONSTATE[n]);
            }
        }
        if (n == 2) {
            int n2;
            boolean bl = true;
            int n3 = n2 = this.getStateMachine().isSingleRoute() ? 1 : 3;
            if (this.getData().mCalculatedRouteListElement == null || this.getData().mCalculatedRouteListElement.length < n2) {
                this.getLogger().log(100000, "RcsCalculatingBase#updateRgRouteCalculationState() - less than %1 routes were calculated", (long)n2);
                bl = false;
            } else {
                block3: for (int i2 = 0; i2 < n2; ++i2) {
                    switch (this.getData().mCalculatedRouteListElement[i2].calculationState) {
                        case 3: 
                        case 5: {
                            continue block3;
                        }
                        default: {
                            this.getLogger().log(100000, "RcsCalculatingBase#updateRgRouteCalculationState() - invalid route %1 (calculationState=%2)", (long)i2, (long)this.getData().mCalculatedRouteListElement[i2].calculationState);
                            bl = false;
                        }
                    }
                }
            }
            if (!bl) {
                this.getStateMachine().fireOnFailedCalculation();
                if (Util.isPorsche(this.getStateMachine().getEnv().getFramework())) {
                    this.goTo(0);
                }
            } else {
                this.matchCalculatedAndVisibleRoutes();
            }
        }
    }
}

