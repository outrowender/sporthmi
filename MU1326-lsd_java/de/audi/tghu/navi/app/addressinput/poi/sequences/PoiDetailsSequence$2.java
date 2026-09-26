/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiDetailsSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiDetailsSequence$2
extends NavCommand {
    private final /* synthetic */ PoiDetailsSequence this$0;

    PoiDetailsSequence$2(PoiDetailsSequence poiDetailsSequence, String string) {
        this.this$0 = poiDetailsSequence;
        super(string);
    }

    @Override
    public void execute() {
        PoiDetailsSequence.access$000(this.this$0).enterDetailsScreen(this.dsiResponseContainer.getLiCurrentLD());
        this.getCommandList().commandFinished();
    }
}

