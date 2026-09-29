/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListManager;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;

class TMCAbstractListManager$8
extends TMCCommand {
    private final /* synthetic */ TMCAbstractListManager this$0;

    TMCAbstractListManager$8(TMCAbstractListManager tMCAbstractListManager, AppTMC appTMC, LogChannel logChannel, String string) {
        this.this$0 = tMCAbstractListManager;
        super(appTMC, logChannel, string);
    }

    @Override
    public void execute() {
        this.this$0.appTmc.getPreviewMap().setPreviewAreaAroundCCP(13);
        this.getCommandList().commandFinished();
    }
}

