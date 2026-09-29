/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.atip.interapp.NaviOnlineService$NaviOnlineSearchAreaListener;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToRemoteHmiFromCurrentLDSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

class ReturnNavLocationToRemoteHmiFromCurrentLDSequence$1
extends NavCommand {
    private final /* synthetic */ ReturnNavLocationToRemoteHmiFromCurrentLDSequence this$0;

    ReturnNavLocationToRemoteHmiFromCurrentLDSequence$1(ReturnNavLocationToRemoteHmiFromCurrentLDSequence returnNavLocationToRemoteHmiFromCurrentLDSequence) {
        this.this$0 = returnNavLocationToRemoteHmiFromCurrentLDSequence;
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        this.logger.log(-2137614336, "%1 - liCurrentLd=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        NaviOnlineService$NaviOnlineSearchAreaListener naviOnlineService$NaviOnlineSearchAreaListener = this.navigation.getInterAppService().getNaviOnlineService().getSearchAreaListener();
        if (naviOnlineService$NaviOnlineSearchAreaListener != null) {
            naviOnlineService$NaviOnlineSearchAreaListener.updateSearchLocation(Util.getLocationAccessor(navLocation));
            this.getCommandList().commandFinished();
        } else {
            this.env.getLogChannel().log(10000, "ReturnNavLocationToRemoteHmiFromCurrentLDSequence#start() - NaviOnlineSearchAreaListener is null");
            this.getCommandList().commandAborted("No NaviOnlineSearchAreaListener available");
        }
    }
}

