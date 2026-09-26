/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.online;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.online.NaviOnlineServiceImpl;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

class NaviOnlineServiceImpl$2
extends NavCommand {
    private final /* synthetic */ String val$poiName;
    private final /* synthetic */ ChoiceModelApp val$flipFlopModel;
    private final /* synthetic */ int val$position;
    private final /* synthetic */ boolean val$restart;
    private final /* synthetic */ NaviOnlineServiceImpl this$0;

    NaviOnlineServiceImpl$2(NaviOnlineServiceImpl naviOnlineServiceImpl, String string, String string2, ChoiceModelApp choiceModelApp, int n, boolean bl) {
        this.this$0 = naviOnlineServiceImpl;
        this.val$poiName = string2;
        this.val$flipFlopModel = choiceModelApp;
        this.val$position = n;
        this.val$restart = bl;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getTransformedLocation();
        Util.setOnlinePOINameOnLocation(navLocation, this.val$poiName);
        this.this$0.logChannel.log(-2137614336, "NaviOnlineServiceImpl#insertAsStopover transformedLocation=%1, flipFlopModel=%2", (Object)navLocation, (Object)this.val$flipFlopModel);
        if (this.val$flipFlopModel != null) {
            this.val$flipFlopModel.setValue(this.val$flipFlopModel.getValue() ^ 1);
        }
        NaviOnlineServiceImpl.access$000(this.this$0).addAsStopOver(navLocation, this.val$position, this.val$restart, null);
        this.getCommandList().commandFinished();
    }
}

