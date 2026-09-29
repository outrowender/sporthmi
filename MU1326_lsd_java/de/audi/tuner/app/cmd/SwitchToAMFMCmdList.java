/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd;

import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.cmd.RadioCmdManager;
import de.audi.tuner.app.cmd.RadioCommandList;

class SwitchToAMFMCmdList
extends RadioCommandList {
    SwitchToAMFMCmdList(int n, int n2, RadioCmdManager radioCmdManager) {
        super(radioCmdManager, "AM/FM");
        this.add(radioCmdManager.cmdRequestConnection(n, n2));
        this.add(radioCmdManager.cmdSwitchUniUsage(false));
        this.add(radioCmdManager.cmdSwitchDABUsage(false));
        this.add(radioCmdManager.cmdSwitchAMFMUsage(true));
        this.add(radioCmdManager.cmdDemute());
        this.add(radioCmdManager.cmdFadeToConnection(n, n2));
    }

    SwitchToAMFMCmdList(int n, AMFMStation aMFMStation, boolean bl, RadioCmdManager radioCmdManager) {
        this(Utilities.getBandIdByWaveband(aMFMStation.waveband), n, radioCmdManager);
        this.addBeforeFadeTo(radioCmdManager.cmdTuneAMFMStationBlock(aMFMStation, bl, n));
        this.addAtFirstPos(radioCmdManager.cmdHighlightAMFMStation(aMFMStation, bl, n));
    }
}

