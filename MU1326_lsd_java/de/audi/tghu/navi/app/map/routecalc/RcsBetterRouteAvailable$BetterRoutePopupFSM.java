/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.RcsBetterRouteAvailable;
import de.audi.tghu.navi.app.map.routecalc.RcsBetterRouteAvailable$1;
import de.audi.tghu.navi.app.map.routecalc.RcsBetterRouteAvailable$AbstractPopupFSM;

final class RcsBetterRouteAvailable$BetterRoutePopupFSM
extends RcsBetterRouteAvailable$AbstractPopupFSM {
    private final /* synthetic */ RcsBetterRouteAvailable this$0;

    private RcsBetterRouteAvailable$BetterRoutePopupFSM(RcsBetterRouteAvailable rcsBetterRouteAvailable) {
        this.this$0 = rcsBetterRouteAvailable;
        super(rcsBetterRouteAvailable, null);
    }

    @Override
    protected void showPopup() {
        this.this$0.getLogger().log(-2137614336, "RcsBetterRouteAvailable.BetterRoutePopupFSM#showPopup()");
        this.this$0.getViews().getSemidynRGView().showPopupSemidynBetterMain();
    }

    @Override
    protected void hidePopup() {
        this.this$0.getLogger().log(-2137614336, "RcsBetterRouteAvailable.BetterRoutePopupFSM#hidePopup()");
        this.this$0.getViews().getSemidynRGView().hidePopupSemidynBetterMain();
    }

    @Override
    protected void afaRepeat() {
        this.this$0.getStateMachine().naviMap.getNaviInterface().afaRepeat(5);
    }

    /* synthetic */ RcsBetterRouteAvailable$BetterRoutePopupFSM(RcsBetterRouteAvailable rcsBetterRouteAvailable, RcsBetterRouteAvailable$1 rcsBetterRouteAvailable$1) {
        this(rcsBetterRouteAvailable);
    }
}

