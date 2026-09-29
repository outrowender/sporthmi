/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequenceNAR;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequenceNAR$4$1;
import org.dsi.ifc.global.NavLocation;

class AddressInputCityZipSequenceNAR$4
extends NavCommand {
    private final /* synthetic */ AddressInputCityZipSequenceNAR this$0;

    AddressInputCityZipSequenceNAR$4(AddressInputCityZipSequenceNAR addressInputCityZipSequenceNAR) {
        this.this$0 = addressInputCityZipSequenceNAR;
    }

    @Override
    public void execute() {
        Object object = this.getCommandList().get("NavLocation from History");
        if (object == null || !(object instanceof NavLocation)) {
            this.getCommandList().commandAborted("unexpected Object");
        } else {
            this.getCommandList().commandFinishedWithPostCommand(new AddressInputCityZipSequenceNAR$4$1(this, "LispSelectItemFromLocationCommand", object));
        }
    }
}

