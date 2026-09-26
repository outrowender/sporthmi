/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiManager$1
extends NavCommand {
    private final /* synthetic */ PoiManager this$0;

    PoiManager$1(PoiManager poiManager, String string) {
        this.this$0 = poiManager;
        super(string);
    }

    @Override
    public void execute() {
        PoiManager.access$000(this.this$0);
        this.getCommandList().commandFinished();
    }
}

