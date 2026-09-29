/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.sds.NotifySDSCommand;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl;
import org.dsi.ifc.global.NavLocation;

class SDSHandlerImpl$11
extends NotifySDSCommand {
    private final /* synthetic */ NavLocation val$location;
    private final /* synthetic */ SDSHandlerImpl this$0;

    SDSHandlerImpl$11(SDSHandlerImpl sDSHandlerImpl, NaviServiceListener naviServiceListener, NavLocation navLocation) {
        this.this$0 = sDSHandlerImpl;
        this.val$location = navLocation;
        super(naviServiceListener);
    }

    @Override
    public void call() {
        this.this$0.storeFavoriteDestination(this.val$location);
        this.feedbackNaviServiceListener.responseSetFavoriteDestination((byte)0);
    }
}

