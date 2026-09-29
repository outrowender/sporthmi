/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.city;

import de.audi.tghu.navi.app.addressinput.city.CityZipInputSimpleSequence;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.command.NavCommand;

class CityZipInputSimpleSequence$1
extends NavCommand {
    private final /* synthetic */ CityZipInputSimpleSequence this$0;

    CityZipInputSimpleSequence$1(CityZipInputSimpleSequence cityZipInputSimpleSequence, String string) {
        this.this$0 = cityZipInputSimpleSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand(this.dsiResponseContainer.getLiCurrentLD()));
    }
}

