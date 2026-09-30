/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info.readout;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;
import de.audi.tghu.info.app.tmc.readout.UrgentPopupHandler;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class InfoUrgentPopupHandler
extends UrgentPopupHandler {
    private final BaseListModelApp listModel;

    public InfoUrgentPopupHandler(LogChannel logChannel, InfoEnv infoEnv) {
        super(logChannel, infoEnv);
        this.listModel = infoEnv.getBaseListModel(500226);
    }

    protected boolean showNextPopup() {
        if (!this.msgs.isEmpty()) {
            this.logger.log(10000000, "[UrgentPopupHandler#showNextPopup] Urgent messages are available, show them. ");
            TmcMessage tmcMessage = (TmcMessage)this.msgs.remove(0);
            this.logger.log(10000000, "[UrgentPopupHandler#showNextPopup] Show message: %1 ", (Object)tmcMessage);
            TmcListElement tmcListElement = new TmcListElement();
            tmcListElement.setMessage(tmcMessage);
            EvoListRow[] evoListRowArray = this.listRowBuilder.buildDetailsList(tmcListElement);
            this.focusPreviewMapOnSingleEvent(tmcMessage);
            this.listModel.removeAll();
            this.listModel.append(evoListRowArray);
            this.msgFilter.setMessageAsShown(tmcMessage);
            return true;
        }
        this.logger.log(10000000, "[UrgentPopupHandler#showNextPopup] No messages are available. ");
        return false;
    }

    private void focusPreviewMapOnSingleEvent(final TmcMessage tmcMessage) {
        if (this.appTMC == null) {
            this.logger.log(10000, "InfoUrgentPopupHandler#focusPreviewMapOnSingleEvent() appTMC is null");
            return;
        }
        CommandListManager commandListManager = this.appTMC.getCmdListManager();
        CommandList commandList = new CommandList(commandListManager);
        commandList.add(new TMCCommand(this.appTMC, this.logger, "InfoUrgentPopupHandler#focusPreviewMapOnSingleEvent"){

            public void execute() {
                InfoUrgentPopupHandler.this.appTMC.getTMCHandler().getBoundingRectangle(new long[]{tmcMessage.getMessageID()});
            }

            public void getBoundingRectangleForTrafficMessagesResult(NavRectangle navRectangle) {
                InfoUrgentPopupHandler.this.appTMC.getResponseContainer().setRectangle(navRectangle);
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new TMCCommand(this.appTMC, this.logger){

            public void execute() {
                NavRectangle navRectangle = InfoUrgentPopupHandler.this.appTMC.getResponseContainer().getRectangle();
                InfoUrgentPopupHandler.this.appTMC.getPreviewMap().setPreviewTrafficInfoTmcEvents(new long[]{tmcMessage.getMessageID()}, navRectangle, 13, null, null);
                this.getCommandList().commandFinished();
            }
        });
        commandListManager.execute(commandList);
    }
}

