/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$14;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class PhonenumberInputSequence$14$1
extends NavCommand {
    private final /* synthetic */ PhonenumberInputSequence$14 this$1;

    PhonenumberInputSequence$14$1(PhonenumberInputSequence$14 phonenumberInputSequence$14, String string) {
        this.this$1 = phonenumberInputSequence$14;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
        if (navLocation != null && navLocation.isPositionValid()) {
            this.logger.log(-2137614336, "NavLocation is valid, show Detail screen");
            this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand(navLocation));
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

