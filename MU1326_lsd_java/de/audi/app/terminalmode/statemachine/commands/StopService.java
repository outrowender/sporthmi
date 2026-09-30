/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.SPIServiceState;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.commands.AbstractDSICommand;
import de.audi.atip.log.LogChannel;

public class StopService
extends AbstractDSICommand {
    private static final String LOGCLASS = "StopService";
    private final IStateHandler stateHandler;
    private IDSISmartphoneManager.ISmartphoneProperties smartphoneProperties;

    public StopService(IDSISmartphoneManager iDSISmartphoneManager, IContext iContext, LogChannel logChannel, IStateHandler iStateHandler, IDSISmartphoneManager.ISmartphoneProperties iSmartphoneProperties) {
        super(logChannel, LOGCLASS, iContext, iDSISmartphoneManager);
        this.stateHandler = iStateHandler;
        this.smartphoneProperties = iSmartphoneProperties;
    }

    public void execute() {
        this.logger.log(1000000, "[%1.execute]", (Object)LOGCLASS);
        this.stateHandler.setServiceStatus(false);
        this.smartphoneProperties.getPropertySPIServiceState().accept(SPIServiceState.NOT_STARTED);
        this.getCommandList().commandFinished();
    }
}

