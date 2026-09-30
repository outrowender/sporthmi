/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.app.ecall.core.bap.IEcallBapServiceAdapter;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

class AudioStateSetGetCmd
extends Command {
    private final IEcallBapServiceAdapter bapServiceAdapter;
    private final int audioSource;

    AudioStateSetGetCmd(LogChannel logChannel, IEcallBapServiceAdapter iEcallBapServiceAdapter, int n) {
        super(logChannel);
        if (iEcallBapServiceAdapter == null) {
            throw new IllegalArgumentException();
        }
        this.bapServiceAdapter = iEcallBapServiceAdapter;
        this.audioSource = n;
    }

    public void execute() {
        this.logger.log(1000000, "AudioStateSetGetCmd#execute(): audioSource %1", (long)this.audioSource);
        this.bapServiceAdapter.setAudioSource(this.audioSource);
        this.getCommandList().commandFinished();
    }
}

