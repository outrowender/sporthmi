/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiStartSpellerAlongRouteCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiMainScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;

class PoiMainScreenInputSequence$1
extends NavCommand {
    private final /* synthetic */ PoiMainScreenInputSequence this$0;

    PoiMainScreenInputSequence$1(PoiMainScreenInputSequence poiMainScreenInputSequence, String string) {
        this.this$0 = poiMainScreenInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        if (this.this$0.poiSearchArea.getSearchContext() == 1) {
            this.getCommandList().commandFinishedWithPostCommand(new PoiStartSpellerAlongRouteCommand(this.this$0.spellerType, Util.isHURegionNAR()));
        } else {
            CommandList commandList = PoiMainScreenInputSequence.access$000(this.this$0, this.this$0.spellerType);
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        }
    }
}

