/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.AbstractTelAudioCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;

public class TelRequestConnectionCmd
extends AbstractTelAudioCmd {
    static final int FINISH_TRIGGER_REQUEST = 0;
    static final int FINISH_TRIGGER_START = 1;
    static final int FINISH_TRIGGER_FADED_IN = 2;
    private final int connection;
    private final int finishTrigger;

    static String getFinishTriggerName(int n) {
        switch (n) {
            case 0: {
                return "FINISH_TRIGGER_REQUEST";
            }
            case 1: {
                return "FINISH_TRIGGER_START";
            }
            case 2: {
                return "FINISH_TRIGGER_FADED_IN";
            }
        }
        return "UNKNOWN_TRIGGER";
    }

    public TelRequestConnectionCmd(LogChannel logChannel, int n, HMIAudioService hMIAudioService, int n2) {
        super(logChannel, "TelRequestConnectionCmd: " + n + ", finishTrigger: " + TelRequestConnectionCmd.getFinishTriggerName(n2), hMIAudioService);
        this.connection = n;
        this.finishTrigger = n2;
        if (hMIAudioService == null) {
            throw new IllegalArgumentException("TelRequestConnectionCmd#init: audioService is null");
        }
    }

    public void execute() {
        if (this.finishTrigger == 0) {
            this.logger.log(1000000, "[TelRequestConnectionCmd#execute] requesting connection %1", (long)this.connection);
            this.audioService.requestConnection(this.connection);
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(1000000, "[TelRequestConnectionCmd#execute] requesting connection %2, waiting for %1", (Object)TelRequestConnectionCmd.getFinishTriggerName(this.finishTrigger), (long)this.connection);
            this.audioService.requestConnection(this.connection);
        }
    }

    public void stopConnection(int n, int n2) {
        if (n == this.connection) {
            this.logger.log(1000000, "[TelRequestConnectionCmd#stopConnection] connection=%1, finish command", (long)n);
            this.getCommandList().commandFinished();
        }
    }

    public void pauseConnection(int n, int n2) {
        if (n == this.connection && TelRequestConnectionCmd.isSomeMuteConnection(n)) {
            this.logger.log(1000000, "[TelRequestConnectionCmd#pauseConnection] MUTE connection=%1", (long)n);
            this.getCommandList().commandFinished();
        }
    }

    public void startConnection(int n, int n2) {
        if (n == this.connection) {
            this.checkEnableVolumeLockForBTDownlink(n, n2);
            if (this.finishTrigger == 2) {
                this.logger.log(1000000, "[TelRequestConnectionCmd#startConnection] fading in to connection=%1", (long)n);
                this.audioService.fadeToConnection(n);
            } else {
                this.logger.log(1000000, "[TelRequestConnectionCmd#startConnection] finishing");
                this.getCommandList().commandFinished();
            }
        }
    }

    public void errorConnection(int n, int n2, int n3) {
        if (n == this.connection) {
            this.logger.log(1000000, "[TelRequestConnectionCmd#errorConnection] connection=%1, hmiTerminal=%2, errorCode=%3", (long)n, (long)n2, (long)n3);
            this.getCommandList().commandFinished();
        }
    }

    public void fadedIn(int n, int n2) {
        if (n == this.connection) {
            this.logger.log(1000000, "[TelRequestConnectionCmd#fadedIn] connection=%1", (long)n);
            this.getCommandList().commandFinished();
        }
    }

    private void checkEnableVolumeLockForBTDownlink(int n, int n2) {
        if (n == 106) {
            this.audioService.setVolumelock(n, n2, true, "PhoneHMI.setVolumeLock(true) for BT Downlink");
        }
    }

    private static boolean isSomeMuteConnection(int n) {
        return n == 106 || n == 102;
    }
}

