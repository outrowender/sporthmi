/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiSearchAreaCityScreenInputSequence$2
extends NavCommand {
    private final /* synthetic */ PoiSearchAreaCityScreenInputSequence this$0;

    PoiSearchAreaCityScreenInputSequence$2(PoiSearchAreaCityScreenInputSequence poiSearchAreaCityScreenInputSequence) {
        this.this$0 = poiSearchAreaCityScreenInputSequence;
    }

    @Override
    public void execute() {
        PoiSearchAreaCityScreenInputSequence.access$100(this.this$0).updateSearchArea(4, this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

