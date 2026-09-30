/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator;
import de.audi.tghu.navi.app.map.routecalc.RcciEvent;
import de.audi.tghu.navi.app.map.routecalc.RcsBase;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.RouteOptions;

class RcsRGActivated
extends RcsBase {
    RcsRGActivated(RouteCalcSM routeCalcSM) {
        super(routeCalcSM, "RcsRGActivated");
    }

    protected RcsRGActivated(RouteCalcSM routeCalcSM, String string) {
        super(routeCalcSM, string);
    }

    public void enter() {
        super.enter();
        this.reset();
    }

    public void reset() {
        this.getLogger().log(10000000, "RcsRGActivated#cleanup()");
        this.getData().rgRCCI = null;
        this.getData().origialRoute = null;
        this.getData().betterRoute = null;
        this.getViews().getSemidynRGView().hidePopupBetterRouteAvailable();
        this.getStateMachine().naviMap.getMapDataContainer().enterAltRoutesFromRightDrawer = false;
    }

    public final void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
        block3: {
            try {
                if (rgRouteCostChangeInformation == null || rgRouteCostChangeInformation.oldRoute == null) {
                    this.getLogger().log(100000, "RcsRGActived#updateRgRouteCostChangeInformation() - %1", (Object)rgRouteCostChangeInformation);
                    return;
                }
                RcciEvent rcciEvent = RcciEvent.create(rgRouteCostChangeInformation, this.stateMachine.getThresholdDefinitiveBetter(rgRouteCostChangeInformation));
                this.getLogger().log(10000000, "RcsRGActivated#updateRgRouteCostChangeInformation() - %1", (Object)rcciEvent);
                super.updateRgRouteCostChangeInformation(rgRouteCostChangeInformation);
                this.getStateMachine().dispatchRcciEvent(rcciEvent);
                this.postUpdateRCCI(rcciEvent);
            }
            catch (Exception exception) {
                this.getLogger().log(10000, "RcsRGActivated#updateRgRouteCostChangeInformation() - %1", (Throwable)exception);
                if (!this.getLogger().isDebug2()) break block3;
                exception.printStackTrace();
            }
        }
    }

    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        this.getLogger().log(100000000, "RcsRGActivated#updateRgActive( %1 )", bl);
        if (!bl) {
            this.goTo(0);
        }
    }

    protected void postUpdateRCCI(RcciEvent rcciEvent) {
        this.getLogger().log(10000000, "RcsRGActivated#postUpdateRCCI( %1 )", (Object)IRouteCalculator.sBetterRoute[rcciEvent.type]);
        switch (rcciEvent.type) {
            case 1: {
                break;
            }
            case 0: {
                this.getLogger().log(10000, "RcsRGActivated#postUpdateRCCI( inconsistent )");
                break;
            }
            case 2: 
            case 3: 
            case 4: 
            case 6: {
                this.data.iBetterRouteState = rcciEvent.type;
                this.goTo(9);
                break;
            }
            default: {
                this.getLogger().log(10000, "RcsRGActivated#postUpdateRCCI( %1 ) - unexpected call", (long)rcciEvent.type);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateRgRouteCalculationState(int n) {
        super.updateRgRouteCalculationState(n);
        if (n == 0) {
            this.getLogger().log(100000, "RcsRGActivated#updateRgRouteCalculationState( 0:idle ) - cleanup CRLEs (workaround)");
            Object object = this.getMutex();
            synchronized (object) {
                CalculatedRouteListElement[] calculatedRouteListElementArray = this.getStateMachine().getCalculatedRouteListElement();
                CalculatedRouteListElement calculatedRouteListElement = null;
                if (calculatedRouteListElementArray != null && calculatedRouteListElementArray.length == 3) {
                    for (int i2 = 0; i2 < 3; ++i2) {
                        if (calculatedRouteListElementArray[i2].calculationState != 5) continue;
                        calculatedRouteListElement = calculatedRouteListElementArray[i2];
                    }
                    if (calculatedRouteListElement != null) {
                        this.getStateMachine().mCalculatedRouteListElement = new CalculatedRouteListElement[]{calculatedRouteListElement};
                    } else {
                        this.getLogger().log(100000, "RcsRGActivated#updateRgRouteCalculationState( 0:idle ) - active route not found");
                    }
                }
            }
        }
    }

    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
        super.updateRgDestinationInfo(navRouteListDataArray);
        this.getLogger().log(10000000, "RcsRGActived#updateRgDestinationInfo()");
        this.reset();
    }

    public int getValue4Model() {
        return 6;
    }

    public void updateRGCurrentRouteOptions(RouteOptions routeOptions) {
        this.getLogger().log(10000000, "RcsRGActivated#updateRGCurrentRouteOptions() - Route options changed for current route - reset Flags");
        this.stateMachine.resetIgnoreBetterRouteFlags();
    }
}

