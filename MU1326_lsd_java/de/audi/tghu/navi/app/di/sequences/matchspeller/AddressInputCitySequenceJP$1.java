/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCitySequenceJP;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequenceAsia;
import org.dsi.ifc.global.NavLocation;

class AddressInputCitySequenceJP$1
extends NavCommand {
    private final /* synthetic */ AddressInputCitySequenceJP this$0;

    AddressInputCitySequenceJP$1(AddressInputCitySequenceJP addressInputCitySequenceJP, String string) {
        this.this$0 = addressInputCitySequenceJP;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (AddressInputCitySequenceJP.access$000(this.this$0, navLocation)) {
            AddressInputCityZipSequenceAsia.setIsCityCenterSelected(true);
        } else {
            AddressInputCityZipSequenceAsia.setIsCityCenterSelected(false);
        }
        this.getCommandList().commandFinished();
    }
}

