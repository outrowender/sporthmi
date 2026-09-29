/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiDetailsSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LISpellerData;

class PoiDetailsSequence$3
extends NavCommand {
    private final /* synthetic */ PoiDetailsSequence this$0;

    PoiDetailsSequence$3(PoiDetailsSequence poiDetailsSequence) {
        this.this$0 = poiDetailsSequence;
    }

    @Override
    public void execute() {
        LISpellerData lISpellerData = this.dsiResponseContainer.getSpellerState();
        this.getCommandList().commandFinishedWithPostCommand(new LIRestoreStateCommand(lISpellerData));
    }
}

