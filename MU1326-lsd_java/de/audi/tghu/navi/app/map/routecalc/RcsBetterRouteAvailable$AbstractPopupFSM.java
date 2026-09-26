/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.RcsBetterRouteAvailable;
import de.audi.tghu.navi.app.map.routecalc.RcsBetterRouteAvailable$1;
import de.audi.tghu.navi.app.map.routecalc.RcsBetterRouteAvailable$AbstractPopupFSM$PopupCanceledState;
import de.audi.tghu.navi.app.map.routecalc.RcsBetterRouteAvailable$AbstractPopupFSM$PopupNotVisibleState;
import de.audi.tghu.navi.app.map.routecalc.RcsBetterRouteAvailable$AbstractPopupFSM$PopupVisibleState;
import de.audi.tghu.navi.app.map.routecalc.RcsBetterRouteAvailable$AbstractPopupFSM$State;

abstract class RcsBetterRouteAvailable$AbstractPopupFSM {
    static final String POPUP_NOT_VISIBLE;
    static final String POPUP_VISIBLE;
    static final String POPUP_CANCELED;
    private final RcsBetterRouteAvailable$AbstractPopupFSM$PopupNotVisibleState popupNotVisibleState = new RcsBetterRouteAvailable$AbstractPopupFSM$PopupNotVisibleState(this, "POPUP_NOT_VISIBLE");
    private final RcsBetterRouteAvailable$AbstractPopupFSM$PopupVisibleState popupVisibleState = new RcsBetterRouteAvailable$AbstractPopupFSM$PopupVisibleState(this, "POPUP_VISIBLE");
    private final RcsBetterRouteAvailable$AbstractPopupFSM$PopupCanceledState popupCanceledState = new RcsBetterRouteAvailable$AbstractPopupFSM$PopupCanceledState(this, "POPUP_CANCELED");
    private RcsBetterRouteAvailable$AbstractPopupFSM$State currentState = this.popupNotVisibleState;
    private final /* synthetic */ RcsBetterRouteAvailable this$0;

    private RcsBetterRouteAvailable$AbstractPopupFSM(RcsBetterRouteAvailable rcsBetterRouteAvailable) {
        this.this$0 = rcsBetterRouteAvailable;
    }

    public RcsBetterRouteAvailable$AbstractPopupFSM$State getCurrentState() {
        return this.currentState;
    }

    protected abstract void showPopup() {
    }

    protected abstract void hidePopup() {
    }

    protected abstract void afaRepeat() {
    }

    private void changeState(RcsBetterRouteAvailable$AbstractPopupFSM$State rcsBetterRouteAvailable$AbstractPopupFSM$State) {
        if (rcsBetterRouteAvailable$AbstractPopupFSM$State == this.currentState) {
            return;
        }
        this.currentState.exit();
        this.currentState = rcsBetterRouteAvailable$AbstractPopupFSM$State;
        this.currentState.enter();
    }

    private boolean isValidContextToShowPopup() {
        return this.this$0.getStateMachine().naviMap.getActiveContextIndex() != 20;
    }

    static /* synthetic */ RcsBetterRouteAvailable access$000(RcsBetterRouteAvailable$AbstractPopupFSM rcsBetterRouteAvailable$AbstractPopupFSM) {
        return rcsBetterRouteAvailable$AbstractPopupFSM.this$0;
    }

    static /* synthetic */ RcsBetterRouteAvailable$AbstractPopupFSM$PopupCanceledState access$100(RcsBetterRouteAvailable$AbstractPopupFSM rcsBetterRouteAvailable$AbstractPopupFSM) {
        return rcsBetterRouteAvailable$AbstractPopupFSM.popupCanceledState;
    }

    static /* synthetic */ void access$200(RcsBetterRouteAvailable$AbstractPopupFSM rcsBetterRouteAvailable$AbstractPopupFSM, RcsBetterRouteAvailable$AbstractPopupFSM$State rcsBetterRouteAvailable$AbstractPopupFSM$State) {
        rcsBetterRouteAvailable$AbstractPopupFSM.changeState(rcsBetterRouteAvailable$AbstractPopupFSM$State);
    }

    static /* synthetic */ boolean access$300(RcsBetterRouteAvailable$AbstractPopupFSM rcsBetterRouteAvailable$AbstractPopupFSM) {
        return rcsBetterRouteAvailable$AbstractPopupFSM.isValidContextToShowPopup();
    }

    static /* synthetic */ RcsBetterRouteAvailable$AbstractPopupFSM$PopupVisibleState access$400(RcsBetterRouteAvailable$AbstractPopupFSM rcsBetterRouteAvailable$AbstractPopupFSM) {
        return rcsBetterRouteAvailable$AbstractPopupFSM.popupVisibleState;
    }

    static /* synthetic */ RcsBetterRouteAvailable$AbstractPopupFSM$PopupNotVisibleState access$500(RcsBetterRouteAvailable$AbstractPopupFSM rcsBetterRouteAvailable$AbstractPopupFSM) {
        return rcsBetterRouteAvailable$AbstractPopupFSM.popupNotVisibleState;
    }

    /* synthetic */ RcsBetterRouteAvailable$AbstractPopupFSM(RcsBetterRouteAvailable rcsBetterRouteAvailable, RcsBetterRouteAvailable$1 rcsBetterRouteAvailable$1) {
        this(rcsBetterRouteAvailable);
    }
}

