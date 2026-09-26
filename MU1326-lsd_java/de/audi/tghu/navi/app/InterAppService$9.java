/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

class InterAppService$9
extends NotifyNaviServiceListenerCommand {
    private final /* synthetic */ String val$favName;
    private final /* synthetic */ InterAppService this$0;

    InterAppService$9(InterAppService interAppService, NaviServiceListener naviServiceListener, String string) {
        this.this$0 = interAppService;
        this.val$favName = string;
        super(naviServiceListener);
    }

    @Override
    public void call(NaviServiceListener naviServiceListener) {
        int n = this.env.getChoiceModel(-249690624).getValue();
        this.env.getChoiceModel(-1407187456).setValue(n == 0 ? 1 : 0);
        if (n == 0) {
            naviServiceListener.responseSetDestination((byte)3);
            this.getCommandList().commandAborted("No valid TryBestMatchResult found!");
        } else {
            this.env.getLogChannel().log(-2137614336, "Routeguidance will be set to the following Location: %1", (Object)LocationFormatter.formatLocationShort(this.dsiResponseContainer.getTryBestMatchResultData()[0].getLocation()));
            NavLocation navLocation = this.dsiResponseContainer.getTryBestMatchResultData()[0].getLocation();
            Util.setFavoriteNameOnLocation(navLocation, this.val$favName);
            InterAppService.access$100(this.this$0).storeDestination(navLocation, true, true);
            naviServiceListener.responseSetDestination((byte)0);
            this.getCommandList().commandFinished();
        }
    }
}

