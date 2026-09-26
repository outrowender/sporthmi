/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.statemachine.State;

public interface IStateMachinePresetAccess {
    default public boolean isStarted() {
    }

    default public State getCurrentTopState() {
    }
}

