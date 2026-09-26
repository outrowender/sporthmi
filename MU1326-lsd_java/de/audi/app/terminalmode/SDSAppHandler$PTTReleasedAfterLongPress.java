/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.SDSAppHandler;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.atip.log.LogChannel;

class SDSAppHandler$PTTReleasedAfterLongPress
extends AbstractCommand {
    private final /* synthetic */ SDSAppHandler this$0;

    public SDSAppHandler$PTTReleasedAfterLongPress(SDSAppHandler sDSAppHandler, LogChannel logChannel, IContext iContext) {
        this.this$0 = sDSAppHandler;
        super(logChannel, "PTTReleasedAfterLongPress", iContext);
    }

    @Override
    public void execute() {
        SDSAppHandler.access$300(this.this$0).pttReleasedAfterLongPress();
        this.getCommandList().commandFinished();
    }
}

