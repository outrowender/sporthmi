/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.tuner.app.amfm.dsi.IAmFmDsiDownManager;
import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd;
import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd$Builder;

public class AbortAMForcedStationListUpdateCmd
extends AbstractAMFMCmd {
    private final IAmFmDsiDownManager downManager;

    public AbortAMForcedStationListUpdateCmd(IAmFmDsiDownManager iAmFmDsiDownManager, AbstractAMFMCmd$Builder abstractAMFMCmd$Builder) {
        super(abstractAMFMCmd$Builder);
        this.downManager = iAmFmDsiDownManager;
        this.setName("AbortAMForcedStationListUpdateCmd()");
    }

    @Override
    public void execute() {
        this.downManager.forceAMUpdate(2);
    }

    @Override
    public void forceAMUpdateStatus(int n) {
        this.logger.log(-2137614336, "[AbortAMForcedStationListUpdateCmd.forceAMUpdateStatus] status:%1", (long)n);
        super.forceAMUpdateStatus(n);
        if (n != 1) {
            this.commandFinished();
        }
    }
}

