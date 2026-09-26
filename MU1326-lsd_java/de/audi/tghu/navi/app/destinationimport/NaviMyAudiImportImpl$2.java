/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.destinationimport;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiImportImpl;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

class NaviMyAudiImportImpl$2
extends NavCommand {
    private final /* synthetic */ byte[] val$destination;
    private final /* synthetic */ NaviMyAudiImportImpl this$0;

    NaviMyAudiImportImpl$2(NaviMyAudiImportImpl naviMyAudiImportImpl, String string, byte[] byArray) {
        this.this$0 = naviMyAudiImportImpl;
        this.val$destination = byArray;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = (NavLocation)this.getCommandList().get("STREAMED_LOCATION");
        this.logger.log(-2137614336, "Streamed Location is %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        if (NaviMyAudiImportImpl.access$100(this.this$0).getInputMode() == 1) {
            this.this$0.logChannel.log(-2137614336, "%1 - send to ADB", (Object)this.CLASS_NAME);
            NaviMyAudiImportImpl.access$200(this.this$0).getCurrentLocationInputHandler().updateLocation(this.val$destination);
        } else if (NaviMyAudiImportImpl.access$100(this.this$0).getInputMode() == 2) {
            this.this$0.logChannel.log(-2137614336, "%1 - set as home address", (Object)this.CLASS_NAME);
            NaviMyAudiImportImpl.access$300(this.this$0).onCreateEditHomeAddress(navLocation);
        } else {
            this.this$0.logChannel.log(-2137614336, "%1 - start RG", (Object)this.CLASS_NAME);
            this.getCommandList().commandFinishedWithPostSequence(NaviMyAudiImportImpl.access$400(this.this$0).getStartSequence(navLocation));
        }
        this.getCommandList().commandFinished();
    }
}

