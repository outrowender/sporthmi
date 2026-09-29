/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.sds.NotifySDSCommand;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl;
import org.dsi.ifc.global.NavLocation;

class SDSHandlerImpl$9
extends NotifySDSCommand {
    private final /* synthetic */ NavLocation val$location;
    private final /* synthetic */ SDSHandlerImpl this$0;

    SDSHandlerImpl$9(SDSHandlerImpl sDSHandlerImpl, NaviServiceListener naviServiceListener, NavLocation navLocation) {
        this.this$0 = sDSHandlerImpl;
        this.val$location = navLocation;
        super(naviServiceListener);
    }

    @Override
    public void call() {
        if (SDSHandlerImpl.access$000(this.this$0) == null) {
            this.this$0.logChannel.log(1078071040, "SDSHandlerImple#setLastDestinationByIndex lastDestHandler is null");
            this.getCommandList().commandAborted("SDSHandlerImple#setLastDestinationByIndex lastDestHandler is null");
        }
        this.this$0.storeLastDestination(this.val$location);
        this.feedbackNaviServiceListener.responseSetLastDestination((byte)0);
    }
}

