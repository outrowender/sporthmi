/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.listeners;

import de.audi.app.navi.evo.di.jp.listeners.AddressInputCityScreenListenerJP$1;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputCityScreenListenerJP$1$2
extends NavCommand {
    private final /* synthetic */ AddressInputCityScreenListenerJP$1 this$1;

    AddressInputCityScreenListenerJP$1$2(AddressInputCityScreenListenerJP$1 addressInputCityScreenListenerJP$1, String string) {
        this.this$1 = addressInputCityScreenListenerJP$1;
        super(string);
    }

    @Override
    public void execute() {
        this.env.fireModelEvent(AddressInputCityScreenListenerJP$1.access$100(this.this$1), AddressInputCityScreenListenerJP$1.access$200(this.this$1));
        this.getCommandList().commandFinished();
    }
}

