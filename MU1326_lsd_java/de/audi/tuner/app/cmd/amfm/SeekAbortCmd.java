/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd;

public class SeekAbortCmd
extends AbstractAMFMCmd {
    public SeekAbortCmd(AbstractAMFMCmd.Builder builder) {
        super(builder);
    }

    public void execute() {
        if (this.tuner.isSeekActive()) {
            this.tuner.seekStation(3, -2);
        } else {
            this.commandFinished();
        }
    }

    public void seekStationStatus(int n) {
        super.seekStationStatus(n);
        if (n == 3 || n == 2) {
            this.commandFinished();
        }
    }
}

