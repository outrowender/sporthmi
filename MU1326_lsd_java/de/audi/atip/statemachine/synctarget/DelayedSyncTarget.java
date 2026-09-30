/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.synctarget;

import de.audi.atip.statemachine.SyncTargetManager;
import de.audi.atip.statemachine.SyncTargetProcessor;
import de.audi.atip.statemachine.synctarget.AbstractSyncTarget;

public class DelayedSyncTarget
extends AbstractSyncTarget {
    public DelayedSyncTarget(int n, int n2, SyncTargetManager syncTargetManager) {
        super(n, n2, syncTargetManager);
    }

    public boolean execute(SyncTargetProcessor syncTargetProcessor) {
        if (this.isActive()) {
            return syncTargetProcessor.processSyncTransition(this.transitionID);
        }
        this.trigger();
        return true;
    }

    public void activated(SyncTargetProcessor syncTargetProcessor) {
        if (this.isTriggered()) {
            this.execute(syncTargetProcessor);
            this.resetTrigger();
        }
    }
}

