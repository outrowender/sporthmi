/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.AbstractTelAudioCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class TelReleaseConnectionCmd
extends AbstractTelAudioCmd {
    private final int connection;

    TelReleaseConnectionCmd(LogChannel logChannel, int n, HMIAudioService hMIAudioService) {
        super(logChannel, new StringBuffer().append("TelReleaseConnectionCmd: ").append(n).toString(), hMIAudioService);
        this.connection = n;
    }

    @Override
    public void execute() {
        boolean bl;
        int n = this.getConnectionStatus(this.connection);
        boolean bl2 = bl = this.getConnectionStatus(this.connection) == 5;
        if (this.logger.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("releasing AC:");
            buffer.append(this.connection);
            buffer.append(" (");
            buffer.append(this.getConnectionStatusName(n));
            buffer.append(")");
            if (!bl) {
                buffer.append(" --> waiting for stopConnection");
            }
            this.logger.log(1078071040, "[TelReleaseConnectionCmd#execute] %1", (Object)buffer);
        }
        this.audioService.releaseConnection(this.connection);
        if (bl) {
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void stopConnection(int n, int n2) {
        if (n == this.connection) {
            this.logger.log(1078071040, "[TelReleaseConnectionCmd#stopConnection] AC:%1", (long)n);
            this.checkDisableVolumeLockForBTDownlink(n, n2);
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
        if (n == this.connection) {
            this.logger.log(1078071040, "[TelReleaseConnectionCmd#stopConnection] AC:%1, errorCode:%2", (long)n, (long)n3);
            this.checkDisableVolumeLockForBTDownlink(n, n2);
            this.getCommandList().commandFinished();
        }
    }

    private int getConnectionStatus(int n) {
        if (this.audioService != null) {
            return this.audioService.getStatus(n);
        }
        return -1;
    }

    private void checkDisableVolumeLockForBTDownlink(int n, int n2) {
        if (n == 106) {
            this.audioService.setVolumelock(n, n2, false, "PhoneHMI.setVolumeLock(false) for BT Downlink");
        }
    }
}

