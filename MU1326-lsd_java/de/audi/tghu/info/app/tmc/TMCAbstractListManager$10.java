/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.AppTMC;
import de.audi.tghu.info.app.tmc.TMCAbstractListManager;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;

class TMCAbstractListManager$10
extends TMCCommand {
    private final /* synthetic */ int val$length;
    private final /* synthetic */ TMCAbstractListManager this$0;

    TMCAbstractListManager$10(TMCAbstractListManager tMCAbstractListManager, AppTMC appTMC, LogChannel logChannel, String string, int n) {
        this.this$0 = tMCAbstractListManager;
        this.val$length = n;
        super(appTMC, logChannel, string);
    }

    @Override
    public void execute() {
        this.this$0.lc.log(-2137614336, "%1#setListLength(%2) execute", (Object)TMCAbstractListManager.access$200(), (long)this.val$length);
        this.this$0.listModel.setLength(this.val$length);
        this.this$0.onUpdateEventsTotal();
        this.getCommandList().commandFinished();
    }
}

