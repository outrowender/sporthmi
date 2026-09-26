/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.listeners;

import de.audi.app.navi.evo.di.nar.listeners.AddressInputCityZipScreenListenerNAR;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputCityZipScreenListenerNAR$2
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ AddressInputCityZipScreenListenerNAR this$0;

    AddressInputCityZipScreenListenerNAR$2(AddressInputCityZipScreenListenerNAR addressInputCityZipScreenListenerNAR, String string, int n, int n2) {
        this.this$0 = addressInputCityZipScreenListenerNAR;
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

