/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.tuner.app.amfm.dsi.IAmFmDsiDownManager;
import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd;

public class AbortAMForcedStationListUpdateCmd
extends AbstractAMFMCmd {
    private final IAmFmDsiDownManager downManager;

    public AbortAMForcedStationListUpdateCmd(IAmFmDsiDownManager iAmFmDsiDownManager, AbstractAMFMCmd.Builder builder) {
        super(builder);
        this.downManager = iAmFmDsiDownManager;
        this.setName("AbortAMForcedStationListUpdateCmd()");
    }

    public void execute() {
        this.downManager.forceAMUpdate(2);
    }

    public void forceAMUpdateStatus(int n) {
        this.logger.log(10000000, "[AbortAMForcedStationListUpdateCmd.forceAMUpdateStatus] status:%1", (long)n);
        super.forceAMUpdateStatus(n);
        if (n != 1) {
            this.commandFinished();
        }
    }
}

