/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.terminalmode;

import de.audi.atip.interapp.terminalmode.TerminalModeDevice;

public interface ITerminalModeUpdateService {
    default public void activateDevice(TerminalModeDevice terminalModeDevice) {
    }

    default public void deactivateDevice(TerminalModeDevice terminalModeDevice) {
    }

    default public void enableTerminalModeForDevice(TerminalModeDevice terminalModeDevice) {
    }

    default public void disableTerminalModeForDevice(TerminalModeDevice terminalModeDevice) {
    }

    default public void deleteDeviceFromPersistence(TerminalModeDevice terminalModeDevice) {
    }

    default public void callNumberViaTM(String string) {
    }

    default public void endCallViaTM() {
    }
}

