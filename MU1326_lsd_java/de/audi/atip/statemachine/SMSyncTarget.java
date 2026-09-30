/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.statemachine.SyncTargetProcessor;

public interface SMSyncTarget {
    public void activate(SyncTargetProcessor var1);

    public void deactivate();

    public boolean isActive();

    public boolean triggerSync(SyncTargetProcessor var1, int var2);

    public void resetTrigger();
}

