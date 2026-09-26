/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequenceAsia;
import org.dsi.ifc.global.NavLocation;

class AddressInputCityZipSequenceAsia$1
extends NavCommand {
    private final /* synthetic */ AddressInputCityZipSequenceAsia this$0;

    AddressInputCityZipSequenceAsia$1(AddressInputCityZipSequenceAsia addressInputCityZipSequenceAsia, String string) {
        this.this$0 = addressInputCityZipSequenceAsia;
        super(string);
    }

    @Override
    public void execute() {
        Object object = this.getCommandList().get("NavLocation from History");
        if (object instanceof NavLocation) {
            this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand((NavLocation)object));
        } else {
            this.getCommandList().commandAborted("unexpected Object");
        }
    }
}

