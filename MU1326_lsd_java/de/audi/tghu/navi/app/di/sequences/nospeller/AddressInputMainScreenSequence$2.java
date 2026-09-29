/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.nospeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.nospeller.AddressInputMainScreenSequence;

class AddressInputMainScreenSequence$2
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenSequence this$0;

    AddressInputMainScreenSequence$2(AddressInputMainScreenSequence addressInputMainScreenSequence) {
        this.this$0 = addressInputMainScreenSequence;
    }

    @Override
    public void execute() {
        this.this$0.inputManager.setBackupLocation(this.dsiResponseContainer.getLiCurrentLD());
        this.this$0.modelAccessToUse.onStart(this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

