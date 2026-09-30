/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.IPowerState;
import de.audi.app.bap.dsi.bap.IDSIBAPController;
import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManager;
import de.audi.app.bap.fw.AbstractFunctionListASG;
import de.audi.app.bap.fw.config.BAPConfig;
import de.audi.app.bap.fw.functiontypes.BAPFunctionGetAll;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.fw.indication.IBAPFunctionStatusAllListener;
import de.audi.app.bap.fw.indication.IBAPFunctionStatusListener;
import de.audi.app.bap.fw.indication.IErrorIndicationListener;
import de.audi.app.bap.utils.CollectionUtils;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBAPModuleInitializationManagerASG
extends AbstractBAPModuleInitializationManager
implements IErrorIndicationListener,
IBAPFunctionStatusListener {
    public static final int INIT_STATE_WAITING_FOR_BAPCONFIG = 5;
    public static final int INIT_STATE_WAITING_FOR_STATUSALL = 6;
    public static final int INIT_STATE_WAITING_FOR_FCT_LIST_STATUS = 7;
    public static final int INIT_STATE_UPDATE_PROPERTIES = 8;
    private static final long BAP_CONFIG_TIMEOUT_MILLIS = 20000L;
    private final AbstractBAPModuleASG moduleAsg;
    private final Timer bapGetConfigRetryTimer;
    private final BAPFunctionPropertyASG bapConfigProperty;

    public AbstractBAPModuleInitializationManagerASG(AbstractBAPModuleASG abstractBAPModuleASG, IDSIBAPController iDSIBAPController, IPowerState iPowerState) {
        super(abstractBAPModuleASG, iDSIBAPController, iPowerState);
        this.moduleAsg = abstractBAPModuleASG;
        this.bapConfigProperty = abstractBAPModuleASG.getBAPFunctionPropertyASG(abstractBAPModuleASG.getFunctionList().getBAPConfigBAPFctID());
        this.bapGetConfigRetryTimer = new Timer("bapGetConfigRetryTimer", 20000L, true, new TimerListener(){

            public void fireTimer(Timer timer) {
                AbstractBAPModuleInitializationManagerASG.this.getBAPConfigREQ();
            }

            public void cancelTimer(Timer timer) {
            }
        });
        this.addInitStateListener(abstractBAPModuleASG);
    }

    protected void startInitialization() {
        this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerASG#startInitialization] starting initialization for lsgID: %1", (Object)this.lsgIDDescription);
        this.getBAPConfigREQ();
    }

    public void bapReset(BAPEntity bAPEntity) {
        this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerASG#bapReset]");
        BAPConfig bAPConfig = this.bapConfigFromResetSerializer(bAPEntity);
        this.startInitializationSequenceWithBAPConfig(bAPConfig);
    }

    public void notifyStatusIndicationReceived(int n, StatusProperty statusProperty) {
        if (n != this.moduleAsg.getFunctionList().getBAPConfigBAPFctID()) {
            this.logChannel.log(10000, "[AbstractBAPModuleInitializationManagerASG#notifyStatusIndicationReceived] fctID is not the expected one for BAP Config. fctID: %1", (long)n);
            return;
        }
        BAPConfig bAPConfig = this.bapConfigFromStatusSerializer(statusProperty);
        this.startInitializationSequenceWithBAPConfig(bAPConfig);
    }

    public void processIndicationError(int n, int n2) {
        this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerASG#processIndicationError] fctID: %1 errorCode: %2", (long)n, (long)n2);
        if (n != this.moduleAsg.getFunctionList().getBAPConfigBAPFctID()) {
            this.logChannel.log(10000, "[AbstractBAPModuleInitializationManagerASG#processIndicationError] fctID is not the expected one for BAP Config. fctID: %1", (long)n);
            return;
        }
        switch (n2) {
            case 50: {
                this.logChannel.log(10000, "[AbstractBAPModuleInitializationManagerASG#processIndicationError] BAP Error: Incompatible Protocol Version.");
                this.resetInitialization();
                break;
            }
            case 34: {
                this.logChannel.log(10000, "[AbstractBAPModuleInitializationManagerASG#processIndicationError] BAP Error: Retry not successful (Get BAP config not answered).");
                this.resetInitialization();
                break;
            }
            default: {
                this.logChannel.log(10000, "[AbstractBAPModuleInitializationManagerASG#processIndicationError] Ignoring unexpected BAP Error. errorCode: %1", (long)n2);
            }
        }
    }

    public void sendSetGetProperties() {
        this.logChannel.log(10000, "[AbstractBAPModuleInitializationManagerASG#sendSetGetProperties] send SetGet requests");
        CommandList commandList = new CommandList(this.cmdListManager);
        commandList.add(new CommandUpdateSetGetProperties());
        this.cmdListManager.start();
        commandList.execute(this.getClass().getName());
    }

    protected abstract BAPConfig bapConfigFromResetSerializer(BAPEntity var1);

    protected abstract BAPConfig bapConfigFromStatusSerializer(StatusProperty var1);

    protected abstract boolean isBapConfigSupported(BAPConfig var1);

    private void getBAPConfigREQ() {
        this.setInitState(5);
        if (this.bapConfigProperty != null) {
            this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerASG#getBAPConfigREQ]");
            this.bapConfigProperty.addStatusListener(this);
            this.bapConfigProperty.addErrorIndicationListener(this);
            this.bapConfigProperty.getREQ();
        } else {
            this.logChannel.log(10000, "[AbstractBAPModuleInitializationManagerASG.CommandVersionCheck#execute] BAPConfig property not found for lsgID=%1", (Object)this.moduleAsg.getLSGDescription());
        }
    }

    private synchronized void startInitializationSequenceWithBAPConfig(BAPConfig bAPConfig) {
        this.resetInitialization();
        if (this.isBapConfigSupported(bAPConfig)) {
            this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerASG#checkBAPConfig] Version check successful. Starting initialization Command List.");
            CommandList commandList = new CommandList(this.cmdListManager);
            commandList.add(new CommandGetAll());
            commandList.add(new CommandGetFunctionList());
            commandList.add(new CommandUpdateProperties());
            commandList.add(new CommandFinishInitializationSequence());
            this.cmdListManager.start();
            commandList.execute(this.getClass().getName());
        } else {
            this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerASG#checkBAPConfig] Version check not successful. Will retry getting BAP Config.");
            this.bapGetConfigRetryTimer.restart();
        }
    }

    protected void resetInitialization() {
        this.setInitState(5);
        this.bapGetConfigRetryTimer.cancel();
        this.bapConfigProperty.removeStatusListener(this);
        this.bapConfigProperty.removeErrorIndicationListener(this);
        this.cmdListManager.abortExecution("resetInitialization", null, false);
        this.moduleAsg.resetBAPFunctions();
        this.moduleAsg.setInitialValues();
    }

    public void setRetryTimeout(long l) {
        this.bapGetConfigRetryTimer.setDelay(l);
    }

    private final class CommandGetAll
    extends Command
    implements IBAPFunctionStatusAllListener {
        private final BAPFunctionGetAll getAllFunction;

        public CommandGetAll() {
            super(AbstractBAPModuleInitializationManagerASG.this.logChannel);
            this.getAllFunction = AbstractBAPModuleInitializationManagerASG.this.moduleAsg.getBAPFunctionGetAll();
        }

        public void execute() {
            AbstractBAPModuleInitializationManagerASG.this.setInitState(6);
            if (this.getAllFunction != null) {
                AbstractBAPModuleInitializationManagerASG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerASG.CommandGetAll#execute] send GetAll request");
                this.getAllFunction.setStatusAllListener(this);
                this.getAllFunction.getAllREQ();
            } else {
                AbstractBAPModuleInitializationManagerASG.this.logChannel.log(10000, "[AbstractBAPModuleInitializationManagerASG.CommandGetAll#execute] getAll function not found");
                this.commandList.stop("GetAll function not available");
            }
        }

        public void notifyStatusAllIndicationReceived(int n) {
            AbstractBAPModuleInitializationManagerASG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerASG.CommandGetAll#notifyStatusAllIndicationReceived] properties can now be updated");
            this.getAllFunction.resetStatusAllListener();
            this.commandList.commandFinished();
        }
    }

    private final class CommandGetFunctionList
    extends Command
    implements IBAPFunctionStatusListener {
        private final BAPFunctionPropertyASG functionListProperty;

        public CommandGetFunctionList() {
            super(AbstractBAPModuleInitializationManagerASG.this.logChannel);
            this.functionListProperty = AbstractBAPModuleInitializationManagerASG.this.moduleAsg.getBAPFunctionPropertyASG(AbstractBAPModuleInitializationManagerASG.this.moduleAsg.getFunctionList().getFctListBAPFctID());
        }

        public void execute() {
            AbstractBAPModuleInitializationManagerASG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerASG.CommandGetFunctionList#execute] send FunctionList.Get request");
            AbstractBAPModuleInitializationManagerASG.this.setInitState(7);
            if (this.functionListProperty != null) {
                this.functionListProperty.addStatusListener(this);
                this.functionListProperty.getREQ();
            } else {
                AbstractBAPModuleInitializationManagerASG.this.logChannel.log(10000, "[AbstractBAPModuleInitializationManagerASG.CommandGetFunctionList#execute] FunctionList function not found");
            }
        }

        public void notifyStatusIndicationReceived(int n, StatusProperty statusProperty) {
            AbstractBAPModuleInitializationManagerASG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerASG.CommandGetFunctionList#notifyStatusIndicationReceived] received function list for lsgID=%1", (Object)AbstractBAPModuleInitializationManagerASG.this.moduleAsg.getLSGDescription());
            this.functionListProperty.removeStatusListener(this);
            ((AbstractFunctionListASG)AbstractBAPModuleInitializationManagerASG.this.moduleAsg.getFunctionList()).setFunctionListConfiguration(statusProperty);
            this.commandList.commandFinished();
        }
    }

    private final class CommandUpdateProperties
    extends Command
    implements IBAPFunctionStatusListener {
        private final List allProperties;
        private final List functionsToBeUpdated;
        private int updatedPropertiesCount;
        private int totalPropertiesToUpdateCount;

        public CommandUpdateProperties() {
            super(AbstractBAPModuleInitializationManagerASG.this.logChannel);
            this.functionsToBeUpdated = new ArrayList(10);
            this.allProperties = AbstractBAPModuleInitializationManagerASG.this.moduleAsg.getFunctionRegistration().getAllProperties();
        }

        public void execute() {
            AbstractBAPModuleInitializationManagerASG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerASG.CommandUpdateProperties#execute] updating properties (lsgID=%1", (Object)AbstractBAPModuleInitializationManagerASG.this.moduleAsg.getLSGDescription());
            AbstractBAPModuleInitializationManagerASG.this.setInitState(8);
            CollectionUtils.filterFromIteratorIntoCollection(this.allProperties.iterator(), this.functionsToBeUpdated, new CollectionUtils.Predicate(){

                public boolean evaluate(Object object) {
                    BAPFunctionPropertyASG bAPFunctionPropertyASG = (BAPFunctionPropertyASG)object;
                    int n = bAPFunctionPropertyASG.getFctID();
                    return n == AbstractBAPModuleInitializationManagerASG.this.moduleAsg.getFunctionList().getOperationStateBAPFctID() || AbstractBAPModuleInitializationManagerASG.this.moduleAsg.getFunctionList().isInModuleSpecificRange(n) && AbstractBAPModuleInitializationManagerASG.this.moduleAsg.getFunctionList().isFunctionSupported(n);
                }
            });
            this.updatedPropertiesCount = 0;
            this.totalPropertiesToUpdateCount = this.functionsToBeUpdated.size();
            this.updateNextProperty();
        }

        private void updateNextProperty() {
            if (this.functionsToBeUpdated.isEmpty()) {
                AbstractBAPModuleInitializationManagerASG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerASG.CommandUpdateProperties#updateNextProperty] all properties updated");
                this.commandList.commandFinished();
            } else {
                ++this.updatedPropertiesCount;
                AbstractBAPModuleInitializationManagerASG.this.logChannel.log(100000000, "[AbstractBAPModuleInitializationManagerASG.CommandUpdateProperties#updateNextProperty] update property %1 of %2", (long)this.updatedPropertiesCount, (long)this.totalPropertiesToUpdateCount);
                BAPFunctionPropertyASG bAPFunctionPropertyASG = (BAPFunctionPropertyASG)this.functionsToBeUpdated.get(0);
                bAPFunctionPropertyASG.addStatusListener(this);
                bAPFunctionPropertyASG.getREQ();
            }
        }

        public void notifyStatusIndicationReceived(int n, StatusProperty statusProperty) {
            BAPFunctionPropertyASG bAPFunctionPropertyASG = AbstractBAPModuleInitializationManagerASG.this.moduleAsg.getBAPFunctionPropertyASG(n);
            bAPFunctionPropertyASG.removeStatusListener(this);
            this.functionsToBeUpdated.remove(bAPFunctionPropertyASG);
            this.updateNextProperty();
        }
    }

    private final class CommandUpdateSetGetProperties
    extends Command
    implements IBAPFunctionStatusListener {
        private final List allProperties;
        private final List propertiesToSend;
        private int updatedPropertiesCount;
        private int totalPropertiesToUpdateCount;

        public CommandUpdateSetGetProperties() {
            super(AbstractBAPModuleInitializationManagerASG.this.logChannel);
            this.propertiesToSend = new ArrayList(5);
            this.allProperties = AbstractBAPModuleInitializationManagerASG.this.moduleAsg.getFunctionRegistration().getAllProperties();
        }

        public void execute() {
            AbstractBAPModuleInitializationManagerASG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerASG.CommandUpdateSetGetProperties#execute] updating properties (lsgID=%1", (Object)AbstractBAPModuleInitializationManagerASG.this.moduleAsg.getLSGDescription());
            CollectionUtils.filterFromIteratorIntoCollection(this.allProperties.iterator(), this.propertiesToSend, new CollectionUtils.Predicate(){

                public boolean evaluate(Object object) {
                    BAPFunctionPropertyASG bAPFunctionPropertyASG = (BAPFunctionPropertyASG)object;
                    int n = bAPFunctionPropertyASG.getFctID();
                    return AbstractBAPModuleInitializationManagerASG.this.moduleAsg.getFunctionList().isInModuleSpecificRange(n) && AbstractBAPModuleInitializationManagerASG.this.moduleAsg.getFunctionList().isFunctionSupported(n) && CommandUpdateSetGetProperties.this.hasSetGet(bAPFunctionPropertyASG);
                }
            });
            this.updatedPropertiesCount = 0;
            this.totalPropertiesToUpdateCount = this.propertiesToSend.size();
            this.updateNextProperty();
        }

        private void updateNextProperty() {
            if (this.propertiesToSend.isEmpty()) {
                AbstractBAPModuleInitializationManagerASG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerASG.CommandUpdateSetGetProperties#updateNextProperty] all properties updated");
                this.commandList.commandFinished();
            } else {
                ++this.updatedPropertiesCount;
                AbstractBAPModuleInitializationManagerASG.this.logChannel.log(100000000, "[AbstractBAPModuleInitializationManagerASG.CommandUpdateSetGetProperties#updateNextProperty] update property %1 of %2", (long)this.updatedPropertiesCount, (long)this.totalPropertiesToUpdateCount);
                BAPFunctionPropertyASG bAPFunctionPropertyASG = (BAPFunctionPropertyASG)this.propertiesToSend.get(0);
                bAPFunctionPropertyASG.addStatusListener(this);
                bAPFunctionPropertyASG.setGetREQ();
            }
        }

        private boolean hasSetGet(BAPFunctionPropertyASG bAPFunctionPropertyASG) {
            return bAPFunctionPropertyASG.getSetGetSerializer() != null;
        }

        public void notifyStatusIndicationReceived(int n, StatusProperty statusProperty) {
            BAPFunctionPropertyASG bAPFunctionPropertyASG = AbstractBAPModuleInitializationManagerASG.this.moduleAsg.getBAPFunctionPropertyASG(n);
            bAPFunctionPropertyASG.removeStatusListener(this);
            this.propertiesToSend.remove(bAPFunctionPropertyASG);
            this.updateNextProperty();
        }
    }

    private final class CommandFinishInitializationSequence
    extends Command {
        public CommandFinishInitializationSequence() {
            super(AbstractBAPModuleInitializationManagerASG.this.logChannel);
        }

        public void execute() {
            AbstractBAPModuleInitializationManagerASG.this.setInitState(9);
            AbstractBAPModuleInitializationManagerASG.this.updateHMIState();
            AbstractBAPModuleInitializationManagerASG.this.logChannel.log(10000000, "[AbstractBAPModuleInitializationManagerASG.CommandFinishInitializationSequence#execute] initialization sequence completed for lsgID=%1: %1", (Object)AbstractBAPModuleInitializationManagerASG.this.lsgIDDescription);
            this.commandList.commandFinished();
        }
    }
}

