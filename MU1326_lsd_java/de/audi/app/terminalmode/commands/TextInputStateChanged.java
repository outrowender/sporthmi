/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.keyevents.ITMKeyPanelHandler;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;

public class TextInputStateChanged
extends AbstractCommand {
    private static final String LOGCLASS;
    private final ITMKeyPanelHandler keyPanelHandler;
    private final boolean textInputActive;

    public TextInputStateChanged(IContext iContext, boolean bl, ITMKeyPanelHandler iTMKeyPanelHandler) {
        super(iContext.getLogger().main(), "TextInputStateChanged", iContext);
        this.keyPanelHandler = iTMKeyPanelHandler;
        this.textInputActive = bl;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"TextInputStateChanged");
        this.keyPanelHandler.setCharacterRecognition(9, this.textInputActive);
        this.getCommandList().commandFinished();
    }
}

