/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.listeners;

import de.audi.app.navi.evo.di.jp.listeners.AddressInputChomeScreenListenerJP;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputChomeScreenListenerJP$1;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputChomeScreenListenerJP$1$1
extends NavCommand {
    private final /* synthetic */ AddressInputChomeScreenListenerJP$1 this$1;

    AddressInputChomeScreenListenerJP$1$1(AddressInputChomeScreenListenerJP$1 addressInputChomeScreenListenerJP$1) {
        this.this$1 = addressInputChomeScreenListenerJP$1;
    }

    @Override
    public void execute() {
        AddressInputChomeScreenListenerJP.access$700(AddressInputChomeScreenListenerJP$1.access$600(this.this$1)).getPoiService().startPoiWithSearchContext(4, this.dsiResponseContainer.getLiCurrentLD(), true);
        this.getCommandList().commandFinished();
    }
}

