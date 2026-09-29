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
import de.esolutions.fw.util.commons.Buffer;

public class RequestAudioConnectionWithDuration
extends AbstractCommand {
    private final IAudioManager audioManager;
    private final TMAudioConnection audioConnection;
    private final int duration;

    public RequestAudioConnectionWithDuration(TMAudioConnection tMAudioConnection, IContext iContext, int n) {
        super(iContext.getLogger().main(), RequestAudioConnectionWithDuration.formatTag(tMAudioConnection, n, iContext.getAudioManager()), iContext);
        this.audioConnection = tMAudioConnection;
        this.audioManager = iContext.getAudioManager();
        this.duration = n;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)this.getName());
        this.audioManager.requestAudio(this.audioConnection, this.duration);
        this.commandList.commandFinished();
    }

    private static String formatTag(TMAudioConnection tMAudioConnection, int n, IAudioManager iAudioManager) {
        return new Buffer().append("RequestAudioConnectionWithDuration(").append(tMAudioConnection.toString()).append(")").append(", duration=").append(n).append(")").toString();
    }
}

