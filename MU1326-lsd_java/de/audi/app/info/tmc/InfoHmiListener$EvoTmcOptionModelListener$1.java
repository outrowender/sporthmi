/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info.tmc;

import de.audi.app.info.tmc.InfoHmiListener;
import de.audi.app.info.tmc.InfoHmiListener$EvoTmcOptionModelListener;
import de.audi.atip.interapp.maptmc.MapTmcService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListRow;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.TmcListElement;

class InfoHmiListener$EvoTmcOptionModelListener$1
extends TMCCommand {
    private final /* synthetic */ TMCAbstractListRow val$row;
    private final /* synthetic */ InfoHmiListener$EvoTmcOptionModelListener this$1;

    InfoHmiListener$EvoTmcOptionModelListener$1(InfoHmiListener$EvoTmcOptionModelListener infoHmiListener$EvoTmcOptionModelListener, AppTMC appTMC, LogChannel logChannel, TMCAbstractListRow tMCAbstractListRow) {
        this.this$1 = infoHmiListener$EvoTmcOptionModelListener;
        this.val$row = tMCAbstractListRow;
        super(appTMC, logChannel);
    }

    @Override
    public void execute() {
        NavRectangle navRectangle = InfoHmiListener.access$200(InfoHmiListener$EvoTmcOptionModelListener.access$900(this.this$1)).getResponseContainer().getRectangle();
        MapTmcService mapTmcService = InfoHmiListener.access$200(InfoHmiListener$EvoTmcOptionModelListener.access$900(this.this$1)).getMapService();
        TmcListElement tmcListElement = this.val$row.getTmcListElement();
        if (mapTmcService != null) {
            try {
                mapTmcService.showInMap(new long[]{this.val$row.getTmcListElement().getUID()}, navRectangle, tmcListElement);
            }
            catch (Exception exception) {
                this.logger.log(10000, "InfoHmiListener#showTmcEventInMap ERROR = %1", (Throwable)exception);
            }
        } else {
            this.logger.log(10000, "InfoHmiListener#showTmcEventInMap Map can not be called, map is null. ");
        }
        this.getCommandList().commandFinished();
    }
}

