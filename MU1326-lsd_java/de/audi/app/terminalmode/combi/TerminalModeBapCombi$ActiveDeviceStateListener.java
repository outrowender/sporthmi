/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.combi;

import de.audi.app.terminalmode.combi.TerminalModeBapCombi;
import de.audi.app.terminalmode.combi.TerminalModeBapCombi$1;
import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDevice$ConnectionState;
import de.audi.atip.interapp.bap.data.TimeStamp;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.atip.interapp.combi.bap.audio.data.PlayPosition;

final class TerminalModeBapCombi$ActiveDeviceStateListener
implements IActiveDeviceStateListener {
    private final /* synthetic */ TerminalModeBapCombi this$0;

    private TerminalModeBapCombi$ActiveDeviceStateListener(TerminalModeBapCombi terminalModeBapCombi) {
        this.this$0 = terminalModeBapCombi;
    }

    @Override
    public void updateActiveDeviceState(TMDevice tMDevice) {
        if (tMDevice.connectionState().is(TMDevice$ConnectionState.ACTIVATING)) {
            TerminalModeBapCombi.access$500(this.this$0).updateActiveInfoState(9);
            int n = this.getBapSourceType(tMDevice);
            TerminalModeBapCombi.access$500(this.this$0).updateActiveSource(n, 0, 0, false, false, 0);
            TerminalModeBapCombi.access$500(this.this$0).updateCurrentStation(new CombiBAPCurrentStationInfo());
            TerminalModeBapCombi.access$500(this.this$0).updatePlayPosition(PlayPosition.builder().setTimePosition(TimeStamp.getInstanceFromSeconds(-65536)).setTotalPlayTime(TimeStamp.getInstanceFromSeconds(-65536)).build());
            TerminalModeBapCombi.access$500(this.this$0).updateActiveInfoState(9);
        }
    }

    private int getBapSourceType(TMDevice tMDevice) {
        if (tMDevice.isCarplayDevice()) {
            return 37;
        }
        if (tMDevice.isAndroidAutoDevice()) {
            return 39;
        }
        return 40;
    }

    /* synthetic */ TerminalModeBapCombi$ActiveDeviceStateListener(TerminalModeBapCombi terminalModeBapCombi, TerminalModeBapCombi$1 terminalModeBapCombi$1) {
        this(terminalModeBapCombi);
    }
}

