/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiManager$3
extends NavCommand {
    private final /* synthetic */ PoiManager this$0;

    PoiManager$3(PoiManager poiManager) {
        this.this$0 = poiManager;
    }

    @Override
    public void execute() {
        this.this$0.startPoiMainScreen(true, false);
        this.getCommandList().commandFinished();
    }
}

