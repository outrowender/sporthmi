/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.dab;

import de.audi.tuner.app.cmd.dab.AbstractDABCmd;
import de.audi.tuner.app.cmd.dab.AbstractDABCmd$Builder;
import de.audi.tuner.app.dab.DABDSIDownManager;

public class AbortDABForcedUpdateListAndSwitchLinkingDeviceUsage
extends AbstractDABCmd {
    private final DABDSIDownManager downManager;

    public AbortDABForcedUpdateListAndSwitchLinkingDeviceUsage(DABDSIDownManager dABDSIDownManager, AbstractDABCmd$Builder abstractDABCmd$Builder) {
        super(abstractDABCmd$Builder);
        this.downManager = dABDSIDownManager;
        this.setName("AbortDABForcedStationListUpdateCmd()");
    }

    @Override
    public void execute() {
        this.downManager.forceLMUpdate(2);
        this.downManager.reNotification(27);
    }

    @Override
    public void forceLMUpdateStatus(int n) {
        this.logger.log(-2137614336, "[AbortDABForcedStationListUpdateCmd.forceLMUpdateStatus] status:%1", (long)n);
        super.forceLMUpdateStatus(n);
        if (n != 1) {
            this.downManager.switchLinkingDeviceUsage(1);
            this.commandFinished();
        }
    }
}

