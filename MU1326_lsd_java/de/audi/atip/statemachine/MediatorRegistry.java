/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.statemachine.EventMediator;

public interface MediatorRegistry {
    public void registerMediator(EventMediator var1, int[] var2);

    public void unregisterMediator(EventMediator var1, int[] var2);
}

