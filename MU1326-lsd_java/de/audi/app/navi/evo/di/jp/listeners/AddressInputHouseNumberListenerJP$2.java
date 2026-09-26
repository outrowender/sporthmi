/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.listeners;

import de.audi.app.navi.evo.di.jp.listeners.AddressInputHouseNumberListenerJP;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputHouseNumberListenerJP$2
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ AddressInputHouseNumberListenerJP this$0;

    AddressInputHouseNumberListenerJP$2(AddressInputHouseNumberListenerJP addressInputHouseNumberListenerJP, String string, int n, int n2) {
        this.this$0 = addressInputHouseNumberListenerJP;
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

