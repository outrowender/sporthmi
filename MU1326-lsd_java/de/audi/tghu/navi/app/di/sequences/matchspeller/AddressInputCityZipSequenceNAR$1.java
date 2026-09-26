/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequenceNAR;

class AddressInputCityZipSequenceNAR$1
extends NavCommand {
    private final /* synthetic */ AddressInputCityZipSequenceNAR this$0;

    AddressInputCityZipSequenceNAR$1(AddressInputCityZipSequenceNAR addressInputCityZipSequenceNAR, String string) {
        this.this$0 = addressInputCityZipSequenceNAR;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand(this.dsiResponseContainer.getLiCurrentLD()));
    }
}

