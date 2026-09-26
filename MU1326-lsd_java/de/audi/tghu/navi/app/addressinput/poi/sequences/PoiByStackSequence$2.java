/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiStartSpellerAlongRouteCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiByStackSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;

class PoiByStackSequence$2
extends NavCommand {
    private final /* synthetic */ PoiByStackSequence this$0;

    PoiByStackSequence$2(PoiByStackSequence poiByStackSequence, String string) {
        this.this$0 = poiByStackSequence;
        super(string);
    }

    @Override
    public void execute() {
        if (this.this$0.searchArea.getSearchContext() == 1) {
            this.getCommandList().commandFinishedWithPostCommand(new PoiStartSpellerAlongRouteCommand(this.this$0.spellerType, Util.isHURegionNAR()));
        } else if (this.this$0.searchArea.getSearchContext() == 5 && this.this$0.spellerType == 0xA800000) {
            CommandList commandList = this.this$0.createStartSpellerCommandList(0x3800000);
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else {
            CommandList commandList = this.this$0.createStartSpellerCommandList(this.this$0.spellerType);
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        }
    }
}

