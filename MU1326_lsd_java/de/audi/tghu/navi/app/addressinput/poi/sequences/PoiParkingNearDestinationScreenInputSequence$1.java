/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetContextCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParkingNearDestinationScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParkingNearDestinationScreenInputSequence$1$1;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class PoiParkingNearDestinationScreenInputSequence$1
extends NavCommand {
    private final /* synthetic */ PoiParkingNearDestinationScreenInputSequence this$0;

    PoiParkingNearDestinationScreenInputSequence$1(PoiParkingNearDestinationScreenInputSequence poiParkingNearDestinationScreenInputSequence, String string) {
        this.this$0 = poiParkingNearDestinationScreenInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        CommandList commandList = this.this$0.commandListFactory.createCommandList();
        NavLocation navLocation = new NavLocation();
        NavLocation navLocation2 = this.dsiResponseContainer.getSelectedLocation();
        navLocation.longitude = navLocation2.longitude;
        navLocation.latitude = navLocation2.latitude;
        commandList.add(new PoiSetContextCommand(navLocation));
        commandList.add(new PoiParkingNearDestinationScreenInputSequence$1$1(this, navLocation2));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }

    static /* synthetic */ PoiParkingNearDestinationScreenInputSequence access$000(PoiParkingNearDestinationScreenInputSequence$1 poiParkingNearDestinationScreenInputSequence$1) {
        return poiParkingNearDestinationScreenInputSequence$1.this$0;
    }
}

