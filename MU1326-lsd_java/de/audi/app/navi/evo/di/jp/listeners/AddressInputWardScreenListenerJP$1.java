/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.listeners;

import de.audi.app.navi.evo.di.jp.listeners.AddressInputWardScreenListenerJP;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputWardScreenListenerJP$1
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ AddressInputWardScreenListenerJP this$0;

    AddressInputWardScreenListenerJP$1(AddressInputWardScreenListenerJP addressInputWardScreenListenerJP, String string, int n, int n2) {
        this.this$0 = addressInputWardScreenListenerJP;
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

