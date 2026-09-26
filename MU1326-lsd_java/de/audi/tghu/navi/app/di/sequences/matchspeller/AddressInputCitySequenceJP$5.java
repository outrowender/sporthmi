/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCitySequenceJP;

class AddressInputCitySequenceJP$5
extends NavCommand {
    private final /* synthetic */ AddressInputCitySequenceJP this$0;

    AddressInputCitySequenceJP$5(AddressInputCitySequenceJP addressInputCitySequenceJP, String string) {
        this.this$0 = addressInputCitySequenceJP;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

