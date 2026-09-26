/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.listeners;

import de.audi.app.navi.evo.di.eu.listeners.AddressInputMainScreenListenerEU;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputMainScreenListenerEU$2
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ AddressInputMainScreenListenerEU this$0;

    AddressInputMainScreenListenerEU$2(AddressInputMainScreenListenerEU addressInputMainScreenListenerEU, String string, int n, int n2) {
        this.this$0 = addressInputMainScreenListenerEU;
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

