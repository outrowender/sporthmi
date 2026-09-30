/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.SPIServiceState;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractDSICommand;
import de.audi.atip.log.LogChannel;

public class StartService
extends AbstractDSICommand {
    private static final String LOGCLASS = "StartService";
    private final IDSISmartphoneManager.ISmartphoneProperties smartphoneProperties;
    private final IStateHandler stateHandler;

    public StartService(IDSISmartphoneManager iDSISmartphoneManager, IContext iContext, LogChannel logChannel, IStateHandler iStateHandler, IDSISmartphoneManager.ISmartphoneProperties iSmartphoneProperties) {
        super(logChannel, "StartService(" + iDSISmartphoneManager + ")", iContext, iDSISmartphoneManager);
        this.stateHandler = iStateHandler;
        this.smartphoneProperties = iSmartphoneProperties;
    }

    public void execute() {
        TMState tMState = this.stateHandler.getCurrentState();
        this.logger.log(1000000, "[%1.execute] %2", (Object)LOGCLASS, (Object)tMState);
        this.dsiSmartphoneManager.startService(tMState);
        this.smartphoneProperties.getPropertySPIServiceState().accept(SPIServiceState.STARTING);
        this.getCommandList().commandFinished();
    }
}

