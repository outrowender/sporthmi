/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputVillageStreetSequence;
import org.dsi.ifc.global.NavLocation;

class AddressInputVillageStreetSequence$1
extends NavCommand {
    private final /* synthetic */ AddressInputVillageStreetSequence this$0;

    AddressInputVillageStreetSequence$1(AddressInputVillageStreetSequence addressInputVillageStreetSequence, String string) {
        this.this$0 = addressInputVillageStreetSequence;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (AddressInputVillageStreetSequence.access$000(this.this$0, navLocation)) {
            AddressInputVillageStreetSequence.setIsVillageStreetCenterSelected(true);
        } else {
            AddressInputVillageStreetSequence.setIsVillageStreetCenterSelected(false);
        }
        this.getCommandList().commandFinished();
    }
}

