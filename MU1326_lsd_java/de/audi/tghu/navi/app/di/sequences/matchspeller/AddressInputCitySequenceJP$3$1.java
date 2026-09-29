/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.LiLastCityOrStreetHistoryAddCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCitySequenceJP$3;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

class AddressInputCitySequenceJP$3$1
extends NavCommand {
    private final /* synthetic */ AddressInputCitySequenceJP$3 this$1;

    AddressInputCitySequenceJP$3$1(AddressInputCitySequenceJP$3 addressInputCitySequenceJP$3) {
        this.this$1 = addressInputCitySequenceJP$3;
    }

    @Override
    public void execute() {
        NavLocation navLocation = (NavLocation)this.getCommandList().get("STRIPPED_LOCATION");
        this.getCommandList().commandFinishedWithPostCommand(new LiLastCityOrStreetHistoryAddCommand(navLocation, false, LocationFormatter.formatCityTitleWithoutCityCenter(navLocation)));
    }
}

