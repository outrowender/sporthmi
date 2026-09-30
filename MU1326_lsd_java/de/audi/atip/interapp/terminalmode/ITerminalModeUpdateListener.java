/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.terminalmode;

import de.audi.atip.interapp.terminalmode.CallStateChanged;
import de.audi.atip.interapp.terminalmode.TerminalModeAppState;
import de.audi.atip.interapp.terminalmode.TerminalModeAudioUsage;
import de.audi.atip.interapp.terminalmode.TerminalModeDevice;

public interface ITerminalModeUpdateListener {
    public void updateAppStates(TerminalModeAppState[] var1);

    public void updateDeviceList(TerminalModeDevice[] var1);

    public void updateActiveDeviceState(TerminalModeDevice var1);

    public void updateAudioConnectionUsage(TerminalModeAudioUsage var1);

    public void updateTMVideoFocus(boolean var1);

    public void updateCallState(CallStateChanged[] var1);
}

