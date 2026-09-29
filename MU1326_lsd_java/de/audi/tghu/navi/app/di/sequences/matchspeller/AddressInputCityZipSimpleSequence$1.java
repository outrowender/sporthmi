/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSimpleSequence;

class AddressInputCityZipSimpleSequence$1
extends NavCommand {
    private final /* synthetic */ AddressInputCityZipSimpleSequence this$0;

    AddressInputCityZipSimpleSequence$1(AddressInputCityZipSimpleSequence addressInputCityZipSimpleSequence) {
        this.this$0 = addressInputCityZipSimpleSequence;
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand(this.env.getContainer().getLiCurrentLD()));
    }
}

