/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionDataListener;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronization;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronizationCommand;
import de.vw.mib.bap.requests.StatusProperty;

public abstract class AbstractCommandOpenFunctionSync
extends AbstractFunctionSynchronizationCommand
implements IAcknowledgeListener,
BAPFunctionDataListener {
    protected StatusProperty functionSyncStatusSerializer;

    public AbstractCommandOpenFunctionSync(AbstractBAPModuleFSG abstractBAPModuleFSG, AbstractFunctionSynchronization abstractFunctionSynchronization) {
        super(abstractBAPModuleFSG, abstractFunctionSynchronization, "CommandOpenFunctionSync");
        this.init();
    }

    private void init() {
        this.functionSyncStatusSerializer = this.createFunctionSynchronizationStatus();
        int[] nArray = this.functionSync.getFunctionsToBeSynchronized();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (this.moduleFsg.getFunctionList().isFunctionSupported(nArray[i2])) {
                this.setFunctionBit(nArray[i2]);
                continue;
            }
            this.logger.log(10000000, "[AbstractCommandOpenFunctionSync#init] [%1] fctID=%2 not supported -> don't add to function sync", (Object)this.functionSync.getSyncTypeDescription(), (long)nArray[i2]);
        }
    }

    protected abstract StatusProperty createFunctionSynchronizationStatus();

    protected abstract void setFunctionBit(int var1);

    public void execute() {
        this.logger.log(10000000, "[AbstractCommandOpenFunctionSync#execute] [%1] start command", (Object)this.functionSync.getSyncTypeDescription());
        this.functionSync.getFctSyncProperty().addDataListener(this);
        this.functionSync.getFctSyncProperty().addAcknowledgeListener(this);
        this.functionSync.setSyncState(1);
        this.functionSync.getFctSyncProperty().sendStatusIfChanged(this.functionSyncStatusSerializer);
    }

    public void abort() {
        this.removeAllListeners();
        super.abort();
    }

    public void notifyDataValidChanged(int n, boolean bl) {
    }

    public void notifyDataChanged(int n) {
    }

    public void notifyDataUpdatedNoChange(int n) {
        this.logger.log(10000000, "[AbstractCommandOpenFunctionSync#notifyDataUpdatedNoChange] [%1] fctID=%2", (Object)this.functionSync.getSyncTypeDescription(), (Object)FunctionIDs.getDescription(this.moduleFsg.getLSGID(), n));
        this.finishCommand();
    }

    public void processAcknowledge(int n, int n2) {
        this.logger.log(10000000, "[AbstractCommandOpenFunctionSync#processAcknowledge] [%1] fctID=%2, acknowledgeType=%3", (Object)this.functionSync.getSyncTypeDescription(), (Object)FunctionIDs.getDescription(this.moduleFsg.getLSGID(), n), (long)n2);
        this.finishCommand();
    }

    private void finishCommand() {
        this.logger.log(10000000, "[AbstractCommandOpenFunctionSync#finishCommand] [%1] lsgID=%2", (Object)this.functionSync.getSyncTypeDescription(), (Object)LSGIDs.getDescription(this.moduleFsg.getLSGID()));
        this.removeAllListeners();
        this.functionSync.setSyncState(2);
        this.commandList.commandFinished();
    }

    private void removeAllListeners() {
        this.functionSync.getFctSyncProperty().removeDataListener(this);
        this.functionSync.getFctSyncProperty().removeAcknowledgeListener(this);
    }
}

