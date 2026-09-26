/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.searcharea;

import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiCountryInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiCountryInputSequence$2
extends NavCommand {
    private final /* synthetic */ PoiCountryInputSequence this$0;

    PoiCountryInputSequence$2(PoiCountryInputSequence poiCountryInputSequence) {
        this.this$0 = poiCountryInputSequence;
    }

    @Override
    public void execute() {
        PoiCountryInputSequence.access$000(this.this$0).setLocation(this.dsiResponseContainer.getLiCurrentLD());
        PoiCountryInputSequence.access$000(this.this$0).setSearchContext(5);
        PoiCountryInputSequence.access$100(this.this$0).onUpdateHistoryList();
        this.getCommandList().commandFinished();
    }
}

