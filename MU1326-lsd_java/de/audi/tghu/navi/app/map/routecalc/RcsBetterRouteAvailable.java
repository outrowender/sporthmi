/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.RcciEvent;
import de.audi.tghu.navi.app.map.routecalc.RcsBetterRouteAvailable$BetterRoutePopupFSM;
import de.audi.tghu.navi.app.map.routecalc.RcsBetterRouteAvailable$BlockedPopupFSM;
import de.audi.tghu.navi.app.map.routecalc.RcsRGActivated;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;

public class RcsBetterRouteAvailable
extends RcsRGActivated {
    RcsBetterRouteAvailable$BlockedPopupFSM blockedPopupFSM = new RcsBetterRouteAvailable$BlockedPopupFSM(this, null);
    RcsBetterRouteAvailable$BetterRoutePopupFSM betterRoutePopupFSM = new RcsBetterRouteAvailable$BetterRoutePopupFSM(this, null);

    protected RcsBetterRouteAvailable(RouteCalcSM routeCalcSM) {
        super(routeCalcSM, "RcsBetterRouteAvailable");
    }

    @Override
    public void exit() {
        super.exit();
        this.cleanAll();
    }

    public boolean refreshPopupOnUpdate() {
        return true;
    }

    @Override
    public void enter() {
        this.postUpdateRCCI(this.getStateMachine().getRcciEvent());
    }

    @Override
    protected void postUpdateRCCI(RcciEvent rcciEvent) {
        try {
            this.getStateMachine().naviMap.getActiveContext().updateRgRouteCostChangeInformation(this.getData().rgRCCI);
        }
        catch (Exception exception) {
            this.getLogger().log(10000, "RcsBetterRouteAvailable#postUpdateRCCI( ) - %1", (Throwable)exception);
        }
        long l = rcciEvent.reliable ? rcciEvent.savingTime : -1L;
        this.data.iBetterRouteState = rcciEvent.type;
        switch (rcciEvent.type) {
            case 1: {
                this.goTo(7);
                break;
            }
            case 0: {
                this.getLogger().log(10000, "RcsBetterRouteAvailable#postUpdateRCCI( ) - inconsistent");
                break;
            }
            case 6: {
                this.getLogger().log(-1601830656, "RcsBetterRouteAvailable#postUpdateRCCI( ) - new route is not recommended");
                break;
            }
            case 4: 
            case 9: {
                this.getLogger().log(-2137614336, "RcsBetterRouteAvailable#postUpdateRCCI( ) - due to blocking, ignored = %1", this.getData().isPopupDueToBlockingIgnored);
                this.refreshBetterRouteIndicator(l, true);
                this.refreshNewRouteEta(rcciEvent.origin.newRoute.etaWithSpeedAndFlow);
                this.blockedPopupFSM.getCurrentState().onShowPrompt();
                break;
            }
            case 3: 
            case 8: {
                this.getLogger().log(-2137614336, "RcsBetterRouteAvailable#postUpdateRCCI( ) - definitive better, ignored = %1", this.getData().isPopupDefinitiveBetterIgnored);
                this.refreshBetterRouteIndicator(l, true);
                this.refreshNewRouteEta(rcciEvent.origin.newRoute.etaWithSpeedAndFlow);
                this.betterRoutePopupFSM.getCurrentState().onShowPrompt();
                break;
            }
            case 2: 
            case 7: {
                this.refreshBetterRouteIndicator(l, false);
                this.refreshNewRouteEta(rcciEvent.origin.newRoute.etaWithSpeedAndFlow);
                break;
            }
            default: {
                this.getLogger().log(-2137614336, "RcsBetterRouteAvailable#postUpdateRCCI( %1 ) - unexpected call", (long)rcciEvent.type);
                this.goTo(9);
            }
        }
    }

    protected void refreshBetterRouteIndicator(long l, boolean bl) {
        this.getLogger().log(-2137614336, "RcsBetterRouteAvailable#refreshBetterRouteIndicator( %1 )", l);
        this.getData().sSavingTimeOfBetterRoute = l;
        if (bl) {
            this.getViews().getSemidynRGView().showShortInfo(l);
            return;
        }
        if (!this.getData().wasOnceVisible) {
            this.getViews().getSemidynRGView().showPopupBetterRouteAvailable(l);
            this.getData().wasOnceVisible = true;
            this.data.shortBetterRouteAvailableInfoTimer.start();
        } else if (this.data.shortBetterRouteAvailableInfoTimer.isRunning() && this.getViews().getSemidynRGView().isBetterRouteIndicatorVisible()) {
            this.getViews().getSemidynRGView().updateSavedTime(l);
        } else {
            this.getViews().getSemidynRGView().showShortInfo(l);
        }
    }

    protected void refreshNewRouteEta(long l) {
    }

    private void cleanAll() {
        this.data.shortBetterRouteAvailableInfoTimer.cancel();
        this.getViews().getSemidynRGView().hidePopupBetterRouteAvailable();
        this.getViews().getSemidynRGView().hidePopupSemidynBlockMain();
        this.getViews().getSemidynRGView().hidePopupSemidynBetterMain();
        this.blockedPopupFSM.getCurrentState().onClearAll();
        this.betterRoutePopupFSM.getCurrentState().onClearAll();
    }

    @Override
    public void setSelectedRouteIndex(int n) {
        this.getLogger().log(-2137614336, "RcsBetterRouteAvailable#setSelectedRouteIndex( %1 )", (long)n);
        if (0 <= n && n <= 1) {
            this.getData().iRouteIndex = n;
        } else {
            this.getLogger().log(10000, "RcsBetterRouteAvailable#setSelectedRouteIndex( ) - invalid index");
        }
    }
}

