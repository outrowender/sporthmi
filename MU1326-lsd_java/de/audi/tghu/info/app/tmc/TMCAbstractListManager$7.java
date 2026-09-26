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

class TMCAbstractListManager$7
extends TMCCommand {
    private final /* synthetic */ boolean val$isPreviewMapPositionRefreshActive;
    private final /* synthetic */ TmcMessage val$focussedMsg;
    private final /* synthetic */ int val$previewMapClientId;
    private final /* synthetic */ TMCAbstractListManager this$0;

    TMCAbstractListManager$7(TMCAbstractListManager tMCAbstractListManager, AppTMC appTMC, LogChannel logChannel, String string, boolean bl, TmcMessage tmcMessage, int n) {
        this.this$0 = tMCAbstractListManager;
        this.val$isPreviewMapPositionRefreshActive = bl;
        this.val$focussedMsg = tmcMessage;
        this.val$previewMapClientId = n;
        super(appTMC, logChannel, string);
    }

    @Override
    public void execute() {
        NavRectangle navRectangle = this.this$0.appTmc.getResponseContainer().getRectangle();
        if (!this.val$isPreviewMapPositionRefreshActive) {
            this.this$0.appTmc.getPreviewMap().setPreviewMapPositionRefreshAllowed(false);
        }
        this.this$0.appTmc.getPreviewMap().setPreviewTrafficInfoTmcEvents(new long[]{this.val$focussedMsg.getMessageID()}, navRectangle, this.val$previewMapClientId, null, null);
        if (!this.val$isPreviewMapPositionRefreshActive) {
            this.this$0.appTmc.getPreviewMap().setPreviewMapPositionRefreshAllowed(true);
        }
        this.getCommandList().commandFinished();
    }
}

