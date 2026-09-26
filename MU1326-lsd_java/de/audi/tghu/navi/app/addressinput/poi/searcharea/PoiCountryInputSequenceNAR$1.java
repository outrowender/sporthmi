/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.searcharea;

import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiCountryInputSequenceNAR;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiCountryInputSequenceNAR$1
extends NavCommand {
    private final /* synthetic */ PoiCountryInputSequenceNAR this$0;

    PoiCountryInputSequenceNAR$1(PoiCountryInputSequenceNAR poiCountryInputSequenceNAR) {
        this.this$0 = poiCountryInputSequenceNAR;
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.selectionCriterionAvailable(1) && this.dsiResponseContainer.selectionCriterionAvailable(138)) {
            this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(1, 138, true, true, true));
        } else if (this.dsiResponseContainer.selectionCriterionAvailable(1)) {
            this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(1, true, true, true));
        } else {
            this.getCommandList().commandAborted("SELCRITDES_COUNTRY_STATE is not available as selection criteria");
        }
    }
}

