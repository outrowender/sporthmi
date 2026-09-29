/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiStartSpellerAlongRouteCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParkingNearDestinationScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiParkingNearDestinationScreenInputSequence$2
extends NavCommand {
    private final /* synthetic */ PoiParkingNearDestinationScreenInputSequence this$0;

    PoiParkingNearDestinationScreenInputSequence$2(PoiParkingNearDestinationScreenInputSequence poiParkingNearDestinationScreenInputSequence, String string) {
        this.this$0 = poiParkingNearDestinationScreenInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        if (this.this$0.poiSearchArea.getSearchContext() == 1) {
            this.getCommandList().commandFinishedWithPostCommand(new PoiStartSpellerAlongRouteCommand(0x9800000, false));
        } else {
            this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(0x9800000, false, false, false));
        }
    }
}

