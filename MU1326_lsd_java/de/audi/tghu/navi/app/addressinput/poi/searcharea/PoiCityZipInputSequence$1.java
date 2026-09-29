/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.searcharea;

import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiCityZipInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiCityZipInputSequence$1
extends NavCommand {
    private final /* synthetic */ PoiCityZipInputSequence this$0;

    PoiCityZipInputSequence$1(PoiCityZipInputSequence poiCityZipInputSequence) {
        this.this$0 = poiCityZipInputSequence;
    }

    @Override
    public void execute() {
        PoiCityZipInputSequence.access$000(this.this$0).setSearchContext(4);
        PoiCityZipInputSequence.access$000(this.this$0).setLocation(this.dsiResponseContainer.getLiCurrentLD());
        PoiCityZipInputSequence.access$100(this.this$0).onUpdateSearchArea(PoiCityZipInputSequence.access$000(this.this$0));
        this.getCommandList().commandFinished();
    }
}

