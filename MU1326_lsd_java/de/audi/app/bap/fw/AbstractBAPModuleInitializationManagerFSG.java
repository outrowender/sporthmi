/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.IPowerState;
import de.audi.app.bap.dsi.bap.IDSIBAPController;
import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManager;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionDataListener;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.fw.indication.IAcknowledgeListener;
import de.audi.app.bap.fw.indication.IAcknowledgeTimeoutListener;
import de.audi.app.bap.fw.indication.IErrorIndicationListener;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.datatypes.BAPEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractBAPModuleInitializationManagerFSG
extends AbstractBAPModuleInitializationManager {
    public static final int INIT_STATE_WAITING_FOR_FCT_LIST_ACKNOWLEDGE = 3;
    public static final int INIT_STATE_UPDATING_BAP_FUNCTIONS = 4;
    private static final int MAX_INIT_FAILS = 5;
    private volatile int failedCounter;
    private final AbstractBAPModuleFSG moduleFsg;
    protected final BAPFunctionPropertyFSG fsgOperationStateFunction;
    private volatile boolean appIsReady = true;

    public AbstractBAPModuleInitializationManagerFSG(AbstractBAPModuleFSG abstractBAPModuleFSG, BAPFunctionPropertyFSG bAPFunctionPropertyFSG, IDSIBAPController iDSIBAPController, IPowerState iPowerState) {
        super(abstractBAPModuleFSG, iDSIBAPController, iPowerState);
        this.moduleFsg = abstractBAPModuleFSG;
        this.fsgOperationStateFunction = bAPFunctionPropertyFSG;
    }

    public abstract boolean isOpStateNormalOperation();

    public abstract boolean setFSGOperationStateValue(int var1);

    protected void startInitialization() {
        this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG#startInitialization] starting initialization sequence for lsgID: %1", (Object)this.lsgIDDescription);
        CommandList commandList = new CommandList(this.cmdListManager);
        commandList.add(new CommandUpdateFunctionList());
        commandList.add(new CommandUpdateOperationState());
        commandList.add(new CommandUpdateProperties());
        commandList.add(new CommandUpdateArrays());
        commandList.add(new CommandFinishInitializationSequence());
        this.cmdListManager.start();
        commandList.execute(this.getClass().getName());
    }

    protected void resetInitialization() {
        this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG#resetInitialization] aborting initialization sequence for lsgID: %1", (Object)this.lsgIDDescription);
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

    public void bapReset(BAPEntity bAPEntity) {
    }

    public synchronized void setAppIsReady(boolean bl) {
        this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG#setAppIsReady] LSG=%2: ready=%1", bl, (Object)LSGIDs.getDescription(this.module.getLSGID()));
        this.appIsReady = bl;
        this.updateOperationState();
    }

    public synchronized void updateOperationState() {
        this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG#updateOperationState] updating operation state of LSG=%3 (swdlRunning=%1, appState=%2)", this.isSwdlRunning(), (Object)new Integer(this.getAppState()), (Object)LSGIDs.getDescription(this.module.getLSGID()));
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
        this.logChannel.log(1000000, "[AbstractBAPModuleInitializationManagerFSG#updateOperationStateBAP] new operation state of LSG=%1 is %2", (Object)LSGIDs.getDescription(this.module.getLSGID()), (Object)AbstractBAPModuleInitializationManagerFSG.getOpStateString(n2));
        if (this.setFSGOperationStateValue(n2) || this.fsgOperationStateFunction.isStatusRequestTransmissionPending() || !this.fsgOperationStateFunction.isDataValid()) {
            this.fsgOperationStateFunction.resendLastStatus();
        } else {
            this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG#updateOperationStateBAP] operation state of LSG=%1 is not updated", (Object)LSGIDs.getDescription(this.module.getLSGID()));
        }
    }

    private void updateOperationStateMOST(int n) {
        this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG#updateOperationStateMOST] new operation state of LSG=%1 is %2", (Object)LSGIDs.getDescription(this.module.getLSGID()), (Object)AbstractBAPModuleInitializationManagerFSG.getOpStateString(n));
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

    private final class CommandUpdateArrays
    extends Command
    implements IAcknowledgeListener,
    IAcknowledgeTimeoutListener {
        private final List arraysToBeUpdated;

        public CommandUpdateArrays() {
            super(AbstractBAPModuleInitializationManagerFSG.this.logChannel);
            this.arraysToBeUpdated = new ArrayList(10);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void execute() {
            AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#execute] send changedArray request for all available arrays (lsgID=%1)", (Object)LSGIDs.getDescription(AbstractBAPModuleInitializationManagerFSG.this.moduleFsg.getLSGID()));
            List list = AbstractBAPModuleInitializationManagerFSG.this.moduleFsg.getFunctionRegistration().getAllArrays();
            if (list.isEmpty()) {
                this.commandList.commandFinished();
                return;
            }
            List list2 = this.arraysToBeUpdated;
            synchronized (list2) {
                this.arraysToBeUpdated.addAll(list);
            }
            int n = 1;
            int n2 = list.size();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                BAPFunctionArrayFSG bAPFunctionArrayFSG = (BAPFunctionArrayFSG)iterator.next();
                if (AbstractBAPModuleInitializationManagerFSG.this.moduleFsg.getFunctionList().isFunctionSupported(bAPFunctionArrayFSG.getFctID()) && bAPFunctionArrayFSG.isDataValid()) {
                    AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#execute] update array %1 of %2", (long)n, (long)n2);
                    AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#execute] %1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
                    bAPFunctionArrayFSG.addAcknowledgeListener(this);
                    bAPFunctionArrayFSG.addAcknowledgeTimeoutListener(this);
                    if (!bAPFunctionArrayFSG.sendFullRangeUpdate()) {
                        AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(100000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#execute] array %1 not sent; move on", (Object)bAPFunctionArrayFSG.getFctIDDescription());
                        this.arrayUpdated(bAPFunctionArrayFSG);
                    }
                } else {
                    AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#execute] ignore array %1 of %2", (long)n, (long)n2);
                    AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#execute] %1", (Object)bAPFunctionArrayFSG.getFctIDDescription());
                    this.removeFunction(bAPFunctionArrayFSG);
                }
                ++n;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void removeFunction(BAPFunctionArrayFSG bAPFunctionArrayFSG) {
            boolean bl = false;
            List list = this.arraysToBeUpdated;
            synchronized (list) {
                this.arraysToBeUpdated.remove(bAPFunctionArrayFSG);
                if (this.arraysToBeUpdated.isEmpty()) {
                    AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#removeFunction] all arrays acknowledged");
                    bl = true;
                } else {
                    AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#removeFunction] %1 arrays to be acknowledged", (long)this.arraysToBeUpdated.size());
                }
            }
            if (bl) {
                this.commandList.commandFinished();
            }
        }

        public void processAcknowledge(int n, int n2) {
            if (n2 == 4) {
                BAPFunctionArrayFSG bAPFunctionArrayFSG = AbstractBAPModuleInitializationManagerFSG.this.moduleFsg.getBAPFunctionArrayFSG(n);
                AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(100000000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#processAcknowledge] array update acknowledged (lsgID=%1, fctID=%2)", (Object)bAPFunctionArrayFSG.getLSGIDDescription(), (Object)bAPFunctionArrayFSG.getFctIDDescription());
                this.arrayUpdated(bAPFunctionArrayFSG);
            }
        }

        public void processAcknowledgeTimeout(int n) {
            AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateArrays#processAcknowledgeTimeout] ");
            BAPFunctionArrayFSG bAPFunctionArrayFSG = AbstractBAPModuleInitializationManagerFSG.this.moduleFsg.getBAPFunctionArrayFSG(n);
            this.arrayUpdated(bAPFunctionArrayFSG);
        }

        private void arrayUpdated(BAPFunctionArrayFSG bAPFunctionArrayFSG) {
            bAPFunctionArrayFSG.removeAcknowledgeListener(this);
            bAPFunctionArrayFSG.removeAcknowledgeTimeoutListener(this);
            this.removeFunction(bAPFunctionArrayFSG);
        }
    }

    private final class CommandUpdateProperties
    extends Command
    implements IAcknowledgeListener,
    IAcknowledgeTimeoutListener,
    BAPFunctionDataListener {
        private final List propertiesToBeUpdated;

        public CommandUpdateProperties() {
            super(AbstractBAPModuleInitializationManagerFSG.this.logChannel);
            this.propertiesToBeUpdated = new ArrayList(10);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void execute() {
            AbstractBAPModuleInitializationManagerFSG.this.setInitState(4);
            AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateProperties#execute] updating all available properties (lsgID=%1)", (Object)LSGIDs.getDescription(AbstractBAPModuleInitializationManagerFSG.this.moduleFsg.getLSGID()));
            List list = AbstractBAPModuleInitializationManagerFSG.this.moduleFsg.getFunctionRegistration().getAllProperties();
            if (list.isEmpty()) {
                this.commandList.commandFinished();
                return;
            }
            List list2 = this.propertiesToBeUpdated;
            synchronized (list2) {
                this.propertiesToBeUpdated.addAll(list);
            }
            int n = 1;
            int n2 = list.size();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                BAPFunctionPropertyFSG bAPFunctionPropertyFSG = (BAPFunctionPropertyFSG)iterator.next();
                if (AbstractBAPModuleInitializationManagerFSG.this.moduleFsg.getFunctionList().isFunctionSupported(bAPFunctionPropertyFSG.getFctID()) && this.isRelevantForUpdateProperties(bAPFunctionPropertyFSG.getFctID()) && !bAPFunctionPropertyFSG.isControlledByFunctionSync()) {
                    AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(100000000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateProperties#execute] update property %1 of %2", (long)n, (long)n2);
                    bAPFunctionPropertyFSG.addDataListener(this);
                    bAPFunctionPropertyFSG.addAcknowledgeListener(this);
                    bAPFunctionPropertyFSG.addAcknowledgeTimeoutListener(this);
                    if (bAPFunctionPropertyFSG.isLastStatusAckAvailable()) {
                        bAPFunctionPropertyFSG.resendLastStatusAck();
                    } else {
                        bAPFunctionPropertyFSG.resendLastStatus();
                    }
                } else {
                    AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(100000000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateProperties#execute] ignore property %1 of %2", (long)n, (long)n2);
                    this.removeProperty(bAPFunctionPropertyFSG);
                }
                ++n;
            }
        }

        private boolean isRelevantForUpdateProperties(int n) {
            if (AbstractBAPModuleInitializationManagerFSG.this.getHMIState() == 1 && n == AbstractBAPModuleInitializationManagerFSG.this.moduleFsg.getFunctionList().getOperationStateBAPFctID()) {
                return false;
            }
            return AbstractBAPModuleInitializationManagerFSG.this.moduleFsg.isRelevantForUpdateProperties(n);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void removeProperty(BAPFunctionPropertyFSG bAPFunctionPropertyFSG) {
            boolean bl = false;
            List list = this.propertiesToBeUpdated;
            synchronized (list) {
                this.propertiesToBeUpdated.remove(bAPFunctionPropertyFSG);
                if (this.propertiesToBeUpdated.isEmpty()) {
                    AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateProperties#removeProperty] all properties acknowledged");
                    bl = true;
                } else {
                    AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(100000000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateProperties#removeProperty] %1 properties to be acknowledged", (long)this.propertiesToBeUpdated.size());
                }
            }
            if (bl) {
                this.commandList.commandFinished();
            }
        }

        public void processAcknowledge(int n, int n2) {
            if (n2 == 0 || n2 == 1) {
                BAPFunctionPropertyFSG bAPFunctionPropertyFSG = AbstractBAPModuleInitializationManagerFSG.this.moduleFsg.getBAPFunctionPropertyFSG(n);
                AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(100000000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateProperties#processAcknowledge] property update acknowledged (lsgID=%1, fctID=%2)", (Object)bAPFunctionPropertyFSG.getFctIDDescription(), (Object)bAPFunctionPropertyFSG.getFctIDDescription());
                this.propertyUpdated(bAPFunctionPropertyFSG);
            }
        }

        private void propertyUpdated(BAPFunctionPropertyFSG bAPFunctionPropertyFSG) {
            bAPFunctionPropertyFSG.removeDataListener(this);
            bAPFunctionPropertyFSG.removeAcknowledgeListener(this);
            bAPFunctionPropertyFSG.removeAcknowledgeTimeoutListener(this);
            this.removeProperty(bAPFunctionPropertyFSG);
        }

        public void processAcknowledgeTimeout(int n) {
            AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(100000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateProperties#processAcknowledgeTimeout]");
            BAPFunctionPropertyFSG bAPFunctionPropertyFSG = AbstractBAPModuleInitializationManagerFSG.this.moduleFsg.getBAPFunctionPropertyFSG(n);
            this.propertyUpdated(bAPFunctionPropertyFSG);
        }

        public void notifyDataValidChanged(int n, boolean bl) {
        }

        public void notifyDataChanged(int n) {
        }

        public void notifyDataUpdatedNoChange(int n) {
            BAPFunctionPropertyFSG bAPFunctionPropertyFSG = AbstractBAPModuleInitializationManagerFSG.this.moduleFsg.getBAPFunctionPropertyFSG(n);
            this.propertyUpdated(bAPFunctionPropertyFSG);
        }
    }

    private final class CommandUpdateFunctionList
    extends Command
    implements IAcknowledgeListener,
    IErrorIndicationListener {
        private final BAPFunctionPropertyFSG functionListProperty;

        public CommandUpdateFunctionList() {
            super(AbstractBAPModuleInitializationManagerFSG.this.logChannel);
            this.functionListProperty = AbstractBAPModuleInitializationManagerFSG.this.moduleFsg.getBAPFunctionPropertyFSG(AbstractBAPModuleInitializationManagerFSG.this.moduleFsg.getFunctionList().getFctListBAPFctID());
        }

        public void execute() {
            AbstractBAPModuleInitializationManagerFSG.this.setInitState(3);
            this.functionListProperty.addAcknowledgeListener(this);
            this.functionListProperty.addErrorIndicationListener(this);
            this.sendFunctionList();
        }

        private void sendFunctionList() {
            AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateFunctionList#sendUpdate] updating function list for lsgID=%1", (Object)LSGIDs.getDescription(AbstractBAPModuleInitializationManagerFSG.this.moduleFsg.getLSGID()));
            BAPFunctionPropertyFSG bAPFunctionPropertyFSG = AbstractBAPModuleInitializationManagerFSG.this.moduleFsg.getBAPFunctionPropertyFSG(AbstractBAPModuleInitializationManagerFSG.this.moduleFsg.getFunctionList().getFctListBAPFctID());
            bAPFunctionPropertyFSG.resendLastStatus();
        }

        public void processAcknowledge(int n, int n2) {
            if (n2 == 0) {
                AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG.CommandUpdateFunctionList#processAcknowledge] called (lsgID=%1)", (Object)AbstractBAPModuleInitializationManagerFSG.this.lsgIDDescription);
                this.functionListProperty.removeAcknowledgeListener(this);
                this.commandList.commandFinished();
            }
        }

        public void processIndicationError(int n, int n2) {
            if (n2 == 66) {
                this.functionListProperty.removeErrorIndicationListener(this);
                AbstractBAPModuleInitializationManagerFSG.this.handleInitFailure(this);
            }
        }
    }

    private final class CommandUpdateOperationState
    extends Command {
        public CommandUpdateOperationState() {
            super(AbstractBAPModuleInitializationManagerFSG.this.logChannel);
        }

        public void execute() {
            AbstractBAPModuleInitializationManagerFSG.this.updateOperationState();
            this.commandList.commandFinished();
        }
    }

    private final class CommandFinishInitializationSequence
    extends Command {
        public CommandFinishInitializationSequence() {
            super(AbstractBAPModuleInitializationManagerFSG.this.logChannel);
        }

        public void execute() {
            AbstractBAPModuleInitializationManagerFSG.this.setInitState(9);
            AbstractBAPModuleInitializationManagerFSG.this.updateOperationState();
            AbstractBAPModuleInitializationManagerFSG.this.updateHMIState();
            AbstractBAPModuleInitializationManagerFSG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerFSG.CommandFinishInitializationSequence#execute] initialization sequence completed for lsgID=%1", (Object)AbstractBAPModuleInitializationManagerFSG.this.lsgIDDescription);
            this.commandList.commandFinished();
        }
    }
}

