/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.audio.IAudioManager
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.audio.IAudioManager;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;

public class ReleaseAudioConnection
extends AbstractCommand {
    private static final String LOGCLASS;
    private final IAudioManager audioManager;
    private final TMAudioConnection audioConnection;

    public ReleaseAudioConnection(TMAudioConnection tMAudioConnection, IContext iContext) {
        super(iContext.getLogger().main(), new StringBuffer().append("ReleaseAudioConnection(").append(tMAudioConnection.toString()).append(")").toString(), iContext);
        this.audioManager = iContext.getAudioManager();
        this.audioConnection = tMAudioConnection;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute] %2", (Object)"ReleaseAudioConnection", (Object)this.audioConnection.toString());
        this.audioManager.releaseAudio(this.audioConnection);
        this.commandList.commandFinished();
    }
}

