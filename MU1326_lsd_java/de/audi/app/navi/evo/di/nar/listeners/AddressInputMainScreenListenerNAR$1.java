/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.listeners;

import de.audi.app.navi.evo.di.nar.listeners.AddressInputMainScreenListenerNAR;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AddressInputMainScreenListenerNAR$1
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenListenerNAR this$0;

    AddressInputMainScreenListenerNAR$1(AddressInputMainScreenListenerNAR addressInputMainScreenListenerNAR, String string) {
        this.this$0 = addressInputMainScreenListenerNAR;
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

