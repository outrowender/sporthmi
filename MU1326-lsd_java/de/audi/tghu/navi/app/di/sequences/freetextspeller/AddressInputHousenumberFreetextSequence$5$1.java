/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.freetextspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence$5;

class AddressInputHousenumberFreetextSequence$5$1
extends NavCommand {
    private final /* synthetic */ AddressInputHousenumberFreetextSequence$5 this$1;

    AddressInputHousenumberFreetextSequence$5$1(AddressInputHousenumberFreetextSequence$5 addressInputHousenumberFreetextSequence$5, String string) {
        this.this$1 = addressInputHousenumberFreetextSequence$5;
        super(string);
    }

    @Override
    public void execute() {
        AddressInputHousenumberFreetextSequence$5.access$000((AddressInputHousenumberFreetextSequence$5)this.this$1).modelAccess.onHousenumberValid();
        AddressInputHousenumberFreetextSequence$5.access$000((AddressInputHousenumberFreetextSequence$5)this.this$1).modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

