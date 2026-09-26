/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.CorePoiManager;
import de.audi.tghu.navi.app.addressinput.poi.CorePoiManager$1$1;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;

class CorePoiManager$1
extends NavCommand {
    private final /* synthetic */ boolean val$isReRouting;
    private final /* synthetic */ CorePoiManager this$0;

    CorePoiManager$1(CorePoiManager corePoiManager, boolean bl) {
        this.this$0 = corePoiManager;
        this.val$isReRouting = bl;
    }

    @Override
    public void execute() {
        int n = this.this$0.poiSearchArea.getSearchContext();
        this.this$0.logChannel.log(-2137614336, "%1#cancelAlongRouteSearch - search area context: %2", (Object)this.CLASS_NAME, (long)n);
        if (CorePoiManager.access$000(this.this$0, n, this.val$isReRouting)) {
            this.this$0.logChannel.log(-2137614336, "%1#cancelAlongRouteSearch - canceling poi screens", (Object)this.CLASS_NAME);
            CommandList commandList = this.this$0.commandListFactory.createCommandList();
            commandList.add(new LISPCancelSpellerCommand());
            commandList.add(new CorePoiManager$1$1(this, "Leave POI Screens"));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else {
            this.this$0.logChannel.log(-2137614336, "%1#cancelAlongRouteSearch - nothing to do because of search area", (Object)this.CLASS_NAME);
            this.getCommandList().commandFinished();
        }
    }

    static /* synthetic */ CorePoiManager access$100(CorePoiManager$1 corePoiManager$1) {
        return corePoiManager$1.this$0;
    }
}

