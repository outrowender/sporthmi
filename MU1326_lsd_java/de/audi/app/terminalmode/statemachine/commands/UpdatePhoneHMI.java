/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;

public class UpdatePhoneHMI
extends AbstractCommand {
    private static final String LOGCLASS = "UpdatePhoneHMI";
    private final boolean tmScreenVisible;

    public UpdatePhoneHMI(IContext iContext, boolean bl) {
        super(iContext.getLogger().main(), LOGCLASS, iContext);
        this.tmScreenVisible = bl;
    }

    public void execute() {
        this.logger.log(1000000, "[%1.execute]", (Object)LOGCLASS);
        this.context.getPhoneAppHandler().updateVideoFocus(this.tmScreenVisible);
        this.getCommandList().commandFinished();
    }
}

