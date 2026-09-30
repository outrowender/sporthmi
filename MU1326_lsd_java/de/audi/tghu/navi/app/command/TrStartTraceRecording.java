/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class TrStartTraceRecording
extends NavCommand {
    private final int recordingMode;

    public TrStartTraceRecording(int n) {
        this.recordingMode = n;
    }

    public void execute() {
        this.logger.log(10000000, "TrStartTraceRecording#execute( recordingMode: %1 )", (long)this.recordingMode);
        this.getDSINavigation().trStartTraceRecording(this.recordingMode);
    }

    public void trStartTraceRecordingResult(int n, long l, int n2) {
        this.logger.log(10000000, "TrStartTraceRecording#trStartTraceRecordingResult( %1, %2, %3 )", (long)n, l, (long)n2);
        if (n != 0) {
            this.getCommandList().commandAborted(n2);
        }
        this.getCommandList().commandFinished();
    }
}

