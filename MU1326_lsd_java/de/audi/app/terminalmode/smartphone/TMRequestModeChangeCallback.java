/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.statemachine.TMState;

public interface TMRequestModeChangeCallback {
    default public void modeChanged(TMState tMState) {
    }
}

