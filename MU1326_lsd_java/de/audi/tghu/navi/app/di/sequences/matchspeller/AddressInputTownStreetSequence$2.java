/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputTownStreetSequence;

class AddressInputTownStreetSequence$2
extends NavCommand {
    private final /* synthetic */ AddressInputTownStreetSequence this$0;

    AddressInputTownStreetSequence$2(AddressInputTownStreetSequence addressInputTownStreetSequence, String string) {
        this.this$0 = addressInputTownStreetSequence;
        super(string);
    }

    @Override
    public void execute() {
        if (!this.dsiResponseContainer.selectionCriterionAvailable(151) || !this.dsiResponseContainer.refinementCriterionAvailable(151)) {
            this.this$0.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
        } else {
            this.this$0.modelAccess.onAmbiguousElementSelected();
        }
        this.getCommandList().commandFinished();
    }
}

