/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequenceNAR;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequenceNAR$3$1;
import org.dsi.ifc.global.NavLocation;

class AddressInputStreetSequenceNAR$3
extends NavCommand {
    private final /* synthetic */ AddressInputStreetSequenceNAR this$0;

    AddressInputStreetSequenceNAR$3(AddressInputStreetSequenceNAR addressInputStreetSequenceNAR) {
        this.this$0 = addressInputStreetSequenceNAR;
    }

    @Override
    public void execute() {
        Object object = this.getCommandList().get("STREET_HISTORY_ENTRY_LOCATION");
        if (object == null || !(object instanceof NavLocation)) {
            this.getCommandList().commandAborted("unexpected Object");
        } else {
            this.getCommandList().commandFinishedWithPostCommand(new AddressInputStreetSequenceNAR$3$1(this, "LispSelectItemFromLocationCommand", object));
        }
    }
}

