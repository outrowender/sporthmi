/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$ISmartphoneProperties;
import de.audi.app.terminalmode.smartphone.SPIServiceState;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.commands.AbstractDSICommand;
import de.audi.atip.log.LogChannel;

public class StopService
extends AbstractDSICommand {
    private static final String LOGCLASS;
    private final IStateHandler stateHandler;
    private IDSISmartphoneManager$ISmartphoneProperties smartphoneProperties;

    public StopService(IDSISmartphoneManager iDSISmartphoneManager, IContext iContext, LogChannel logChannel, IStateHandler iStateHandler, IDSISmartphoneManager$ISmartphoneProperties iDSISmartphoneManager$ISmartphoneProperties) {
        super(logChannel, "StopService", iContext, iDSISmartphoneManager);
        this.stateHandler = iStateHandler;
        this.smartphoneProperties = iDSISmartphoneManager$ISmartphoneProperties;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"StopService");
        this.stateHandler.setServiceStatus(false);
        this.smartphoneProperties.getPropertySPIServiceState().accept(SPIServiceState.NOT_STARTED);
        this.getCommandList().commandFinished();
    }
}

