/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiDetailScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiDetailScreenInputSequence$2
extends NavCommand {
    private final /* synthetic */ PoiDetailScreenInputSequence this$0;

    PoiDetailScreenInputSequence$2(PoiDetailScreenInputSequence poiDetailScreenInputSequence, String string) {
        this.this$0 = poiDetailScreenInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        PoiDetailScreenInputSequence.access$000(this.this$0).onUpdateLocation(this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

