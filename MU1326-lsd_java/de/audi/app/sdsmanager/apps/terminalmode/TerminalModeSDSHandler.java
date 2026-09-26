/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.terminalmode;

import de.audi.app.sdsmanager.apps.terminalmode.ITerminalModeSDSHandler;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.atip.interapp.terminalmode.DefaultTerminalModeUpdateListener;
import de.audi.atip.interapp.terminalmode.TerminalModeAppState;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;
import de.audi.atip.log.LogChannel;

public class TerminalModeSDSHandler
extends DefaultTerminalModeUpdateListener
implements ITerminalModeSDSHandler {
    private final LogChannel lc = Logger.getHMILog();
    private volatile boolean terminalModeDeviceActive = false;
    private volatile boolean terminalModeSpeechActive = false;

    @Override
    public void updateActiveDeviceState(TerminalModeDevice terminalModeDevice) {
        boolean bl = terminalModeDevice.isActive();
        this.lc.log(-2137614336, "TerminalModeSDSHandler#updateActiveDeviceState: terminal mode device active: %1!", bl);
        if (!bl) {
            this.terminalModeSpeechActive = false;
        }
        this.terminalModeDeviceActive = bl;
    }

    @Override
    public boolean isTerminalModeDeviceActive() {
        return this.terminalModeDeviceActive;
    }

    @Override
    public void updateAppStates(TerminalModeAppState[] terminalModeAppStateArray) {
        for (int i2 = 0; i2 < terminalModeAppStateArray.length; ++i2) {
            TerminalModeAppState terminalModeAppState = terminalModeAppStateArray[i2];
            if (terminalModeAppState == null) continue;
            this.lc.log(-2137614336, "TerminalModeSDSHandler#updateAppStates: %1!", (Object)terminalModeAppState.toString());
            if (terminalModeAppState.getAppId() != 3 || !terminalModeAppState.isRunningOnDevice()) continue;
            this.terminalModeSpeechActive = true;
            return;
        }
        this.lc.log(-2137614336, "TerminalModeSDSHandler#updateAppStates: Currently no SDS running on terminal mode device!");
        this.terminalModeSpeechActive = false;
    }

    @Override
    public boolean isTerminalModeSpeechActive() {
        return this.terminalModeDeviceActive && this.terminalModeSpeechActive;
    }
}

