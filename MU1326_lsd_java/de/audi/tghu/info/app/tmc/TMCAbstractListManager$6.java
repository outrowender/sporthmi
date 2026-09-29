/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListManager;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.TmcMessage;

class TMCAbstractListManager$6
extends TMCCommand {
    private final /* synthetic */ TmcMessage val$focussedMsg;
    private final /* synthetic */ TMCAbstractListManager this$0;

    TMCAbstractListManager$6(TMCAbstractListManager tMCAbstractListManager, AppTMC appTMC, LogChannel logChannel, String string, TmcMessage tmcMessage) {
        this.this$0 = tMCAbstractListManager;
        this.val$focussedMsg = tmcMessage;
        super(appTMC, logChannel, string);
    }

    @Override
    public void execute() {
        this.this$0.showInMapAvailableChoice.setValue(1);
        this.this$0.appTmc.getTMCHandler().getBoundingRectangle(new long[]{this.val$focussedMsg.getMessageID()});
    }

    @Override
    public void getBoundingRectangleForTrafficMessagesResult(NavRectangle navRectangle) {
        this.this$0.appTmc.getResponseContainer().setRectangle(navRectangle);
        this.getCommandList().commandFinished();
    }
}

