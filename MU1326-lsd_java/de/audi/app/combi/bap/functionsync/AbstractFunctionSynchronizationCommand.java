/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronization;
import de.audi.tghu.command.Command;

public abstract class AbstractFunctionSynchronizationCommand
extends Command {
    protected final AbstractBAPModuleFSG moduleFsg;
    protected AbstractFunctionSynchronization functionSync;

    public AbstractFunctionSynchronizationCommand(AbstractBAPModuleFSG abstractBAPModuleFSG, AbstractFunctionSynchronization abstractFunctionSynchronization, String string) {
        super(abstractBAPModuleFSG.getLogChannel(), string);
        this.moduleFsg = abstractBAPModuleFSG;
        this.functionSync = abstractFunctionSynchronization;
    }
}

