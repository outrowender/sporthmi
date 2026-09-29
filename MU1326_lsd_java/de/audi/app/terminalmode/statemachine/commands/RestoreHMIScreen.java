/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class RestoreHMIScreen
extends AbstractCommand {
    private static final String LOGCLASS;
    private final IStateHandler stateHandler;

    public RestoreHMIScreen(IContext iContext, IStateHandler iStateHandler) {
        super(iContext.getLogger().main(), "RestoreHMIScreen", iContext);
        this.stateHandler = iStateHandler;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"RestoreHMIScreen");
        ChoiceModelApp choiceModelApp = this.stateHandler.getLastScreenWasEntertainment() && this.stateHandler.getCurrentState().isResourceOwnerDevice(Resource.AUDIO_MEDIA) || this.context.getDeviceManager().getActiveDevice().isAndroidAutoDevice() ? this.context.getChoiceModel(785657856) : this.context.getChoiceModel(617885696);
        this.stateHandler.setLastScreenWasEntertainment(false);
        choiceModelApp.setValue(choiceModelApp.getValue() == 0 ? 1 : 0);
        this.getCommandList().commandFinished();
    }
}

