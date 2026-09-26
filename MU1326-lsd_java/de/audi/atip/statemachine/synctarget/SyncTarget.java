/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.synctarget;

import de.audi.atip.statemachine.SyncTargetManager;
import de.audi.atip.statemachine.SyncTargetProcessor;
import de.audi.atip.statemachine.synctarget.AbstractSyncTarget;

public class SyncTarget
extends AbstractSyncTarget {
    public SyncTarget(int n, int n2, SyncTargetManager syncTargetManager) {
        super(n, n2, syncTargetManager);
    }

    @Override
    public boolean execute(SyncTargetProcessor syncTargetProcessor) {
        return syncTargetProcessor.processSyncTransition(this.transitionID);
    }

    @Override
    public void activated(SyncTargetProcessor syncTargetProcessor) {
    }
}

