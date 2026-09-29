/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd;

import de.audi.tuner.app.cmd.RadioCmdManager;
import de.audi.tuner.app.cmd.RadioCommandList;
import de.audi.tuner.app.sdars.StationInfoExt;

class SwitchToSdarsCmdList
extends RadioCommandList {
    SwitchToSdarsCmdList(RadioCmdManager radioCmdManager, int n) {
        super(radioCmdManager, "SDARS");
        this.add(radioCmdManager.cmdRequestConnection(7, n));
        this.add(radioCmdManager.cmdDemute());
        this.add(radioCmdManager.cmdFadeToConnection(7, n));
    }

    public SwitchToSdarsCmdList(RadioCmdManager radioCmdManager, StationInfoExt stationInfoExt, int n) {
        super(radioCmdManager, "SDARS");
        this.add(radioCmdManager.cmdRequestConnection(7, n));
        this.add(radioCmdManager.cmdDemute());
        this.add(radioCmdManager.cmdSelectSDARSServiceBlock(stationInfoExt));
        this.add(radioCmdManager.cmdFadeToConnection(7, n));
    }
}

