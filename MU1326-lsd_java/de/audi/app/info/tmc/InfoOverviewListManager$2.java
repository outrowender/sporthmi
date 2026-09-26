/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info.tmc;

import de.audi.app.info.tmc.InfoOverviewListManager;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;

class InfoOverviewListManager$2
extends TMCCommand {
    private final /* synthetic */ InfoOverviewListManager this$0;

    InfoOverviewListManager$2(InfoOverviewListManager infoOverviewListManager, AppTMC appTMC, LogChannel logChannel, String string) {
        this.this$0 = infoOverviewListManager;
        super(appTMC, logChannel, string);
    }

    @Override
    public void execute() {
        EvoListRow evoListRow = InfoOverviewListManager.access$1600(this.this$0).getRow(0);
        if (this.this$0.getMenuModel() != null && evoListRow != null) {
            this.this$0.getMenuModel().setFocusedItem(InfoOverviewListManager.access$1700(this.this$0).getID(), FocusAdvice.VIEWPORT_SECOND_POSITION, evoListRow.getUniqueID());
            this.this$0.setFocusedRowIndex(0);
        }
        this.getCommandList().commandFinished();
    }
}

