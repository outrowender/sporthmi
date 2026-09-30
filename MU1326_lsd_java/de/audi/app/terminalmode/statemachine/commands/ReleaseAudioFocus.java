/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;

public class ReleaseAudioFocus
extends AbstractCommand {
    private static final String LOGCLASS = "ReleaseAudioFocus";
    private final IAudioManager audioManager;

    public ReleaseAudioFocus(IContext iContext) {
        super(iContext.getLogger().main(), LOGCLASS, iContext);
        this.audioManager = iContext.getAudioManager();
    }

    public void execute() {
        this.logger.log(1000000, "[%1.execute]", (Object)LOGCLASS);
        if (this.audioManager.hasAudioFocus()) {
            this.audioManager.releaseAudioFocus();
        }
        this.commandList.commandFinished();
    }
}

