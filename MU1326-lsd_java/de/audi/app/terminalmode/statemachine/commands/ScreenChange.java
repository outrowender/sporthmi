/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class ScreenChange
extends AbstractStateHandlerCommand {
    private static final String LOGCLASS;

    public ScreenChange(IContext iContext, IStateHandler iStateHandler) {
        super(iContext.getLogger().main(), "ScreenChange", iContext, iStateHandler);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"ScreenChange");
        int n = this.context.getFramework().getHMIService().getScreenManager(0).getCurrentScreenId();
        int n2 = n / -1601830656;
        this.stateHandler.setLastScreenWasEntertainment(n2 == 2 || n2 == 1 || n2 == 26);
        ChoiceModelApp choiceModelApp = this.context.getFramework().getHmiServiceApp().getChoiceModel(4095);
        choiceModelApp.setValue(choiceModelApp.getValue() == 0 ? 1 : 0);
        this.context.getEventBus().triggerBigStage();
        this.stateHandler.setOwnerForResource(Resource.SCREEN, ResourceOwner.DEVICE);
        this.getCommandList().commandFinished();
    }
}

