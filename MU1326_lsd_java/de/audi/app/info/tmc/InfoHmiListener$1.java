/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info.tmc;

import de.audi.app.info.tmc.InfoHmiListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;

class InfoHmiListener$1
extends TMCCommand {
    private final /* synthetic */ InfoHmiListener this$0;

    InfoHmiListener$1(InfoHmiListener infoHmiListener, AppTMC appTMC, LogChannel logChannel, String string) {
        this.this$0 = infoHmiListener;
        super(appTMC, logChannel, string);
    }

    @Override
    public void execute() {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "InfoHmiListener#itemFocused hidePreviewMap");
        }
        InfoHmiListener.access$200(this.this$0).getPreviewMap().hidePreviewMap();
        InfoHmiListener.access$300(this.this$0).setFocusedRowIndex(-1);
        this.getCommandList().commandFinished();
    }
}

