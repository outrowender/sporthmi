/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info.readout;

import de.audi.app.info.readout.InfoUrgentPopupHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.TmcMessage;

class InfoUrgentPopupHandler$1
extends TMCCommand {
    private final /* synthetic */ TmcMessage val$msg;
    private final /* synthetic */ InfoUrgentPopupHandler this$0;

    InfoUrgentPopupHandler$1(InfoUrgentPopupHandler infoUrgentPopupHandler, AppTMC appTMC, LogChannel logChannel, String string, TmcMessage tmcMessage) {
        this.this$0 = infoUrgentPopupHandler;
        this.val$msg = tmcMessage;
        super(appTMC, logChannel, string);
    }

    @Override
    public void execute() {
        InfoUrgentPopupHandler.access$000(this.this$0).getTMCHandler().getBoundingRectangle(new long[]{this.val$msg.getMessageID()});
    }

    @Override
    public void getBoundingRectangleForTrafficMessagesResult(NavRectangle navRectangle) {
        InfoUrgentPopupHandler.access$100(this.this$0).getResponseContainer().setRectangle(navRectangle);
        this.getCommandList().commandFinished();
    }
}

