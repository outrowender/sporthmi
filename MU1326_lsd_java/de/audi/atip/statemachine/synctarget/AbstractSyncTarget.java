/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.synctarget;

import de.audi.atip.statemachine.SMSyncTarget;
import de.audi.atip.statemachine.SyncTargetManager;
import de.audi.atip.statemachine.SyncTargetProcessor;

public abstract class AbstractSyncTarget
implements SMSyncTarget {
    protected SyncTargetManager syncTargetManager;
    private boolean active = false;
    private boolean triggered = false;
    protected final int syncEventID;
    protected final int transitionID;

    public AbstractSyncTarget(int n, int n2, SyncTargetManager syncTargetManager) {
        this.syncEventID = n;
        this.transitionID = n2;
        this.syncTargetManager = syncTargetManager;
    }

    public AbstractSyncTarget(int n, SyncTargetManager syncTargetManager) {
        this.syncEventID = n;
        this.transitionID = -1;
        this.syncTargetManager = syncTargetManager;
    }

    @Override
    public void activate(SyncTargetProcessor syncTargetProcessor) {
        this.active = true;
        this.activated(syncTargetProcessor);
    }

    @Override
    public void deactivate() {
        this.active = false;
    }

    @Override
    public boolean isActive() {
        return this.active;
    }

    @Override
    public void resetTrigger() {
        this.triggered = false;
    }

    protected boolean isTriggered() {
        return this.triggered;
    }

    protected void trigger() {
        this.triggered = true;
    }

    @Override
    public boolean triggerSync(SyncTargetProcessor syncTargetProcessor, int n) {
        if (this.syncEventID != n) {
            return false;
        }
        return this.execute(syncTargetProcessor);
    }

    public abstract boolean execute(SyncTargetProcessor syncTargetProcessor) {
    }

    public abstract void activated(SyncTargetProcessor syncTargetProcessor) {
    }
}

