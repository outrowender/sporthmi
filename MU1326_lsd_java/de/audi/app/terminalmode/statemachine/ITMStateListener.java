/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.statemachine.TMState;

public interface ITMStateListener {
    default public void updateState(TMState tMState) {
    }
}

