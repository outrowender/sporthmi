/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.statemachine.SyncTargetProcessor;

public interface SMSyncTarget {
    default public void activate(SyncTargetProcessor syncTargetProcessor) {
    }

    default public void deactivate() {
    }

    default public boolean isActive() {
    }

    default public boolean triggerSync(SyncTargetProcessor syncTargetProcessor, int n) {
    }

    default public void resetTrigger() {
    }
}

