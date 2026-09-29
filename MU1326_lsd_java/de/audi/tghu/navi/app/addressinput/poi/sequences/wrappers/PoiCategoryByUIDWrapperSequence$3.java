/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiCategoryByUIDWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiCategoryByUIDWrapperSequence$3
extends NavCommand {
    private final /* synthetic */ PoiCategoryByUIDWrapperSequence this$0;

    PoiCategoryByUIDWrapperSequence$3(PoiCategoryByUIDWrapperSequence poiCategoryByUIDWrapperSequence, String string) {
        this.this$0 = poiCategoryByUIDWrapperSequence;
        super(string);
    }

    @Override
    public void execute() {
        if (this.this$0.initialSpellerState == null) {
            this.env.getLogChannel().log(1078071040, "[PoiInput] CategoryByUIDWrapperSequence#Invalid sequence state - spellerState is NULL.");
            this.getCommandList().commandAborted("Not Initial Spellerstate available");
        } else {
            if (this.env.getLogChannel().isDebug2()) {
                this.env.getLogChannel().log(14808325, "[PoiInput] CategoryByUIDWrapperSequence#Invalid sequence state - spellerState is OK.");
            }
            this.getCommandList().commandFinishedWithPostCommand(new LIRestoreStateCommand(this.this$0.initialSpellerState));
        }
    }
}

