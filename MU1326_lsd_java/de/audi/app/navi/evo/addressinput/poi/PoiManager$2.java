/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiManager$2
extends NavCommand {
    private final /* synthetic */ boolean val$hideSearchArea;
    private final /* synthetic */ PoiManager this$0;

    PoiManager$2(PoiManager poiManager, String string, boolean bl) {
        this.this$0 = poiManager;
        this.val$hideSearchArea = bl;
        super(string);
    }

    @Override
    public void execute() {
        PoiManager.access$100(this.this$0);
        if (this.val$hideSearchArea) {
            this.this$0.hideSearchArea();
        } else {
            this.this$0.showSearchArea();
        }
        this.getCommandList().commandFinished();
    }
}

