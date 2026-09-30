/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.statemachine.State;

public interface IStateMachinePresetAccess {
    public boolean isStarted();

    public State getCurrentTopState();
}

