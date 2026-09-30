/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.synctarget;

import de.audi.atip.statemachine.SyncTargetManager;
import de.audi.atip.statemachine.SyncTargetProcessor;
import de.audi.atip.statemachine.synctarget.AbstractSyncTarget;

public class PopupSyncTarget
extends AbstractSyncTarget {
    public PopupSyncTarget(int n, SyncTargetManager syncTargetManager) {
        super(n, syncTargetManager);
    }

    public boolean execute(SyncTargetProcessor syncTargetProcessor) {
        return false;
    }

    public void activated(SyncTargetProcessor syncTargetProcessor) {
    }
}

