/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToAddressbookSequence;
import de.audi.tghu.navi.app.command.LocationToStreamCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

class ReturnNavLocationToAddressbookSequence$1
extends NavCommand {
    private final /* synthetic */ NavLocation val$location;
    private final /* synthetic */ ReturnNavLocationToAddressbookSequence this$0;

    ReturnNavLocationToAddressbookSequence$1(ReturnNavLocationToAddressbookSequence returnNavLocationToAddressbookSequence, String string, NavLocation navLocation) {
        this.this$0 = returnNavLocationToAddressbookSequence;
        this.val$location = navLocation;
        super(string);
    }

    @Override
    public void execute() {
        if (this.val$location == null) {
            this.logger.log(-2137614336, "%1 - using liCurrentLd", (Object)this.CLASS_NAME);
            this.getCommandList().commandFinishedWithPostCommand(new LocationToStreamCommand(this.dsiResponseContainer.getLiCurrentLD()));
        } else {
            this.logger.log(-2137614336, "%1 - using given location(%2)", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(this.val$location));
            this.getCommandList().commandFinishedWithPostCommand(new LocationToStreamCommand(this.val$location));
        }
    }
}

