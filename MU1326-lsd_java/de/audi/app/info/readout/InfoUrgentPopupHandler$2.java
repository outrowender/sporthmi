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

class InfoUrgentPopupHandler$2
extends TMCCommand {
    private final /* synthetic */ TmcMessage val$msg;
    private final /* synthetic */ InfoUrgentPopupHandler this$0;

    InfoUrgentPopupHandler$2(InfoUrgentPopupHandler infoUrgentPopupHandler, AppTMC appTMC, LogChannel logChannel, TmcMessage tmcMessage) {
        this.this$0 = infoUrgentPopupHandler;
        this.val$msg = tmcMessage;
        super(appTMC, logChannel);
    }

    @Override
    public void execute() {
        NavRectangle navRectangle = InfoUrgentPopupHandler.access$200(this.this$0).getResponseContainer().getRectangle();
        InfoUrgentPopupHandler.access$300(this.this$0).getPreviewMap().setPreviewTrafficInfoTmcEvents(new long[]{this.val$msg.getMessageID()}, navRectangle, 13, null, null);
        this.getCommandList().commandFinished();
    }
}

