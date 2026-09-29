/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.audio.IAudioManager
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;

public class ReleaseAudioFocus
extends AbstractCommand {
    private static final String LOGCLASS;
    private final IAudioManager audioManager;

    public ReleaseAudioFocus(IContext iContext) {
        super(iContext.getLogger().main(), "ReleaseAudioFocus", iContext);
        this.audioManager = iContext.getAudioManager();
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"ReleaseAudioFocus");
        if (this.audioManager.hasAudioFocus()) {
            this.audioManager.releaseAudioFocus();
        }
        this.commandList.commandFinished();
    }
}

