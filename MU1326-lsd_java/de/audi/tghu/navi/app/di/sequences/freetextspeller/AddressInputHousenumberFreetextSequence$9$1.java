/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.freetextspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence$9;

class AddressInputHousenumberFreetextSequence$9$1
extends NavCommand {
    private final /* synthetic */ AddressInputHousenumberFreetextSequence$9 this$1;

    AddressInputHousenumberFreetextSequence$9$1(AddressInputHousenumberFreetextSequence$9 addressInputHousenumberFreetextSequence$9) {
        this.this$1 = addressInputHousenumberFreetextSequence$9;
    }

    @Override
    public void execute() {
        AddressInputHousenumberFreetextSequence$9.access$300((AddressInputHousenumberFreetextSequence$9)this.this$1).modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

