/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;

class AppTMC$2
extends TMCCommand {
    private final /* synthetic */ AppTMC this$0;

    AppTMC$2(AppTMC appTMC, AppTMC appTMC2, LogChannel logChannel, String string) {
        this.this$0 = appTMC;
        super(appTMC2, logChannel, string);
    }

    @Override
    public void execute() {
        this.this$0.listManager.onUpdateEventsTotal();
        this.getCommandList().commandFinished();
    }
}

