/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputHouseNumberSequenceAsia;
import org.dsi.ifc.global.NavLocation;

class AddressInputHouseNumberSequenceAsia$1
extends NavCommand {
    private final /* synthetic */ AddressInputHouseNumberSequenceAsia this$0;

    AddressInputHouseNumberSequenceAsia$1(AddressInputHouseNumberSequenceAsia addressInputHouseNumberSequenceAsia, String string) {
        this.this$0 = addressInputHouseNumberSequenceAsia;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (AddressInputHouseNumberSequenceAsia.access$000(this.this$0, navLocation)) {
            AddressInputHouseNumberSequenceAsia.setIsHouseNumberCenterSelected(true);
        } else {
            AddressInputHouseNumberSequenceAsia.setIsHouseNumberCenterSelected(false);
        }
        this.getCommandList().commandFinished();
    }
}

