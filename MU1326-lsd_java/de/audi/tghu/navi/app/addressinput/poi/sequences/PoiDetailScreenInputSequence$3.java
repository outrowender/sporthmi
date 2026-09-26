/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiDetailScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class PoiDetailScreenInputSequence$3
extends NavCommand {
    private final /* synthetic */ PoiDetailScreenInputSequence this$0;

    PoiDetailScreenInputSequence$3(PoiDetailScreenInputSequence poiDetailScreenInputSequence, String string) {
        this.this$0 = poiDetailScreenInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        PoiDetailScreenInputSequence.access$100(this.this$0).setPreviewPOIsOnboard(new NavLocation[]{this.dsiResponseContainer.getLiCurrentLD()}, 1, null, null);
        this.getCommandList().commandFinished();
    }
}

