/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCitySequenceJP;
import org.dsi.ifc.global.NavLocation;

class AddressInputCitySequenceJP$4
extends NavCommand {
    private final /* synthetic */ AddressInputCitySequenceJP this$0;

    AddressInputCitySequenceJP$4(AddressInputCitySequenceJP addressInputCitySequenceJP, String string) {
        this.this$0 = addressInputCitySequenceJP;
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

