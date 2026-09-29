/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.IPowerState;
import de.audi.app.bap.dsi.bap.IDSIBAPController;
import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManager;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerFSG$CommandFinishInitializationSequence;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerFSG$CommandUpdateArrays;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerFSG$CommandUpdateFunctionList;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerFSG$CommandUpdateOperationState;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerFSG$CommandUpdateProperties;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.datatypes.BAPEntity;

public abstract class AbstractBAPModuleInitializationManagerFSG
extends AbstractBAPModuleInitializationManager {
    public static final int INIT_STATE_WAITING_FOR_FCT_LIST_ACKNOWLEDGE;
    public static final int INIT_STATE_UPDATING_BAP_FUNCTIONS;
    private static final int MAX_INIT_FAILS;
    private volatile int failedCounter;
    private final AbstractBAPModuleFSG moduleFsg;
    protected final BAPFunctionPropertyFSG fsgOperationStateFunction;
    private volatile boolean appIsReady = true;

    public AbstractBAPModuleInitializationManagerFSG(AbstractBAPModuleFSG abstractBAPModuleFSG, BAPFunctionPropertyFSG bAPFunctionPropertyFSG, IDSIBAPController iDSIBAPController, IPowerState iPowerState) {
        super(abstractBAPModuleFSG, iDSIBAPController, iPowerState);
        this.moduleFsg = abstractBAPModuleFSG;
        this.fsgOperationStateFunction = bAPFunctionPropertyFSG;
    }

    public abstract boolean isOpStateNormalOperation() {
    }

    public abstract boolean setFSGOperationStateValue(int n) {
    }

    @Override
    protected void startInitialization() {
        this.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG#startInitialization] starting initialization sequence for lsgID: %1", (Object)this.lsgIDDescription);
        CommandList commandList = new CommandList(this.cmdListManager);
        commandList.add(new AbstractBAPModuleInitializationManagerFSG$CommandUpdateFunctionList(this));
        commandList.add(new AbstractBAPModuleInitializationManagerFSG$CommandUpdateOperationState(this));
        commandList.add(new AbstractBAPModuleInitializationManagerFSG$CommandUpdateProperties(this));
        commandList.add(new AbstractBAPModuleInitializationManagerFSG$CommandUpdateArrays(this));
        commandList.add(new AbstractBAPModuleInitializationManagerFSG$CommandFinishInitializationSequence(this));
        this.cmdListManager.start();
        commandList.execute(super.getClass().getName());
    }

    @Override
    protected void resetInitialization() {
        this.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG#resetInitialization] aborting initialization sequence for lsgID: %1", (Object)this.lsgIDDescription);
        this.cmdListManager.abortExecution("BAP stack changed", null, false);
        this.moduleFsg.resetBAPFunctions();
        this.moduleFsg.setInitialValues();
    }

    private synchronized void handleInitFailure(Command command) {
        command.getCommandList().stop("error 0x42 received -> restart init sequence");
        this.setInitState(-1);
        if (++this.failedCounter < 5) {
            this.logChannel.log(10000, "[AbstractBAPModuleInitializationManagerFSG#handleInitFailure] init sequence FAILED for lsgID=%1; retry (failedCounter=%2) ", (Object)this.lsgIDDescription, (long)this.failedCounter);
            this.updateHMIState(true);
        } else {
            this.logChannel.log(1000, "[AbstractBAPModuleInitializationManagerFSG#handleInitFailure] init sequence FAILED for lsgID=%1; max number of retries reached", (Object)this.lsgIDDescription);
        }
    }

    @Override
    public void bapReset(BAPEntity bAPEntity) {
    }

    public synchronized void setAppIsReady(boolean bl) {
        this.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG#setAppIsReady] LSG=%2: ready=%1", bl, (Object)LSGIDs.getDescription(this.module.getLSGID()));
        this.appIsReady = bl;
        this.updateOperationState();
    }

    @Override
    public synchronized void updateOperationState() {
        this.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG#updateOperationState] updating operation state of LSG=%3 (swdlRunning=%1, appState=%2)", this.isSwdlRunning(), (Object)new Integer(this.getAppState()), (Object)LSGIDs.getDescription(this.module.getLSGID()));
        int n = this.getGeneralOperationState();
        this.updateOperationStateBAP(n);
        this.updateOperationStateMOST(n);
    }

    private int getGeneralOperationState() {
        int n;
        if (this.powerState.isPowerOn()) {
            if (this.isSwdlRunning() || !this.appIsReady) {
                n = 2;
            } else {
                switch (this.getAppState()) {
                    case 0: {
                        n = 2;
                        break;
                    }
                    case 1: {
                        if (this.isRequiredDataForOpStateNormalAvailable() && this.getInitState() >= 9) {
                            n = 0;
                            break;
                        }
                        n = 2;
                        break;
                    }
                    default: {
                        n = 3;
                        break;
                    }
                }
            }
        } else {
            n = 1;
        }
        return n;
    }

    protected void updateOperationStateBAP(int n) {
        int n2 = this.getBapStackState() == 0 ? 2 : n;
        this.logChannel.log(1078071040, "[AbstractBAPModuleInitializationManagerFSG#updateOperationStateBAP] new operation state of LSG=%1 is %2", (Object)LSGIDs.getDescription(this.module.getLSGID()), (Object)AbstractBAPModuleInitializationManagerFSG.getOpStateString(n2));
        if (this.setFSGOperationStateValue(n2) || this.fsgOperationStateFunction.isStatusRequestTransmissionPending() || !this.fsgOperationStateFunction.isDataValid()) {
            this.fsgOperationStateFunction.resendLastStatus();
        } else {
            this.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG#updateOperationStateBAP] operation state of LSG=%1 is not updated", (Object)LSGIDs.getDescription(this.module.getLSGID()));
        }
    }

    private void updateOperationStateMOST(int n) {
        this.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerFSG#updateOperationStateMOST] new operation state of LSG=%1 is %2", (Object)LSGIDs.getDescription(this.module.getLSGID()), (Object)AbstractBAPModuleInitializationManagerFSG.getOpStateString(n));
        if (this.module.getListManager() != null) {
            this.module.getListManager().setOperationState(n);
        }
    }

    protected boolean isRequiredDataForOpStateNormalAvailable() {
        return true;
    }

    protected static String getOpStateString(int n) {
        Buffer buffer = new Buffer();
        buffer.append(n);
        buffer.append(" (");
        switch (n) {
            case 0: {
                buffer.append("NORMAL_OPERATION");
                break;
            }
            case 1: {
                buffer.append("STAND_BY");
                break;
            }
            case 2: {
                buffer.append("INITIALIZING");
                break;
            }
            case 3: {
                buffer.append("DEFECT");
                break;
            }
            default: {
                buffer.append("UNKNOWN");
            }
        }
        buffer.append(")");
        return buffer.toString();
    }

    static /* synthetic */ AbstractBAPModuleFSG access$000(AbstractBAPModuleInitializationManagerFSG abstractBAPModuleInitializationManagerFSG) {
        return abstractBAPModuleInitializationManagerFSG.moduleFsg;
    }

    static /* synthetic */ void access$100(AbstractBAPModuleInitializationManagerFSG abstractBAPModuleInitializationManagerFSG, Command command) {
        abstractBAPModuleInitializationManagerFSG.handleInitFailure(command);
    }
}

