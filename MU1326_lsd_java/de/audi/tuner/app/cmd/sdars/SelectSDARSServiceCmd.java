/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.sdars;

import de.audi.tuner.app.cmd.sdars.AbstractSDARSCmd;
import de.audi.tuner.app.sdars.SDARSStatusManager;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.sdars.ServiceStatus3;

public class SelectSDARSServiceCmd
extends AbstractSDARSCmd {
    private final StationInfoExt station;
    private final boolean block;
    private boolean mute;
    private int selectServiceStatus;

    public SelectSDARSServiceCmd(StationInfoExt stationInfoExt, boolean bl, AbstractSDARSCmd.Builder builder) {
        super(builder);
        this.station = stationInfoExt;
        this.block = bl;
        Buffer buffer = new Buffer().append("SelectSDARSServiceCmd(").append(stationInfoExt).append(',').append(bl).append(')');
        this.setName(buffer);
    }

    public void execute() {
        this.logExecuteFirstCmd();
        this.logger.log(10000000, "[SelectSDARSServiceCmd.execute] sid:%1 ", (Object)this.station);
        SDARSStatusManager sDARSStatusManager = this.sdarsTuner.getStatusManager();
        if (sDARSStatusManager != null) {
            this.mute = this.sdarsTuner.getStatusManager().isMute();
        }
        this.selectServiceStatus = 0;
        this.sdarsTuner.selectStation(this.station, 0);
        if (!this.block) {
            this.commandFinished();
        }
    }

    protected void commandFinished() {
        this.logFinishFirstCmd();
        super.commandFinished();
    }

    public void selectStationStatus(int n) {
        this.logger.log(10000000, "[SelectServiceCmd.selectServiceStatus] status:%1", (long)n);
        super.selectStationStatus(n);
        this.selectServiceStatus = n;
        if (this.selectServiceStatus == 1 && this.mute) {
            this.commandFinished();
        } else if (this.selectServiceStatus != 1) {
            this.commandFinished();
        }
    }

    public void updateServiceStatus3(ServiceStatus3 serviceStatus3) {
        this.logger.log(10000000, "[SelectServiceCmd.updateServiceStatus3] status:%1", (Object)serviceStatus3);
        super.updateServiceStatus3(serviceStatus3);
        boolean bl = this.mute = serviceStatus3.audioStatus == 1;
        if (this.selectServiceStatus == 1 && this.mute) {
            this.commandFinished();
        }
    }
}

