/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface TerminalModeActionProxy
extends ActionProxy {
    default public void hmiActivatedTerminalMode(int n) {
    }

    default public void hmiDeactivatedTerminalMode(int n) {
    }

    default public void resetNewDeviceDetection(int n) {
    }

    default public void parkingActivatedTerminalMode(int n) {
    }

    default public void parkingDeactivatedTerminalMode(int n) {
    }
}

