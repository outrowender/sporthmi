/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.Monitor;

public abstract class AbstractFunctionSyncEpilogueAction
extends Monitor {
    protected final AbstractBAPModuleFSG module;

    public AbstractFunctionSyncEpilogueAction(AbstractBAPModuleFSG abstractBAPModuleFSG, LogChannel logChannel) {
        super(logChannel);
        this.module = abstractBAPModuleFSG;
    }

    @Override
    public final void epilogue(CommandList commandList) {
        this.execute();
        super.epilogue(commandList);
    }

    protected abstract void execute() {
    }
}

