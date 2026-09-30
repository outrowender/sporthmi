/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.terminalmode;

import de.audi.atip.interapp.terminalmode.TerminalModeDevice;

public interface ITerminalModeUpdateService {
    public void activateDevice(TerminalModeDevice var1);

    public void deactivateDevice(TerminalModeDevice var1);

    public void enableTerminalModeForDevice(TerminalModeDevice var1);

    public void disableTerminalModeForDevice(TerminalModeDevice var1);

    public void deleteDeviceFromPersistence(TerminalModeDevice var1);

    public void callNumberViaTM(String var1);

    public void endCallViaTM();
}

