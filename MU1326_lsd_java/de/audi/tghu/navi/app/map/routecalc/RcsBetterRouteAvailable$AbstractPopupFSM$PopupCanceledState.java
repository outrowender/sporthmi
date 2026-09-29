/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.RcsBetterRouteAvailable$AbstractPopupFSM;
import de.audi.tghu.navi.app.map.routecalc.RcsBetterRouteAvailable$AbstractPopupFSM$State;

class RcsBetterRouteAvailable$AbstractPopupFSM$PopupCanceledState
extends RcsBetterRouteAvailable$AbstractPopupFSM$State {
    private final /* synthetic */ RcsBetterRouteAvailable$AbstractPopupFSM this$1;

    public RcsBetterRouteAvailable$AbstractPopupFSM$PopupCanceledState(RcsBetterRouteAvailable$AbstractPopupFSM rcsBetterRouteAvailable$AbstractPopupFSM, String string) {
        this.this$1 = rcsBetterRouteAvailable$AbstractPopupFSM;
        super(rcsBetterRouteAvailable$AbstractPopupFSM, string);
    }

    @Override
    void enter() {
        RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).getLogger().log(-2137614336, "RcsBetterRouteAvailable.PopupCanceledState#enter()");
        this.this$1.hidePopup();
    }

    @Override
    void onClearAll() {
        RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).getLogger().log(-2137614336, "RcsBetterRouteAvailable.PopupCanceledState#onClearAll()");
        RcsBetterRouteAvailable$AbstractPopupFSM.access$200(this.this$1, RcsBetterRouteAvailable$AbstractPopupFSM.access$500(this.this$1));
    }

    @Override
    void onShowPrompt() {
        if (!RcsBetterRouteAvailable$AbstractPopupFSM.access$300(this.this$1)) {
            RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).getLogger().log(-2137614336, "RcsBetterRouteAvailable.PopupCanceledState#onShowPrompt() Active Context not valid, RCCI Map ");
        } else if (!RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).getStateMachine().isBetterRouteIgnored()) {
            RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).getLogger().log(-2137614336, "RcsBetterRouteAvailable.PopupCanceledState#onShowPrompt() Better Route NOT ignored");
            RcsBetterRouteAvailable$AbstractPopupFSM.access$200(this.this$1, RcsBetterRouteAvailable$AbstractPopupFSM.access$400(this.this$1));
        } else {
            RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).getLogger().log(-2137614336, "RcsBetterRouteAvailable.PopupCanceledState#onShowPrompt() Stay in canceled state");
        }
    }
}

