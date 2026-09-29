/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputTownStreetSequence;
import org.dsi.ifc.global.NavLocation;

class AddressInputTownStreetSequence$1
extends NavCommand {
    private final /* synthetic */ AddressInputTownStreetSequence this$0;

    AddressInputTownStreetSequence$1(AddressInputTownStreetSequence addressInputTownStreetSequence, String string) {
        this.this$0 = addressInputTownStreetSequence;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (AddressInputTownStreetSequence.access$000(this.this$0, navLocation)) {
            AddressInputTownStreetSequence.setIsTownStreetCenterSelected(true);
        } else {
            AddressInputTownStreetSequence.setIsTownStreetCenterSelected(false);
        }
        this.getCommandList().commandFinished();
    }
}

