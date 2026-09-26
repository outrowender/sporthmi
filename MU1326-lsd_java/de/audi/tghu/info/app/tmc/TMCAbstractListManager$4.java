/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListManager;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;
import org.dsi.ifc.global.NavRectangle;

class TMCAbstractListManager$4
extends TMCCommand {
    private final /* synthetic */ TMCAbstractListManager this$0;

    TMCAbstractListManager$4(TMCAbstractListManager tMCAbstractListManager, AppTMC appTMC, LogChannel logChannel, String string) {
        this.this$0 = tMCAbstractListManager;
        super(appTMC, logChannel, string);
    }

    @Override
    public void execute() {
        NavRectangle navRectangle = this.this$0.appTmc.getResponseContainer().getRectangle();
        this.this$0.appTmc.getPreviewMap().setPreviewTrafficInfoTmcEvents(this.tmcApp.getResponseContainer().getChildrenTrafficEvents(), navRectangle, 13, null, null);
        this.getCommandList().commandFinished();
    }
}

