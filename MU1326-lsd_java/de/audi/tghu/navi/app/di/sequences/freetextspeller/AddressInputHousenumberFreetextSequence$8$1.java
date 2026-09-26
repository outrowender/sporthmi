/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.freetextspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence$8;

class AddressInputHousenumberFreetextSequence$8$1
extends NavCommand {
    private final /* synthetic */ AddressInputHousenumberFreetextSequence$8 this$1;

    AddressInputHousenumberFreetextSequence$8$1(AddressInputHousenumberFreetextSequence$8 addressInputHousenumberFreetextSequence$8) {
        this.this$1 = addressInputHousenumberFreetextSequence$8;
    }

    @Override
    public void execute() {
        AddressInputHousenumberFreetextSequence$8.access$200((AddressInputHousenumberFreetextSequence$8)this.this$1).modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

