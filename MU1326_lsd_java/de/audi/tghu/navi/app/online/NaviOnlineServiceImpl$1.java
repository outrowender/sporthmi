/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.online;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.online.NaviOnlineServiceImpl;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

class NaviOnlineServiceImpl$1
extends NavCommand {
    private final /* synthetic */ String val$poiName;
    private final /* synthetic */ String val$destinationID;
    private final /* synthetic */ ChoiceModelApp val$flipFlopModel;
    private final /* synthetic */ NaviOnlineServiceImpl this$0;

    NaviOnlineServiceImpl$1(NaviOnlineServiceImpl naviOnlineServiceImpl, String string, String string2, String string3, ChoiceModelApp choiceModelApp) {
        this.this$0 = naviOnlineServiceImpl;
        this.val$poiName = string2;
        this.val$destinationID = string3;
        this.val$flipFlopModel = choiceModelApp;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getTransformedLocation();
        Util.setOnlinePOINameOnLocation(navLocation, this.val$poiName);
        Util.setOnlinePoiIdOnLocation(navLocation, this.val$destinationID);
        this.this$0.logChannel.log(-2137614336, "NaviOnlineServiceImpl#startRouteGuidance: execute Command NaviOnlineServiceImpl#setDescriptionOnLocation. Location = (%1, %2). Triggering Model %3", (long)navLocation.latitude, (long)navLocation.longitude, (long)this.val$flipFlopModel.getID());
        this.val$flipFlopModel.setValue(this.val$flipFlopModel.getValue() ^ 1);
        this.getCommandList().commandFinishedWithPostSequence(this.this$0.getStartSequence(navLocation));
    }
}

