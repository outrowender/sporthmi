/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.RcsBetterRouteAvailable$AbstractPopupFSM;
import de.audi.tghu.navi.app.map.routecalc.RcsBetterRouteAvailable$AbstractPopupFSM$State;

class RcsBetterRouteAvailable$AbstractPopupFSM$PopupNotVisibleState
extends RcsBetterRouteAvailable$AbstractPopupFSM$State {
    private final /* synthetic */ RcsBetterRouteAvailable$AbstractPopupFSM this$1;

    public RcsBetterRouteAvailable$AbstractPopupFSM$PopupNotVisibleState(RcsBetterRouteAvailable$AbstractPopupFSM rcsBetterRouteAvailable$AbstractPopupFSM, String string) {
        this.this$1 = rcsBetterRouteAvailable$AbstractPopupFSM;
        super(rcsBetterRouteAvailable$AbstractPopupFSM, string);
    }

    @Override
    void enter() {
        RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).getLogger().log(-2137614336, "RcsBetterRouteAvailable.PopupNotVisibleState#enter()");
        this.this$1.hidePopup();
    }

    @Override
    void onShowPrompt() {
        if (RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).getStateMachine().isBetterRouteIgnored()) {
            RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).getLogger().log(-2137614336, "RcsBetterRouteAvailable.PopupNotVisibleState#onShowPrompt() Better Route ignored");
            RcsBetterRouteAvailable$AbstractPopupFSM.access$200(this.this$1, RcsBetterRouteAvailable$AbstractPopupFSM.access$100(this.this$1));
        } else if (!RcsBetterRouteAvailable$AbstractPopupFSM.access$300(this.this$1)) {
            RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).getLogger().log(-2137614336, "RcsBetterRouteAvailable.PopupNotVisibleState#onShowPrompt() Active Context not avlid, RCCI Map");
        } else {
            RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).getLogger().log(-2137614336, "RcsBetterRouteAvailable.PopupNotVisibleState#onShowPrompt() Better Route NOT ignored");
            RcsBetterRouteAvailable$AbstractPopupFSM.access$200(this.this$1, RcsBetterRouteAvailable$AbstractPopupFSM.access$400(this.this$1));
        }
    }

    @Override
    void onClearAll() {
        RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).getLogger().log(-2137614336, "RcsBetterRouteAvailable.PopupNotVisibleState#onClearAll()");
    }
}

