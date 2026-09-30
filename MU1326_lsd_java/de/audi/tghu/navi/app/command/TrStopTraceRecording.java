/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class TrStopTraceRecording
extends NavCommand {
    public void execute() {
        this.getDSINavigation().trStopTraceRecording();
    }

    public void trStopTraceRecordingResult(int n, long l, int n2) {
        this.logger.log(10000000, "TrStopTraceRecording#trStopTraceRecordingResultCode( trStopTraceRecordingResultCode: %1, timestamp: %2, errorCode: %3 )", (long)n, l, (long)n2);
        if (n != 0) {
            this.getCommandList().commandAborted(n2);
        }
        this.getCommandList().commandFinished();
    }
}

