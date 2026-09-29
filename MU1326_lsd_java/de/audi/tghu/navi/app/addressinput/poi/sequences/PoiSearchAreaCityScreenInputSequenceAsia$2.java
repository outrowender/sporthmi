/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiSearchAreaCityScreenInputSequenceAsia;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiSearchAreaCityScreenInputSequenceAsia$2
extends NavCommand {
    private final /* synthetic */ PoiSearchAreaCityScreenInputSequenceAsia this$0;

    PoiSearchAreaCityScreenInputSequenceAsia$2(PoiSearchAreaCityScreenInputSequenceAsia poiSearchAreaCityScreenInputSequenceAsia) {
        this.this$0 = poiSearchAreaCityScreenInputSequenceAsia;
    }

    @Override
    public void execute() {
        if (PoiSearchAreaCityScreenInputSequenceAsia.access$000(this.this$0) == 4 && this.dsiResponseContainer.selectionCriterionAvailable(133) && this.dsiResponseContainer.selectionCriterionAvailable(6)) {
            this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(133, 6, true, true, true));
        } else if ((PoiSearchAreaCityScreenInputSequenceAsia.access$000(this.this$0) == -1 || PoiSearchAreaCityScreenInputSequenceAsia.access$000(this.this$0) == 3) && this.dsiResponseContainer.selectionCriterionAvailable(133) && this.dsiResponseContainer.selectionCriterionAvailable(6)) {
            this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(2, 6, true, true, true));
        } else if ((PoiSearchAreaCityScreenInputSequenceAsia.access$000(this.this$0) == -1 || PoiSearchAreaCityScreenInputSequenceAsia.access$000(this.this$0) == 1) && this.dsiResponseContainer.selectionCriterionAvailable(2)) {
            this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(2, true, true, true));
        } else if ((PoiSearchAreaCityScreenInputSequenceAsia.access$000(this.this$0) == -1 || PoiSearchAreaCityScreenInputSequenceAsia.access$000(this.this$0) == 2) && this.dsiResponseContainer.selectionCriterionAvailable(6)) {
            this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(6, true, true, true));
        } else {
            this.getCommandList().commandAborted("Neither SELCRITDES_TOWN nor SELCRITDES_ZIP_CODE are available as selection criteria");
        }
    }
}

