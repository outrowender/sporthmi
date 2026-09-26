/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.listeners;

import de.audi.app.navi.evo.di.jp.listeners.AddressInputHouseNumberListenerJP;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputHouseNumberListenerJP$1
extends NavCommand {
    private final /* synthetic */ AddressInputHouseNumberListenerJP this$0;

    AddressInputHouseNumberListenerJP$1(AddressInputHouseNumberListenerJP addressInputHouseNumberListenerJP) {
        this.this$0 = addressInputHouseNumberListenerJP;
    }

    @Override
    public void execute() {
        AddressInputHouseNumberListenerJP.access$000(this.this$0).getPoiService().startPoiWithSearchContext(4, this.dsiResponseContainer.getLiCurrentLD(), true);
        this.getCommandList().commandFinished();
    }
}

