/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParkingNearDestinationScreenInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParkingNearDestinationScreenInputSequence$1;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class PoiParkingNearDestinationScreenInputSequence$1$1
extends NavCommand {
    private final /* synthetic */ NavLocation val$selectedLocation;
    private final /* synthetic */ PoiParkingNearDestinationScreenInputSequence$1 this$1;

    PoiParkingNearDestinationScreenInputSequence$1$1(PoiParkingNearDestinationScreenInputSequence$1 poiParkingNearDestinationScreenInputSequence$1, NavLocation navLocation) {
        this.this$1 = poiParkingNearDestinationScreenInputSequence$1;
        this.val$selectedLocation = navLocation;
    }

    @Override
    public void execute() {
        if (PoiParkingNearDestinationScreenInputSequence$1.access$000((PoiParkingNearDestinationScreenInputSequence$1)this.this$1).poiSearchArea.getSearchContext() == 1) {
            PoiParkingNearDestinationScreenInputSequence.access$100(PoiParkingNearDestinationScreenInputSequence$1.access$000(this.this$1)).updateNavLocationForAirDistance(null);
        } else {
            PoiParkingNearDestinationScreenInputSequence.access$100(PoiParkingNearDestinationScreenInputSequence$1.access$000(this.this$1)).updateNavLocationForAirDistance(this.val$selectedLocation);
        }
        this.getCommandList().commandFinished();
    }
}

