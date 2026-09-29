/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.command.LISetCountryForCityAndStreetHistoryCommand;
import de.audi.tghu.navi.app.command.LiLastStateHistoryAddCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputProvinceSequenceAsia;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

class AddressInputProvinceSequenceAsia$3
extends NavCommand {
    private final /* synthetic */ AddressInputProvinceSequenceAsia this$0;

    AddressInputProvinceSequenceAsia$3(AddressInputProvinceSequenceAsia addressInputProvinceSequenceAsia, String string) {
        this.this$0 = addressInputProvinceSequenceAsia;
        super(string);
    }

    @Override
    public void execute() {
        Object object = this.getCommandList().get("NavLocation from History");
        if (object instanceof NavLocation) {
            NavLocation navLocation = (NavLocation)object;
            CommandList commandList = this.this$0.commandListFactory.createCommandList();
            commandList.add(new LISetCountryForCityAndStreetHistoryCommand(LocationFormatter.formatState(navLocation)));
            commandList.add(new LiLastStateHistoryAddCommand(navLocation, false, LocationFormatter.formatState(navLocation)));
            commandList.add(new LISetCurrentLDCommand(navLocation));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else {
            this.getCommandList().commandAborted("unexpected Object");
        }
    }
}

