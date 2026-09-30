/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;

public class ReleaseAudioConnection
extends AbstractCommand {
    private static final String LOGCLASS = "ReleaseAudioConnection";
    private final IAudioManager audioManager;
    private final TMAudioConnection audioConnection;

    public ReleaseAudioConnection(TMAudioConnection tMAudioConnection, IContext iContext) {
        super(iContext.getLogger().main(), "ReleaseAudioConnection(" + tMAudioConnection.toString() + ")", iContext);
        this.audioManager = iContext.getAudioManager();
        this.audioConnection = tMAudioConnection;
    }

    public void execute() {
        this.logger.log(1000000, "[%1.execute] %2", (Object)LOGCLASS, (Object)this.audioConnection.toString());
        this.audioManager.releaseAudio(this.audioConnection);
        this.commandList.commandFinished();
    }
}

