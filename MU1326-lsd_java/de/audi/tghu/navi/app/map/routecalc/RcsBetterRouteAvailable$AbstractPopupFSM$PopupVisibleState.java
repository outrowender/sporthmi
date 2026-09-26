/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.RcsBetterRouteAvailable$AbstractPopupFSM;
import de.audi.tghu.navi.app.map.routecalc.RcsBetterRouteAvailable$AbstractPopupFSM$State;

class RcsBetterRouteAvailable$AbstractPopupFSM$PopupVisibleState
extends RcsBetterRouteAvailable$AbstractPopupFSM$State {
    private final /* synthetic */ RcsBetterRouteAvailable$AbstractPopupFSM this$1;

    public RcsBetterRouteAvailable$AbstractPopupFSM$PopupVisibleState(RcsBetterRouteAvailable$AbstractPopupFSM rcsBetterRouteAvailable$AbstractPopupFSM, String string) {
        this.this$1 = rcsBetterRouteAvailable$AbstractPopupFSM;
        super(rcsBetterRouteAvailable$AbstractPopupFSM, string);
    }

    @Override
    void enter() {
        RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).getLogger().log(-2137614336, "RcsBetterRouteAvailable.PopupVisibleState#enter() Show popup and afaRepeat");
        this.this$1.showPopup();
        this.this$1.afaRepeat();
    }

    @Override
    void onShowPrompt() {
        if (RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).getStateMachine().isBetterRouteIgnored()) {
            RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).getLogger().log(-2137614336, "RcsBetterRouteAvailable.PopupVisibleState#onShowPrompt() Better Route Ignored");
            RcsBetterRouteAvailable$AbstractPopupFSM.access$200(this.this$1, RcsBetterRouteAvailable$AbstractPopupFSM.access$100(this.this$1));
        } else if (!RcsBetterRouteAvailable$AbstractPopupFSM.access$300(this.this$1)) {
            RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).getLogger().log(-2137614336, "RcsBetterRouteAvailable.PopupVisibleState#onShowPrompt() Active Context not valid, RCCI Map");
        } else {
            RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).getLogger().log(-2137614336, "RcsBetterRouteAvailable.PopupVisibleState#onShowPrompt() Better Route NOT Ignored");
            if (RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).refreshPopupOnUpdate()) {
                this.this$1.showPopup();
            }
        }
    }

    @Override
    void onClearAll() {
        RcsBetterRouteAvailable$AbstractPopupFSM.access$000(this.this$1).getLogger().log(-2137614336, "RcsBetterRouteAvailable.PopupVisibleState#onClearAll()");
        RcsBetterRouteAvailable$AbstractPopupFSM.access$200(this.this$1, RcsBetterRouteAvailable$AbstractPopupFSM.access$500(this.this$1));
    }
}

