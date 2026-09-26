/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw;

import de.audi.app.bap.IPowerState;
import de.audi.app.bap.dsi.bap.IDSIBAPController;
import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManager;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG$1;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG$CommandFinishInitializationSequence;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG$CommandGetAll;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG$CommandGetFunctionList;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG$CommandUpdateProperties;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties;
import de.audi.app.bap.fw.config.BAPConfig;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.fw.indication.IBAPFunctionStatusListener;
import de.audi.app.bap.fw.indication.IErrorIndicationListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.command.CommandList;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;

public abstract class AbstractBAPModuleInitializationManagerASG
extends AbstractBAPModuleInitializationManager
implements IErrorIndicationListener,
IBAPFunctionStatusListener {
    public static final int INIT_STATE_WAITING_FOR_BAPCONFIG;
    public static final int INIT_STATE_WAITING_FOR_STATUSALL;
    public static final int INIT_STATE_WAITING_FOR_FCT_LIST_STATUS;
    public static final int INIT_STATE_UPDATE_PROPERTIES;
    private static final long BAP_CONFIG_TIMEOUT_MILLIS;
    private final AbstractBAPModuleASG moduleAsg;
    private final Timer bapGetConfigRetryTimer;
    private final BAPFunctionPropertyASG bapConfigProperty;

    public AbstractBAPModuleInitializationManagerASG(AbstractBAPModuleASG abstractBAPModuleASG, IDSIBAPController iDSIBAPController, IPowerState iPowerState) {
        super(abstractBAPModuleASG, iDSIBAPController, iPowerState);
        this.moduleAsg = abstractBAPModuleASG;
        this.bapConfigProperty = abstractBAPModuleASG.getBAPFunctionPropertyASG(abstractBAPModuleASG.getFunctionList().getBAPConfigBAPFctID());
        this.bapGetConfigRetryTimer = new Timer("bapGetConfigRetryTimer", 0, true, new AbstractBAPModuleInitializationManagerASG$1(this));
        this.addInitStateListener(abstractBAPModuleASG);
    }

    @Override
    protected void startInitialization() {
        this.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerASG#startInitialization] starting initialization for lsgID: %1", (Object)this.lsgIDDescription);
        this.getBAPConfigREQ();
    }

    @Override
    public void bapReset(BAPEntity bAPEntity) {
        this.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerASG#bapReset]");
        BAPConfig bAPConfig = this.bapConfigFromResetSerializer(bAPEntity);
        this.startInitializationSequenceWithBAPConfig(bAPConfig);
    }

    @Override
    public void notifyStatusIndicationReceived(int n, StatusProperty statusProperty) {
        if (n != this.moduleAsg.getFunctionList().getBAPConfigBAPFctID()) {
            this.logChannel.log(10000, "[AbstractBAPModuleInitializationManagerASG#notifyStatusIndicationReceived] fctID is not the expected one for BAP Config. fctID: %1", (long)n);
            return;
        }
        BAPConfig bAPConfig = this.bapConfigFromStatusSerializer(statusProperty);
        this.startInitializationSequenceWithBAPConfig(bAPConfig);
    }

    @Override
    public void processIndicationError(int n, int n2) {
        this.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerASG#processIndicationError] fctID: %1 errorCode: %2", (long)n, (long)n2);
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
        commandList.add(new AbstractBAPModuleInitializationManagerASG$CommandUpdateSetGetProperties(this));
        this.cmdListManager.start();
        commandList.execute(super.getClass().getName());
    }

    protected abstract BAPConfig bapConfigFromResetSerializer(BAPEntity bAPEntity) {
    }

    protected abstract BAPConfig bapConfigFromStatusSerializer(StatusProperty statusProperty) {
    }

    protected abstract boolean isBapConfigSupported(BAPConfig bAPConfig) {
    }

    private void getBAPConfigREQ() {
        this.setInitState(5);
        if (this.bapConfigProperty != null) {
            this.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerASG#getBAPConfigREQ]");
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
            this.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerASG#checkBAPConfig] Version check successful. Starting initialization Command List.");
            CommandList commandList = new CommandList(this.cmdListManager);
            commandList.add(new AbstractBAPModuleInitializationManagerASG$CommandGetAll(this));
            commandList.add(new AbstractBAPModuleInitializationManagerASG$CommandGetFunctionList(this));
            commandList.add(new AbstractBAPModuleInitializationManagerASG$CommandUpdateProperties(this));
            commandList.add(new AbstractBAPModuleInitializationManagerASG$CommandFinishInitializationSequence(this));
            this.cmdListManager.start();
            commandList.execute(super.getClass().getName());
        } else {
            this.logChannel.log(-2137614336, "[AbstractBAPModuleInitializationManagerASG#checkBAPConfig] Version check not successful. Will retry getting BAP Config.");
            this.bapGetConfigRetryTimer.restart();
        }
    }

    @Override
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

    static /* synthetic */ AbstractBAPModuleASG access$000(AbstractBAPModuleInitializationManagerASG abstractBAPModuleInitializationManagerASG) {
        return abstractBAPModuleInitializationManagerASG.moduleAsg;
    }

    static /* synthetic */ void access$400(AbstractBAPModuleInitializationManagerASG abstractBAPModuleInitializationManagerASG) {
        abstractBAPModuleInitializationManagerASG.getBAPConfigREQ();
    }
}

