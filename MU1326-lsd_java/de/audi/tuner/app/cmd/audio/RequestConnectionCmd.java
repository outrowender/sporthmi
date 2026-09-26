/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.audio;

import de.audi.tuner.app.cmd.audio.AbstractAudioCmd;
import de.audi.tuner.app.cmd.audio.AbstractAudioCmd$Builder;
import de.esolutions.fw.util.commons.Buffer;

public class RequestConnectionCmd
extends AbstractAudioCmd {
    public RequestConnectionCmd(int n, int n2, AbstractAudioCmd$Builder abstractAudioCmd$Builder) {
        super(n, n2, abstractAudioCmd$Builder);
        this.setName(new Buffer().append("RequestConnectionCmd(").append(n).append(')').toString());
    }

    @Override
    public void execute() {
        this.logExecuteFirstCmd();
        this.logger.log(-2137614336, "[RequestConnectionCmd.execute] request AC:%1 HT:%2", (long)this.connection, (long)this.terminalID);
        this.audio.requestAudioChannel(this.connection, this.terminalID);
        if (this.terminalID != 0) {
            this.logger.log(-2137614336, "[RequestConnectionCmd.execute] Don't wait for SDIS audio connections");
            this.commandFinished();
        } else if (this.connection == 13 && this.audio.isActive(12)) {
            this.logger.log(-2137614336, "[RequestConnectionCmd.execute] FM active and AM requested -> wait");
        } else if (this.connection == 12 && this.audio.isActive(13)) {
            this.logger.log(-2137614336, "[RequestConnectionCmd.execute] AM active and FM requested -> wait");
        } else {
            this.logger.log(-2137614336, "[RequestConnectionCmd.execute] AC:%1 -> don't wait", (long)this.connection);
            this.commandFinished();
        }
    }

    @Override
    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }

    @Override
    public void fadedIn(int n, int n2) {
        super.fadedIn(n, n2);
        if (n2 == this.terminalID && this.connection == n) {
            this.logger.log(-2137614336, "[RequestConnectionCmd.fadedIn] AC:%1 HT:%2", (long)n, (long)n2);
            this.commandFinished();
        }
    }

    @Override
    public void pauseConnection(int n, int n2) {
        super.pauseConnection(n, n2);
        if (n2 == this.terminalID && n == this.connection) {
            this.logger.log(-2137614336, "[RequestConnectionCmd.pauseConnection] AC:%1 HT:%2", (long)n, (long)n2);
            this.commandFinished();
        }
    }

    @Override
    public void startConnection(int n, int n2) {
        super.startConnection(n, n2);
        if (n2 == this.terminalID && n == this.connection) {
            this.logger.log(-2137614336, "[RequestConnectionCmd.startConnection] AC:%1 HT:%2", (long)n, (long)n2);
            this.commandFinished();
        }
    }

    @Override
    public void stopConnection(int n, int n2) {
        super.stopConnection(n, n2);
        if (n2 == this.terminalID && n == this.connection) {
            this.logger.log(-2137614336, "[RequestConnectionCmd.stopConnection] AC:%1 HT:%2", (long)n, (long)n2);
            this.commandFinished();
        }
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
        super.errorConnection(n, n2, n3);
        if (n2 == this.terminalID && n == this.connection) {
            this.logger.log(-2137614336, "[RequestConnectionCmd.errorConnection] AC:%1 HT:%2", (long)n, (long)n2);
            this.commandFinished();
        }
    }
}

