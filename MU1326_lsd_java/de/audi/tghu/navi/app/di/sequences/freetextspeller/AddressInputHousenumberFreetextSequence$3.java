/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.freetextspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence;

class AddressInputHousenumberFreetextSequence$3
extends NavCommand {
    private final /* synthetic */ AddressInputHousenumberFreetextSequence this$0;

    AddressInputHousenumberFreetextSequence$3(AddressInputHousenumberFreetextSequence addressInputHousenumberFreetextSequence, String string) {
        this.this$0 = addressInputHousenumberFreetextSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.modelAccess.onStart(this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

