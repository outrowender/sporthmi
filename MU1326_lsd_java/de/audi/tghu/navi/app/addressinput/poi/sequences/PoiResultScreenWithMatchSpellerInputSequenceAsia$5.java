/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.commands.HidePreviewMapCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithMatchSpellerInputSequenceAsia;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class PoiResultScreenWithMatchSpellerInputSequenceAsia$5
extends NavCommand {
    private final /* synthetic */ PoiResultScreenWithMatchSpellerInputSequenceAsia this$0;

    PoiResultScreenWithMatchSpellerInputSequenceAsia$5(PoiResultScreenWithMatchSpellerInputSequenceAsia poiResultScreenWithMatchSpellerInputSequenceAsia) {
        this.this$0 = poiResultScreenWithMatchSpellerInputSequenceAsia;
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
        if (!navLocation.isPositionValid()) {
            CommandList commandList = this.this$0.commandListFactory.createCommandList();
            commandList.add(new HidePreviewMapCommand(PoiResultScreenWithMatchSpellerInputSequenceAsia.access$000(this.this$0)));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#hidePreviewMap").toString());
        }
        this.this$0.modelAccess.onElementFocused(this.dsiResponseContainer.getSelectedLocation());
        this.getCommandList().commandFinished();
    }
}

