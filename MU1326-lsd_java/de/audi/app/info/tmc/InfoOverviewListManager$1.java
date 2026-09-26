/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info.tmc;

import de.audi.app.info.tmc.InfoOverviewListManager;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListRow;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;

class InfoOverviewListManager$1
extends TMCCommand {
    private final /* synthetic */ InfoOverviewListManager this$0;

    InfoOverviewListManager$1(InfoOverviewListManager infoOverviewListManager, AppTMC appTMC, LogChannel logChannel, String string) {
        this.this$0 = infoOverviewListManager;
        super(appTMC, logChannel, string);
    }

    @Override
    public void execute() {
        int n = InfoOverviewListManager.access$100(this.this$0).getIndexForUniqueID(InfoOverviewListManager.access$000(this.this$0));
        InfoOverviewListManager.access$400(this.this$0).log(-2137614336, "%1#loadNextDetailsScreen() execute with lastSelectedNodeId=%2 (%3)", (Object)InfoOverviewListManager.access$200(), InfoOverviewListManager.access$300(this.this$0), (long)n);
        if (n == -1 || n >= InfoOverviewListManager.access$500(this.this$0).getLength() - 1) {
            InfoOverviewListManager.access$700(this.this$0).log(1078071040, "%1#loadNextDetailsScreen() lastSelectedNodeId: %2, end of list reached", (Object)InfoOverviewListManager.access$200(), InfoOverviewListManager.access$600(this.this$0));
            this.getCommandList().commandFinished();
            return;
        }
        if (!InfoOverviewListManager.access$800(this.this$0, n)) {
            TMCAbstractListRow tMCAbstractListRow = (TMCAbstractListRow)InfoOverviewListManager.access$900(this.this$0).getRow(n);
            if (tMCAbstractListRow == null) {
                InfoOverviewListManager.access$1100(this.this$0).log(-1601830656, "%1#loadNextDetailsScreen() lastSelectedNodeId: %2 is not valid", (Object)InfoOverviewListManager.access$200(), InfoOverviewListManager.access$1000(this.this$0));
                InfoOverviewListManager.access$1200(this.this$0).setStatus(0);
                this.getCommandList().commandFinished();
                return;
            }
            InfoOverviewListManager.access$1400(this.this$0).log(14808325, "%1#loadNextDetailsScreen() lastSelectedNodeId: %2 and next node are valid, we need a next request", (Object)InfoOverviewListManager.access$200(), InfoOverviewListManager.access$1300(this.this$0));
            this.getCommandList().commandFinishedWithPostSequence(InfoOverviewListManager.access$1500(this.this$0, tMCAbstractListRow.getTmcListElement().uID, n));
        } else {
            this.this$0.updateDetailsScreen();
            this.getCommandList().commandFinished();
        }
    }
}

