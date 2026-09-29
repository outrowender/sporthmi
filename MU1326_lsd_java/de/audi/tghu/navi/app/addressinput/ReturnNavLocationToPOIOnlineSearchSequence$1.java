/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToPOIOnlineSearchSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.poi.online.OnlineSearchController;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

class ReturnNavLocationToPOIOnlineSearchSequence$1
extends NavCommand {
    private final /* synthetic */ ReturnNavLocationToPOIOnlineSearchSequence this$0;

    ReturnNavLocationToPOIOnlineSearchSequence$1(ReturnNavLocationToPOIOnlineSearchSequence returnNavLocationToPOIOnlineSearchSequence) {
        this.this$0 = returnNavLocationToPOIOnlineSearchSequence;
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        this.logger.log(-2137614336, "%1 - liCurrentLd=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        OnlineSearchController onlineSearchController = this.navigation.getOnlineSearchController();
        if (onlineSearchController == null) {
            this.env.getLogChannel().log(10000, "ReturnNavLocationToNaviOnlineSequence#start() - no OnlineSearchController");
            return;
        }
        onlineSearchController.getOnlineSearchSequence().setSearchArea(3, navLocation);
        this.getCommandList().commandFinished();
    }
}

