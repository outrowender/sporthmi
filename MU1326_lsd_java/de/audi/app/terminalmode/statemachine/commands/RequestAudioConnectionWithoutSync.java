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

public class RequestAudioConnectionWithoutSync
extends AbstractCommand {
    private final IAudioManager audioManager;
    private final TMAudioConnection audioConnection;
    private final boolean checkAudioFocus;

    public RequestAudioConnectionWithoutSync(TMAudioConnection tMAudioConnection, IContext iContext, boolean bl) {
        super(iContext.getLogger().main(), RequestAudioConnectionWithoutSync.formatTag(tMAudioConnection, iContext.getAudioManager()), iContext);
        this.audioConnection = tMAudioConnection;
        this.audioManager = iContext.getAudioManager();
        this.checkAudioFocus = bl;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)this.getName());
        this.audioManager.requestAudio(this.audioConnection, this.checkAudioFocus);
        this.getCommandList().commandFinished();
    }

    public static String formatTag(TMAudioConnection tMAudioConnection, IAudioManager iAudioManager) {
        return new Buffer().append("RequestAudioConnectionWithoutSync").append("(").append(tMAudioConnection.toString()).append(")").toString();
    }
}

