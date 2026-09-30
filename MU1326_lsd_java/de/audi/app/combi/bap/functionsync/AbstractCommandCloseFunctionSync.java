/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronization;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronizationCommand;
import de.vw.mib.bap.requests.StatusProperty;

public abstract class AbstractCommandCloseFunctionSync
extends AbstractFunctionSynchronizationCommand
implements IAcknowledgeListener {
    public AbstractCommandCloseFunctionSync(AbstractBAPModuleFSG abstractBAPModuleFSG, AbstractFunctionSynchronization abstractFunctionSynchronization) {
        super(abstractBAPModuleFSG, abstractFunctionSynchronization, "CommandCloseFunctionSync");
    }

    public void execute() {
        this.logger.log(10000000, "[AbstractCommandCloseFunctionSync#execute] [%1] start command", (Object)this.functionSync.getSyncTypeDescription());
        this.functionSync.getFctSyncProperty().addAcknowledgeListener(this);
        this.functionSync.setSyncState(3);
        this.functionSync.getFctSyncProperty().sendStatusIfChanged(this.createFunctionSynchronizationStatus());
    }

    public void abort() {
        this.removeAllListeners();
        super.abort();
    }

    public void processAcknowledge(int n, int n2) {
        this.logger.log(10000000, "[AbstractCommandCloseFunctionSync#processAcknowledge] [%1] fctID=%2, acknowledgeType=%3", (Object)this.functionSync.getSyncTypeDescription(), (long)n, (long)n2);
        this.functionSync.setSyncState(4);
        this.removeAllListeners();
        this.commandList.commandFinished();
    }

    private void removeAllListeners() {
        this.functionSync.getFctSyncProperty().removeAcknowledgeListener(this);
    }

    protected abstract StatusProperty createFunctionSynchronizationStatus();
}

