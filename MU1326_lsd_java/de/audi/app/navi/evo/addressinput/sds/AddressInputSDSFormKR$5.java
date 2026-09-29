/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.sds;

import de.audi.app.navi.evo.addressinput.sds.AddressInputSDSFormKR;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AddressInputSDSFormKR$5
extends NavCommand {
    private final /* synthetic */ AddressInputSDSFormKR this$0;

    AddressInputSDSFormKR$5(AddressInputSDSFormKR addressInputSDSFormKR, String string) {
        this.this$0 = addressInputSDSFormKR;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
        if (navLocation.isPositionValid()) {
            this.dsiResponseContainer.setLiCurrentState(navLocation, new int[0], new int[0]);
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

