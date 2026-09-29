/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.listeners;

import de.audi.app.navi.evo.di.eu.listeners.AddressInputMainScreenListenerEU;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AddressInputMainScreenListenerEU$3
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenListenerEU this$0;

    AddressInputMainScreenListenerEU$3(AddressInputMainScreenListenerEU addressInputMainScreenListenerEU, String string) {
        this.this$0 = addressInputMainScreenListenerEU;
        super(string);
    }

    @Override
    public void execute() {
        Object object = this.getCommandList().get("NavLocation from History");
        if (object != null && object instanceof NavLocation) {
            AddressInputMainScreenListenerEU.access$000(this.this$0).setPreviewLocationCity((NavLocation)object, 1, null, null);
        }
        this.getCommandList().commandFinished();
    }
}

