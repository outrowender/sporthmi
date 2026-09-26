/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd;

import de.audi.tuner.app.cmd.RadioCmdManager;
import de.audi.tuner.app.cmd.RadioCommandList;
import de.audi.tuner.app.uni.UnifiedStationExt;

class SwitchToUniCmdList
extends RadioCommandList {
    SwitchToUniCmdList(RadioCmdManager radioCmdManager, UnifiedStationExt unifiedStationExt, int n) {
        super(radioCmdManager, "UNI");
        this.add(radioCmdManager.cmdRequestConnection(11, n));
        this.add(radioCmdManager.cmdSwitchDABUsage(false));
        this.add(radioCmdManager.cmdSwitchAMFMUsage(false));
        this.add(radioCmdManager.cmdSwitchUniUsage(true));
        this.add(radioCmdManager.cmdDemute());
        this.add(radioCmdManager.cmdTuneUniStationBlock(unifiedStationExt, n));
        this.add(radioCmdManager.cmdFadeToConnection(11, n));
    }

    SwitchToUniCmdList(RadioCmdManager radioCmdManager, int n) {
        super(radioCmdManager, "UNI");
        this.add(radioCmdManager.cmdRequestConnection(11, n));
        this.add(radioCmdManager.cmdSwitchDABUsage(false));
        this.add(radioCmdManager.cmdSwitchAMFMUsage(false));
        this.add(radioCmdManager.cmdSwitchUniUsage(true));
        this.add(radioCmdManager.cmdDemute());
        this.add(radioCmdManager.cmdFadeToConnection(11, n));
    }
}

