/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequenceAsia;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiSearchAreaCityScreenInputSequenceAsia$3
extends NavCommand {
    private final /* synthetic */ PoiSearchAreaCityScreenInputSequenceAsia this$0;

    PoiSearchAreaCityScreenInputSequenceAsia$3(PoiSearchAreaCityScreenInputSequenceAsia poiSearchAreaCityScreenInputSequenceAsia) {
        this.this$0 = poiSearchAreaCityScreenInputSequenceAsia;
    }

    @Override
    public void execute() {
        PoiSearchAreaCityScreenInputSequenceAsia.access$100(this.this$0).updateSearchArea(4, this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

