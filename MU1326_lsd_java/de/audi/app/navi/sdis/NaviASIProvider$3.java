/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.sdis;

import de.audi.app.navi.sdis.NaviASIProvider;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import org.dsi.ifc.global.NavLocation;

class NaviASIProvider$3
extends NavCommand {
    private final /* synthetic */ DestinationInfo[] val$destinationInfo;
    private final /* synthetic */ NavCommand val$replyOKCommand;
    private final /* synthetic */ NavCommand val$replyDeclinedCommand;
    private final /* synthetic */ NaviASIProvider this$0;

    NaviASIProvider$3(NaviASIProvider naviASIProvider, DestinationInfo[] destinationInfoArray, NavCommand navCommand, NavCommand navCommand2) {
        this.this$0 = naviASIProvider;
        this.val$destinationInfo = destinationInfoArray;
        this.val$replyOKCommand = navCommand;
        this.val$replyDeclinedCommand = navCommand2;
    }

    @Override
    public void execute() {
        NavLocation[] navLocationArray = (NavLocation[])this.getCommandList().get("NavLocationArray");
        for (int i2 = 0; i2 < this.val$destinationInfo.length; ++i2) {
            if (Util.isEmpty(this.val$destinationInfo[i2].poiName)) continue;
            Util.setDescriptionOnLocation(navLocationArray[i2], this.val$destinationInfo[i2].poiName);
        }
        NaviASIProvider.access$200(this.this$0).startGuidanceToDestinations(navLocationArray, this.val$replyOKCommand, this.val$replyDeclinedCommand);
        this.getCommandList().commandFinished();
    }
}

