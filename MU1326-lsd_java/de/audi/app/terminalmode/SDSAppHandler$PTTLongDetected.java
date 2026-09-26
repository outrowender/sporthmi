/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.SDSAppHandler;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractDSICommand;
import de.audi.tghu.command.CommandList;

class SDSAppHandler$PTTLongDetected
extends AbstractDSICommand {
    private static final String LOGCLASS;
    private final /* synthetic */ SDSAppHandler this$0;

    public SDSAppHandler$PTTLongDetected(SDSAppHandler sDSAppHandler, IContext iContext) {
        this.this$0 = sDSAppHandler;
        super(iContext.getLogger().main(), "PTTLongDetected", iContext, iContext.getSmartphoneDSIManager());
    }

    @Override
    public void execute() {
        if (SDSAppHandler.access$200(this.this$0).getCurrentState().isAppFree(Application.SPEECH) || SDSAppHandler.access$200(this.this$0).getCurrentState().isAppOwnerDevice(Application.SPEECH)) {
            this.logger.log(1078071040, "[%1.execute] speech is free", (Object)"PTTLongDetected");
            SDSAppHandler.access$300(this.this$0).startSpeechSession();
            TMState tMState = SDSAppHandler.access$200(this.this$0).getCurrentState();
            tMState.setOwnerForApplication(Application.SPEECH, ApplicationOwner.DEVICE);
            CommandList commandList = SDSAppHandler.access$200(this.this$0).changeState(tMState, IRequestor.MAINUNIT, -1L);
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else {
            this.logger.log(1078071040, "[%1.execute] speech not free", (Object)"PTTLongDetected");
            this.getCommandList().commandFinished();
        }
    }
}

