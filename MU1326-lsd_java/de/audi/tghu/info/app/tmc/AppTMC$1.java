/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;

class AppTMC$1
extends TMCCommand {
    private final /* synthetic */ AppTMC this$0;

    AppTMC$1(AppTMC appTMC, AppTMC appTMC2, LogChannel logChannel, String string) {
        this.this$0 = appTMC;
        super(appTMC2, logChannel, string);
    }

    @Override
    public void execute() {
        TiledListModelApp tiledListModelApp = this.this$0.listManager.getListModel();
        EvoListRow evoListRow = tiledListModelApp.getRow(0);
        if (this.this$0.listManager.getMenuModel() != null && evoListRow != null) {
            this.this$0.listManager.getMenuModel().setFocusedItem(tiledListModelApp.getID(), FocusAdvice.VIEWPORT_SECOND_POSITION, evoListRow.getUniqueID());
            this.this$0.listManager.setFocusedRowIndex(0);
        }
        this.getCommandList().commandFinished();
    }
}

