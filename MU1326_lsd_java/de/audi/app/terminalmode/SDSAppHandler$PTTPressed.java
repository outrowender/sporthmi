/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.SDSAppHandler;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.atip.log.LogChannel;

class SDSAppHandler$PTTPressed
extends AbstractCommand {
    private final /* synthetic */ SDSAppHandler this$0;

    public SDSAppHandler$PTTPressed(SDSAppHandler sDSAppHandler, LogChannel logChannel, IContext iContext) {
        this.this$0 = sDSAppHandler;
        super(logChannel, "PTTPressed", iContext);
    }

    @Override
    public void execute() {
        if (SDSAppHandler.access$200(this.this$0).getCurrentState().isAppFree(Application.SPEECH)) {
            SDSAppHandler.access$300(this.this$0).prewarm();
        }
        this.getCommandList().commandFinished();
    }
}

