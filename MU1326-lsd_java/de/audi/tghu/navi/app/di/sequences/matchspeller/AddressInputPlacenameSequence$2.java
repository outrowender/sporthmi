/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputPlacenameSequence;
import org.dsi.ifc.global.NavLocation;

class AddressInputPlacenameSequence$2
extends NavCommand {
    private final /* synthetic */ AddressInputPlacenameSequence this$0;

    AddressInputPlacenameSequence$2(AddressInputPlacenameSequence addressInputPlacenameSequence, String string) {
        this.this$0 = addressInputPlacenameSequence;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (AddressInputPlacenameSequence.access$000(this.this$0, navLocation) && !this.dsiResponseContainer.selectionCriterionAvailable(5)) {
            AddressInputPlacenameSequence.setIsPlaceNameCenterSelected(true);
        } else {
            AddressInputPlacenameSequence.setIsPlaceNameCenterSelected(false);
        }
        this.getCommandList().commandFinished();
    }
}

