/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.terminalmode;

import de.audi.atip.interapp.terminalmode.CallStateChanged;
import de.audi.atip.interapp.terminalmode.TerminalModeAppState;
import de.audi.atip.interapp.terminalmode.TerminalModeAudioUsage;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;

public interface ITerminalModeUpdateListener {
    default public void updateAppStates(TerminalModeAppState[] terminalModeAppStateArray) {
    }

    default public void updateDeviceList(TerminalModeDevice[] terminalModeDeviceArray) {
    }

    default public void updateActiveDeviceState(TerminalModeDevice terminalModeDevice) {
    }

    default public void updateAudioConnectionUsage(TerminalModeAudioUsage terminalModeAudioUsage) {
    }

    default public void updateTMVideoFocus(boolean bl) {
    }

    default public void updateCallState(CallStateChanged[] callStateChangedArray) {
    }
}

