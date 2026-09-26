/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

class AbstractAddressInputManager$8
extends NavCommand {
    private final /* synthetic */ AbstractAddressInputManager this$0;

    AbstractAddressInputManager$8(AbstractAddressInputManager abstractAddressInputManager, String string) {
        this.this$0 = abstractAddressInputManager;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.getLiCurrentLD() == null) {
            if (!this.dsiResponseContainer.isLiIsSpellerActive()) {
                if (this.this$0.backupLocation == null) {
                    this.this$0.backupLocation = (NavLocation)this.getCommandList().get("STREAMED_LOCATION");
                    if (this.this$0.backupLocation != null && !Util.isEmpty(this.this$0.backupLocation.country)) {
                        LISetCurrentLDCommand lISetCurrentLDCommand = new LISetCurrentLDCommand(this.this$0.backupLocation);
                        this.getCommandList().commandFinishedWithPostCommand(lISetCurrentLDCommand);
                    } else {
                        this.this$0.backupLocation = this.this$0.vehicle.getVehicleCountryLocation();
                        LISetCurrentLDCommand lISetCurrentLDCommand = new LISetCurrentLDCommand(this.this$0.backupLocation);
                        this.getCommandList().commandFinishedWithPostCommand(lISetCurrentLDCommand);
                    }
                } else {
                    LISetCurrentLDCommand lISetCurrentLDCommand = new LISetCurrentLDCommand(this.this$0.backupLocation);
                    this.getCommandList().commandFinishedWithPostCommand(lISetCurrentLDCommand);
                }
            } else {
                this.logger.log(1078071040, "%1#execute() - speller currently active, do no set currentLD for onNewNaviServiceListener()", (Object)this.CLASS_NAME);
                this.getCommandList().commandFinished();
            }
        } else {
            if (this.this$0.backupLocation == null) {
                this.this$0.backupLocation = this.dsiResponseContainer.getLiCurrentLD();
            }
            this.getCommandList().commandFinished();
        }
    }
}

