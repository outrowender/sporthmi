/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.app.ecall.core.audio.cmd.AbstractEcallAudioCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;

class EcallReleaseConnectionCmd
extends AbstractEcallAudioCmd {
    private final int connection;

    EcallReleaseConnectionCmd(LogChannel logChannel, int n, HMIAudioService hMIAudioService) {
        super(logChannel, hMIAudioService);
        this.connection = n;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "EcallReleaseConnectionCmd#execute(): release connection: %1 ", (long)this.connection);
        boolean bl = this.isStopped(this.connection);
        this.audioService.releaseConnection(this.connection);
        if (bl) {
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(1078071040, "EcallReleaseConnectionCmd#execute(): waiting for stopConnection");
        }
    }

    @Override
    public void stopConnection(int n, int n2) {
        if (n == this.connection) {
            this.logger.log(1078071040, "[EcallReleaseConnectionCmd#stopConnection] AC:%1", (long)n);
            this.getCommandList().commandFinished();
        }
    }

    private boolean isStopped(int n) {
        return this.getConnectionStatus(n) == 5;
    }

    private int getConnectionStatus(int n) {
        if (this.audioService != null) {
            return this.audioService.getStatus(n);
        }
        return -1;
    }
}

