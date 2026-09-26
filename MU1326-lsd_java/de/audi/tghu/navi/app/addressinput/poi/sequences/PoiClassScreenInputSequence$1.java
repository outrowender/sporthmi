/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiStartSpellerAlongRouteCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiClassScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;

class PoiClassScreenInputSequence$1
extends NavCommand {
    private final /* synthetic */ PoiClassScreenInputSequence this$0;

    PoiClassScreenInputSequence$1(PoiClassScreenInputSequence poiClassScreenInputSequence, String string) {
        this.this$0 = poiClassScreenInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        if (this.this$0.poiSearchArea.getSearchContext() == 1) {
            this.getCommandList().commandFinishedWithPostCommand(new PoiStartSpellerAlongRouteCommand(this.this$0.spellerType, Util.isHURegionNAR()));
        } else {
            CommandList commandList = this.this$0.createStartSpellerCommandList(this.this$0.spellerType);
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        }
    }
}

