/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.listeners;

import de.audi.app.navi.evo.di.nar.listeners.AddressInputCityZipScreenListenerNAR;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputCityZipScreenListenerNAR$1
extends NavCommand {
    private final /* synthetic */ AddressInputCityZipScreenListenerNAR this$0;

    AddressInputCityZipScreenListenerNAR$1(AddressInputCityZipScreenListenerNAR addressInputCityZipScreenListenerNAR, String string) {
        this.this$0 = addressInputCityZipScreenListenerNAR;
        super(string);
    }

    @Override
    public void execute() {
        int n = this.dsiResponseContainer.selectionCriterionAvailable(6) ? 1 : 0;
        this.env.getChoiceModel(1260652032).setValue(n);
        this.getCommandList().commandFinished();
    }
}

