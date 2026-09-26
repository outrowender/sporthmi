/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.listener;

import de.audi.app.navi.evo.di.kr.listener.AddressInputCityScreenListenerKR$1;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputCityScreenListenerKR$1$2
extends NavCommand {
    private final /* synthetic */ AddressInputCityScreenListenerKR$1 this$1;

    AddressInputCityScreenListenerKR$1$2(AddressInputCityScreenListenerKR$1 addressInputCityScreenListenerKR$1, String string) {
        this.this$1 = addressInputCityScreenListenerKR$1;
        super(string);
    }

    @Override
    public void execute() {
        this.env.fireModelEvent(AddressInputCityScreenListenerKR$1.access$100(this.this$1), AddressInputCityScreenListenerKR$1.access$200(this.this$1));
        this.getCommandList().commandFinished();
    }
}

