/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequenceCN;
import org.dsi.ifc.global.NavLocation;

class AddressInputStreetSequenceCN$1
extends NavCommand {
    private final /* synthetic */ AddressInputStreetSequenceCN this$0;

    AddressInputStreetSequenceCN$1(AddressInputStreetSequenceCN addressInputStreetSequenceCN, String string) {
        this.this$0 = addressInputStreetSequenceCN;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (AddressInputStreetSequenceCN.access$000(this.this$0, navLocation)) {
            AddressInputStreetSequenceCN.setIsStreetCenterSelected(true);
        } else {
            AddressInputStreetSequenceCN.setIsStreetCenterSelected(false);
        }
        this.getCommandList().commandFinished();
    }
}

