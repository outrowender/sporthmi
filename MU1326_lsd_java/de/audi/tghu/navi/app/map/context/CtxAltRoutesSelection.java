/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.context.CtxMultiRouteBase;
import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator;
import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator$RouteCalculationListener;
import de.audi.tghu.navi.app.map.utils.MapEnv;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.navigation.CalculatedRouteListElement;

public class CtxAltRoutesSelection
extends CtxMultiRouteBase
implements IRouteCalculator$RouteCalculationListener {
    public static final int SCREEN_SWITCH_DELAY;
    private Object refreshSideBarMutex = new Object();

    public CtxAltRoutesSelection(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public void enter() {
        super.enter();
        Rect rect = this.getVisibleArea();
        this.setHotPoint(rect.kordX + (rect.diffX >> 1), rect.kordY + (rect.diffY >> 1));
        this.getMap().getRouteCalculationHandler().setRouteCalculationListener(this);
        this.backupPOIVisibilityAndHideAllPOIs();
        this.naviMap.getGuiInterface().switchToRouteSelectionSidebar(0);
        this.naviMap.getNaviInterface().alternativeRoutesScreenEntered();
        this.refreshSidebarData();
        this.naviMap.getNaviInterface().getViewSizeChangeHandler().requestLargeViewSize(10);
        if (this.getMap().getRouteCalculationHandler().isCalcFurtherAltRoutes()) {
            this.getViews().getMainMapView().setOptionIconVisible(false);
        }
    }

    @Override
    protected int getMapMode() {
        if (this.getMap().getRouteCalculationHandler().isWaitingForAlternativRoutes() || this.getMap().getRouteCalculationHandler().isMatchingRoutesFound()) {
            return 6;
        }
        return 2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void exit() {
        super.exit();
        this.getMap().getRouteCalculationHandler().removeRouteCalculationListener(this);
        Object object = this.refreshSideBarMutex;
        synchronized (object) {
            this.naviMap.getGuiInterface().drawAlternativeRoutesSelectionUI(new CalculatedRouteListElement[0]);
        }
        this.naviMap.getNaviInterface().getViewSizeChangeHandler().unrequestLargeViewSize(10);
        this.getViews().getMainMapView().setOptionIconVisible(true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void clearSideBar() {
        Object object = this.refreshSideBarMutex;
        synchronized (object) {
            this.naviMap.getGuiInterface().drawAlternativeRoutesSelectionUI(null);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void refreshSidebarData() {
        int n = 0;
        CalculatedRouteListElement[] calculatedRouteListElementArray = this.getMap().getRouteCalculationHandler().getCalculatedRouteListElement();
        if (calculatedRouteListElementArray != null) {
            for (int i2 = 0; i2 < calculatedRouteListElementArray.length; ++i2) {
                if (calculatedRouteListElementArray[i2] == null || !MapUtils.isCRLElementCalculated(calculatedRouteListElementArray[i2])) continue;
                ++n;
            }
        }
        this.getLogChannel().log(-2137614336, "CtxAltRoutesSelection#refreshSidebarData() - calculated routes : %1", (long)n);
        Object object = this.refreshSideBarMutex;
        synchronized (object) {
            this.naviMap.getGuiInterface().drawAlternativeRoutesSelectionUI(calculatedRouteListElementArray);
        }
    }

    @Override
    protected void onRouteSelected(int n) {
        try {
            if (this.naviMap.getNaviInterface().getCalculatedRoutes() != null && (this.naviMap.getNaviInterface().getCalculatedRoutes()[n].getCalculationState() == 3 || this.naviMap.getNaviInterface().getCalculatedRoutes()[n].getCalculationState() == 5)) {
                this.getLogChannel().log(1078071040, "CtxAltRoutesSelection#onRouteSelected() - select route %1 to start", (long)n);
                this.getMap().getRouteCalculationHandler().startRG(n);
                this.getMap().switchToAShownContext();
            } else {
                this.getLogChannel().log(1078071040, "CtxAltRoutesSelection#onRouteSelected() - selected Route is not yet calculated itemID = %1", (long)n);
            }
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            this.getLogChannel().log(-1601830656, "CtxAltRoutesSelection#onRouteSelected() - route %1 is invalid", (long)n);
        }
        catch (Exception exception) {
            this.getLogChannel().log(-1601830656, "CtxAltRoutesSelection#onRouteSelected() - %1", (Throwable)exception);
        }
    }

    @Override
    protected void onHKBackClicked() {
        if (this.getMap().getRouteCalculationHandler().isCalcFurtherAltRoutes()) {
            this.getLogChannel().log(1078071040, "CtxAltRoutesSelection#onHKBackClicked() - continue current RG");
            this.getMap().getRouteCalculationHandler().setCalcFurtherAltRoutes(false);
            this.getGUI().fireModelEvent(-904002048);
            this.getGUI().fireHKBackEvent();
            this.getMap().getRouteCalculationHandler().cancel();
        } else {
            this.getLogChannel().log(1078071040, "CtxAltRoutesSelection#onHKBackClicked() - cancel the route calculation");
            this.getGUI().fireHKBackEvent();
            this.getMap().getRouteCalculationHandler().abortRouteCalculation(false);
        }
    }

    @Override
    protected void onHKSelectionClicked() {
        super.onHKSelectionClicked();
        if (this.getMap().getRouteCalculationHandler().isCalcFurtherAltRoutes()) {
            this.getLogChannel().log(1078071040, "CtxAltRoutesSelection#onHKSelectionClicked() - continue current RG");
            this.getMap().getRouteCalculationHandler().setCalcFurtherAltRoutes(false);
            this.onRouteSelected(0);
            this.getMap().getNaviInterface().abortSDSSession();
        } else {
            this.getLogChannel().log(-1601830656, "CtxAltRoutesSelection#onHKSelectionClicked() - unexpected call");
        }
    }

    @Override
    public void onMatchFound() {
        this.getLogChannel().log(-2137614336, "CtxAltRoutesSelection#onMatchFound()");
        this.getMap().getMVRequest().setMode(6);
        this.displayCurrentRoute();
    }

    @Override
    public void keyPressed(int n, int n2) {
        if (n == -904002048) {
            this.getLogChannel().log(-2137614336, "CtxAltRoutesSelection#keyPressed( %1, %2) - HK_Back event", (long)n, (long)n2);
            this.onHKBackClicked();
        } else if (n == 1965098496) {
            this.getLogChannel().log(-2137614336, "CtxAltRoutesSelection#keyPressed( %1, %2) - SK_Left event", (long)n, (long)n2);
        } else {
            super.keyPressed(n, n2);
        }
    }

    @Override
    public void onAllMatchFound(int n) {
        this.getLogChannel().log(-2137614336, "CtxAltRoutesSelection#onAllMatchFound( %1 )", (long)n);
    }

    @Override
    public void onFailedCalculation() {
        this.getLogChannel().log(-2137614336, "CtxAltRoutesSelection#onFailedCalculation()");
    }

    @Override
    public void displayCurrentRoute() {
        this.getLogChannel().log(-2137614336, "CtxAltRoutesSelection#displayCurrentRoute( )");
        if (this.getMap().getRouteCalculationHandler().isCalculatingAltRoutes() && this.getMap().getRouteCalculationHandler().isCalculationFinished()) {
            this.getLogChannel().log(-2137614336, "CtxAltRoutesSelection#displayCurrentRoute() - calculation is finished");
            this.restartScreenSwitchDelayer();
        }
        if (this.getMap().getMVRequest().getMVRequestControlActive().getMode() == 6) {
            super.displayCurrentRoute();
        }
    }

    @Override
    protected void restartScreenSwitchDelayer() {
        if (this.isScreenSwitchDelayerEnabled()) {
            this.getLogChannel().log(-2137614336, "CtxAltRoutesSelection#restartScreenSwitchDelayer()");
            this.getRouteCalcHandler().restartTimerIfCalculationStateIsReady();
        } else {
            this.getLogChannel().log(-2137614336, "CtxAltRoutesSelection#restartScreenSwitchDelayer() - disabled");
        }
    }

    @Override
    protected void cancelScreenSwitchDelayer() {
        this.getLogChannel().log(-2137614336, "CtxAltRoutesSelection#cancelScreenSwitchDelayer()");
        this.getRouteCalcHandler().cancelTimer();
    }

    private boolean isScreenSwitchDelayerEnabled() {
        return this.getMap().getRouteCalculationHandler().isAutoStartRGAndSwitchEnabled();
    }

    @Override
    public void updateRgActive(boolean bl) {
        if (!bl && !Util.isHURegionAsia()) {
            this.cancelScreenSwitchDelayer();
            this.getGUI().fireModelEvent(1125910016);
            this.getGUI().fireModelEvent(-904002048);
        }
        super.updateRgActive(bl);
    }

    @Override
    public void viewSizeChanged(int n) {
        if (n == 1) {
            this.getGUI().fireModelEvent(1125910016);
        }
        super.viewSizeChanged(n);
    }

    @Override
    public void onFiredRGAutoStartTimer() {
        IRouteCalculator iRouteCalculator = this.getMap().getRouteCalculationHandler();
        if (MapEnv.isSwitchScreenDelayerDisabled() || !iRouteCalculator.isAutoStartRGAndSwitchEnabled()) {
            this.getLogChannel().log(1078071040, "CtxAltRoutesSelection#onFiredRGAutoStartTimer() - disabled for debugging");
            return;
        }
        this.getLogChannel().log(1078071040, "CtxAltRoutesSelection#onFiredRGAutoStartTimer() - start RG and switch to shown context");
        this.getGUI().fireModelEvent(1125910016);
        int n = iRouteCalculator.getSelectedRouteIndex();
        boolean bl = iRouteCalculator.startRG(n);
        if (!bl && iRouteCalculator.getCalculatedRouteListElement().length > 0 && MapUtils.isCRLElementCalculated(iRouteCalculator.getCalculatedRouteListElement()[0])) {
            this.focusRoute(0);
            iRouteCalculator.startRG(0);
        }
        this.getMap().switchToAShownContext();
    }

    @Override
    public void onEvent(int n, Object object) {
        if (object != null) {
            this.getLogChannel().log(-2137614336, "CtxAltRoutesSelection#onEvent() - EvtId:%2, data:%1", object, (long)n);
        } else {
            this.getLogChannel().log(-2137614336, "CtxAltRoutesSelection#onEvent() - EvtId:%1", (long)n);
        }
        switch (n) {
            case 203: {
                this.getLogChannel().log(-2137614336, "CtxAltRoutesSelection#onEvent() - AutoStartTimerFired");
                break;
            }
            case 200: {
                this.getLogChannel().log(-2137614336, "CtxAltRoutesSelection#onEvent() - FoundFirstMatchedRoute");
                break;
            }
            case 201: {
                this.getLogChannel().log(-2137614336, "CtxAltRoutesSelection#onEvent() - FoundAllMatchedRoutes");
                break;
            }
            case 202: {
                this.getLogChannel().log(-2137614336, "CtxAltRoutesSelection#onEvent() - CalculationFailed");
                break;
            }
            default: {
                super.onEvent(n, object);
            }
        }
    }

    protected void resetNaviInputMode() {
        this.env.getChoiceModel(170).setValue(0);
    }

    @Override
    public void updateLockingState(boolean bl) {
        if (bl && Util.isLockFeatureNavMapOptionDrawerEnabled(this.env)) {
            this.onHKBackClicked();
        }
        super.updateLockingState(bl);
    }
}

