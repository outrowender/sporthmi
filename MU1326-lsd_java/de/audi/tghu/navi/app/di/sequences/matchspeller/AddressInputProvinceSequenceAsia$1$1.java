/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.LISetCountryForCityAndStreetHistoryCommand;
import de.audi.tghu.navi.app.command.LiLastStateHistoryAddCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputProvinceSequenceAsia$1;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

class AddressInputProvinceSequenceAsia$1$1
extends NavCommand {
    private final /* synthetic */ AddressInputProvinceSequenceAsia$1 this$1;

    AddressInputProvinceSequenceAsia$1$1(AddressInputProvinceSequenceAsia$1 addressInputProvinceSequenceAsia$1) {
        this.this$1 = addressInputProvinceSequenceAsia$1;
    }

    @Override
    public void execute() {
        NavLocation navLocation = (NavLocation)this.getCommandList().get("STRIPPED_LOCATION");
        CommandList commandList = AddressInputProvinceSequenceAsia$1.access$000((AddressInputProvinceSequenceAsia$1)this.this$1).commandListFactory.createCommandList();
        commandList.add(new LISetCountryForCityAndStreetHistoryCommand(LocationFormatter.formatState(navLocation)));
        commandList.add(new LiLastStateHistoryAddCommand(navLocation, false, LocationFormatter.formatState(navLocation)));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

