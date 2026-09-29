/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class ADBInterAppService$3
extends NavCommand {
    private final /* synthetic */ String val$combinedName;
    private final /* synthetic */ ADBInterAppService this$0;

    ADBInterAppService$3(ADBInterAppService aDBInterAppService, String string) {
        this.this$0 = aDBInterAppService;
        this.val$combinedName = string;
    }

    private void openAddressInputForm_fromADB() {
        this.env.getChoiceModel(1042286080).setValue(1);
        this.env.getChoiceModel(-1407187456).setValue(1);
        this.getCommandList().commandAborted("setDestination: No valid TryBestMatchResult found!");
    }

    @Override
    public void execute() {
        if (this.env.getChoiceModel(-249690624).getValue() == 0) {
            if (ADBInterAppService.access$400(this.this$0).isDebug2()) {
                ADBInterAppService.access$400(this.this$0).log(14808325, "%1#setDestination tryBestMatch fail, ADB_TRY_BEST_MATCH_CHOICE is 0", (Object)this.CLASS_NAME);
            }
            this.openAddressInputForm_fromADB();
        } else {
            this.env.getLogChannel().log(-2137614336, "Routeguidance will be startet to the following Location: \n########### LOCATION ###########\n %1 \n########### LOCATION END ###########", (Object)this.dsiResponseContainer.getTryBestMatchResultData()[0].getLocation());
            NavLocation navLocation = this.dsiResponseContainer.getTryBestMatchResultData()[0].getLocation();
            ADBInterAppService.access$000(this.this$0, navLocation, this.val$combinedName);
            if (null != navLocation && navLocation.isPositionValid()) {
                this.getCommandList().commandFinishedWithPostSequence(ADBInterAppService.access$100(this.this$0).getStartSequence(navLocation));
            } else if (ADBInterAppService.access$400(this.this$0).isDebug2()) {
                ADBInterAppService.access$400(this.this$0).log(14808325, "%1#setDestination tryBestMatch fail, got no (valid) navLoc", (Object)this.CLASS_NAME);
            }
        }
        this.getCommandList().commandFinished();
    }
}

