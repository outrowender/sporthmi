/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.nospeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.nospeller.AddressInputMainScreenSequenceNAR;

class AddressInputMainScreenSequenceNAR$2
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenSequenceNAR this$0;

    AddressInputMainScreenSequenceNAR$2(AddressInputMainScreenSequenceNAR addressInputMainScreenSequenceNAR) {
        this.this$0 = addressInputMainScreenSequenceNAR;
    }

    @Override
    public void execute() {
        this.this$0.inputManager.setBackupLocation(this.dsiResponseContainer.getLiCurrentLD());
        this.this$0.modelAccessToUse.onStart(this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

