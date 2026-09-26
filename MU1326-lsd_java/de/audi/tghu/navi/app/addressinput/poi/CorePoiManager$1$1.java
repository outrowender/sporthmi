/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.tghu.navi.app.addressinput.poi.CorePoiManager;
import de.audi.tghu.navi.app.addressinput.poi.CorePoiManager$1;
import de.audi.tghu.navi.app.command.NavCommand;

class CorePoiManager$1$1
extends NavCommand {
    private final /* synthetic */ CorePoiManager$1 this$1;

    CorePoiManager$1$1(CorePoiManager$1 corePoiManager$1, String string) {
        this.this$1 = corePoiManager$1;
        super(string);
    }

    @Override
    public void execute() {
        CorePoiManager.access$200(CorePoiManager$1.access$100(this.this$1));
        CorePoiManager$1.access$100((CorePoiManager$1)this.this$1).poiSearchAreaSequence.updateSearchArea(0, null);
        this.getCommandList().commandFinished();
    }
}

