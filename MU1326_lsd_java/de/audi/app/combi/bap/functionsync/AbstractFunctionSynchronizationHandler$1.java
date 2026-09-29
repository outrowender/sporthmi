/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.functionsync;

import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronization;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronizationHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.Monitor;

class AbstractFunctionSynchronizationHandler$1
extends Monitor {
    private final /* synthetic */ AbstractFunctionSynchronizationHandler this$0;

    AbstractFunctionSynchronizationHandler$1(AbstractFunctionSynchronizationHandler abstractFunctionSynchronizationHandler, LogChannel logChannel) {
        this.this$0 = abstractFunctionSynchronizationHandler;
        super(logChannel);
    }

    @Override
    public void epilogue(CommandList commandList) {
        AbstractFunctionSynchronization abstractFunctionSynchronization = (AbstractFunctionSynchronization)commandList;
        AbstractFunctionSynchronizationHandler.access$000(this.this$0, abstractFunctionSynchronization);
        super.epilogue(commandList);
    }
}

