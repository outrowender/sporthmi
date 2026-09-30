/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.dab;

import de.audi.tuner.app.cmd.dab.AbstractDABCmd;
import de.audi.tuner.app.dab.DABDSIDownManager;

public class AbortDABForcedStationListUpdateCmd
extends AbstractDABCmd {
    private final DABDSIDownManager downManager;

    public AbortDABForcedStationListUpdateCmd(DABDSIDownManager dABDSIDownManager, AbstractDABCmd.Builder builder) {
        super(builder);
        this.downManager = dABDSIDownManager;
        this.setName("AbortDABForcedStationListUpdateCmd()");
    }

    public void execute() {
        this.downManager.forceLMUpdate(2);
    }

    public void forceLMUpdateStatus(int n) {
        this.logger.log(10000000, "[AbortDABForcedStationListUpdateCmd.forceLMUpdateStatus] status:%1", (long)n);
        super.forceLMUpdateStatus(n);
        if (n != 1) {
            this.commandFinished();
        }
    }
}

