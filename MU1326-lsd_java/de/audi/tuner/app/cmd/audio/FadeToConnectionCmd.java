/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.audio;

import de.audi.tuner.app.cmd.audio.AbstractAudioCmd;
import de.audi.tuner.app.cmd.audio.AbstractAudioCmd$Builder;
import de.esolutions.fw.util.commons.Buffer;

public class FadeToConnectionCmd
extends AbstractAudioCmd {
    public FadeToConnectionCmd(int n, int n2, AbstractAudioCmd$Builder abstractAudioCmd$Builder) {
        super(n, n2, abstractAudioCmd$Builder);
        this.setName(new Buffer().append("FadeToConnectionCmd(").append(n).append(')').toString());
    }

    @Override
    public void execute() {
        this.logExecuteFirstCmd();
        int n = this.audio.getStatus(this.connection);
        switch (n) {
            case 2: {
                this.logger.log(-2137614336, "[FadeToConnectionCmd.execute] fadeTo AC:%1", (long)this.connection);
                this.audio.fadeTo(this.connection, this.terminalID);
                this.commandFinished();
                break;
            }
            case 3: {
                break;
            }
            default: {
                this.logger.log(-2137614336, "[FadeToConnectionCmd.execute] AC:%1 - nothing to do (status:%2)", (long)this.connection, (long)n);
                this.commandFinished();
            }
        }
    }

    @Override
    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }

    @Override
    public void startConnection(int n, int n2) {
        super.startConnection(n, n2);
        if (n == this.connection) {
            this.logger.log(-2137614336, "[FadeToConnectionCmd.startConnection] AC:%1 - calling #fadeTo(%1)", (long)n);
            this.audio.fadeTo(n, this.terminalID);
            this.commandFinished();
        }
    }

    @Override
    public void fadedIn(int n, int n2) {
        super.fadedIn(n, n2);
        if (n == this.connection) {
            this.logger.log(-2137614336, "[FadeToConnectionCmd.fadedIn] AC:%1", (long)n);
            this.commandFinished();
        }
    }

    @Override
    public void pauseConnection(int n, int n2) {
        super.pauseConnection(n, n2);
        if (n == this.connection) {
            this.logger.log(-2137614336, "[FadeToConnectionCmd.pauseConnection] AC:%1", (long)n);
        }
    }

    @Override
    public void stopConnection(int n, int n2) {
        super.stopConnection(n, n2);
        if (n == this.connection) {
            this.logger.log(-2137614336, "[FadeToConnectionCmd.stopConnection] AC:%1", (long)n);
            this.commandFinished();
        }
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
        super.errorConnection(n, n2, n3);
        if (n == this.connection) {
            this.logger.log(-2137614336, "[FadeToConnectionCmd.errorConnection] AC:%1", (long)n);
            this.commandFinished();
        }
    }
}

