/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.listener;

import de.audi.app.navi.evo.di.kr.listener.AddressInputTownStreetScreenListenerKR;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputTownStreetScreenListenerKR$3
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ AddressInputTownStreetScreenListenerKR this$0;

    AddressInputTownStreetScreenListenerKR$3(AddressInputTownStreetScreenListenerKR addressInputTownStreetScreenListenerKR, String string, int n, int n2) {
        this.this$0 = addressInputTownStreetScreenListenerKR;
        this.val$model = n;
        this.val$terminal = n2;
        super(string);
    }

    @Override
    public void execute() {
        this.env.fireModelEvent(this.val$model, this.val$terminal);
        this.getCommandList().commandFinished();
    }
}

