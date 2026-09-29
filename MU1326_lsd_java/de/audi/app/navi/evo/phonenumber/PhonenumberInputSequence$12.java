/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToAddressbookSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class PhonenumberInputSequence$12
extends NavCommand {
    private final /* synthetic */ HomeAddressHandler val$homeAddressHandler;
    private final /* synthetic */ PhonenumberInputSequence this$0;

    PhonenumberInputSequence$12(PhonenumberInputSequence phonenumberInputSequence, HomeAddressHandler homeAddressHandler) {
        this.this$0 = phonenumberInputSequence;
        this.val$homeAddressHandler = homeAddressHandler;
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
        if (navLocation != null && navLocation.isPositionValid()) {
            if (this.env.getInputModeManager().getInputMode() == 2) {
                this.logger.log(-2137614336, "Selected location is valid, Saving location as home address.");
                this.val$homeAddressHandler.onCreateEditHomeAddress(navLocation);
                this.getCommandList().commandFinished();
            } else if (this.env.getInputModeManager().getInputMode() == 1) {
                this.logger.log(-2137614336, "Selected location is valid, saving location to contact.");
                ReturnNavLocationToAddressbookSequence returnNavLocationToAddressbookSequence = new ReturnNavLocationToAddressbookSequence(PhonenumberInputSequence.access$500(this.this$0));
                this.getCommandList().commandFinishedWithPostSequence(returnNavLocationToAddressbookSequence.getStartCommandListWithLocation(navLocation));
            } else {
                this.logger.log(-2137614336, "Selected location is valid, Route Guidance is starting");
                PhonenumberInputSequence.access$1000(this.this$0).start(navLocation);
                this.getCommandList().commandFinished();
            }
        } else {
            this.getCommandList().commandAborted("Selected location is invalid.");
        }
    }
}

