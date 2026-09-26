/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.info.readout;

import de.audi.app.info.readout.InfoUrgentPopupHandler$1;
import de.audi.app.info.readout.InfoUrgentPopupHandler$2;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.readout.UrgentPopupHandler;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class InfoUrgentPopupHandler
extends UrgentPopupHandler {
    private final BaseListModelApp listModel;

    public InfoUrgentPopupHandler(LogChannel logChannel, InfoEnv infoEnv) {
        super(logChannel, infoEnv);
        this.listModel = infoEnv.getBaseListModel(44173056);
    }

    @Override
    protected boolean showNextPopup() {
        if (!this.msgs.isEmpty()) {
            this.logger.log(-2137614336, "[UrgentPopupHandler#showNextPopup] Urgent messages are available, show them. ");
            TmcMessage tmcMessage = (TmcMessage)this.msgs.remove(0);
            this.logger.log(-2137614336, "[UrgentPopupHandler#showNextPopup] Show message: %1 ", (Object)tmcMessage);
            TmcListElement tmcListElement = new TmcListElement();
            tmcListElement.setMessage(tmcMessage);
            EvoListRow[] evoListRowArray = this.listRowBuilder.buildDetailsList(tmcListElement);
            this.focusPreviewMapOnSingleEvent(tmcMessage);
            this.listModel.removeAll();
            this.listModel.append(evoListRowArray);
            this.msgFilter.setMessageAsShown(tmcMessage);
            return true;
        }
        this.logger.log(-2137614336, "[UrgentPopupHandler#showNextPopup] No messages are available. ");
        return false;
    }

    private void focusPreviewMapOnSingleEvent(TmcMessage tmcMessage) {
        if (this.appTMC == null) {
            this.logger.log(10000, "InfoUrgentPopupHandler#focusPreviewMapOnSingleEvent() appTMC is null");
            return;
        }
        CommandListManager commandListManager = this.appTMC.getCmdListManager();
        CommandList commandList = new CommandList(commandListManager);
        commandList.add(new InfoUrgentPopupHandler$1(this, this.appTMC, this.logger, "InfoUrgentPopupHandler#focusPreviewMapOnSingleEvent", tmcMessage));
        commandList.add(new InfoUrgentPopupHandler$2(this, this.appTMC, this.logger, tmcMessage));
        commandListManager.execute(commandList);
    }

    static /* synthetic */ AppTMC access$000(InfoUrgentPopupHandler infoUrgentPopupHandler) {
        return infoUrgentPopupHandler.appTMC;
    }

    static /* synthetic */ AppTMC access$100(InfoUrgentPopupHandler infoUrgentPopupHandler) {
        return infoUrgentPopupHandler.appTMC;
    }

    static /* synthetic */ AppTMC access$200(InfoUrgentPopupHandler infoUrgentPopupHandler) {
        return infoUrgentPopupHandler.appTMC;
    }

    static /* synthetic */ AppTMC access$300(InfoUrgentPopupHandler infoUrgentPopupHandler) {
        return infoUrgentPopupHandler.appTMC;
    }
}

