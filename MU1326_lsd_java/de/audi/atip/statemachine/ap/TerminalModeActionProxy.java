/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface TerminalModeActionProxy
extends ActionProxy {
    public void hmiActivatedTerminalMode(int var1);

    public void hmiDeactivatedTerminalMode(int var1);

    public void resetNewDeviceDetection(int var1);

    public void parkingActivatedTerminalMode(int var1);

    public void parkingDeactivatedTerminalMode(int var1);
}

