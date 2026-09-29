/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd;

import de.audi.tuner.app.cmd.RadioCmdManager;
import de.audi.tuner.app.cmd.RadioCommandList;
import de.audi.tuner.app.dab.DabStation;

class SwitchToDABCmdList
extends RadioCommandList {
    SwitchToDABCmdList(int n, RadioCmdManager radioCmdManager) {
        super(radioCmdManager, "DAB");
        this.add(radioCmdManager.cmdRequestConnection(5, n));
        this.add(radioCmdManager.cmdSwitchUniUsage(false));
        this.add(radioCmdManager.cmdSwitchAMFMUsage(false));
        this.add(radioCmdManager.cmdSwitchDABUsage(true));
        this.add(radioCmdManager.cmdDemute());
        this.add(radioCmdManager.cmdFadeToConnection(5, n));
    }

    SwitchToDABCmdList(RadioCmdManager radioCmdManager, int n, DabStation dabStation, int n2) {
        this(n2, radioCmdManager);
        this.addBeforeFadeTo(radioCmdManager.cmdSelectDABServiceBlock(n, dabStation, n2));
    }
}

