/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputPlacenameSequence;

class AddressInputPlacenameSequence$1
extends NavCommand {
    private final /* synthetic */ AddressInputPlacenameSequence this$0;

    AddressInputPlacenameSequence$1(AddressInputPlacenameSequence addressInputPlacenameSequence, String string) {
        this.this$0 = addressInputPlacenameSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

