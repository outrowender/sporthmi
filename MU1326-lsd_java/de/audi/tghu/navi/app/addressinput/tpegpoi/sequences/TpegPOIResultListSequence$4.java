/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi.sequences;

import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToAddressbookSequence;
import de.audi.tghu.navi.app.addressinput.tpegpoi.sequences.TpegPOIResultListSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class TpegPOIResultListSequence$4
extends NavCommand {
    private final /* synthetic */ HomeAddressHandler val$homeAddressHandler;
    private final /* synthetic */ TpegPOIResultListSequence this$0;

    TpegPOIResultListSequence$4(TpegPOIResultListSequence tpegPOIResultListSequence, String string, HomeAddressHandler homeAddressHandler) {
        this.this$0 = tpegPOIResultListSequence;
        this.val$homeAddressHandler = homeAddressHandler;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
        if (navLocation.isPositionValid()) {
            if (this.env.getInputModeManager().getInputMode() == 2) {
                this.logger.log(-2137614336, "Selected location is valid, Saving location as home address.");
                this.val$homeAddressHandler.onCreateEditHomeAddress(navLocation);
                this.getCommandList().commandFinished();
            } else if (this.env.getInputModeManager().getInputMode() == 1) {
                this.logger.log(-2137614336, "Selected location is valid, saving location to contact.");
                ReturnNavLocationToAddressbookSequence returnNavLocationToAddressbookSequence = new ReturnNavLocationToAddressbookSequence(this.this$0.commandListFactory);
                this.getCommandList().commandFinishedWithPostSequence(returnNavLocationToAddressbookSequence.getStartCommandListWithLocation(navLocation));
            } else {
                this.logger.log(-2137614336, "Selected location is valid, Route Guidance is starting");
                this.getCommandList().commandFinishedWithPostSequence(TpegPOIResultListSequence.access$200(this.this$0).getStartSequence(navLocation));
            }
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

