/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputWardSequence;
import org.dsi.ifc.global.NavLocation;

class AddressInputWardSequence$1
extends NavCommand {
    private final /* synthetic */ AddressInputWardSequence this$0;

    AddressInputWardSequence$1(AddressInputWardSequence addressInputWardSequence, String string) {
        this.this$0 = addressInputWardSequence;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (AddressInputWardSequence.access$000(this.this$0, navLocation)) {
            AddressInputWardSequence.setIsWardCenterSelected(true);
        } else {
            AddressInputWardSequence.setIsWardCenterSelected(false);
        }
        this.getCommandList().commandFinished();
    }
}

