/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListManager;
import de.audi.tghu.info.app.tmc.TMCAbstractListRow;
import de.audi.tghu.info.app.tmc.TMCConst;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;

class TMCAbstractListManager$2
extends TMCCommand {
    private final /* synthetic */ TMCAbstractListRow val$inforow;
    private final /* synthetic */ TMCAbstractListManager this$0;

    TMCAbstractListManager$2(TMCAbstractListManager tMCAbstractListManager, AppTMC appTMC, LogChannel logChannel, String string, TMCAbstractListRow tMCAbstractListRow) {
        this.this$0 = tMCAbstractListManager;
        this.val$inforow = tMCAbstractListRow;
        super(appTMC, logChannel, string);
    }

    @Override
    public void execute() {
        this.this$0.lc.log(-2137614336, "TMCAbstractListManager#parentNodeSelected - execute");
        if (this.val$inforow.getTmcListElement().getUID() == this.this$0.getOpenedAnchorId()) {
            this.this$0.setOpenedAnchorId(-1L);
            int n = this.this$0.listModel.getLength();
            this.this$0.listModel.removeAndClose(this.val$inforow.getTmcListElement().getUID(), this.val$inforow.getTmcListElement().numberOfMessagesInNode);
            this.this$0.listModel.setLength(n);
        } else {
            TMCAbstractListRow tMCAbstractListRow;
            if (this.this$0.getOpenedAnchorId() != -1L && (tMCAbstractListRow = (TMCAbstractListRow)this.this$0.listModel.getRowByUniqueID(this.this$0.getOpenedAnchorId())) != null) {
                int n = this.this$0.listModel.getLength();
                this.this$0.listModel.removeAndClose(tMCAbstractListRow.getTmcListElement().getUID(), tMCAbstractListRow.getTmcListElement().numberOfMessagesInNode);
                this.this$0.listModel.setLength(n);
            }
            this.this$0.setOpenedAnchorId(this.val$inforow.getTmcListElement().getUID());
            TMCAbstractListManager.access$002(this.this$0, true);
        }
        long[] lArray = this.this$0.getSurroundingAnchorIds(this.val$inforow.getTmcListElement().getUID());
        this.getCommandList().commandFinishedWithPostCommand(this.this$0.getRequestWindowCommand(lArray, this.this$0.getOpenedAnchorId(), -1, TMCConst.WINDOW_REQUEST_SIZE));
    }
}

