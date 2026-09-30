/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.audio;

import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.cmd.audio.AbstractAudioCmd;

public class RestoreAudioCmd
extends AbstractAudioCmd {
    private final TunerStatus status;

    public RestoreAudioCmd(int n, TunerStatus tunerStatus, AbstractAudioCmd.Builder builder) {
        super(n, builder);
        this.status = tunerStatus;
        this.setName("RestoreAudioCmd");
    }

    public void execute() {
        if (!this.status.hasAudioFocus(this.terminalID)) {
            this.logger.log(1000000, "[RestoreAudioCmd.execute] Nothing to do as Radio hasn't audio focus.");
            this.commandFinished();
            return;
        }
        int n = this.audio.getConnectionForActiveTuner(this.terminalID);
        if (this.audio.getStatus(n) != 5) {
            this.logger.log(1000000, "[RestoreAudioCmd.execute] Nothing to do as AC:%1 is already active.", (long)n);
            this.commandFinished();
            return;
        }
        this.logger.log(1000000, "[RestoreAudioCmd.execute] AC:%1 HT:%2", (long)n, (long)this.terminalID);
        this.audio.requestAudioChannel(n, this.terminalID);
    }

    public void stopConnection(int n, int n2) {
        super.stopConnection(n, n2);
        if (this.audio.isTunerAudioConnection(n)) {
            this.commandFinished();
        }
    }

    public void pauseConnection(int n, int n2) {
        super.pauseConnection(n, n2);
        if (this.audio.isTunerAudioConnection(n)) {
            this.commandFinished();
        }
    }

    public void startConnection(int n, int n2) {
        super.startConnection(n, n2);
        if (this.audio.isTunerAudioConnection(n)) {
            this.logger.log(1000000, "[RestoreAudioCmd.startConnection] fade-to AC:%1 HT:%2", (long)n, (long)this.terminalID);
            this.audio.fadeTo(n, this.terminalID);
            this.commandFinished();
        }
    }

    public void errorConnection(int n, int n2, int n3) {
        super.errorConnection(n, n2, n3);
        if (this.audio.isTunerAudioConnection(n)) {
            this.commandFinished();
        }
    }

    public void fadedIn(int n, int n2) {
        super.fadedIn(n, n2);
        if (this.audio.isTunerAudioConnection(n)) {
            this.commandFinished();
        }
    }
}

