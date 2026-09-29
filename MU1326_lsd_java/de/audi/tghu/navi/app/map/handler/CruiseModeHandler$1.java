/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.interapp.NaviCruiseModeServiceListener;
import de.audi.tghu.navi.app.map.handler.CruiseModeHandler;

class CruiseModeHandler$1
implements NaviCruiseModeServiceListener {
    private final /* synthetic */ CruiseModeHandler this$0;

    CruiseModeHandler$1(CruiseModeHandler cruiseModeHandler) {
        this.this$0 = cruiseModeHandler;
    }

    @Override
    public void updateCruiseMode(boolean bl) {
        CruiseModeHandler.access$000(this.this$0).log(-2137614336, "CruiseModeHandler.NullService#updateCruiseMode( )");
    }
}

