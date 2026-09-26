/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.cn.listeners;

import de.audi.app.navi.evo.di.cn.listeners.AddressInputStreetScreenListenerCN;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputStreetScreenListenerCN$1
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ AddressInputStreetScreenListenerCN this$0;

    AddressInputStreetScreenListenerCN$1(AddressInputStreetScreenListenerCN addressInputStreetScreenListenerCN, String string, int n, int n2) {
        this.this$0 = addressInputStreetScreenListenerCN;
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

