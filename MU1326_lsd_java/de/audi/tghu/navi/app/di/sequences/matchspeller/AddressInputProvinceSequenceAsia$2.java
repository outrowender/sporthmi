/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputProvinceSequenceAsia;
import org.dsi.ifc.global.NavLocation;

class AddressInputProvinceSequenceAsia$2
extends NavCommand {
    private final /* synthetic */ AddressInputProvinceSequenceAsia this$0;

    AddressInputProvinceSequenceAsia$2(AddressInputProvinceSequenceAsia addressInputProvinceSequenceAsia, String string) {
        this.this$0 = addressInputProvinceSequenceAsia;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = (NavLocation)this.getCommandList().get("STRIPPED_LOCATION");
        this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand(navLocation));
    }
}

