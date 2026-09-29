/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiManager$4
extends NavCommand {
    private final /* synthetic */ PoiManager this$0;

    PoiManager$4(PoiManager poiManager, String string) {
        this.this$0 = poiManager;
        super(string);
    }

    @Override
    public void execute() {
        PoiManager.access$300(this.this$0).enterRRD(PoiManager.access$200(this.this$0));
        this.getCommandList().commandFinished();
    }
}

