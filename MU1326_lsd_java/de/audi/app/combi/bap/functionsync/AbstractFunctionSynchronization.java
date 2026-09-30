/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.functionsync.AbstractCommandCloseFunctionSync;
import de.audi.app.combi.bap.functionsync.AbstractCommandOpenFunctionSync;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSyncEpilogueAction;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronizationHandler;
import de.audi.app.combi.bap.functionsync.CommandUpdateFunctions;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.requests.StatusProperty;

public abstract class AbstractFunctionSynchronization
extends CommandList {
    public static final int SYNC_TYPE_NO_SYNC = -1;
    public static final int CANCEL_REASON_RESTART = 0;
    public static final int CANCEL_REASON_ABORT = 1;
    public static final int CANCEL_REASON_COMPLETE = 2;
    protected final LogChannel logChannel;
    private final CommandUpdateFunctions updateFunctionsCommand;
    protected final AbstractBAPModuleFSG moduleFsg;
    private final AbstractFunctionSynchronizationHandler fctSyncHandler;
    private final BAPFunctionPropertyFSG fctSyncProperty;
    protected final int syncType;
    private volatile int syncState = 0;
    private volatile int cancelReason = -1;

    public AbstractFunctionSynchronization(AbstractBAPModuleFSG abstractBAPModuleFSG, AbstractFunctionSynchronizationHandler abstractFunctionSynchronizationHandler, int n, int n2) {
        super(abstractFunctionSynchronizationHandler.getCommandListManager());
        this.moduleFsg = abstractBAPModuleFSG;
        this.fctSyncHandler = abstractFunctionSynchronizationHandler;
        this.fctSyncProperty = abstractBAPModuleFSG.getBAPFunctionPropertyFSG(n);
        this.fctSyncProperty.setIsFunctionSyncProperty(true);
        this.logChannel = abstractBAPModuleFSG.getLogChannel();
        this.syncType = n2;
        this.add(this.createOpenFunctionSyncCommand());
        this.updateFunctionsCommand = new CommandUpdateFunctions(abstractBAPModuleFSG, this);
        this.add(this.updateFunctionsCommand);
        this.add(this.createCloseFunctionSyncCommand());
        this.addAdditionalCommands();
    }

    protected abstract void addAdditionalCommands();

    protected abstract AbstractCommandOpenFunctionSync createOpenFunctionSyncCommand();

    protected abstract AbstractCommandCloseFunctionSync createCloseFunctionSyncCommand();

    protected abstract int[] getFunctionsToBeSynchronized();

    public BAPFunctionPropertyFSG getFctSyncProperty() {
        return this.fctSyncProperty;
    }

    public void addEpilogueAction(AbstractFunctionSyncEpilogueAction abstractFunctionSyncEpilogueAction) {
        this.addMonitor(abstractFunctionSyncEpilogueAction);
    }

    public void setSyncState(int n) {
        this.logChannel.log(10000000, "[AbstractFunctionSynchronization#setSyncState] [%1] new state is %2", (Object)this.getSyncTypeDescription(), (Object)this.fctSyncHandler.getSyncStateDescription(n));
        this.syncState = n;
    }

    public int getSyncState() {
        return this.syncState;
    }

    public void cancel(int n) {
        this.logChannel.log(10000000, "[AbstractFunctionSynchronization#cancel] [%1] reason: %2", (Object)this.getSyncTypeDescription(), (long)n);
        this.cancelReason = n;
        if (n == 0) {
            this.logChannel.log(10000000, "[AbstractFunctionSynchronization#cancel] [%1] sync is restarted", (Object)this.getSyncTypeDescription());
            this.stop("Function sync restarted");
        } else if (n == 1) {
            this.logChannel.log(10000000, "[AbstractFunctionSynchronization#cancel] sync is aborted -> finish function sync immediately");
            if (this.getActiveCommand() != this.updateFunctionsCommand) {
                this.updateFunctionsCommand.abort();
            }
            this.stop("Function sync aborted");
        } else if (n == 2) {
            this.logChannel.log(10000000, "[AbstractFunctionSynchronization#cancel] sync is completed -> skip update functions");
            this.updateFunctionsCommand.abort();
            if (this.getActiveCommand() == this.updateFunctionsCommand) {
                this.commandFinished();
            }
        }
    }

    public boolean isCanceled() {
        return this.cancelReason != -1;
    }

    public int getSyncType() {
        return this.syncType;
    }

    public abstract String getSyncTypeDescription();

    public boolean enqueuePropertyUpdate(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, StatusProperty statusProperty) {
        return this.updateFunctionsCommand.enqueuePropertyUpdate(bAPFunctionPropertyFSG, statusProperty);
    }

    public boolean isQueuedPropertiesSent() {
        return this.updateFunctionsCommand.isQueuedPropertiesSent();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("syncType: ").append(this.getSyncTypeDescription());
        buffer.append("\nsyncState: ").append(this.fctSyncHandler.getSyncStateDescription(this.syncState));
        buffer.append("\nfunctions not updated yet:\n");
        buffer.append(this.updateFunctionsCommand.logPendingFunctions());
        buffer.append("\n");
        buffer.append(super.toString());
        return buffer.toString();
    }
}

