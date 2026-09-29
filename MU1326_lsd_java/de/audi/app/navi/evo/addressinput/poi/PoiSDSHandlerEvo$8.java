/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiSDSHandlerEvo;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

class PoiSDSHandlerEvo$8
extends NavCommand {
    private final /* synthetic */ NavLocation val$navLoc;
    private final /* synthetic */ PoiSDSHandlerEvo this$0;

    PoiSDSHandlerEvo$8(PoiSDSHandlerEvo poiSDSHandlerEvo, String string, NavLocation navLocation) {
        this.this$0 = poiSDSHandlerEvo;
        this.val$navLoc = navLocation;
        super(string);
    }

    @Override
    public void execute() {
        NaviOnlineService naviOnlineService = this.navigation.getInterAppService().getNaviOnlineService();
        if (naviOnlineService != null && naviOnlineService.getSearchAreaListener() != null) {
            naviOnlineService.getSearchAreaListener().updateSearchLocation(Util.getLocationAccessor(this.val$navLoc));
        } else {
            this.logger.log(1078071040, "%1#startUpdateSearchLocationSequence() - Listener is null or not available, no update sent.", (Object)this.CLASS_NAME);
        }
        this.getCommandList().commandFinished();
    }
}

