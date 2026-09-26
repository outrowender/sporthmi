/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.terminalmode;

import de.audi.atip.interapp.terminalmode.CallStateChanged;
import de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener;
import de.audi.atip.interapp.terminalmode.TerminalModeAppState;
import de.audi.atip.interapp.terminalmode.TerminalModeAudioUsage;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;

public class DefaultTerminalModeUpdateListener
implements ITerminalModeUpdateListener {
    @Override
    public void updateAppStates(TerminalModeAppState[] terminalModeAppStateArray) {
    }

    @Override
    public void updateDeviceList(TerminalModeDevice[] terminalModeDeviceArray) {
    }

    @Override
    public void updateActiveDeviceState(TerminalModeDevice terminalModeDevice) {
    }

    @Override
    public void updateAudioConnectionUsage(TerminalModeAudioUsage terminalModeAudioUsage) {
    }

    @Override
    public void updateTMVideoFocus(boolean bl) {
    }

    @Override
    public void updateCallState(CallStateChanged[] callStateChangedArray) {
    }
}

