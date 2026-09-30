/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.app.ecall.core.audio.cmd.AbstractEcallAudioCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;

class EcallRequestConnectionCmd
extends AbstractEcallAudioCmd {
    static final int FINISH_TRIGGER_REQUEST = 0;
    static final int FINISH_TRIGGER_FADED_IN = 1;
    private final int finishTrigger;
    private final int connection;

    static String getFinishTriggerName(int n) {
        switch (n) {
            case 0: {
                return "FINISH_TRIGGER_REQUEST";
            }
            case 1: {
                return "FINISH_TRIGGER_FADED_IN";
            }
        }
        return "UNKNOWN_TRIGGER";
    }

    EcallRequestConnectionCmd(LogChannel logChannel, int n, HMIAudioService hMIAudioService, int n2) {
        super(logChannel, hMIAudioService);
        this.connection = n;
        this.finishTrigger = n2;
    }

    public void execute() {
        if (this.finishTrigger == 1 && this.skipRequestConnection()) {
            return;
        }
        this.logger.log(1000000, "EcallRequestConnectionCmd#execute(): requesting connection %1", (long)this.connection);
        this.audioService.requestConnection(this.connection);
        if (this.finishTrigger == 0) {
            this.getCommandList().commandFinished();
        }
    }

    public void stopConnection(int n, int n2) {
        if (n == this.connection) {
            this.logger.log(1000000, "[EcallRequestConnectionCmd#stopConnection] connection=%1", (long)n);
            this.getCommandList().commandFinished();
        }
    }

    public void pauseConnection(int n, int n2) {
        if (n == this.connection) {
            this.logger.log(1000000, "[EcallRequestConnectionCmd#pauseConnection] connection=%1", (long)n);
        }
    }

    public void startConnection(int n, int n2) {
        if (n == this.connection) {
            if (this.finishTrigger == 1) {
                this.logger.log(1000000, "[EcallRequestConnectionCmd#startConnection] fading in to connection=%1", (long)n);
                this.audioService.fadeToConnection(n);
            } else {
                this.logger.log(1000000, "[EcallRequestConnectionCmd#startConnection] finishing");
                this.getCommandList().commandFinished();
            }
        }
    }

    public void errorConnection(int n, int n2, int n3) {
        if (n == this.connection) {
            this.logger.log(10000000, "[EcallRequestConnectionCmd#errorConnection] connection=%1, hmiTerminal=%2, errorCode=%3", (long)n, (long)n2, (long)n3);
            this.getCommandList().commandFinished();
        }
    }

    public void fadedIn(int n, int n2) {
        if (n == this.connection) {
            this.logger.log(1000000, "[EcallRequestConnectionCmd#fadedIn] connection=%1", (long)n);
            this.getCommandList().commandFinished();
        }
    }

    private boolean skipRequestConnection() {
        int n = this.audioService.getStatus(this.connection);
        if (n == 0 || n == 1) {
            this.logger.log(1000000, "[EcallRequestConnectionCmd#avoidRequestConnection] connection=%1 already faded in, finish command!", (long)this.connection);
            this.getCommandList().commandFinished();
            return true;
        }
        if (n == 2) {
            this.logger.log(1000000, "[EcallRequestConnectionCmd#avoidRequestConnection] connection=%1 already started, fading in!", (long)this.connection);
            this.audioService.fadeToConnection(this.connection);
            return true;
        }
        return false;
    }
}

