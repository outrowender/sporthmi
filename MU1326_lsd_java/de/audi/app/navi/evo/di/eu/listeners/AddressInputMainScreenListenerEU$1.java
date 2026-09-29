/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.listeners;

import de.audi.app.navi.evo.di.eu.listeners.AddressInputMainScreenListenerEU;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AddressInputMainScreenListenerEU$1
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenListenerEU this$0;

    AddressInputMainScreenListenerEU$1(AddressInputMainScreenListenerEU addressInputMainScreenListenerEU, String string) {
        this.this$0 = addressInputMainScreenListenerEU;
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

